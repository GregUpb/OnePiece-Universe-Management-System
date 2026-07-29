package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import view.*;

public class MarineCorpViewController implements ActionListener
{
    MainView mainView;
    MarineCorpViewView marineCorpViewView;

    public MarineCorpViewController(MainView mainview, MarineCorpViewView marineCorpViewView)
    {
        this.mainView = mainview;
        this.marineCorpViewView = marineCorpViewView;

        addActionListener();
    }

    public void addActionListener()
    {
        marineCorpViewView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == marineCorpViewView.backButton)
        {
            this.mainView.setInfoText("Marine Corp");
            this.mainView.showPanel("MARINECORP");
        }
        

        // When a corp is selected call setMembers(corp.GetCorpMembers)
    }

    public JPanel getFrame()
    {
        return marineCorpViewView.setFrame();
    }
}