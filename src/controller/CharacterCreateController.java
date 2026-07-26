package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.*;
import model.Character;
import view.CharacterCreateView;
import view.MainView;

public class CharacterCreateController implements ActionListener
{
    MainView mainview;
    CharacterCreateView characterCreateView;
    CharacterDatabase charDatabase;
    DevilFruitDatabase devilFruitDatabase;
    
    public CharacterCreateController(MainView mainview, CharacterCreateView characterCreateView, CharacterDatabase charDatabase, DevilFruitDatabase devilFruitDatabase)
    {
        this.mainview = mainview;

        this.characterCreateView = characterCreateView;
        this.charDatabase = charDatabase;
        this.devilFruitDatabase = devilFruitDatabase;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterCreateView.setFrame();
    }

    public void addActionListener()
    {
        characterCreateView.exitButton.addActionListener(this);
        characterCreateView.submitButton.addActionListener(this);

        characterCreateView.pirateRadioButton.addActionListener(this);
        characterCreateView.marineRadioButton.addActionListener(this);
        characterCreateView.hunterRadioButton.addActionListener(this);
        characterCreateView.civRadioButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterCreateView.exitButton)
        {
            characterCreateView.panel.setVisible(false);
            mainview.showPanel("CHARACTER");
        }
        else if (e.getSource() == characterCreateView.pirateRadioButton)
        {
            characterCreateView.captureRadioButton.setVisible(true);
            characterCreateView.showPanel("PIRATE");
        }
        else if (e.getSource() == characterCreateView.marineRadioButton)
        {
            characterCreateView.aliveRadioButton.setSelected(true);
            characterCreateView.captureRadioButton.setVisible(false);
            characterCreateView.showPanel("MARINE");
        }
        else if (e.getSource() == characterCreateView.hunterRadioButton)
        {
            characterCreateView.aliveRadioButton.setSelected(true);
            characterCreateView.captureRadioButton.setVisible(false);
            characterCreateView.showPanel("HUNTER");
        }
        else if (e.getSource() == characterCreateView.civRadioButton)
        {
            characterCreateView.aliveRadioButton.setSelected(true);
            characterCreateView.captureRadioButton.setVisible(false);
            characterCreateView.showPanel("CIVILIAN");
        }

        // --- NEW SUBMIT LOGIC (Using Public Fields) ---
        else if (e.getSource() == characterCreateView.submitButton)
        {
            try {
                // Extract Parent Attributes directly from public fields
                String name = characterCreateView.nameTextField.getText();
                String alias = characterCreateView.aliasTextField.getText();
                String origin = characterCreateView.originTextField.getText();

                // Determine Status
                String status = "";
                if (characterCreateView.aliveRadioButton.isSelected()) {
                    status = "Alive";
                } else if (characterCreateView.captureRadioButton.isSelected()) {
                    status = "Captured";
                } else if (characterCreateView.deadRadioButton.isSelected()) {
                    status = "Dead";
                }

                // Parse Wallet (will throw NumberFormatException if input is not number)
                int wallet = Integer.parseInt(characterCreateView.walletTextField.getText());

                // Ala pa devil fruit database kaya null ka muna boss
                DevilFruit dfPower = null;
                int selectedDFIndex = characterCreateView.devilfruitComboBox.getSelectedIndex();

                // Index 0 is "None", legit fruits start at index 1.
                if (selectedDFIndex > 0) {
                    dfPower = devilFruitDatabase.getAllDF().get(selectedDFIndex - 1);
                }

                Character newCharacter = null;

                if (characterCreateView.pirateRadioButton.isSelected()) {
                    int bounty = Integer.parseInt(characterCreateView.bountyTextField.getText());
                    String role = (String) characterCreateView.rolesComboBox.getSelectedItem();
                    boolean isCaptain = role.equalsIgnoreCase("Captain");

                    newCharacter = new Pirate(name, alias, origin, status, dfPower, wallet, bounty, role, isCaptain, null);

                }
                else if (characterCreateView.marineRadioButton.isSelected()) {
                    String rank = (String) characterCreateView.ranksComboBox.getSelectedItem();

                    newCharacter = new Marine(name, alias, origin, status, dfPower, wallet, rank, null, false);

                }
                else if (characterCreateView.hunterRadioButton.isSelected()) {
                    String combatStyle = characterCreateView.combatTextField.getText();
                    int captures = Integer.parseInt(characterCreateView.captureTextField.getText());

                    newCharacter = new PirateHunter(name, alias, origin, status, dfPower, wallet, combatStyle, captures);

                }
                else if (characterCreateView.civRadioButton.isSelected()) {
                    String profession = (String) characterCreateView.civrolesComboBox.getSelectedItem();
                    String residence = characterCreateView.residenceTextField.getText();

                    newCharacter = new Civilian(name, alias, origin, status, dfPower, wallet, profession, residence);
                }

                // Add to Database
                if (newCharacter != null) {
                    this.charDatabase.addCharacter(newCharacter);
                    System.out.println("Successfully added " + newCharacter.GetName() + " to the Module 1 Database.");
                    if (dfPower != null) {
                        dfPower.SetCurrentOwner(newCharacter);
                    }
                }

                JOptionPane.showMessageDialog(characterCreateView.panel, "Character Created Successfully!");
                characterCreateView.panel.setVisible(false);
                mainview.showPanel("CHARACTER");

            } catch (NumberFormatException ex) {
                // Catches errors if the user puts letters in the Wallet, Bounty, or Capture fields
                JOptionPane.showMessageDialog(characterCreateView.panel, "Please ensure Wallet, Bounty, and Captures contain only numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(characterCreateView.panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void refreshDFComboBox()
    {
        // Clean whole list
        characterCreateView.devilfruitComboBox.removeAllItems();
        characterCreateView.devilfruitComboBox.addItem("None"); // Default option

        //Populate combo box with devil fruits from database
        for (DevilFruit df : devilFruitDatabase.getAllDF()) {
            characterCreateView.devilfruitComboBox.addItem(df.GetFruitID() + " - " + df.GetFruitName());
        }
    }
}
