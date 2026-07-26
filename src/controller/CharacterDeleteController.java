package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.CharacterCreateView;
import view.CharacterDeleteView;
import view.CharacterViewView;
import view.MainView;
import view.PirateCrewView;

public class CharacterDeleteController implements ActionListener
{
    MainView mainview;
    CharacterDeleteView characterDeleteView;
    
    public CharacterDeleteController(MainView mainview, CharacterDeleteView characterDeleteView)
    {
        this.mainview = mainview;

        this.characterDeleteView = characterDeleteView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return characterDeleteView.setFrame();
    }

    public void addActionListener()
    {
        characterDeleteView.backButton.addActionListener(this);
        characterDeleteView.deleteButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == characterDeleteView.backButton)
        {
            characterDeleteView.setFrame().setVisible(false);
            mainview.showPanel("CHARACTER");
        } else if (e.getSource() == characterDeleteView.deleteButton)
        {
            int res = JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you Sure?");
            if (res == JOptionPane.YES_OPTION)
            {
                if (JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you really Sure?") == JOptionPane.YES_OPTION)
                {
                    if (JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you really really Sure?") == JOptionPane.YES_OPTION)
                    {
                        if (JOptionPane.showConfirmDialog(characterDeleteView.optionPane, "Are you really really really Sure?") == JOptionPane.YES_OPTION)
                        {
                            JOptionPane.showMessageDialog(null, "AYOKO NGA");
                        }
                    }
                }
            }
        }

    }


}
