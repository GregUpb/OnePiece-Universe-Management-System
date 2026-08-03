package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.*;
import model.*;
import model.Character;

public class BountyRegisterController implements ActionListener
{
    MainView mainview;
    BountyRegisterView bountyRegisterView;
    BountyManager bountyDatabase;
    CharacterDatabase charDatabase;

    // Lists to map the ComboBox indexes directly to the objects
    private List<Pirate> availableTargets;
    private List<Character> availableCaptors;

    public BountyRegisterController(MainView mainView, BountyRegisterView bountyRegisterView, BountyManager bountyDatabase, CharacterDatabase charDatabase)
    {
        this.mainview = mainView;
        this.bountyRegisterView = bountyRegisterView;
        this.bountyDatabase = bountyDatabase;
        this.charDatabase = charDatabase;

        addActionListener();
    }

    public JPanel getFrame()
    {
        return bountyRegisterView.setFrame();
    }

    public void addActionListener()
    {
        bountyRegisterView.submitButton.addActionListener(this);
        bountyRegisterView.exitButton.addActionListener(this);
    }

    public void refreshComboBoxes()
    {
        bountyRegisterView.capturedComboBox.removeAllItems();
        bountyRegisterView.captorComboBox.removeAllItems();

        availableTargets = new ArrayList<>();
        availableCaptors = new ArrayList<>();

        for (Character c : charDatabase.getAllCharacters()) {


            if (c instanceof Pirate) {
                // Cannot capture a pirate that is already dead
                if (!c.GetStatus().equalsIgnoreCase("dead")) {
                    availableTargets.add((Pirate) c);
                    bountyRegisterView.capturedComboBox.addItem(c.GetID() + " - " + c.GetName());
                }
            }

            else if (c instanceof Marine || c instanceof PirateHunter || c instanceof Civilian) {
                availableCaptors.add(c);
                bountyRegisterView.captorComboBox.addItem(c.GetID() + " - " + c.GetName());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bountyRegisterView.exitButton)
        {
            this.mainview.setInfoText("Bounty");
            this.mainview.showPanel("BOUNTY");
        }
        else if (e.getSource() == bountyRegisterView.submitButton)
        {
            try {
                int targetIndex = bountyRegisterView.capturedComboBox.getSelectedIndex();
                int captorIndex = bountyRegisterView.captorComboBox.getSelectedIndex();

                if (targetIndex < 0 || captorIndex < 0) {
                    throw new Exception("Please ensure both a Target and a Captor are selected.");
                }

                Pirate target = availableTargets.get(targetIndex);
                Character captor = availableCaptors.get(captorIndex);

                bountyDatabase.registerCapture(captor, target, "captured");

                JOptionPane.showMessageDialog(bountyRegisterView.panel,
                        "Bounty successfully claimed by " + captor.GetName() + "!");

                this.mainview.setInfoText("Bounty");
                this.mainview.showPanel("BOUNTY");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(bountyRegisterView.panel,
                        "Error: " + ex.getMessage(), "Registration Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // Make sure the bounty database saves the new record even if an error is thrown
                bountyDatabase.writeDatabase();
            }
        }
    }
}