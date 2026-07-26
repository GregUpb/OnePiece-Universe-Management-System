package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.CharacterCreateView;
import view.CharacterModifyView;
import view.MainView;
import view.PirateCrewView;

public class CharacterModifyController implements ActionListener
{
    MainView mainview;
    CharacterModifyView characterModifyView;
    
    public CharacterModifyController(MainView mainview, CharacterModifyView characterModifyView)
    {
        this.mainview = mainview;

        this.characterModifyView = characterModifyView;
        addActionListener();

        // set it so the first character is already set to modify
    }

    public JPanel getFrame()
    {
        return characterModifyView.setFrame();
    }

    public void addActionListener()
    {
        characterModifyView.exitButton.addActionListener(this);
        characterModifyView.submitButton.addActionListener(this);
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

    }


}
