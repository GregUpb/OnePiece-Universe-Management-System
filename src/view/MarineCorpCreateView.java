package view;

import java.awt.*;
import javax.swing.*;
import panel.*;

public class MarineCorpCreateView
{

    String[] temp = {"None", "Cheese", "McBalls", "McMc"};

    public JPanel panel, centerPanel;
    
    public JPanel locationPanel, fundsPanel, commanderPanel, membersPanel;

    public JLabel locationLabel, fundsLabel, commanderLabel, membersLabel;
    public JTextField locationTextField, fundsTextField;
    public JComboBox commanderComboBox;

    public JButton exitButton, submitButton;

    public JPanel innerPanel;
    public JScrollPane scrollPane;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public MarineCorpCreateView()
    {
        panel = new JPanel(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(innerPanel);

        // Location
        locationLabel = new JLabel("Base Location: ");
        locationLabel.setFont(textFont);
        locationLabel.setPreferredSize(new Dimension(150, 0));
        locationTextField = new JTextField();
        locationTextField.setFont(textFont);

        locationPanel = new JPanel(new BorderLayout());
        locationPanel.setPreferredSize(new Dimension(300, 50));
        locationPanel.add(locationLabel, BorderLayout.LINE_START);
        locationPanel.add(locationTextField, BorderLayout.CENTER);
        centerPanel.add(locationPanel);

        // Funds
        fundsLabel = new JLabel("Operational Funds: ");
        fundsLabel.setFont(textFont);
        fundsLabel.setPreferredSize(new Dimension(150, 0));
        fundsTextField = new JTextField();
        fundsTextField.setFont(textFont);

        fundsPanel = new JPanel(new BorderLayout());
        fundsPanel.setPreferredSize(new Dimension(300, 50));
        fundsPanel.add(fundsLabel, BorderLayout.LINE_START);
        fundsPanel.add(fundsTextField, BorderLayout.CENTER);
        centerPanel.add(fundsPanel);

        // Commander
        commanderLabel = new JLabel("Commander: ");
        commanderLabel.setFont(textFont);
        commanderLabel.setPreferredSize(new Dimension(150, 0));
        commanderComboBox = new JComboBox<>(temp);
        commanderComboBox.setFont(textFont);

        commanderPanel = new JPanel(new BorderLayout());
        commanderPanel.setPreferredSize(new Dimension(300, 50));
        commanderPanel.add(commanderLabel, BorderLayout.LINE_START);
        commanderPanel.add(commanderComboBox, BorderLayout.CENTER);
        centerPanel.add(commanderPanel);

        // Members
        membersLabel = new JLabel("Members of the Corp: ");
        membersLabel.setFont(textFont);
        membersLabel.setPreferredSize(new Dimension(300, 50));
        membersLabel.setAlignmentX(SwingConstants.LEFT);
        centerPanel.add(membersLabel);
        centerPanel.add(scrollPane);

        exitButton = new JButton("Exit");
        exitButton.setFont(buttonFont);
        submitButton = new JButton("Submit");
        submitButton.setFont(buttonFont);

        panel.add(exitButton, BorderLayout.PAGE_START);
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
