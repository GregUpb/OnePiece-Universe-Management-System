package view;

import java.awt.*;
import javax.swing.*;

import panel.*;

public class MarineCorpModifyView
{

    String[] temp = {"None", "Cheese", "McBalls", "McMc"};

    public JPanel panel, centerPanel, topPanel;
    public JPanel locationPanel, fundsPanel, commanderPanel, membersPanel, innerPanel;
    public JScrollPane scrollPanel;
    public JButton exitButton, submitButton;

    public JComboBox charSelectComboBox;

    private JLabel locationLabel, fundsLabel, commanderLabel, membersLabel;

    public JTextField locationTextField, fundsTextField;
    public JComboBox commanderComboBox;

    public JComboBox crewSelectComboBox;

    public JCheckBox locationCheckBox, fundsCheckBox, commanderCheckBox, membersCheckBox;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public MarineCorpModifyView()
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

        // Location
        locationLabel = new JLabel("Base Location: ");
        locationLabel.setFont(textFont);
        locationLabel.setPreferredSize(new Dimension(150, 0));
        locationTextField = new JTextField();
        locationTextField.setFont(textFont);

        locationPanel = new JPanel(new BorderLayout());
        locationPanel.setPreferredSize(new Dimension(0, 50));
        locationCheckBox = new JCheckBox();
        locationPanel.add(locationLabel, BorderLayout.LINE_START);
        locationPanel.add(locationTextField, BorderLayout.CENTER);
        locationPanel.add(locationCheckBox, BorderLayout.LINE_END);
        centerPanel.add(locationPanel);

        // Operational funds
        fundsLabel = new JLabel("Operational Funds: ");
        fundsLabel.setFont(textFont);
        fundsLabel.setPreferredSize(new Dimension(150, 0));
        fundsTextField = new JTextField();
        fundsTextField.setFont(textFont);

        fundsPanel = new JPanel(new BorderLayout());
        fundsPanel.setPreferredSize(new Dimension(0, 50));
        fundsCheckBox = new JCheckBox();
        fundsPanel.add(fundsLabel, BorderLayout.LINE_START);
        fundsPanel.add(fundsTextField, BorderLayout.CENTER);
        fundsPanel.add(fundsCheckBox, BorderLayout.LINE_END);
        centerPanel.add(fundsPanel);

        // Commander
        commanderLabel = new JLabel("Commander's Name: ");
        commanderLabel.setFont(textFont);
        commanderLabel.setPreferredSize(new Dimension(150, 0));
        commanderComboBox = new JComboBox<>(temp);
        commanderComboBox.setFont(textFont);

        commanderPanel = new JPanel(new BorderLayout());
        commanderPanel.setPreferredSize(new Dimension(0, 50));
        commanderCheckBox = new JCheckBox();
        commanderPanel.add(commanderLabel, BorderLayout.LINE_START);
        commanderPanel.add(commanderComboBox, BorderLayout.CENTER);
        commanderPanel.add(commanderCheckBox, BorderLayout.LINE_END);
        centerPanel.add(commanderPanel);

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
