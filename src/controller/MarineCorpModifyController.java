package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import view.*;

public class MarineCorpModifyController implements ActionListener
{

    MainView mainView;
    MarineCorpModifyView marineCorpModifyView;
    
    public MarineCorpModifyController(MainView mainView, MarineCorpModifyView marineCorpModifyView)
    {
        this.mainView = mainView;
        this.marineCorpModifyView = marineCorpModifyView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return marineCorpModifyView.setFrame();
    }

    public void addActionListener()
    {
        marineCorpModifyView.exitButton.addActionListener(this);
        marineCorpModifyView.submitButton.addActionListener(this);

        /* TEMPORARY */
        marineCorpModifyView.addCharacter("Luffy");
        marineCorpModifyView.addCharacter("67");
        marineCorpModifyView.addCharacter("Badass Name");
        marineCorpModifyView.addCharacter("Asuna");
        marineCorpModifyView.addCharacter("Zoro");
        marineCorpModifyView.addCharacter("Mika");
        marineCorpModifyView.addCharacter("Hina");
        marineCorpModifyView.addCharacter("JoJo");
        marineCorpModifyView.addCharacter("Corn");
        marineCorpModifyView.addCharacter("Karane");
        marineCorpModifyView.addCharacter("Miku");
        marineCorpModifyView.addCharacter("Drugs");
        marineCorpModifyView.addCharacter("Hentai");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == marineCorpModifyView.exitButton)
        {
            marineCorpModifyView.panel.setVisible(false);
            mainView.showPanel("MARINECORP");
        }

    }


}
