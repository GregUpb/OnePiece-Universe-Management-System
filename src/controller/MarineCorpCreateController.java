package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;
import  model.*;
import panel.CharacterSelectionPanel;

public class MarineCorpCreateController implements ActionListener
{
    MainView mainView;
    MarineCorpCreateView marineCorpCreateView;

    MarineCorpDatabase marineCorpDatabase;
    CharacterDatabase charDatabase;

    public MarineCorpCreateController(MainView mainView, MarineCorpCreateView marineCorpCreateView, MarineCorpDatabase marineCorpDatabase, CharacterDatabase charDatabase)
    {
        this.mainView = mainView;
        this.marineCorpCreateView = marineCorpCreateView;

        this.marineCorpDatabase = marineCorpDatabase;
        this.charDatabase = charDatabase;

        addActionListener();
    }

    public JPanel getFrame()
    {
        return marineCorpCreateView.setFrame();
    }

    public void addActionListener()
    {
        marineCorpCreateView.exitButton.addActionListener(this);
        marineCorpCreateView.submitButton.addActionListener(this);
    }

    public void refreshData()
    {
        // Clear previous data
        marineCorpCreateView.commanderComboBox.removeAllItems();
        marineCorpCreateView.commanderComboBox.addItem("None");
        marineCorpCreateView.innerPanel.removeAll(); // Clears the previous checklist

        // Punuin ng Marines galing sa database
        for (model.Character c : charDatabase.getAllCharacters()) {
            if (c instanceof Marine) {
                Marine m = (Marine) c;
                // Add to Commander Dropdown
                marineCorpCreateView.commanderComboBox.addItem(m.GetID() + " - " + m.GetName());
                // Add to the visual checklist panel
                marineCorpCreateView.addCharacter(m.GetID() + " - " + m.GetName());
            }
        }

        // Refresh UI to show newly added checkboxes
        marineCorpCreateView.innerPanel.revalidate();
        marineCorpCreateView.innerPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == marineCorpCreateView.exitButton)
        {
            marineCorpCreateView.panel.setVisible(false);
            mainView.showPanel("MARINECORP");
        }
        else if (e.getSource() == marineCorpCreateView.submitButton)
        {
            try {
                String location = marineCorpCreateView.locationTextField.getText();
                int funds = Integer.parseInt(marineCorpCreateView.fundsTextField.getText());
                Marine commander = null;
                int selectedIndex = marineCorpCreateView.commanderComboBox.getSelectedIndex();
                java.util.List<Marine> marines = new java.util.ArrayList<>();
                for (model.Character c : charDatabase.getAllCharacters()) {
                    if (c instanceof Marine) {
                        marines.add((Marine) c);
                    }
                }
                if (selectedIndex > 0) {
                    commander = marines.get(selectedIndex - 1);
                }
                MarineCorp newCorp = new MarineCorp(location, null, funds, new java.util.ArrayList<>());
                if (commander != null) {
                    newCorp.SetCorpCommander(commander);
                    commander.SetIsCorpCommander(true);
                }
                for (java.awt.Component comp : marineCorpCreateView.innerPanel.getComponents()) {
                    if (comp instanceof panel.CharacterSelectionPanel) {
                        panel.CharacterSelectionPanel csp = (panel.CharacterSelectionPanel) comp;
                        if (csp.isSelected()) {
                            String labelText = csp.getName();
                            String idString = labelText.split(" - ")[0];
                            long marineId = Long.parseLong(idString);
                            for (model.Character c : charDatabase.getAllCharacters()) {
                                if (c.GetID() == marineId && c instanceof Marine) {
                                    newCorp.AddCorpMember((Marine) c);
                                    break;
                                }
                            }
                        }
                    }
                }
                marineCorpDatabase.addMCorp(newCorp);
                JOptionPane.showMessageDialog(marineCorpCreateView.panel, "Marine Corp Created Successfully!");
                marineCorpCreateView.panel.setVisible(false);
                mainView.showPanel("MARINECORP");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(marineCorpCreateView.panel, "Operational Funds must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(marineCorpCreateView.panel, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
