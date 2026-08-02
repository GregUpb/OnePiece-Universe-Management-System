package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Character;
import model.CharacterDatabase;
import model.DevilFruit;
import model.DevilFruitDatabase;
import view.DevilFruitAssignView;
import view.MainView;

public class DevilFruitAssignController implements ActionListener
{
    MainView mainview;
    DevilFruitAssignView devilFruitAssignView;
    DevilFruitDatabase devilFruitDatabase;
    CharacterDatabase charDatabase; // Added to access the characters

    public DevilFruitAssignController(MainView mainview, DevilFruitAssignView devilFruitAssignView, DevilFruitDatabase devilFruitDatabase, CharacterDatabase charDatabase)
    {
        this.mainview = mainview;
        this.devilFruitAssignView = devilFruitAssignView;
        this.devilFruitDatabase = devilFruitDatabase;
        this.charDatabase = charDatabase;

        addActionListener();
    }

    private void addActionListener()
    {
        devilFruitAssignView.exitButton.addActionListener(this);
        devilFruitAssignView.submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == devilFruitAssignView.exitButton)
        {
            devilFruitAssignView.setFrame().setVisible(false);
            mainview.showPanel("DEVILFRUIT"); // Assuming this is your main menu key
        }
        else if (e.getSource() == devilFruitAssignView.submitButton)
        {
            int selectedDFIndex = devilFruitAssignView.dfComboBox.getSelectedIndex();
            int selectedCharIndex = devilFruitAssignView.charComboBox.getSelectedIndex();

            // Validate that both lists have an active selection
            if (selectedDFIndex >= 0 && selectedCharIndex >= 0) {

                // Fetch the objects from their respective databases
                DevilFruit selectedDF = devilFruitDatabase.getAllDF().get(selectedDFIndex);
                Character selectedChar = charDatabase.getAllCharacters().get(selectedCharIndex);

                try {
                    // Assign the character to the devil fruit
                    // (Assuming your DevilFruit model handles the bidirectional linking internally)
                    selectedDF.SetCurrentOwner(selectedChar);

                    JOptionPane.showMessageDialog(devilFruitAssignView.mainPanel,
                            selectedDF.GetFruitName() + " has been assigned to " + selectedChar.GetName() + "!");

                    // Close panel and return to menu
                    devilFruitAssignView.setFrame().setVisible(false);
                    mainview.showPanel("DEVILFRUIT");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(devilFruitAssignView.mainPanel,
                            "Error assigning Devil Fruit: " + ex.getMessage(), "Assignment Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(devilFruitAssignView.mainPanel,
                        "Please ensure both a Devil Fruit and a Character are selected.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            }

            // Save
            charDatabase.writeDatabase();
            devilFruitDatabase.writeDatabase();
        }
    }

    public void refreshComboBoxes()
    {
        // Clean whole list for both
        devilFruitAssignView.dfComboBox.removeAllItems();
        devilFruitAssignView.charComboBox.removeAllItems();
        // Loop through actual database and add devil fruits and characters
        for (DevilFruit df : devilFruitDatabase.getAllDF()) {
            devilFruitAssignView.dfComboBox.addItem(df.GetFruitID() + " - " + df.GetFruitName());
        }
        for (Character c : charDatabase.getAllCharacters()) {
            devilFruitAssignView.charComboBox.addItem(c.GetID() + " - " + c.GetName());
        }
    }

    public JPanel getFrame()
    {
        return devilFruitAssignView.setFrame();
    }
}