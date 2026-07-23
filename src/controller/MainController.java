package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.CharacterView;
import view.DevilFruitView;
import view.MainView;

public class MainController implements ActionListener
{
    MainView mainView;

    CharacterController characterController;
    DevilFruitController devilFruitController;
    
    public MainController(MainView mainView)
    {
        this.mainView = mainView;

        addActionListener();

        characterController = new CharacterController(new CharacterView());
        mainView.addPanel(characterController.getFrame(), "CHARACTER");
        devilFruitController = new DevilFruitController(new DevilFruitView());
        mainView.addPanel(devilFruitController.getFrame(), "DEVILFRUIT");

    }

    public JPanel setFrame()
    {
        return mainView.getFrame();
    }

    public void addActionListener()
    {
        mainView.characterButton.addActionListener(this);
        mainView.devilfruitButton.addActionListener(this);
        mainView.crewButton.addActionListener(this);
        mainView.corpButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == mainView.characterButton)
        {
            mainView.setInfoText("Character");
            mainView.showPanel("CHARACTER");
        }

    }

}
