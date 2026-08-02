package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;
import model.*;

public class BountyViewController implements ActionListener
{
    MainView mainview;
    BountyViewView bountyViewView;
    
    public BountyViewController(MainView mainView, BountyViewView bountyViewView)
    {
        this.mainview = mainView;
        this.bountyViewView = bountyViewView;
        
        addActionListener();
    }

    public JPanel getFrame()
    {
        return bountyViewView.setFrame();
    }

    public void addActionListener()
    {
        bountyViewView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == bountyViewView.backButton)
        {
            this.mainview.setInfoText("Bounty");
            this.mainview.showPanel("BOUNTY");
        }

    }


}