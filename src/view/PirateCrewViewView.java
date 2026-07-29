package view;

import java.awt.*;
import javax.swing.*;

public class PirateCrewViewView
{

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox charSelectComboBox;

    public JLabel  nameLabel, shipLabel, totalBountyLabel, captainLabel, membersLabel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public PirateCrewViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel(new GridLayout(0, 1));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        charSelectComboBox = new JComboBox<>();
        topPanel.add(charSelectComboBox, BorderLayout.CENTER);

        // Character Information
        nameLabel = new JLabel("Pirate Crew Name: ");
        nameLabel.setFont(textFont);
        infoPanel.add(nameLabel);

        shipLabel = new JLabel("Ship's Name: ");
        shipLabel.setFont(textFont);
        infoPanel.add(shipLabel);

        totalBountyLabel = new JLabel("Total Crew Bounty: ");
        totalBountyLabel.setFont(textFont);
        infoPanel.add(totalBountyLabel);

        captainLabel = new JLabel("Captain's Name: ");
        captainLabel.setFont(textFont);
        infoPanel.add(captainLabel);

        membersLabel = new JLabel("Members: ");
        membersLabel.setFont(textFont);
        infoPanel.add(membersLabel);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }

}
