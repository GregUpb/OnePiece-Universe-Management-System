package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;

public class PirateCrewCreateController implements ActionListener
{

    MainView mainView;
    PirateCrewCreateView pirateCrewCreateView;
    
    public PirateCrewCreateController(MainView mainView, PirateCrewCreateView pirateCrewCreateView)
    {
        this.mainView = mainView;
        this.pirateCrewCreateView = pirateCrewCreateView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return pirateCrewCreateView.setFrame();
    }

    public void addActionListener()
    {
        pirateCrewCreateView.exitButton.addActionListener(this);
        pirateCrewCreateView.submitButton.addActionListener(this);

        /* TEMPORARY */
        pirateCrewCreateView.addCharacter("Luffy");
        pirateCrewCreateView.addCharacter("67");
        pirateCrewCreateView.addCharacter("Badass Name");
        pirateCrewCreateView.addCharacter("Asuna");
        pirateCrewCreateView.addCharacter("Zoro");
        pirateCrewCreateView.addCharacter("Mika");
        pirateCrewCreateView.addCharacter("Hina");
        pirateCrewCreateView.addCharacter("JoJo");
        pirateCrewCreateView.addCharacter("Corn");
        pirateCrewCreateView.addCharacter("Karane");
        pirateCrewCreateView.addCharacter("Miku");
        pirateCrewCreateView.addCharacter("Drugs");
        pirateCrewCreateView.addCharacter("Hentai");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == pirateCrewCreateView.exitButton)
        {
            pirateCrewCreateView.panel.setVisible(false);
            mainView.showPanel("PIRATECREW");
        }

    }


}
