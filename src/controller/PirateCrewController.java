package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.PirateCrewView;

public class PirateCrewController implements ActionListener
{

    PirateCrewView pirateCrewView;
    
    public PirateCrewController(PirateCrewView pirateCrewView)
    {
        this.PirateCrewView = pirateCrewView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return pirateCrewView.panel;
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
            pirateCrewView.panel.setVisible(false);
        }

    }


}
