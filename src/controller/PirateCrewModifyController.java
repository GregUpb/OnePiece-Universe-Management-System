package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;

public class PirateCrewModifyController implements ActionListener
{

    MainView mainView;
    PirateCrewModifyView pirateCrewModifyView;
    
    public PirateCrewModifyController(MainView mainView, PirateCrewModifyView pirateCrewModifyView)
    {
        this.mainView = mainView;
        this.pirateCrewModifyView = pirateCrewModifyView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return pirateCrewModifyView.setFrame();
    }

    public void addActionListener()
    {
        pirateCrewModifyView.exitButton.addActionListener(this);
        pirateCrewModifyView.submitButton.addActionListener(this);

        /* TEMPORARY */
        pirateCrewModifyView.addCharacter("Luffy");
        pirateCrewModifyView.addCharacter("67");
        pirateCrewModifyView.addCharacter("Badass Name");
        pirateCrewModifyView.addCharacter("Asuna");
        pirateCrewModifyView.addCharacter("Zoro");
        pirateCrewModifyView.addCharacter("Mika");
        pirateCrewModifyView.addCharacter("Hina");
        pirateCrewModifyView.addCharacter("JoJo");
        pirateCrewModifyView.addCharacter("Corn");
        pirateCrewModifyView.addCharacter("Karane");
        pirateCrewModifyView.addCharacter("Miku");
        pirateCrewModifyView.addCharacter("Drugs");
        pirateCrewModifyView.addCharacter("Hentai");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == pirateCrewModifyView.exitButton)
        {
            pirateCrewModifyView.panel.setVisible(false);
            mainView.showPanel("PIRATECREW");
        }

    }


}
