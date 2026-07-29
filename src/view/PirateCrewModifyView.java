package view;

import java.awt.*;
import javax.swing.*;

import panel.*;

public class PirateCrewModifyView
{

    String[] temp = {"None", "Cheese", "McBalls", "McMc"};

    public JPanel panel, centerPanel, topPanel;
    public JPanel namePanel, shipPanel, bountyPanel, captainPanel, membersPanel, innerPanel;
    public JScrollPane scrollPanel;
    public JButton exitButton, submitButton;

    public JComboBox charSelectComboBox;

    private JLabel nameLabel, shipLabel, bountyLabel, captainLabel, membersLabel;

    public JTextField nameTextField, shipTextField, bountyTextField;
    public JComboBox captainComboBox;

    public JComboBox crewSelectComboBox;

    public JCheckBox nameCheckBox, shipCheckBox, bountyCheckBox, captainCheckBox, membersCheckBox;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public PirateCrewModifyView()
    {
        panel = new JPanel(new BorderLayout());

        topPanel = new JPanel(new GridLayout(0, 1));
        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        exitButton = new JButton("CANCEL");
        exitButton.setFont(buttonFont);
        topPanel.add(exitButton);
        
        submitButton = new JButton("SUBMIT");
        submitButton.setFont(buttonFont);

        charSelectComboBox = new JComboBox<>();
        topPanel.add(charSelectComboBox);

        // Name
        nameLabel = new JLabel("Name of the Crew: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(150, 0));
        nameTextField = new JTextField();
        nameTextField.setFont(textFont);

        namePanel = new JPanel(new BorderLayout());
        namePanel.setPreferredSize(new Dimension(0, 50));
        nameCheckBox = new JCheckBox();
        namePanel.add(nameLabel, BorderLayout.LINE_START);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        namePanel.add(nameCheckBox, BorderLayout.LINE_END);
        centerPanel.add(namePanel);

        // Ship
        shipLabel = new JLabel("Name of the Ship: ");
        shipLabel.setFont(textFont);
        shipLabel.setPreferredSize(new Dimension(150, 0));
        shipTextField = new JTextField();
        shipTextField.setFont(textFont);

        shipPanel = new JPanel(new BorderLayout());
        shipPanel.setPreferredSize(new Dimension(0, 50));
        shipCheckBox = new JCheckBox();
        shipPanel.add(shipLabel, BorderLayout.LINE_START);
        shipPanel.add(shipTextField, BorderLayout.CENTER);
        shipPanel.add(shipCheckBox, BorderLayout.LINE_END);
        centerPanel.add(shipPanel);

        // Total Crew Bounty
        bountyLabel = new JLabel("Total Crew Bounty: ");
        bountyLabel.setFont(textFont);
        bountyLabel.setPreferredSize(new Dimension(150, 0));
        bountyTextField = new JTextField();
        bountyTextField.setFont(textFont);

        bountyPanel = new JPanel(new BorderLayout());
        bountyPanel.setPreferredSize(new Dimension(0, 50));
        bountyCheckBox = new JCheckBox();
        bountyPanel.add(bountyLabel, BorderLayout.LINE_START);
        bountyPanel.add(bountyTextField, BorderLayout.CENTER);
        bountyPanel.add(bountyCheckBox, BorderLayout.LINE_END);
        centerPanel.add(bountyPanel);

        // Captain
        captainLabel = new JLabel("Captain's Name: ");
        captainLabel.setFont(textFont);
        captainLabel.setPreferredSize(new Dimension(150, 0));
        captainComboBox = new JComboBox<>(temp);
        captainComboBox.setFont(textFont);

        captainPanel = new JPanel(new BorderLayout());
        captainPanel.setPreferredSize(new Dimension(0, 50));
        captainCheckBox = new JCheckBox();
        captainPanel.add(captainLabel, BorderLayout.LINE_START);
        captainPanel.add(captainComboBox, BorderLayout.CENTER);
        captainPanel.add(captainCheckBox, BorderLayout.LINE_END);
        centerPanel.add(captainPanel);

        // Members
        membersLabel = new JLabel("Members: ");
        membersLabel.setFont(textFont);
        membersLabel.setPreferredSize(new Dimension(150, 0));

        membersPanel = new JPanel(new BorderLayout());
        membersPanel.setPreferredSize(new Dimension(0, 50));
        membersCheckBox = new JCheckBox();
        membersPanel.add(membersLabel, BorderLayout.LINE_START);
        membersPanel.add(membersCheckBox, BorderLayout.LINE_END);
        centerPanel.add(membersPanel);

        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPanel = new JScrollPane(innerPanel);

        centerPanel.add(scrollPanel);

        // hehehe
        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.PAGE_END);

    }

    public JPanel setFrame()
    {
        return this.panel;
    }

    public void addCharacter(String name)
    {
        this.innerPanel.add(new CharacterSelectionPanel(name));
    }


}
