package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import model.CharacterDatabase;
import model.DevilFruitDatabase;
import view.DevilFruitView;
import view.*;

public class DevilFruitController implements ActionListener
{
    MainView mainview;
    DevilFruitView devilFruitView;
    DevilFruitCreateController devilFruitCreateController;
    DevilFruitViewController devilFruitViewController;
    DevilFruitAssignController devilFruitAssignController;
    CharacterDatabase charDatabase;
    DevilFruitDatabase devilFruitDatabase;
    
    public DevilFruitController(MainView mainview, DevilFruitView devilFruitView, CharacterDatabase charDatabase, DevilFruitDatabase devilFruitDatabase)
    {
        this.mainview = mainview;

        this.charDatabase = charDatabase;
        this.devilFruitDatabase = devilFruitDatabase;
        devilFruitCreateController = new DevilFruitCreateController(mainview, new DevilFruitCreateView(), devilFruitDatabase);
        this.mainview.addPanel(devilFruitCreateController.getFrame(), "DEVILFRUITCREATE");
        devilFruitViewController = new DevilFruitViewController(mainview, new DevilFruitViewView(), devilFruitDatabase);
        this.mainview.addPanel(devilFruitViewController.getFrame(), "DEVILFRUITVIEW");
        devilFruitAssignController = new DevilFruitAssignController(mainview, new DevilFruitAssignView(), devilFruitDatabase, charDatabase);
        this.mainview.addPanel(devilFruitAssignController.getFrame(), "DEVILFRUITASSIGN");

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
        else if (e.getSource() == devilFruitView.createButton)
        {
            this.mainview.setInfoText("Creating a Devil Fruit");
            this.mainview.showPanel("DEVILFRUITCREATE");
        }
        else if (e.getSource() == devilFruitView.viewButton)
        {
            this.mainview.setInfoText("Viewing a Devil Fruit");
            devilFruitViewController.refreshComboBox();
            this.mainview.showPanel("DEVILFRUITVIEW");
        }
        else if (e.getSource() == devilFruitView.assignButton)
        {
            this.mainview.setInfoText("Assigning a Devil Fruit");
            devilFruitAssignController.refreshComboBoxes();
            this.mainview.showPanel("DEVILFRUITASSIGN");
        }
    }


}
