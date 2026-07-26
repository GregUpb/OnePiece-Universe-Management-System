package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import view.DevilFruitView;

public class DevilFruitController implements ActionListener
{

    DevilFruitView devilFruitView;
    
    public DevilFruitController(DevilFruitView devilFruitView)
    {
        this.devilFruitView = devilFruitView;
        addActionListener();
    }

    public JPanel getFrame()
    {
        return devilFruitView.setFrame();
    }

    public void addActionListener()
    {
        devilFruitView.createButton.addActionListener(this);
        devilFruitView.viewButton.addActionListener(this);
        devilFruitView.assignButton.addActionListener(this);
        devilFruitView.backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        /* Start Creation Buttons */
        if (e.getSource() == devilFruitView.backButton)
        {
            devilFruitView.panel.setVisible(false);
        }

    }


}
