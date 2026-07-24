package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.CharacterView;
import view.DevilFruitView;
import view.MainView;
import view.MarineCorpView;
import view.PirateCrewView;

public class MainController implements ActionListener
{
    MainView mainView;

    /* Controller */
    CharacterController characterController;
    DevilFruitController devilFruitController;
    PirateCrewController pirateCrewController;
    MarineCorpController marineCorpController;
    
    public MainController(MainView mainView)
    {
        this.mainView = mainView;

        addActionListener();

        characterController = new CharacterController(new CharacterView());
        mainView.addPanel(characterController.getFrame(), "CHARACTER");
        devilFruitController = new DevilFruitController(new DevilFruitView());
        mainView.addPanel(devilFruitController.getFrame(), "DEVILFRUIT");
        pirateCrewController = new PirateCrewController(new PirateCrewView());
        mainView.addPanel(pirateCrewController.getFrame(), "PIRATECREW");
        marineCorpController = new MarineCorpController(new MarineCorpView());
        mainView.addPanel(marineCorpController.getFrame(), "MARINECORP");

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
        } else if (e.getSource() == mainView.devilfruitButton)
        {
            mainView.setInfoText("Devil Fruit");
            mainView.showPanel("DEVILFRUIT");
        } else if (e.getSource() == mainView.crewButton)
        {

        } else if (e.getSource() == mainView.corpButton)
        {
            mainView.setInfoText("Marine Corp");
            mainView.showPanel("MARINECORP");
        }

    }

}
