package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.CharacterView;

public class CharacterController implements ActionListener
{

    CharacterView characterView;
    
    public CharacterController(CharacterView charView)
    {
        this.characterView = charView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterView.panel;
    }

    public void addActionListener()
    {
        characterView.pirateButton.addActionListener(this);
        characterView.marineButton.addActionListener(this);
        characterView.hunterButton.addActionListener(this);
        characterView.civButton.addActionListener(this);
        characterView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterView.backButton)
        {
            characterView.panel.setVisible(false);
        }

    }


}
