package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;
import model.*;

public class BountyController implements ActionListener
{
    MainView mainview;
    BountyView bountyView;
    
    public BountyController(MainView mainView, BountyView bountyView)
    {
        this.mainview = mainView;
        this.bountyView = bountyView;
        
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