package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import view.*;

public class PirateCrewViewController implements ActionListener
{
    MainView mainView;
    PirateCrewViewView pirateCrewViewView;

    public PirateCrewViewController(MainView mainview, PirateCrewViewView pirateCrewViewView)
    {
        this.mainView = mainview;
        this.pirateCrewViewView = pirateCrewViewView;

        addActionListener();
    }

    public void addActionListener()
    {
        pirateCrewViewView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == pirateCrewViewView.backButton)
        {
            this.mainView.setInfoText("Pirate Crew");
            this.mainView.showPanel("PIRATECREW");
        }
        
    }

    public JPanel getFrame()
    {
        return pirateCrewViewView.setFrame();
    }
}