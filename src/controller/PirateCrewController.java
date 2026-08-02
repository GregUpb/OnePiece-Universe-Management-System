package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.*;
import model.*;

public class PirateCrewController implements ActionListener
{

    MainView mainView;
    PirateCrewView pirateCrewView;
    PirateCrewCreateController pirateCrewCreateController;
    PirateCrewViewController pirateCrewViewController;
    PirateCrewModifyController pirateCrewModifyController;

    PirateCrewDatabase pirateCrewDatabase;
    CharacterDatabase charDatabase;
    
    public PirateCrewController(MainView mainView, PirateCrewView pirateCrewView, PirateCrewDatabase pirateCrewDatabase, CharacterDatabase charDatabase)
    {
        this.mainView = mainView;
        this.pirateCrewView = pirateCrewView;
        this.pirateCrewDatabase = pirateCrewDatabase;
        this.charDatabase = charDatabase;

        pirateCrewCreateController = new PirateCrewCreateController(mainView, new PirateCrewCreateView(), pirateCrewDatabase, charDatabase);
        mainView.addPanel(pirateCrewCreateController.getFrame(), "PIRATECREWCREATE");
        pirateCrewViewController = new PirateCrewViewController(mainView, new PirateCrewViewView(), pirateCrewDatabase);
        mainView.addPanel(pirateCrewViewController.getFrame(), "PIRATECREWVIEW");
        pirateCrewModifyController = new PirateCrewModifyController(mainView, new PirateCrewModifyView(), pirateCrewDatabase, charDatabase);
        mainView.addPanel(pirateCrewModifyController.getFrame(), "PIRATECREWMODIFY");
        addActionListener();
    }

    public JPanel getFrame()
    {
        return pirateCrewView.setFrame();
    }

    public void addActionListener()
    {
        pirateCrewView.createButton.addActionListener(this);
        pirateCrewView.viewButton.addActionListener(this);
        pirateCrewView.editButton.addActionListener(this);
        pirateCrewView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == pirateCrewView.backButton)
        {
            this.mainView.setInfoText("Main Menu");
            pirateCrewView.panel.setVisible(false);
        } else if (e.getSource() == pirateCrewView.createButton)
        {
            this.mainView.setInfoText("Pirate Crew Create");
            pirateCrewCreateController.refreshData();
            this.mainView.showPanel("PIRATECREWCREATE");
        } else if (e.getSource() == pirateCrewView.viewButton)
        {
            this.mainView.setInfoText("Pirate Crew View");
            pirateCrewViewController.refreshComboBox();
            this.mainView.showPanel("PIRATECREWVIEW");
        } else if (e.getSource() == pirateCrewView.editButton)
        {
            this.mainView.setInfoText("Pirate Crew Modify");
            pirateCrewModifyController.refreshComboBox();
            this.mainView.showPanel("PIRATECREWMODIFY");
        }

    }


}
