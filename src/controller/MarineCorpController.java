package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import view.*;

public class MarineCorpController implements ActionListener
{

    MainView mainView;
    MarineCorpView marineCorpView;

    MarineCorpCreateController marineCorpCreateController;
    MarineCorpViewController marineCorpViewController;
    MarineCorpModifyController marineCorpModifyController;
    MarineCorpDatabase marineCorpDatabase;
    CharacterDatabase charDatabase;
    
    public MarineCorpController(MainView mainView, MarineCorpView marineCorpView, MarineCorpDatabase marineCorpDatabase, CharacterDatabase charDatabase)
    {
        this.mainView = mainView;
        this.marineCorpView = marineCorpView;
        this.marineCorpDatabase = marineCorpDatabase;
        this.charDatabase = charDatabase;

        this.marineCorpCreateController = new MarineCorpCreateController(mainView, new MarineCorpCreateView(), marineCorpDatabase, charDatabase);
        mainView.addPanel(marineCorpCreateController.getFrame(), "MARINECORPCREATE");
        this.marineCorpViewController = new MarineCorpViewController(mainView, new MarineCorpViewView(), marineCorpDatabase);
        mainView.addPanel(marineCorpViewController.getFrame(), "MARINECORPVIEW");
        this.marineCorpModifyController = new MarineCorpModifyController(mainView, new MarineCorpModifyView(), marineCorpDatabase, charDatabase);
        mainView.addPanel(marineCorpModifyController.getFrame(), "MARINECORPMODIFY");

        addActionListener();
    }

    public JPanel getFrame()
    {
        return marineCorpView.setFrame();
    }

    public void addActionListener()
    {
        marineCorpView.createButton.addActionListener(this);
        marineCorpView.viewButton.addActionListener(this);
        marineCorpView.editButton.addActionListener(this);
        marineCorpView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == marineCorpView.backButton)
        {
            this.mainView.setInfoText("Main Menu");
            marineCorpView.panel.setVisible(false);
        } else if (e.getSource() == marineCorpView.createButton)
        {
            this.mainView.setInfoText("Marine Corp Create");
            marineCorpCreateController.refreshData();
            this.mainView.showPanel("MARINECORPCREATE");
        } else if (e.getSource() == marineCorpView.viewButton)
        {
            this.mainView.setInfoText("Marine Corp View");
            marineCorpViewController.refreshComboBox();
            this.mainView.showPanel("MARINECORPVIEW");
        } else if (e.getSource() == marineCorpView.editButton)
        {
            this.mainView.setInfoText("Marine Corp Modify");
            marineCorpModifyController.refreshComboBox();
            this.mainView.showPanel("MARINECORPMODIFY");
        }

    }


}
