package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.CharacterCreateView;
import view.CharacterDeleteView;
import view.CharacterModifyView;
import view.CharacterView;
import view.CharacterViewView;
import view.MainView;
import model.*;

public class CharacterController implements ActionListener
{
    MainView mainview;

    CharacterView characterView;
    CharacterCreateController characterCreateController;
    CharacterViewController characterViewController;
    CharacterModifyController characterModifyController;
    CharacterDeleteController characterDeleteController;
    
    public CharacterController(MainView mainView, CharacterView charView)
    {
        this.mainview = mainView;

        CharacterDatabase charDatabase = new CharacterDatabase();
        characterCreateController = new CharacterCreateController(mainview, new CharacterCreateView(), charDatabase);
        this.mainview.addPanel(characterCreateController.getFrame(), "CHARACTERCREATE");
        characterViewController = new CharacterViewController(mainView, new CharacterViewView(), charDatabase);
        this.mainview.addPanel(characterViewController.getFrame(), "CHARACTERVIEW");
        characterModifyController = new CharacterModifyController(mainView, new CharacterModifyView(), charDatabase);
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
            this.mainview.showPanel("CHARACTERMODIFY");
        } else if (e.getSource() == characterView.deleteButton)
        {
            this.mainview.setInfoText("Unaliving a Character");
            characterDeleteController.refreshComboBox();
            this.mainview.showPanel("CHARACTERDELETE");
        }
        if (e.getSource() == characterView.backButton)
        {
            characterView.panel.setVisible(false);
        }

    }


}