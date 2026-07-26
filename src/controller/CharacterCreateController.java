package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.CharacterCreateView;
import view.MainView;
import view.PirateCrewView;

public class CharacterCreateController implements ActionListener
{
    MainView mainview;
    CharacterCreateView characterCreateView;
    
    public CharacterCreateController(MainView mainview, CharacterCreateView characterCreateView)
    {
        this.mainview = mainview;

        this.characterCreateView = characterCreateView;
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
        if (e.getSource() == characterCreateView.pirateRadioButton)
        {
            characterCreateView.captureRadioButton.setVisible(true);
            characterCreateView.showPanel("PIRATE");
        }
        if (e.getSource() == characterCreateView.marineRadioButton)
        {
            characterCreateView.aliveRadioButton.setSelected(true);
            characterCreateView.captureRadioButton.setVisible(false);
            characterCreateView.showPanel("MARINE");
        }
        if (e.getSource() == characterCreateView.hunterRadioButton)
        {
            characterCreateView.aliveRadioButton.setSelected(true);
            characterCreateView.captureRadioButton.setVisible(false);
            characterCreateView.showPanel("HUNTER");
        }
        if (e.getSource() == characterCreateView.civRadioButton)
        {
            characterCreateView.aliveRadioButton.setSelected(true);
            characterCreateView.captureRadioButton.setVisible(false);
            characterCreateView.showPanel("CIVILIAN");
        }

    }


}
