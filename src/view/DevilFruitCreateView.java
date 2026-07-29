package view;

import java.awt.*;
import javax.swing.*;

public class DevilFruitCreateView
{
    public JPanel panel, centerPanel;
    public JPanel typeButtonPanel, typePanel, namePanel, abilityPanel;
    public JButton exitButton, submitButton;

    public JLabel typeLabel, nameLabel, abilityLabel;
    public JTextField nameTextField, abilityTextField;

    public JRadioButton parameciaRadioButton, zoanRadioButton, logiaRadioButton;
    public ButtonGroup typeButtonGroup;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);

    public DevilFruitCreateView()
    {
        panel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(); // Single column layout
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        exitButton = new JButton("CANCEL");
        exitButton.setFont(buttonFont);

        submitButton = new JButton("SUBMIT");
        submitButton.setFont(buttonFont);

        // Type/Category
        typeLabel = new JLabel("Category: ");
        typeLabel.setFont(textFont);
        typeLabel.setPreferredSize(new Dimension(150, 0));
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        parameciaRadioButton = new JRadioButton("Paramecia");
        parameciaRadioButton.setSelected(true);
        zoanRadioButton = new JRadioButton("Zoan");
        logiaRadioButton = new JRadioButton("Logia");

        typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(parameciaRadioButton);
        typeButtonGroup.add(zoanRadioButton);
        typeButtonGroup.add(logiaRadioButton);

        typeButtonPanel = new JPanel(new GridLayout(1, 0));
        typeButtonPanel.add(parameciaRadioButton);
        typeButtonPanel.add(zoanRadioButton);
        typeButtonPanel.add(logiaRadioButton);

        typePanel = new JPanel(new BorderLayout());
        typePanel.setPreferredSize(new Dimension(0, 50));
        typePanel.add(typeLabel, BorderLayout.LINE_START);
        typePanel.add(typeButtonPanel, BorderLayout.CENTER);
        centerPanel.add(typePanel);

        // Name
        nameLabel = new JLabel("Fruit Name: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(150, 0));
        nameTextField = new JTextField();
        nameTextField.setFont(textFont);

        namePanel = new JPanel(new BorderLayout());
        namePanel.setPreferredSize(new Dimension(0, 50));
        namePanel.add(nameLabel, BorderLayout.LINE_START);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        centerPanel.add(namePanel);

        // Primary Ability
        abilityLabel = new JLabel("Primary Ability: ");
        abilityLabel.setFont(textFont);
        abilityLabel.setPreferredSize(new Dimension(150, 0));
        abilityTextField = new JTextField();
        abilityTextField.setFont(textFont);

        abilityPanel = new JPanel(new BorderLayout());
        abilityPanel.setPreferredSize(new Dimension(0, 50));
        abilityPanel.add(abilityLabel, BorderLayout.LINE_START);
        abilityPanel.add(abilityTextField, BorderLayout.CENTER);
        centerPanel.add(abilityPanel);

        panel.add(exitButton, BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.PAGE_END);
    }

    public JPanel setFrame()
    {
        return this.panel;
    }
}