package view;

import java.awt.*;
import javax.swing.*;

public class CharacterModifyView
{

    String[] temp = {"None", "Cheese", "McBalls", "McMc"};

    public JPanel panel, generalPanel, topPanel;
    public JPanel specified1Panel, specified2Panel, specified3Panel, specified4Panel;
    public JPanel statusButtonPanel, typeButtonPanel;
    public JPanel namePanel, aliasPanel, originPanel, typePanel, statusPanel, dfPanel, walletPanel, rolePanel, ranksPanel, civrolePanel, bountyPanel, crewPanel, corpPanel, combatPanel, capturePanel, residencePanel;
    public JButton exitButton, submitButton;

    public JComboBox charSelectComboBox;

    private JLabel nameLabel, aliasLabel, originLabel, statusLabel, dfLabel, walletLabel, roleLabel, ranksLabel, civroleLabel, typeLabel;

    public JTextField nameTextField;
    public JTextField aliasTextField;
    public JTextField originTextField;
    public JTextField walletTextField;
    public JRadioButton aliveRadioButton, captureRadioButton, deadRadioButton;
    public ButtonGroup statusButtonGroup, typeButtonGroup;
    public JComboBox devilfruitComboBox;

    public JLabel specified1Label, specified2Label, specified3Label, specified4Label;
    public JTextField specified1TextField, specified2TextField;
    public JComboBox specified3ComboBox, specified4ComboBox;

    CardLayout cardLayout;

    public JCheckBox nameCheckBox, aliasCheckBox, originCheckBox, statusCheckBox, dfCheckBox, walletCheckBox;
    public JCheckBox specified1CheckBox, specified2CheckBox, specified3CheckBox, specified4CheckBox;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public CharacterModifyView()
    {
        panel = new JPanel(new BorderLayout());

        generalPanel = new JPanel(new GridLayout(0, 1));
        topPanel = new JPanel(new GridLayout(0, 1));

        exitButton = new JButton("CANCEL");
        exitButton.setFont(buttonFont);
        topPanel.add(exitButton);
        
        submitButton = new JButton("SUBMIT");
        submitButton.setFont(buttonFont);

        charSelectComboBox = new JComboBox<>();
        topPanel.add(charSelectComboBox);

        // Name
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(150, 0));
        nameTextField = new JTextField(null);
        nameTextField.setFont(textFont);
        nameCheckBox = new JCheckBox();
        
        namePanel = new JPanel(new BorderLayout());
        namePanel.add(nameLabel, BorderLayout.LINE_START);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        namePanel.add(nameCheckBox, BorderLayout.LINE_END);
        generalPanel.add(namePanel);

        // Alias
        aliasLabel = new JLabel("Alias: ");
        aliasLabel.setFont(textFont);
        aliasLabel.setPreferredSize(new Dimension(150, 0));
        aliasTextField = new JTextField();
        aliasTextField.setFont(textFont);
        aliasCheckBox = new JCheckBox();
        
        aliasPanel = new JPanel(new BorderLayout());
        aliasPanel.add(aliasLabel, BorderLayout.LINE_START);
        aliasPanel.add(aliasTextField, BorderLayout.CENTER);
        aliasPanel.add(aliasCheckBox, BorderLayout.LINE_END);
        generalPanel.add(aliasPanel);

        // Origin
        originLabel = new JLabel("Origin: ");
        originLabel.setFont(textFont);
        originLabel.setPreferredSize(new Dimension(150, 0));
        originTextField = new JTextField();
        originTextField.setFont(textFont);
        originCheckBox = new JCheckBox();

        originPanel = new JPanel(new BorderLayout());
        originPanel.add(originLabel, BorderLayout.LINE_START);
        originPanel.add(originTextField, BorderLayout.CENTER);
        originPanel.add(originCheckBox, BorderLayout.LINE_END);
        generalPanel.add(originPanel);

        // Status
        statusLabel = new JLabel("Status: ");
        statusLabel.setFont(textFont);
        statusLabel.setPreferredSize(new Dimension(150, 0));
        aliveRadioButton = new JRadioButton("Alive");
        aliveRadioButton.setFont(textFont);
        aliveRadioButton.setSelected(true);
        captureRadioButton = new JRadioButton("Captured");
        captureRadioButton.setFont(textFont);
        deadRadioButton = new JRadioButton("Dead");
        deadRadioButton.setFont(textFont);

        statusButtonGroup = new ButtonGroup();
        statusButtonGroup.add(aliveRadioButton);
        statusButtonGroup.add(captureRadioButton);
        statusButtonGroup.add(deadRadioButton);

        statusButtonPanel = new JPanel(new GridLayout(1 , 0));
        statusButtonPanel.add(aliveRadioButton);
        statusButtonPanel.add(captureRadioButton);
        statusButtonPanel.add(deadRadioButton);
        statusCheckBox = new JCheckBox();

        statusPanel = new JPanel(new BorderLayout());
        statusPanel.add(statusLabel, BorderLayout.LINE_START);
        statusPanel.add(statusButtonPanel, BorderLayout.CENTER);
        statusPanel.add(statusCheckBox, BorderLayout.LINE_END);

        generalPanel.add(statusPanel);

        // Devil Fruit
        dfLabel = new JLabel("Devil Fruit: ");
        dfLabel.setFont(textFont);
        dfLabel.setPreferredSize(new Dimension(150, 0));
        devilfruitComboBox = new JComboBox<>();
        dfCheckBox = new JCheckBox();

        dfPanel = new JPanel(new BorderLayout());
        dfPanel.add(dfLabel, BorderLayout.LINE_START);
        dfPanel.add(devilfruitComboBox, BorderLayout.CENTER);
        dfPanel.add(dfCheckBox, BorderLayout.LINE_END);
        generalPanel.add(dfPanel);

        // Wallet
        walletLabel = new JLabel("Wallet: ");
        walletLabel.setFont(textFont);
        walletLabel.setPreferredSize(new Dimension(150, 0));
        walletTextField = new JTextField();
        walletTextField.setFont(textFont);
        walletCheckBox = new JCheckBox();

        walletPanel = new JPanel(new BorderLayout());
        walletPanel.add(walletLabel, BorderLayout.LINE_START);
        walletPanel.add(walletTextField, BorderLayout.CENTER);
        walletPanel.add(walletCheckBox, BorderLayout.LINE_END);
        generalPanel.add(walletPanel);

        /* TYPE Specific */
        specified1Label = new JLabel("1: ");
        specified1Label.setFont(textFont);
        specified1Label.setPreferredSize(new Dimension(150, 0));
        specified1TextField = new JTextField();
        specified1TextField.setFont(textFont);
        specified1CheckBox = new JCheckBox();
        
        specified1Panel = new JPanel(new BorderLayout());
        specified1Panel.add(specified1Label, BorderLayout.LINE_START);
        specified1Panel.add(specified1TextField, BorderLayout.CENTER);
        specified1Panel.add(specified1CheckBox, BorderLayout.LINE_END);
        generalPanel.add(specified1Panel);

        // 2
        specified2Label = new JLabel("2: ");
        specified2Label.setFont(textFont);
        specified2Label.setPreferredSize(new Dimension(150, 0));
        specified2TextField = new JTextField();
        specified2TextField.setFont(textFont);
        specified2CheckBox = new JCheckBox();
        
        specified2Panel = new JPanel(new BorderLayout());
        specified2Panel.add(specified2Label, BorderLayout.LINE_START);
        specified2Panel.add(specified2TextField, BorderLayout.CENTER);
        specified2Panel.add(specified2CheckBox, BorderLayout.LINE_END);
        generalPanel.add(specified2Panel);

        // 3
        specified3Label = new JLabel("3: ");
        specified3Label.setFont(textFont);
        specified3Label.setPreferredSize(new Dimension(150, 0));
        specified3ComboBox = new JComboBox<>(temp);
        specified3CheckBox = new JCheckBox();
        
        specified3Panel = new JPanel(new BorderLayout());
        specified3Panel.add(specified3Label, BorderLayout.LINE_START);
        specified3Panel.add(specified3ComboBox, BorderLayout.CENTER);
        specified3Panel.add(specified3CheckBox, BorderLayout.LINE_END);
        generalPanel.add(specified3Panel);

        // 4
        specified4Label = new JLabel("4: ");
        specified4Label.setFont(textFont);
        specified4Label.setPreferredSize(new Dimension(150, 0));
        specified4ComboBox = new JComboBox<>(temp);
        specified4CheckBox = new JCheckBox();
        
        specified4Panel = new JPanel(new BorderLayout());
        specified4Panel.add(specified4Label, BorderLayout.LINE_START);
        specified4Panel.add(specified4ComboBox, BorderLayout.CENTER);
        specified4Panel.add(specified4CheckBox, BorderLayout.LINE_END);
        generalPanel.add(specified4Panel);

        // hehehe
        panel.add(topPanel, BorderLayout.PAGE_START);
        panel.add(generalPanel, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.PAGE_END);

    }

    public JPanel setFrame()
    {
        return this.panel;
    }


}
