package controller;

import exceptions.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.*;
import view.CharacterCreateView;
import view.MainView;

public class CharacterCreateController implements ActionListener
{
    MainView mainview;
    CharacterCreateView characterCreateView;
    CharacterDatabase charDatabase;
    DevilFruitDatabase devilFruitDatabase;
    PirateCrewDatabase pirateCrewDatabase;
    MarineCorpDatabase marineCorpDatabase;

    public CharacterCreateController(MainView mainview, CharacterCreateView characterCreateView, CharacterDatabase charDatabase, DevilFruitDatabase devilFruitDatabase, PirateCrewDatabase pirateCrewDatabase, MarineCorpDatabase marineCorpDatabase)
    {
        this.mainview = mainview;
        this.characterCreateView = characterCreateView;
        this.charDatabase = charDatabase;
        this.devilFruitDatabase = devilFruitDatabase;
        this.pirateCrewDatabase = pirateCrewDatabase;
        this.marineCorpDatabase = marineCorpDatabase;
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

        else if (e.getSource() == characterCreateView.submitButton)
        {
            try {
                String name = characterCreateView.nameTextField.getText();
                String alias = characterCreateView.aliasTextField.getText();
                String origin = characterCreateView.originTextField.getText();

                if (name.isBlank())
                {
                    throw new EmptyInputException("Name cannot be empty");
                } else if (origin.isBlank())
                {
                    throw new EmptyInputException("Origin cannot be empty");
                }

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

                DevilFruit dfPower = null;
                int selectedDFIndex = characterCreateView.devilfruitComboBox.getSelectedIndex();

                // Index 0 is "None", legit fruits start at index 1.
                if (selectedDFIndex > 0) {
                    dfPower = devilFruitDatabase.getAllDF().get(selectedDFIndex - 1);
                }

                model.Character newCharacter = null;

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

                    if (dfPower != null) {
                        dfPower.SetCurrentOwner(newCharacter);
                    }

                    if (newCharacter instanceof Pirate) {
                        int selectedCrewIndex = characterCreateView.crewComboBox.getSelectedIndex();
                        if (selectedCrewIndex > 0) {
                            model.PirateCrew selectedCrew = pirateCrewDatabase.getAllPCrew().get(selectedCrewIndex - 1);
                            ((Pirate) newCharacter).SetPirateCrew(selectedCrew);
                        }
                    } else if (newCharacter instanceof Marine) {
                        int selectedCorpIndex = characterCreateView.corpComboBox.getSelectedIndex();
                        if (selectedCorpIndex > 0) {
                            model.MarineCorp selectedCorp = marineCorpDatabase.getAllMCorp().get(selectedCorpIndex - 1);
                            ((Marine) newCharacter).SetMCorps(selectedCorp);
                        }
                    }
                }

                characterCreateView.nameTextField.setText("");
                characterCreateView.aliasTextField.setText("");
                characterCreateView.originTextField.setText("");
                characterCreateView.aliveRadioButton.setSelected(true);
                characterCreateView.devilfruitComboBox.setSelectedIndex(0);
                characterCreateView.walletTextField.setText("");

                characterCreateView.bountyTextField.setText("");
                characterCreateView.rolesComboBox.setSelectedIndex(0);
                characterCreateView.crewComboBox.setSelectedIndex(0);
                
                characterCreateView.ranksComboBox.setSelectedIndex(0);
                characterCreateView.corpComboBox.setSelectedIndex(0);
                
                characterCreateView.combatTextField.setText("");
                characterCreateView.captureTextField.setText("");
                
                characterCreateView.civrolesComboBox.setSelectedIndex(0);
                characterCreateView.residenceTextField.setText("");

                JOptionPane.showMessageDialog(characterCreateView.panel, "Character Created Successfully!");
                characterCreateView.panel.setVisible(false);
                mainview.showPanel("CHARACTER");

            } catch (NumberFormatException ex) {
                // Catches errors if the user puts letters in the Wallet, Bounty, or Capture fields
                JOptionPane.showMessageDialog(characterCreateView.panel, "Please ensure Wallet, Bounty, and Captures contain only numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(characterCreateView.panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Save
                charDatabase.writeDatabase();
                devilFruitDatabase.writeDatabase();
                pirateCrewDatabase.writeDatabase();
                marineCorpDatabase.writeDatabase();
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

    public void refreshAffiliationComboBoxes()
    {
        characterCreateView.crewComboBox.removeAllItems();
        characterCreateView.crewComboBox.addItem("None");
        for (model.PirateCrew crew : pirateCrewDatabase.getAllPCrew()) {
            characterCreateView.crewComboBox.addItem(crew.GetCrewID() + " - " + crew.GetCrewName());
        }

        characterCreateView.corpComboBox.removeAllItems();
        characterCreateView.corpComboBox.addItem("None");
        for (model.MarineCorp corp : marineCorpDatabase.getAllMCorp()) {
            characterCreateView.corpComboBox.addItem(corp.GetCorpID() + " - " + corp.GetBaseLocation());
        }
    }
}
