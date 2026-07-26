package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import model.Character;

import view.CharacterViewView;
import view.MainView;

public class CharacterViewController implements ActionListener
{
    MainView mainview;
    CharacterViewView characterViewView;
    CharacterDatabase charDatabase;
    DevilFruitDatabase devilFruitDatabase;
    
    public CharacterViewController(MainView mainview, CharacterViewView characterViewView, CharacterDatabase charDatabase, DevilFruitDatabase devilFruitDatabase)
    {
        this.mainview = mainview;

        this.characterViewView = characterViewView;
        this.charDatabase = charDatabase;
        this.devilFruitDatabase = devilFruitDatabase;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterViewView.setFrame();
    }

    public void addActionListener()
    {
        characterViewView.backButton.addActionListener(this);
        characterViewView.charSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == characterViewView.backButton)
        {
            characterViewView.setFrame().setVisible(false);
            mainview.showPanel("CHARACTER");
        }
        // When a character is selected on the combo box
        else if (e.getSource() == characterViewView.charSelectComboBox)
        {
            int selectedIndex = characterViewView.charSelectComboBox.getSelectedIndex();

            // Check if selection is valid && is within database bounds
            if (selectedIndex >= 0 && selectedIndex < charDatabase.getAllCharacters().size()) {

                // Fetch the object from DB(Z, ifykyk lng nmn)
                Character selectedChar = charDatabase.getAllCharacters().get(selectedIndex);

                // Update Parent Attribute Labels
                characterViewView.nameLabel.setText("Name: " + selectedChar.GetName());
                characterViewView.aliasLabel.setText("Alias: " + selectedChar.GetAlias());
                characterViewView.originLabel.setText("Origin: " + selectedChar.GetOrigin());
                characterViewView.statusLabel.setText("Status: " + selectedChar.GetStatus());
                characterViewView.walletLabel.setText("Wallet: " + selectedChar.GetWallet() + " Berries");

                if (selectedChar.GetDFPower() != null) {
                    characterViewView.dfLabel.setText("Devil Fruit: " + selectedChar.GetDFPower().GetFruitName());
                } else {
                    characterViewView.dfLabel.setText("Devil Fruit: None");
                }

                // Clear specified labels before checking which instance of Character is it
                characterViewView.specifiedLabel1.setText("");
                characterViewView.specifiedLabel2.setText("");
                characterViewView.specifiedLabel3.setText("");
                characterViewView.specifiedLabel4.setText("");

                // reactivates specified labels depending on what child of Character
                if (selectedChar instanceof Pirate p) {
                    characterViewView.specifiedLabel1.setText("Faction: Pirate");
                    characterViewView.specifiedLabel2.setText("Bounty: " + p.GetBounty());

                    // Display Captain Status or regular Role
                    if (p.IsCaptain()) {
                        characterViewView.specifiedLabel3.setText("Role: Captain");
                    } else {
                        // Assuming you add a standard public String GetPirateRole() getter in Pirate.java
                        characterViewView.specifiedLabel3.setText("Role: " + p.GetPirateRole());
                    }

                    characterViewView.specifiedLabel4.setText("Crew: " + (p.GetPirateCrew() != null ? p.GetPirateCrew().GetCrewName() : "None"));
                }
                else if (selectedChar instanceof Marine m) {
                    characterViewView.specifiedLabel1.setText("Faction: Marine");
                    characterViewView.specifiedLabel2.setText("Rank: " + m.GetRank());
                    characterViewView.specifiedLabel3.setText("Is a Corp Commander: " + m.GetIsCorpCommander());
                    if (m.GetMCorps() == null){
                        characterViewView.specifiedLabel4.setText("Corps: None");
                    } else{
                        characterViewView.specifiedLabel4.setText("Corps: " + m.GetMCorps());
                    }

                }
                else if (selectedChar instanceof PirateHunter ph) {
                    characterViewView.specifiedLabel1.setText("Faction: Pirate Hunter");
                    characterViewView.specifiedLabel2.setText("Combat Style: " + ph.GetCombatStyle());
                    characterViewView.specifiedLabel3.setText("Confirmed Captures: " + ph.GetCaptures());
                }
                else if (selectedChar instanceof Civilian c) {
                    characterViewView.specifiedLabel1.setText("Faction: Civilian");
                    characterViewView.specifiedLabel2.setText("Profession: " + c.GetProfession());
                    characterViewView.specifiedLabel3.setText("Residence: " + c.GetResidence());
                }
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        characterViewView.charSelectComboBox.removeActionListener(this);
        // Clean whole list
        characterViewView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add characters
        for (Character c : charDatabase.getAllCharacters())
        {
            characterViewView.charSelectComboBox.addItem(c.GetID() + " - " + c.GetName());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        characterViewView.charSelectComboBox.addActionListener(this);
        // If there is at least one character in the list, simulate a click so the labels update
        if (characterViewView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(characterViewView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        }
    }
}
