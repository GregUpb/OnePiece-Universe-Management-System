package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.MarineCorpView;

public class MarineCorpController implements ActionListener
{

    MarineCorpView marineCorpView;
    
    public MarineCorpController(MarineCorpView marineCorpView)
    {
        this.marineCorpView = marineCorpView;
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
            marineCorpView.panel.setVisible(false);
        }

    }


}
