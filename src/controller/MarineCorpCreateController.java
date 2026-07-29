package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;

public class MarineCorpCreateController implements ActionListener
{

    MainView mainView;
    MarineCorpCreateView marineCorpCreateView;
    
    public MarineCorpCreateController(MainView mainView, MarineCorpCreateView marineCorpCreateView)
    {
        this.mainView = mainView;
        this.marineCorpCreateView = marineCorpCreateView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return marineCorpCreateView.setFrame();
    }

    public void addActionListener()
    {
        marineCorpCreateView.exitButton.addActionListener(this);
        marineCorpCreateView.submitButton.addActionListener(this);

        /* TEMPORARY */
        marineCorpCreateView.addCharacter("Luffy");
        marineCorpCreateView.addCharacter("67");
        marineCorpCreateView.addCharacter("Badass Name");
        marineCorpCreateView.addCharacter("Asuna");
        marineCorpCreateView.addCharacter("Zoro");
        marineCorpCreateView.addCharacter("Mika");
        marineCorpCreateView.addCharacter("Hina");
        marineCorpCreateView.addCharacter("JoJo");
        marineCorpCreateView.addCharacter("Corn");
        marineCorpCreateView.addCharacter("Karane");
        marineCorpCreateView.addCharacter("Miku");
        marineCorpCreateView.addCharacter("Drugs");
        marineCorpCreateView.addCharacter("Hentai");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == marineCorpCreateView.exitButton)
        {
            marineCorpCreateView.panel.setVisible(false);
            mainView.showPanel("MARINECORP");
        }

    }


}
