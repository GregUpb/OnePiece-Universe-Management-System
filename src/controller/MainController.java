package controller;

import java.awt.event.*;
import javax.swing.JPanel;

import model.*;
import view.BountyView;
import view.CharacterView;
import view.DevilFruitView;
import view.MainView;
import view.MarineCorpView;
import view.PirateCrewView;

public class MainController implements ActionListener
{

    // /* Datas */
    // public List<DevilFruit> devilfruitList = new ArrayList<>();


    public MainView mainView;

    /* Controller */
    CharacterController characterController;
    CharacterCreateController characterCreateController;
    DevilFruitController devilFruitController;
    PirateCrewController pirateCrewController;
    MarineCorpController marineCorpController;
    BountyController bountyController;
    
    public MainController(MainView mainView)
    {
        this.mainView = mainView;

        addActionListener();
        CharacterDatabase characterDatabase = new CharacterDatabase();
        characterDatabase.readDatabase();
        DevilFruitDatabase devilFruitDatabase = new DevilFruitDatabase();
        devilFruitDatabase.readDatabase();
        MarineCorpDatabase marineCorpDatabase = new MarineCorpDatabase();
        marineCorpDatabase.readDatabase();
        PirateCrewDatabase pirateCrewDatabase = new PirateCrewDatabase();
        pirateCrewDatabase.readDatabase();
        BountyManager bountyDatabase = new BountyManager();
        bountyDatabase.readDatabase();

        characterController = new CharacterController(mainView, new CharacterView(), characterDatabase, devilFruitDatabase, marineCorpDatabase, pirateCrewDatabase);
        mainView.addPanel(characterController.getFrame(), "CHARACTER");
        devilFruitController = new DevilFruitController(mainView, new DevilFruitView(), characterDatabase, devilFruitDatabase);
        mainView.addPanel(devilFruitController.getFrame(), "DEVILFRUIT");
        pirateCrewController = new PirateCrewController(mainView, new PirateCrewView(), pirateCrewDatabase, characterDatabase);
        mainView.addPanel(pirateCrewController.getFrame(), "PIRATECREW");
        marineCorpController = new MarineCorpController(mainView, new MarineCorpView(), marineCorpDatabase, characterDatabase);
        mainView.addPanel(marineCorpController.getFrame(), "MARINECORP");
        bountyController = new BountyController(mainView, new BountyView(), bountyDatabase);
        mainView.addPanel(bountyController.getFrame(), "BOUNTY");

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
        mainView.bountyButton.addActionListener(this);

        
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
            mainView.setInfoText("Pirate Crew");
            mainView.showPanel("PIRATECREW");
        } else if (e.getSource() == mainView.corpButton)
        {
            mainView.setInfoText("Marine Corp");
            mainView.showPanel("MARINECORP");
        } else if (e.getSource() == mainView.bountyButton)
        {
            mainView.setInfoText("Bounty");
            mainView.showPanel("BOUNTY");
        }

    }

}

