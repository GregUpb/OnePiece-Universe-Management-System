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
    BountyManager bountyDatabase;

    public BountyViewController(MainView mainView, BountyViewView bountyViewView, BountyManager bountyDatabase)
    {
        this.mainview = mainView;
        this.bountyViewView = bountyViewView;
        this.bountyDatabase = bountyDatabase;

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

    public void refreshView()
    {
        // Pass the historical captures from the database into the View
        bountyViewView.setHistoricalCaptures(bountyDatabase.getCaptureHistory());
        bountyViewView.innerPanel.revalidate();
        bountyViewView.innerPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bountyViewView.backButton)
        {
            this.mainview.setInfoText("Bounty");
            this.mainview.showPanel("BOUNTY");
        }
    }
}