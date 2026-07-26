package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.CharacterCreateView;
import view.CharacterViewView;
import view.MainView;
import view.PirateCrewView;

public class CharacterViewController implements ActionListener
{
    MainView mainview;
    CharacterViewView characterViewView;
    
    public CharacterViewController(MainView mainview, CharacterViewView characterViewView)
    {
        this.mainview = mainview;

        this.characterViewView = characterViewView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterViewView.setFrame();
    }

    public void addActionListener()
    {
        characterViewView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterViewView.backButton)
        {
            characterViewView.setFrame().setVisible(false);
            mainview.showPanel("CHARACTER");
        }

        // When a character is selected on the combo box, show character info

    }


}
