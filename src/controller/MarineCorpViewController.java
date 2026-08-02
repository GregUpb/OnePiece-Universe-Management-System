package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.MarineCorp;
import model.MarineCorpDatabase;
import view.MainView;
import view.MarineCorpViewView;

public class MarineCorpViewController implements ActionListener
{
    MainView mainView;
    MarineCorpViewView marineCorpViewView;
    MarineCorpDatabase marineCorpDatabase;

    public MarineCorpViewController(MainView mainview, MarineCorpViewView marineCorpViewView, MarineCorpDatabase marineCorpDatabase)
    {
        this.mainView = mainview;
        this.marineCorpViewView = marineCorpViewView;
        this.marineCorpDatabase = marineCorpDatabase;

        addActionListener();
    }

    public void addActionListener()
    {
        marineCorpViewView.backButton.addActionListener(this);
        marineCorpViewView.charSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == marineCorpViewView.backButton)
        {
            this.mainView.setInfoText("Marine Corp");
            this.mainView.showPanel("MARINECORP");
        }
        else if (e.getSource() == marineCorpViewView.charSelectComboBox)
        {
            int selectedIndex = marineCorpViewView.charSelectComboBox.getSelectedIndex();

            // Check if selection is valid
            if (selectedIndex >= 0 && selectedIndex < marineCorpDatabase.getAllMCorp().size()) {
                MarineCorp selectedCorp = marineCorpDatabase.getAllMCorp().get(selectedIndex);
                marineCorpViewView.locationLabel.setText("Marine Corp Location: " + selectedCorp.GetBaseLocation());
                marineCorpViewView.fundsLabel.setText("Operational Funds: " + selectedCorp.GetOperationalFunds());

                if (selectedCorp.GetCorpsCommander() != null) {
                    marineCorpViewView.commanderLabel.setText("Commander's Name: " + selectedCorp.GetCorpsCommander().GetName());
                } else {
                    marineCorpViewView.commanderLabel.setText("Commander's Name: None");
                }

                // Call the setMembers para malagyan ng laman ung CharacterViewPanels
                marineCorpViewView.setMembers(selectedCorp.GetCorpMembers());
                marineCorpViewView.innerPanel.revalidate();
                marineCorpViewView.innerPanel.repaint();
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        marineCorpViewView.charSelectComboBox.removeActionListener(this);
        // Clean whole list
        marineCorpViewView.charSelectComboBox.removeAllItems();
        // Loop through actual database and add corps
        for (MarineCorp corp : marineCorpDatabase.getAllMCorp())
        {
            marineCorpViewView.charSelectComboBox.addItem(corp.GetCorpID() + " - " + corp.GetBaseLocation());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        marineCorpViewView.charSelectComboBox.addActionListener(this);

        // If there is at least one character in the list, simulate a click so the labels update
        if (marineCorpViewView.charSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(marineCorpViewView.charSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        } else {
            // Clear the view if the database is completely empty
            marineCorpViewView.locationLabel.setText("Marine Corp Location: ");
            marineCorpViewView.fundsLabel.setText("Operational Funds: ");
            marineCorpViewView.commanderLabel.setText("Commander's Name: ");
            marineCorpViewView.innerPanel.removeAll();
            marineCorpViewView.innerPanel.revalidate();
            marineCorpViewView.innerPanel.repaint();
        }
    }

    public JPanel getFrame()
    {
        return marineCorpViewView.setFrame();
    }
}