package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.DevilFruit;
import model.DevilFruitDatabase;
import view.DevilFruitViewView;
import view.MainView;

public class DevilFruitViewController implements ActionListener
{
    MainView mainview;
    DevilFruitViewView devilFruitViewView;
    DevilFruitDatabase devilFruitDatabase;

    public DevilFruitViewController(MainView mainview, DevilFruitViewView devilFruitViewView, DevilFruitDatabase devilFruitDatabase)
    {
        this.mainview = mainview;
        this.devilFruitViewView = devilFruitViewView;
        this.devilFruitDatabase = devilFruitDatabase;

        addActionListener();
    }

    public void addActionListener()
    {
        devilFruitViewView.backButton.addActionListener(this);
        devilFruitViewView.dfSelectComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == devilFruitViewView.backButton)
        {
            devilFruitViewView.setFrame().setVisible(false);
            mainview.showPanel("DEVILFRUIT");
        }
        // When a Devil Fruit is selected on the combo box
        else if (e.getSource() == devilFruitViewView.dfSelectComboBox)
        {
            int selectedIndex = devilFruitViewView.dfSelectComboBox.getSelectedIndex();

            // Ensure the selection is valid
            if (selectedIndex >= 0 && selectedIndex < devilFruitDatabase.getAllDF().size()) {

                // Fetch the object from the DB
                DevilFruit selectedFruit = devilFruitDatabase.getAllDF().get(selectedIndex);

                // Update Labels
                devilFruitViewView.nameLabel.setText("Fruit Name: " + selectedFruit.GetFruitName());
                devilFruitViewView.categoryLabel.setText("Category: " + selectedFruit.GetCategory());
                devilFruitViewView.abilityLabel.setText("Primary Ability: " + selectedFruit.GetPrimaryAbility());

                // Check for current owner safely
                if (selectedFruit.HasCurrentOwner()) {
                    devilFruitViewView.currentOwnerLabel.setText("Current Owner: " + selectedFruit.GetCurrentOwner().GetName());
                } else {
                    devilFruitViewView.currentOwnerLabel.setText("Current Owner: None");
                }

                // Build a list of Historical Owners' names
                java.util.List<model.Character> pastOwnersList = selectedFruit.GetHistoricalOwners();

                if (pastOwnersList.isEmpty()) {
                    devilFruitViewView.historicalOwnersLabel.setText("Historical Owners: None");
                } else {
                    StringBuilder ownersString = new StringBuilder("Historical Owners: ");
                    for (int i = 0; i < pastOwnersList.size(); i++) {
                        ownersString.append(pastOwnersList.get(i).GetName());

                        // Add a comma if it's not the last owner in the list
                        if (i < pastOwnersList.size() - 1) {
                            ownersString.append(", ");
                        }
                    }
                    devilFruitViewView.historicalOwnersLabel.setText(ownersString.toString());
                }
            }
        }
    }

    public void refreshComboBox()
    {
        //Temporarily remove action listener para di biglang magising habang minomodify list
        devilFruitViewView.dfSelectComboBox.removeActionListener(this);
        // Clean whole list
        devilFruitViewView.dfSelectComboBox.removeAllItems();
        // Loop through actual database and add devil fruits
        for (DevilFruit df : devilFruitDatabase.getAllDF())
        {
            devilFruitViewView.dfSelectComboBox.addItem(df.GetFruitID() + " - " + df.GetFruitName());
        }
        // Buhayin ule ang action listener now that the list is safely updated
        devilFruitViewView.dfSelectComboBox.addActionListener(this);
        // If there is at least one character in the list, simulate a click so the labels update
        if (devilFruitViewView.dfSelectComboBox.getItemCount() > 0) {
            ActionEvent refreshEvent = new ActionEvent(devilFruitViewView.dfSelectComboBox, ActionEvent.ACTION_PERFORMED, "Refresh");
            this.actionPerformed(refreshEvent);
        }
    }

    public JPanel getFrame()
    {
        return devilFruitViewView.setFrame();
    }
}