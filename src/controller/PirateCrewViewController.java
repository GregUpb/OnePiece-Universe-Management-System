package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.*;
import view.*;

public class PirateCrewViewController implements ActionListener
{
    MainView mainView;
    PirateCrewViewView pirateCrewViewView;
    PirateCrewDatabase pirateCrewDatabase;

    public PirateCrewViewController(MainView mainview, PirateCrewViewView pirateCrewViewView, PirateCrewDatabase pirateCrewDatabase)
    {
        this.mainView = mainview;
        this.pirateCrewViewView = pirateCrewViewView;
        this.pirateCrewDatabase = pirateCrewDatabase;

        addActionListener();
    }

    public void addActionListener()
    {
        pirateCrewViewView.backButton.addActionListener(this);
        pirateCrewViewView.charSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == pirateCrewViewView.backButton)
        {
            this.mainView.setInfoText("Pirate Crew");
            this.mainView.showPanel("PIRATECREW");
        }
        else if (e.getSource() == pirateCrewViewView.charSelectComboBox)
        {
            int selectedIndex = pirateCrewViewView.charSelectComboBox.getSelectedIndex();

            // Check if selection is valid
            if (selectedIndex >= 0 && selectedIndex < pirateCrewDatabase.getAllPCrew().size()) {
                PirateCrew selectedCrew = pirateCrewDatabase.getAllPCrew().get(selectedIndex);
                pirateCrewViewView.nameLabel.setText("Pirate Crew Name: " + selectedCrew.GetCrewName());
                pirateCrewViewView.shipLabel.setText("Ship's Name: " + selectedCrew.GetShipsName());
                pirateCrewViewView.totalBountyLabel.setText("Total Crew Bounty: " + selectedCrew.GetTotalCrewBounty());

                if (selectedCrew.GetCaptain() != null) {
                    pirateCrewViewView.captainLabel.setText("Captain's Name: " + selectedCrew.GetCaptain().GetName());
                } else {
                    pirateCrewViewView.captainLabel.setText("Captain's Name: None");
                }

                // Call the setMembers para malagyan ng laman ung CharacterViewPanels
                pirateCrewViewView.setMembers(selectedCrew.GetCrewMembers());
                pirateCrewViewView.innerPanel.revalidate();
                pirateCrewViewView.innerPanel.repaint();
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        pirateCrewViewView.charSelectComboBox.removeActionListener(this);
        // Clean whole list
        pirateCrewViewView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add crews
        for (PirateCrew crew : pirateCrewDatabase.getAllPCrew())
        {
            pirateCrewViewView.charSelectComboBox.addItem(crew.GetCrewID() + " - " + crew.GetCrewName());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        pirateCrewViewView.charSelectComboBox.addActionListener(this);

        // If there is at least one character in the list, simulate a click so the labels update
        if (pirateCrewViewView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(pirateCrewViewView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        } else {
            // Clear the view if the database is completely empty
            pirateCrewViewView.nameLabel.setText("Pirate Crew Name: ");
            pirateCrewViewView.shipLabel.setText("Ship's Name: ");
            pirateCrewViewView.totalBountyLabel.setText("Total Crew Bounty: ");
            pirateCrewViewView.captainLabel.setText("Captain's Name: ");
            pirateCrewViewView.innerPanel.removeAll();
            pirateCrewViewView.innerPanel.revalidate();
            pirateCrewViewView.innerPanel.repaint();
        }
    }

    public JPanel getFrame()
    {
        return pirateCrewViewView.setFrame();
    }
}