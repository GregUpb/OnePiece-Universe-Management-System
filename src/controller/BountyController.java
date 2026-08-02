package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import view.*;

public class BountyController implements ActionListener
{
    MainView mainview;
    BountyView bountyView;
    BountyManager bountyDatabase;
    BountyRegisterController bountyRegisterController;
    BountyViewController bountyViewController;
    
    public BountyController(MainView mainView, BountyView bountyView, BountyManager bountyDatabase)
    {
        this.mainview = mainView;
        this.bountyView = bountyView;
        this.bountyDatabase = bountyDatabase;

        this.bountyRegisterController = new BountyRegisterController(mainView, new BountyRegisterView(), bountyDatabase);
        mainview.addPanel(bountyRegisterController.getFrame(), "BOUNTYREGISTER");
        this.bountyViewController = new BountyViewController(mainView, new BountyViewView());
        mainview.addPanel(bountyViewController.getFrame(), "BOUNTYVIEW");
        
        addActionListener();
    }

    public JPanel getFrame()
    {
        return bountyView.setFrame();
    }

    public void addActionListener()
    {
        bountyView.registerButton.addActionListener(this); // all that need to get or interact
        bountyView.viewButton.addActionListener(this);
        bountyView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == bountyView.registerButton)
        {
            this.mainview.setInfoText("Registering a Bounty");  // Set the text to show some info
            this.mainview.showPanel("BOUNTYREGISTER"); // need a key to show it
        } else if (e.getSource() == bountyView.viewButton)
        {
            this.mainview.setInfoText("Viewing a Historical Bounty");
            this.mainview.showPanel("BOUNTYVIEW");
        }
        if (e.getSource() == bountyView.backButton)
        {
            this.mainview.setInfoText("Main Menu");
            bountyView.panel.setVisible(false);
        }

    }


}