package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;
import model.*;

public class PirateCrewModifyController implements ActionListener
{
    MainView mainView;
    PirateCrewModifyView pirateCrewModifyView;
    PirateCrewDatabase pirateCrewDatabase;
    CharacterDatabase charDatabase;

    public PirateCrewModifyController(MainView mainView, PirateCrewModifyView pirateCrewModifyView, PirateCrewDatabase pirateCrewDatabase, CharacterDatabase charDatabase)
    {
        this.mainView = mainView;
        this.pirateCrewModifyView = pirateCrewModifyView;
        this.pirateCrewDatabase = pirateCrewDatabase;
        this.charDatabase = charDatabase;

        addActionListener();
    }

    public JPanel getFrame()
    {
        return pirateCrewModifyView.setFrame();
    }

    public void addActionListener()
    {
        pirateCrewModifyView.exitButton.addActionListener(this);
        pirateCrewModifyView.submitButton.addActionListener(this);
        pirateCrewModifyView.charSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == pirateCrewModifyView.exitButton)
        {
            pirateCrewModifyView.panel.setVisible(false);
            mainView.showPanel("PIRATECREW");
        }
        else if (e.getSource() == pirateCrewModifyView.charSelectComboBox)
        {
            int selectedIndex = pirateCrewModifyView.charSelectComboBox.getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < pirateCrewDatabase.getAllPCrew().size()) {
                PirateCrew selectedCrew = pirateCrewDatabase.getAllPCrew().get(selectedIndex);
                pirateCrewModifyView.nameTextField.setText(selectedCrew.GetCrewName());
                pirateCrewModifyView.shipTextField.setText(selectedCrew.GetShipsName());

                if (selectedCrew.GetCaptain() != null) {
                    for (int i = 1; i < pirateCrewModifyView.captainComboBox.getItemCount(); i++) {
                        String item = (String) pirateCrewModifyView.captainComboBox.getItemAt(i);
                        if (item.startsWith(selectedCrew.GetCaptain().GetID() + " -")) {
                            pirateCrewModifyView.captainComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                } else {
                    pirateCrewModifyView.captainComboBox.setSelectedIndex(0); // None
                }

                // Update Members Checkboxes
                for (java.awt.Component comp : pirateCrewModifyView.innerPanel.getComponents()) {
                    if (comp instanceof panel.CharacterSelectionPanel) {
                        panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;
                        String idString = csp.getName().split(" - ")[0];
                        long pirateId = Long.parseLong(idString);

                        // Check if this pirate is in the current crew's member list
                        boolean isMember = false;
                        for (Pirate p : selectedCrew.GetCrewMembers()) {
                            if (p.GetID() == pirateId) {
                                isMember = true;
                                break;
                            }
                        }

                        csp.setChecked(isMember);
                    }
                }
            }
        }
        else if (e.getSource() == pirateCrewModifyView.submitButton)
        {
            int selectedIndex = pirateCrewModifyView.charSelectComboBox.getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < pirateCrewDatabase.getAllPCrew().size()) {
                PirateCrew selectedCrew = pirateCrewDatabase.getAllPCrew().get(selectedIndex);

                try {
                    // Update Name
                    if (pirateCrewModifyView.nameCheckBox.isSelected()) {
                        selectedCrew.SetCrewName(pirateCrewModifyView.nameTextField.getText());
                    }

                    // Update Ship
                    if (pirateCrewModifyView.shipCheckBox.isSelected()) {
                        selectedCrew.SetShipsName(pirateCrewModifyView.shipTextField.getText());
                    }

                    // Update Captain
                    if (pirateCrewModifyView.captainCheckBox.isSelected()) {
                        int capIndex = pirateCrewModifyView.captainComboBox.getSelectedIndex();
                        if (capIndex > 0) {
                            List<Pirate> pirates = getPiratesList();
                            Pirate newCaptain = pirates.get(capIndex - 1);
                            selectedCrew.SetCaptain(newCaptain);
                        }
                    }

                    // Update Members list
                    if (pirateCrewModifyView.membersCheckBox.isSelected()) {
                        for (java.awt.Component comp : pirateCrewModifyView.innerPanel.getComponents()) {
                            if (comp instanceof panel.CharacterSelectionPanel) {
                                panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;
                                String idString = csp.getName().split(" - ")[0];
                                long pirateId = Long.parseLong(idString);

                                Pirate pirateObj = findPirateById(pirateId);

                                if (pirateObj != null) {
                                    if (csp.isSelected()) {
                                        selectedCrew.AddCrewMember(pirateObj);
                                    } else {
                                        selectedCrew.RemoveCrewMember(pirateObj);
                                    }
                                }
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(pirateCrewModifyView.panel, "Pirate Crew Modified Successfully!");
                    pirateCrewModifyView.panel.setVisible(false);
                    mainView.showPanel("PIRATECREW");

                    refreshComboBox();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pirateCrewModifyView.panel, "Error: " + ex.getMessage(), "Modification Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Save
                    charDatabase.writeDatabase();
                    pirateCrewDatabase.writeDatabase();
                }
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        pirateCrewModifyView.charSelectComboBox.removeActionListener(this);
        // Clear whole list
        pirateCrewModifyView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add crews
        for (PirateCrew crew : pirateCrewDatabase.getAllPCrew())
        {
            pirateCrewModifyView.charSelectComboBox.addItem(crew.GetCrewID() + " - " + crew.GetCrewName());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        pirateCrewModifyView.charSelectComboBox.addActionListener(this);
        // Repopulate pirates for captain and members lists
        populatePirates();
        // If there is at least one crew in the list, simulate a click so the labels update
        if (pirateCrewModifyView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(pirateCrewModifyView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        } else {
            // Clear fields if no crews exist
            pirateCrewModifyView.nameTextField.setText("");
            pirateCrewModifyView.shipTextField.setText("");
            pirateCrewModifyView.captainComboBox.setSelectedIndex(-1);
            pirateCrewModifyView.innerPanel.removeAll();
            pirateCrewModifyView.innerPanel.revalidate();
            pirateCrewModifyView.innerPanel.repaint();
        }
    }

    private void populatePirates() {
        pirateCrewModifyView.captainComboBox.removeAllItems();
        pirateCrewModifyView.captainComboBox.addItem("None");
        pirateCrewModifyView.innerPanel.removeAll();

        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Pirate) {
                Pirate p = (Pirate) c;
                String displayName = p.GetID() + " - " + p.GetName();
                pirateCrewModifyView.captainComboBox.addItem(displayName);
                pirateCrewModifyView.addCharacter(displayName);
            }
        }
        pirateCrewModifyView.innerPanel.revalidate();
        pirateCrewModifyView.innerPanel.repaint();
    }

    private List<Pirate> getPiratesList() {
        List<Pirate> pirates = new ArrayList<>();
        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Pirate) {
                pirates.add((Pirate) c);
            }
        }
        return pirates;
    }

    private Pirate findPirateById(long id) {
        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Pirate && c.GetID() == id) {
                return (Pirate) c;
            }
        }
        return null;
    }
}
