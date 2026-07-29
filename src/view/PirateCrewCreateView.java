package view;

import java.awt.*;
import javax.swing.*;
import panel.*;

public class PirateCrewCreateView
{

    String[] temp = {"None", "Cheese", "McBalls", "McMc"};

    public JPanel panel, centerPanel;
    
    public JPanel namePanel, shipPanel, captainPanel, membersPanel;

    public JLabel nameLabel, shipLabel, captainLabel, membersLabel;
    public JTextField nameTextField, shipTextField, totalBountyTextField;
    public JComboBox captainComboBox;

    public JButton exitButton, submitButton;

    public JPanel innerPanel;
    public JScrollPane scrollPane;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public PirateCrewCreateView()
    {
        panel = new JPanel(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(innerPanel);

        // Name
        nameLabel = new JLabel("Name of the Crew: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(150, 0));
        nameTextField = new JTextField();
        nameTextField.setFont(textFont);

        namePanel = new JPanel(new BorderLayout());
        namePanel.setPreferredSize(new Dimension(300, 50));
        namePanel.add(nameLabel, BorderLayout.LINE_START);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        centerPanel.add(namePanel);

        // Ship
        shipLabel = new JLabel("Name of the Ship: ");
        shipLabel.setFont(textFont);
        shipLabel.setPreferredSize(new Dimension(150, 0));
        shipTextField = new JTextField();
        shipTextField.setFont(textFont);

        shipPanel = new JPanel(new BorderLayout());
        shipPanel.setPreferredSize(new Dimension(300, 50));
        shipPanel.add(shipLabel, BorderLayout.LINE_START);
        shipPanel.add(shipTextField, BorderLayout.CENTER);
        centerPanel.add(shipPanel);

        // Captain
        captainLabel = new JLabel("Captain of the Crew: ");
        captainLabel.setFont(textFont);
        captainLabel.setPreferredSize(new Dimension(150, 0));
        captainComboBox = new JComboBox<>(temp);
        captainComboBox.setFont(textFont);

        captainPanel = new JPanel(new BorderLayout());
        captainPanel.setPreferredSize(new Dimension(300, 50));
        captainPanel.add(captainLabel, BorderLayout.LINE_START);
        captainPanel.add(captainComboBox, BorderLayout.CENTER);
        centerPanel.add(captainPanel);

        // Members
        membersLabel = new JLabel("Members of the Crew: ");
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
