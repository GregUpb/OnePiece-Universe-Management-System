package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.*;
import view.*;

public class MarineCorpModifyController implements ActionListener
{
    MainView mainView;
    MarineCorpModifyView marineCorpModifyView;
    MarineCorpDatabase marineCorpDatabase;
    CharacterDatabase charDatabase;

    public MarineCorpModifyController(MainView mainView, MarineCorpModifyView marineCorpModifyView, MarineCorpDatabase marineCorpDatabase, CharacterDatabase charDatabase)
    {
        this.mainView = mainView;
        this.marineCorpModifyView = marineCorpModifyView;
        this.marineCorpDatabase = marineCorpDatabase;
        this.charDatabase = charDatabase;

        addActionListener();
    }

    public JPanel getFrame()
    {
        return marineCorpModifyView.setFrame();
    }

    public void addActionListener()
    {
        marineCorpModifyView.exitButton.addActionListener(this);
        marineCorpModifyView.submitButton.addActionListener(this);
        marineCorpModifyView.charSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == marineCorpModifyView.exitButton)
        {
            marineCorpModifyView.panel.setVisible(false);
            mainView.showPanel("MARINECORP");
        }
        else if (e.getSource() == marineCorpModifyView.charSelectComboBox)
        {
            int selectedIndex = marineCorpModifyView.charSelectComboBox.getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < marineCorpDatabase.getAllMCorp().size()) {
                MarineCorp selectedCorp = marineCorpDatabase.getAllMCorp().get(selectedIndex);

                marineCorpModifyView.locationTextField.setText(selectedCorp.GetBaseLocation());
                marineCorpModifyView.fundsTextField.setText(String.valueOf(selectedCorp.GetOperationalFunds()));

                // Set commander combobox
                if (selectedCorp.GetCorpsCommander() != null) {
                    for (int i = 1; i < marineCorpModifyView.commanderComboBox.getItemCount(); i++) {
                        String item = (String) marineCorpModifyView.commanderComboBox.getItemAt(i);
                        if (item.startsWith(selectedCorp.GetCorpsCommander().GetID() + " -")) {
                            marineCorpModifyView.commanderComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                } else {
                    marineCorpModifyView.commanderComboBox.setSelectedIndex(0); // None
                }

                // Update members checkboxes
                for (java.awt.Component comp : marineCorpModifyView.innerPanel.getComponents()) {
                    if (comp instanceof panel.CharacterSelectionPanel) {
                        panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;
                        String idString = csp.getName().split(" - ")[0];
                        long marineId = Long.parseLong(idString);

                        // Check if this marine is in the current corp's member list
                        boolean isMember = false;
                        for (Marine m : selectedCorp.GetCorpMembers()) {
                            if (m.GetID() == marineId) {
                                isMember = true;
                                break;
                            }
                        }
                        csp.setChecked(isMember);
                    }
                }
            }
        }
        else if (e.getSource() == marineCorpModifyView.submitButton)
        {
            int selectedIndex = marineCorpModifyView.charSelectComboBox.getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < marineCorpDatabase.getAllMCorp().size()) {
                MarineCorp selectedCorp = marineCorpDatabase.getAllMCorp().get(selectedIndex);

                try {
                    // Update Location
                    if (marineCorpModifyView.locationCheckBox.isSelected()) {
                        selectedCorp.SetBaseLocation(marineCorpModifyView.locationTextField.getText());
                    }

                    // Update Funds
                    if (marineCorpModifyView.fundsCheckBox.isSelected()) {
                        selectedCorp.SetOperationalFunds(Integer.parseInt(marineCorpModifyView.fundsTextField.getText()));
                    }

                    // Update Commander
                    if (marineCorpModifyView.commanderCheckBox.isSelected()) {
                        int cmdIndex = marineCorpModifyView.commanderComboBox.getSelectedIndex();
                        if (cmdIndex > 0) {
                            List<Marine> marines = getMarinesList();
                            Marine newCommander = marines.get(cmdIndex - 1);
                            selectedCorp.SetCorpCommander(newCommander);
                        }
                    }

                    // Update Members list
                    if (marineCorpModifyView.membersCheckBox.isSelected()) {
                        for (java.awt.Component comp : marineCorpModifyView.innerPanel.getComponents()) {
                            if (comp instanceof panel.CharacterSelectionPanel) {
                                panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;
                                String idString = csp.getName().split(" - ")[0];
                                long marineId = Long.parseLong(idString);

                                Marine marineObj = findMarineById(marineId);

                                if (marineObj != null) {
                                    if (csp.isSelected()) {
                                        selectedCorp.AddCorpMember(marineObj);
                                    } else {
                                        selectedCorp.RemoveCorpMember(marineObj);
                                    }
                                }
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(marineCorpModifyView.panel, "Marine Corp Modified Successfully!");
                    marineCorpModifyView.panel.setVisible(false);
                    mainView.showPanel("MARINECORP");

                    refreshComboBox();

                    // Reset checkboxes
                    marineCorpModifyView.locationCheckBox.setSelected(false);
                    marineCorpModifyView.fundsCheckBox.setSelected(false);
                    marineCorpModifyView.commanderCheckBox.setSelected(false);
                    marineCorpModifyView.membersCheckBox.setSelected(false);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(marineCorpModifyView.panel, "Funds must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                // Save
                charDatabase.writeDatabase();
                marineCorpDatabase.writeDatabase();
            }
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        marineCorpModifyView.charSelectComboBox.removeActionListener(this);
        // Clean whole list
        marineCorpModifyView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add corps
        for (MarineCorp corp : marineCorpDatabase.getAllMCorp())
        {
            marineCorpModifyView.charSelectComboBox.addItem(corp.GetCorpID() + " - " + corp.GetBaseLocation());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        marineCorpModifyView.charSelectComboBox.addActionListener(this);
        // Repopulate marines for commander and members lists
        populateMarines();
        // If there is at least one character in the list, simulate a click so the labels update
        if (marineCorpModifyView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(marineCorpModifyView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        } else {
            // Clear fields if no corps exist
            marineCorpModifyView.locationTextField.setText("");
            marineCorpModifyView.fundsTextField.setText("");
            marineCorpModifyView.commanderComboBox.setSelectedIndex(-1);
            marineCorpModifyView.innerPanel.removeAll();
            marineCorpModifyView.innerPanel.revalidate();
            marineCorpModifyView.innerPanel.repaint();
        }
    }

    private void populateMarines() {
        marineCorpModifyView.commanderComboBox.removeAllItems();
        marineCorpModifyView.commanderComboBox.addItem("None");
        marineCorpModifyView.innerPanel.removeAll();

        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Marine) {
                Marine m = (Marine) c;
                String displayName = m.GetID() + " - " + m.GetName();
                marineCorpModifyView.commanderComboBox.addItem(displayName);
                marineCorpModifyView.addCharacter(displayName);
            }
        }
        marineCorpModifyView.innerPanel.revalidate();
        marineCorpModifyView.innerPanel.repaint();
    }

    private List<Marine> getMarinesList() {
        List<Marine> marines = new ArrayList<>();
        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Marine) {
                marines.add((Marine) c);
            }
        }
        return marines;
    }

    private Marine findMarineById(long id) {
        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Marine && c.GetID() == id) {
                return (Marine) c;
            }
        }
        return null;
    }
}
