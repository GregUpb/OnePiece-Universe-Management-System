package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import view.CharacterCreateView;
import view.CharacterDeleteView;
import view.CharacterModifyView;
import view.CharacterView;
import view.CharacterViewView;
import view.MainView;

public class CharacterController implements ActionListener
{
    MainView mainview;

    CharacterView characterView;
    CharacterCreateController characterCreateController;
    CharacterViewController characterViewController;
    CharacterModifyController characterModifyController;
    CharacterDeleteController characterDeleteController;
    CharacterDatabase charDatabase;
    DevilFruitDatabase devilFruitDatabase;
    MarineCorpDatabase marineCorpDatabase;
    PirateCrewDatabase pirateCrewDatabase;
    
    public CharacterController(MainView mainView, CharacterView charView, CharacterDatabase charDatabase, DevilFruitDatabase devilFruitDatabase, MarineCorpDatabase marineCorpDatabase, PirateCrewDatabase pirateCrewDatabase)
    {
        this.mainview = mainView;

        this.charDatabase = charDatabase;
        this.devilFruitDatabase = devilFruitDatabase;
        characterCreateController = new CharacterCreateController(mainview, new CharacterCreateView(), charDatabase, devilFruitDatabase, pirateCrewDatabase, marineCorpDatabase);
        this.mainview.addPanel(characterCreateController.getFrame(), "CHARACTERCREATE");
        characterViewController = new CharacterViewController(mainView, new CharacterViewView(), charDatabase, devilFruitDatabase);
        this.mainview.addPanel(characterViewController.getFrame(), "CHARACTERVIEW");
        characterModifyController = new CharacterModifyController(mainView, new CharacterModifyView(), charDatabase, devilFruitDatabase, pirateCrewDatabase, marineCorpDatabase);
        this.mainview.addPanel(characterModifyController.getFrame(), "CHARACTERMODIFY");
        characterDeleteController = new CharacterDeleteController(mainView, new CharacterDeleteView(), charDatabase);
        this.mainview.addPanel(characterDeleteController.getFrame(), "CHARACTERDELETE");

        this.characterView = charView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterView.setFrame();
    }

    public void addActionListener()
    {
        characterView.createButton.addActionListener(this); // all that need to get or interact
        characterView.viewButton.addActionListener(this);
        characterView.modifyButton.addActionListener(this);
        characterView.deleteButton.addActionListener(this);
        characterView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterView.createButton)
        {
            this.mainview.setInfoText("Creating a Character");  // Set the text to show some info
            characterCreateController.refreshDFComboBox();
            characterCreateController.refreshAffiliationComboBoxes();
            this.mainview.showPanel("CHARACTERCREATE"); // need a key to show it
        } else if (e.getSource() == characterView.viewButton)
        {
            this.mainview.setInfoText("Viewing a Character");
            characterViewController.refreshComboBox();
            this.mainview.showPanel("CHARACTERVIEW");
        } else if (e.getSource() == characterView.modifyButton)
        {
            this.mainview.setInfoText("Modifying a Character");
            characterModifyController.refreshComboBox();
            characterModifyController.refreshDFComboBox();
            this.mainview.showPanel("CHARACTERMODIFY");
        } else if (e.getSource() == characterView.deleteButton)
        {
            this.mainview.setInfoText("Unaliving a Character");
            characterDeleteController.refreshComboBox();
            this.mainview.showPanel("CHARACTERDELETE");
        }
        if (e.getSource() == characterView.backButton)
        {
            this.mainview.setInfoText("Main Menu");
            characterView.panel.setVisible(false);
        }

    }


}