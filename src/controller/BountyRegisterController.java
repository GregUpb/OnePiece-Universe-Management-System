package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;
import model.*;

public class BountyRegisterController implements ActionListener
{
    MainView mainview;
    BountyRegisterView bountyRegisterView;
    BountyManager bountyDatabase;
    
    public BountyRegisterController(MainView mainView, BountyRegisterView bountyRegisterView, BountyManager bountyDatabase)
    {
        this.mainview = mainView;
        this.bountyRegisterView = bountyRegisterView;
        this.bountyDatabase = bountyDatabase;
        
        addActionListener();
    }

    public JPanel getFrame()
    {
        return bountyRegisterView.setFrame();
    }

    public void addActionListener()
    {
        bountyRegisterView.submitButton.addActionListener(this);
        bountyRegisterView.exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == bountyRegisterView.exitButton)
        {
            this.mainview.setInfoText("Bounty");
            this.mainview.showPanel("BOUNTY");
        } else if (e.getSource() == bountyRegisterView.submitButton)
        {


            // At the end (enclose in finally if nagtry and catch ka)
            bountyDatabase.writeDatabase();
        }

    }


}