package view;

import java.awt.*;
import javax.swing.*;

import java.util.*;

import panel.*;

public class PirateCrewViewView
{

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox charSelectComboBox;

    public JLabel  nameLabel, shipLabel, totalBountyLabel, captainLabel, membersLabel;

    public JScrollPane scrollPane;
    public JPanel innerPanel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public PirateCrewViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        charSelectComboBox = new JComboBox<>();
        topPanel.add(charSelectComboBox, BorderLayout.CENTER);

        // Character Information
        nameLabel = new JLabel("Pirate Crew Name: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(nameLabel);

        shipLabel = new JLabel("Ship's Name: ");
        shipLabel.setFont(textFont);
        shipLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(shipLabel);

        totalBountyLabel = new JLabel("Total Crew Bounty: ");
        totalBountyLabel.setFont(textFont);
        totalBountyLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(totalBountyLabel);

        captainLabel = new JLabel("Captain's Name: ");
        captainLabel.setFont(textFont);
        captainLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(captainLabel);

        membersLabel = new JLabel("Members: ");
        membersLabel.setFont(textFont);
        membersLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(membersLabel);

        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(innerPanel);
        infoPanel.add(scrollPane);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }

    public void setMembers(java.util.List<model.Pirate> members)
    {
        innerPanel.removeAll();

        for (model.Pirate p : members)
        {
            this.innerPanel.add(new CharacterViewPanel(p.GetName()));
        }

    }

}
