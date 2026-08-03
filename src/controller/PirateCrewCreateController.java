package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.*;
import view.*;

public class PirateCrewCreateController implements ActionListener
{
    MainView mainView;
    PirateCrewCreateView pirateCrewCreateView;

    PirateCrewDatabase pirateCrewDatabase;
    CharacterDatabase charDatabase;

    public PirateCrewCreateController(MainView mainView, PirateCrewCreateView pirateCrewCreateView, PirateCrewDatabase pirateCrewDatabase, CharacterDatabase charDatabase)
    {
        this.mainView = mainView;
        this.pirateCrewCreateView = pirateCrewCreateView;

        this.pirateCrewDatabase = pirateCrewDatabase;
        this.charDatabase = charDatabase;

        addActionListener();
    }

    public JPanel getFrame()
    {
        return pirateCrewCreateView.setFrame();
    }

    public void addActionListener()
    {
        pirateCrewCreateView.exitButton.addActionListener(this);
        pirateCrewCreateView.submitButton.addActionListener(this);
    }

    public void refreshData()
    {
        // 1. Clear previous data
        pirateCrewCreateView.captainComboBox.removeAllItems();
        pirateCrewCreateView.captainComboBox.addItem("None");
        pirateCrewCreateView.innerPanel.removeAll(); // Clears the previous checklist

        // 2. Populate with actual Pirates from the database
        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Pirate) {
                Pirate p = (Pirate) c;
                String displayName = p.GetID() + " - " + p.GetName();

                // Add to Captain Dropdown
                pirateCrewCreateView.captainComboBox.addItem(displayName);

                // Add to the visual checklist panel
                pirateCrewCreateView.addCharacter(displayName);
            }
        }

        // Refresh the UI to show the newly added checkboxes
        pirateCrewCreateView.innerPanel.revalidate();
        pirateCrewCreateView.innerPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == pirateCrewCreateView.exitButton)
        {
            pirateCrewCreateView.panel.setVisible(false);
            mainView.showPanel("PIRATECREW");
        }
        else if (e.getSource() == pirateCrewCreateView.submitButton)
        {
            try {
                String name = pirateCrewCreateView.nameTextField.getText();
                String ship = pirateCrewCreateView.shipTextField.getText();
                Pirate captain = null;
                int selectedIndex = pirateCrewCreateView.captainComboBox.getSelectedIndex();

                // Create a list of just the Pirates to match the ComboBox index
                List<Pirate> pirates = new ArrayList<>();
                for (model.Character c : charDatabase.getAllCharacters()) {
                    if (c instanceof Pirate) {
                        pirates.add((Pirate) c);
                    }
                }
                if (selectedIndex > 0) {
                    captain = pirates.get(selectedIndex - 1);
                }
                PirateCrew newCrew = new PirateCrew(name, ship, null, new ArrayList<>());
                if (captain != null) {
                    newCrew.SetCaptain(captain);
                    captain.SetPirateRole("Captain");
                    captain.SetIsCaptain(true);
                }
                for (java.awt.Component comp : pirateCrewCreateView.innerPanel.getComponents()) {
                    if (comp instanceof panel.CharacterSelectionPanel) {
                        panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;

                        // If the checkbox is checked, extract the Pirate
                        if (csp.isSelected()) {
                            String idString = csp.getName().split(" - ")[0];
                            long pirateId = Long.parseLong(idString);

                            // Find the matching pirate in the database and link them
                            for (model.Character c : charDatabase.getAllCharacters()) {
                                if (c.GetID() == pirateId && c instanceof Pirate) {
                                    newCrew.AddCrewMember((Pirate) c);
                                    break;
                                }
                            }
                        }
                    }
                }

                // Add to Database
                pirateCrewDatabase.addPCrew(newCrew);
                JOptionPane.showMessageDialog(pirateCrewCreateView.panel, "Pirate Crew Created Successfully!");
                pirateCrewCreateView.panel.setVisible(false);
                mainView.showPanel("PIRATECREW");

                // Reset Fields
                pirateCrewCreateView.nameTextField.setText("");
                pirateCrewCreateView.shipTextField.setText("");
                pirateCrewCreateView.captainComboBox.setSelectedIndex(0);
                
                for (java.awt.Component comp : pirateCrewCreateView.innerPanel.getComponents()) {
                    if (comp instanceof panel.CharacterSelectionPanel) {
                        panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;
                        csp.checkBox.setSelected(false);
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(pirateCrewCreateView.panel, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Save
                charDatabase.writeDatabase();
                pirateCrewDatabase.writeDatabase();
            }
        }
    }
}
