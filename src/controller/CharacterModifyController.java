package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.*;
import model.Character;
import view.CharacterModifyView;
import view.MainView;

public class CharacterModifyController implements ActionListener
{
    MainView mainview;
    CharacterModifyView characterModifyView;
    CharacterDatabase charDatabase;
    DevilFruitDatabase devilFruitDatabase;
    PirateCrewDatabase pirateCrewDatabase;
    MarineCorpDatabase marineCorpDatabase;

    public CharacterModifyController(MainView mainview, CharacterModifyView characterModifyView, CharacterDatabase charDatabase, DevilFruitDatabase devilFruitDatabase, PirateCrewDatabase pirateCrewDatabase, MarineCorpDatabase marineCorpDatabase)
    {
        this.mainview = mainview;
        this.characterModifyView = characterModifyView;
        this.charDatabase = charDatabase;
        this.devilFruitDatabase = devilFruitDatabase;
        this.pirateCrewDatabase = pirateCrewDatabase;
        this.marineCorpDatabase = marineCorpDatabase;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterModifyView.setFrame();
    }

    public void addActionListener()
    {
        characterModifyView.exitButton.addActionListener(this);
        characterModifyView.submitButton.addActionListener(this);
        characterModifyView.charSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterModifyView.exitButton)
        {
            characterModifyView.panel.setVisible(false);
            mainview.showPanel("CHARACTER");
        }

        // When a character is selected on the combo box, show character info on the textfields and combobox
        // when submit is clicked get all the data that only have the checkbox checked
        else if (e.getSource() == characterModifyView.charSelectComboBox)
        {
            int selectedIndex = characterModifyView.charSelectComboBox.getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < charDatabase.getAllCharacters().size()) {
                Character selectedChar = charDatabase.getAllCharacters().get(selectedIndex);

                // Populate universal fields
                characterModifyView.nameTextField.setText(selectedChar.GetName());
                characterModifyView.aliasTextField.setText(selectedChar.GetAlias());
                characterModifyView.originTextField.setText(selectedChar.GetOrigin());
                characterModifyView.walletTextField.setText(String.valueOf(selectedChar.GetWallet()));

                // Set radio buttons based on status
                if (selectedChar.GetStatus().equalsIgnoreCase("Alive")) {
                    characterModifyView.aliveRadioButton.setSelected(true);
                } else if (selectedChar.GetStatus().equalsIgnoreCase("Captured")) {
                    characterModifyView.captureRadioButton.setSelected(true);
                } else if (selectedChar.GetStatus().equalsIgnoreCase("Dead")) {
                    characterModifyView.deadRadioButton.setSelected(true);
                }

                // Clear specified labels before checking which instance of Character is it
                characterModifyView.specified1Panel.setVisible(false);
                characterModifyView.specified2Panel.setVisible(false);
                characterModifyView.specified3Panel.setVisible(false);
                characterModifyView.specified4Panel.setVisible(false);

                // reactivates specified labels n other options depending on what child of Character
                if (selectedChar instanceof Pirate p) {
                    characterModifyView.specified1Label.setText("Bounty: ");
                    characterModifyView.specified1TextField.setText(String.valueOf(p.GetBounty()));
                    characterModifyView.specified1Panel.setVisible(true);

                    characterModifyView.specified3Label.setText("Role: ");
                    characterModifyView.specified3ComboBox.removeAllItems();
                    for (String[] role : Pirate.ROLES) {
                        characterModifyView.specified3ComboBox.addItem(role[0]);
                    }
                    characterModifyView.specified3Panel.setVisible(true);
                    //Crew Stuff
                    characterModifyView.specified4Label.setText("Crew: ");
                    characterModifyView.specified4ComboBox.removeAllItems();
                    characterModifyView.specified4ComboBox.addItem("None");
                    for (model.PirateCrew crew : pirateCrewDatabase.getAllPCrew()) {
                        characterModifyView.specified4ComboBox.addItem(crew.GetCrewID() + " - " + crew.GetCrewName());
                    }

                    if (p.GetPirateCrew() != null) {
                        for (int i = 1; i < characterModifyView.specified4ComboBox.getItemCount(); i++) {
                            if (((String)characterModifyView.specified4ComboBox.getItemAt(i)).startsWith(p.GetPirateCrew().GetCrewID() + " -")) {
                                characterModifyView.specified4ComboBox.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                    characterModifyView.specified4Panel.setVisible(true);
                }
                else if (selectedChar instanceof Marine m) {
                    // Rank Stuff
                    characterModifyView.specified3Label.setText("Rank: ");
                    characterModifyView.specified3ComboBox.removeAllItems();
                    for (String[] rank : Marine.RANKS) {
                        characterModifyView.specified3ComboBox.addItem(rank[0]);
                    }

                    // Set current rank in the dropdown
                    for (int i = 0; i < characterModifyView.specified3ComboBox.getItemCount(); i++) {
                        if (((String)characterModifyView.specified3ComboBox.getItemAt(i)).equalsIgnoreCase(m.GetRank())) {
                            characterModifyView.specified3ComboBox.setSelectedIndex(i);
                            break;
                        }
                    }
                    characterModifyView.specified3Panel.setVisible(true);

                    // Corp Stuff
                    characterModifyView.specified4Label.setText("Marine Corp: ");
                    characterModifyView.specified4ComboBox.removeAllItems();
                    characterModifyView.specified4ComboBox.addItem("None");
                    for (model.MarineCorp corp : marineCorpDatabase.getAllMCorp()) {
                        characterModifyView.specified4ComboBox.addItem(corp.GetCorpID() + " - " + corp.GetBaseLocation());
                    }

                    if (m.GetMCorps() != null) {
                        for (int i = 1; i < characterModifyView.specified4ComboBox.getItemCount(); i++) {
                            if (((String)characterModifyView.specified4ComboBox.getItemAt(i)).startsWith(m.GetMCorps().GetCorpID() + " -")) {
                                characterModifyView.specified4ComboBox.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                    characterModifyView.specified4Panel.setVisible(true);
                }
                else if (selectedChar instanceof PirateHunter ph) {
                    characterModifyView.specified1Label.setText("Combat Style: ");
                    characterModifyView.specified1TextField.setText(ph.GetCombatStyle());
                    characterModifyView.specified1Panel.setVisible(true);

                    characterModifyView.specified2Label.setText("Captures: ");
                    characterModifyView.specified2TextField.setText(String.valueOf(ph.GetCaptures()));
                    characterModifyView.specified2Panel.setVisible(true);
                }
                else if (selectedChar instanceof Civilian c) {
                    characterModifyView.specified1Label.setText("Residence: ");
                    characterModifyView.specified1TextField.setText(c.GetResidence());
                    characterModifyView.specified1Panel.setVisible(true);
                }
            }
        }

        // Applies modifications when submitted
        else if (e.getSource() == characterModifyView.submitButton)
        {
            int selectedIndex = characterModifyView.charSelectComboBox.getSelectedIndex();

            if (selectedIndex >= 0 && selectedIndex < charDatabase.getAllCharacters().size()) {
                Character selectedChar = charDatabase.getAllCharacters().get(selectedIndex);

                try {
                    // Execute Setters IF AND ONLY IF the respective checkbox is checked
                    if (characterModifyView.nameCheckBox.isSelected()) {
                        selectedChar.SetName(characterModifyView.nameTextField.getText());
                    }
                    if (characterModifyView.aliasCheckBox.isSelected()) {
                        selectedChar.SetAlias(characterModifyView.aliasTextField.getText());
                    }
                    if (characterModifyView.originCheckBox.isSelected()) {
                        selectedChar.SetOrigin(characterModifyView.originTextField.getText());
                    }
                    if (characterModifyView.walletCheckBox.isSelected()) {
                        selectedChar.SetWallet(Integer.parseInt(characterModifyView.walletTextField.getText()));
                    }
                    if (characterModifyView.statusCheckBox.isSelected()) {
                        if (characterModifyView.aliveRadioButton.isSelected()) selectedChar.SetStatus("Alive");
                        if (characterModifyView.captureRadioButton.isSelected()) selectedChar.SetStatus("Captured");
                        if (characterModifyView.deadRadioButton.isSelected()) selectedChar.SetStatus("Dead");
                    }
                    if (characterModifyView.dfCheckBox.isSelected()) {
                        int selectedDFIndex = characterModifyView.devilfruitComboBox.getSelectedIndex();

                        if (selectedDFIndex == 0) {
                            selectedChar.SetDFPower(null); // Set to None
                        } else {
                            DevilFruit newDF = devilFruitDatabase.getAllDF().get(selectedDFIndex - 1);
                            selectedChar.SetDFPower(newDF);
                            newDF.SetCurrentOwner(selectedChar);
                        }
                    }

                    // Does child class modifications
                    if (selectedChar instanceof Pirate p) {
                        if (characterModifyView.specified1CheckBox.isSelected()) {
                            p.SetBounty(Integer.parseInt(characterModifyView.specified1TextField.getText()));
                        }
                        if (characterModifyView.specified3CheckBox.isSelected()) {
                            String selectedRole = (String) characterModifyView.specified3ComboBox.getSelectedItem();
                            p.SetPirateRole(selectedRole);
                            p.SetIsCaptain(selectedRole.equalsIgnoreCase("Captain"));
                        }
                        if (characterModifyView.specified4CheckBox.isSelected()) {
                            int crewIndex = characterModifyView.specified4ComboBox.getSelectedIndex();
                            if (crewIndex == 0) {
                                p.SetPirateCrew(null);
                            } else {
                                model.PirateCrew newCrew = pirateCrewDatabase.getAllPCrew().get(crewIndex - 1);
                                p.SetPirateCrew(newCrew);
                            }
                        }
                    }
                    else if (selectedChar instanceof Marine m) {
                        // Save Rank Modification
                        if (characterModifyView.specified3CheckBox.isSelected()) {
                            m.SetRank((String) characterModifyView.specified3ComboBox.getSelectedItem());
                        }

                        // Save Corp Modification
                        if (characterModifyView.specified4CheckBox.isSelected()) {
                            int corpIndex = characterModifyView.specified4ComboBox.getSelectedIndex();
                            if (corpIndex == 0) {
                                m.SetMCorps(null);
                            } else {
                                model.MarineCorp newCorp = marineCorpDatabase.getAllMCorp().get(corpIndex - 1);
                                m.SetMCorps(newCorp);
                            }
                        }
                    }
                    else if (selectedChar instanceof PirateHunter ph) {
                        if (characterModifyView.specified1CheckBox.isSelected()) {
                            ph.SetCombatStyle(characterModifyView.specified1TextField.getText());
                        }
                        if (characterModifyView.specified2CheckBox.isSelected()) {
                            ph.SetCaptures(Integer.parseInt(characterModifyView.specified2TextField.getText()));
                        }
                    }
                    else if (selectedChar instanceof Civilian c) {
                        if (characterModifyView.specified1CheckBox.isSelected()) {
                            c.SetResidence(characterModifyView.specified1TextField.getText());
                        }
                    }

                    JOptionPane.showMessageDialog(characterModifyView.panel, "Character Modified Successfully!");
                    characterModifyView.panel.setVisible(false);
                    mainview.showPanel("CHARACTER");

                    // Refresh the combo box to reflect name changes
                    refreshComboBox();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(characterModifyView.panel, "Numeric fields (Wallet, Bounty, Captures) must contain valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        characterModifyView.charSelectComboBox.removeActionListener(this);
        // Clean whole list
        characterModifyView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add characters
        for (Character c : charDatabase.getAllCharacters())
        {
            characterModifyView.charSelectComboBox.addItem(c.GetID() + " - " + c.GetName());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        characterModifyView.charSelectComboBox.addActionListener(this);
        // If there is at least one character in the list, simulate a click so the labels update
        if (characterModifyView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(characterModifyView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        }
    }

    public void refreshDFComboBox()
    {
        characterModifyView.devilfruitComboBox.removeAllItems();
        characterModifyView.devilfruitComboBox.addItem("None"); // Default option

        for (DevilFruit df : devilFruitDatabase.getAllDF()) {
            characterModifyView.devilfruitComboBox.addItem(df.GetFruitID() + " - " + df.GetFruitName());
        }
    }
}
