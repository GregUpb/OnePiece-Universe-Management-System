package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Character;
import model.*;
import view.CharacterDeleteView;
import view.MainView;

public class CharacterDeleteController implements ActionListener
{
    MainView mainview;
    CharacterDeleteView characterDeleteView;
    CharacterDatabase charDatabase;
    
    public CharacterDeleteController(MainView mainview, CharacterDeleteView characterDeleteView, CharacterDatabase charDatabase)
    {
        this.mainview = mainview;

        this.characterDeleteView = characterDeleteView;
        this.charDatabase = charDatabase;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterDeleteView.setFrame();
    }

    public void addActionListener()
    {
        characterDeleteView.backButton.addActionListener(this);
        characterDeleteView.deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterDeleteView.backButton)
        {
            characterDeleteView.setFrame().setVisible(false);
            mainview.showPanel("CHARACTER");
        } else if (e.getSource() == characterDeleteView.deleteButton)
        {
            int selectedIndex = characterDeleteView.charSelectComboBox.getSelectedIndex();

            // Check if selection is valid && is within database bounds
            if (selectedIndex >= 0 && selectedIndex < charDatabase.getAllCharacters().size()) {

                Character selectedChar = charDatabase.getAllCharacters().get(selectedIndex);

                // Wall of verifications
                int res = JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you Sure you want to unalive " + selectedChar.GetName() + "?");
                if (res == JOptionPane.YES_OPTION)
                {
                    if (JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you really Sure?") == JOptionPane.YES_OPTION)
                    {
                        if (JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you really really Sure?") == JOptionPane.YES_OPTION)
                        {
                            if (JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you really really really Sure?") == JOptionPane.YES_OPTION)
                            {
                                // Removes the character from the database
                                charDatabase.getAllCharacters().remove(selectedIndex);

                                JOptionPane.showMessageDialog(characterDeleteView.mainPanel, selectedChar.GetName() + " has been successfully unalived.");

                                // Refresh the dropdown so the deleted character disappears visually(legit na)
                                refreshComboBox();

                                // Balik main menu ule
                                characterDeleteView.setFrame().setVisible(false);
                                mainview.showPanel("CHARACTER");
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(characterDeleteView.mainPanel, "No character selected!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        characterDeleteView.charSelectComboBox.removeActionListener(this);
        // Clean whole list
        characterDeleteView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add characters
        for (model.Character c : charDatabase.getAllCharacters())
        {
            characterDeleteView.charSelectComboBox.addItem(c.GetID() + " - " + c.GetName());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        characterDeleteView.charSelectComboBox.addActionListener(this);
        // If there is at least one character in the list, simulate a click so the labels update
        if (characterDeleteView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(characterDeleteView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        }
    }


}
