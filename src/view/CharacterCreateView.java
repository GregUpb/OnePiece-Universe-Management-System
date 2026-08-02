package view;

import java.awt.*;
import javax.swing.*;
import model.*;

public class CharacterCreateView
{


    public JPanel panel, centerPanel, generalPanel, specifiedPanel;
    public JPanel piratePanel, marinePanel, hunterPanel, civPanel;
    public JPanel statusButtonPanel, typeButtonPanel;
    public JPanel namePanel, aliasPanel, originPanel, typePanel, statusPanel, dfPanel, walletPanel, rolePanel, ranksPanel, civrolePanel, bountyPanel, crewPanel, corpPanel, combatPanel, capturePanel, residencePanel;
    public JButton exitButton, submitButton;

    public JLabel nameLabel, aliasLabel, originLabel, statusLabel, dfLabel, walletLabel, roleLabel, ranksLabel, civroleLabel, typeLabel;

    //private
    public JTextField nameTextField, aliasTextField, originTextField, walletTextField;
    public JRadioButton aliveRadioButton, captureRadioButton, deadRadioButton;
    public JRadioButton pirateRadioButton, marineRadioButton, hunterRadioButton, civRadioButton;
    public ButtonGroup statusButtonGroup, typeButtonGroup;
    //private
    public JComboBox devilfruitComboBox;

    // Roles, Ranks, CivRoles
    //private all 3
    public JComboBox rolesComboBox;
    public JComboBox ranksComboBox;
    public JComboBox civrolesComboBox;

    // Pirate
    //private all 3
    private JLabel bountyLabel, crewLabel;
    public JTextField bountyTextField;
    public JComboBox crewComboBox;

    // Marine
    private JLabel corpLabel;
    public JComboBox corpComboBox;

    // Pirate Hunter
    private JLabel combatLabel, captureLabel;
    public JTextField combatTextField, captureTextField;

    // Civilian
    private JLabel residenceLabel;
    public JTextField residenceTextField;

    CardLayout cardLayout;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public CharacterCreateView()
    {
        panel = new JPanel(new BorderLayout());

        generalPanel = new JPanel();
        generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));
        specifiedPanel = new JPanel(new CardLayout());

        piratePanel = new JPanel();
        piratePanel.setLayout(new BoxLayout(piratePanel, BoxLayout.Y_AXIS));
        marinePanel = new JPanel();
        marinePanel.setLayout(new BoxLayout(marinePanel, BoxLayout.Y_AXIS));
        hunterPanel = new JPanel();
        hunterPanel.setLayout(new BoxLayout(hunterPanel, BoxLayout.Y_AXIS));
        civPanel = new JPanel();
        civPanel.setLayout(new BoxLayout(civPanel, BoxLayout.Y_AXIS));

        exitButton = new JButton("CANCEL");
        exitButton.setFont(buttonFont);
        
        submitButton = new JButton("SUBMIT");
        submitButton.setFont(buttonFont);

        // Type
        typeLabel = new JLabel("Type: ");
        typeLabel.setFont(textFont);
        typeLabel.setPreferredSize(new Dimension(150, 0));
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pirateRadioButton = new JRadioButton("Pirate");
        pirateRadioButton.setSelected(true);
        marineRadioButton = new JRadioButton("Marine");
        hunterRadioButton = new JRadioButton("Pirate Hunter");
        civRadioButton = new JRadioButton("Civilian");

        typeButtonGroup = new ButtonGroup();
        typeButtonGroup.add(pirateRadioButton);
        typeButtonGroup.add(marineRadioButton);
        typeButtonGroup.add(hunterRadioButton);
        typeButtonGroup.add(civRadioButton);

        typeButtonPanel = new JPanel(new GridLayout(1, 0));
        typeButtonPanel.add(pirateRadioButton);
        typeButtonPanel.add(marineRadioButton);
        typeButtonPanel.add(hunterRadioButton);
        typeButtonPanel.add(civRadioButton);

        typePanel = new JPanel(new BorderLayout());
        typePanel.setPreferredSize(new Dimension(0, 50));
        typePanel.add(typeLabel, BorderLayout.LINE_START);
        typePanel.add(typeButtonPanel, BorderLayout.CENTER);

        generalPanel.add(typePanel);

        // Name
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(150, 0));
        nameTextField = new JTextField(null);
        nameTextField.setFont(textFont);
        
        namePanel = new JPanel(new BorderLayout());
        namePanel.setPreferredSize(new Dimension(0, 50));
        namePanel.add(nameLabel, BorderLayout.LINE_START);
        namePanel.add(nameTextField, BorderLayout.CENTER);
        generalPanel.add(namePanel);

        // Alias
        aliasLabel = new JLabel("Alias (Optional): ");
        aliasLabel.setFont(textFont);
        aliasLabel.setPreferredSize(new Dimension(150, 0));
        aliasTextField = new JTextField();
        aliasTextField.setFont(textFont);
        
        aliasPanel = new JPanel(new BorderLayout());
        aliasPanel.setPreferredSize(new Dimension(0, 50));
        aliasPanel.add(aliasLabel, BorderLayout.LINE_START);
        aliasPanel.add(aliasTextField, BorderLayout.CENTER);
        generalPanel.add(aliasPanel);

        // Origin
        originLabel = new JLabel("Origin: ");
        originLabel.setFont(textFont);
        originLabel.setPreferredSize(new Dimension(150, 0));
        originTextField = new JTextField();
        originTextField.setFont(textFont);

        originPanel = new JPanel(new BorderLayout());
        originPanel.setPreferredSize(new Dimension(0, 50));
        originPanel.add(originLabel, BorderLayout.LINE_START);
        originPanel.add(originTextField, BorderLayout.CENTER);
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

        statusPanel = new JPanel(new BorderLayout());
        statusPanel.setPreferredSize(new Dimension(0, 50));
        statusPanel.add(statusLabel, BorderLayout.LINE_START);
        statusPanel.add(statusButtonPanel, BorderLayout.CENTER);

        generalPanel.add(statusPanel);

        // Devil Fruit
        dfLabel = new JLabel("Devil Fruit: ");
        dfLabel.setFont(textFont);
        dfLabel.setPreferredSize(new Dimension(150, 0));
        devilfruitComboBox = new JComboBox<>();

        dfPanel = new JPanel(new BorderLayout());
        dfPanel.setPreferredSize(new Dimension(0, 50));
        dfPanel.add(dfLabel, BorderLayout.LINE_START);
        dfPanel.add(devilfruitComboBox, BorderLayout.CENTER);
        generalPanel.add(dfPanel);

        // Wallet
        walletLabel = new JLabel("Wallet: ");
        walletLabel.setFont(textFont);
        walletLabel.setPreferredSize(new Dimension(150, 0));
        walletTextField = new JTextField();
        walletTextField.setFont(textFont);

        walletPanel = new JPanel(new BorderLayout());
        walletPanel.setPreferredSize(new Dimension(0, 50));
        walletPanel.add(walletLabel, BorderLayout.LINE_START);
        walletPanel.add(walletTextField, BorderLayout.CENTER);
        generalPanel.add(walletPanel);

        /* TYPE Specific */
        piratePanel = new JPanel(new GridLayout(0, 1));
        marinePanel = new JPanel(new GridLayout(0, 1));
        hunterPanel = new JPanel(new GridLayout(0, 1));
        civPanel = new JPanel(new GridLayout(0, 1));

        // Bounty
        bountyLabel = new JLabel("Bounty: ");
        bountyLabel.setFont(textFont);
        bountyLabel.setPreferredSize(new Dimension(150, 0));
        bountyTextField = new JTextField();
        bountyTextField.setFont(textFont);

        bountyPanel = new JPanel(new BorderLayout());
        bountyPanel.setPreferredSize(new Dimension(0, 50));
        bountyPanel.add(bountyLabel, BorderLayout.LINE_START);
        bountyPanel.add(bountyTextField, BorderLayout.CENTER);
        piratePanel.add(bountyPanel);

        // Role
        roleLabel = new JLabel("Pirate Role: ");
        roleLabel.setFont(textFont);
        roleLabel.setPreferredSize(new Dimension(150, 0));
        rolesComboBox = new JComboBox<>();
        for (String[] role : Pirate.ROLES) {
            rolesComboBox.addItem(role[0]); // role[0] gets "Captain", "Navigator", and more
        }

        rolePanel = new JPanel(new BorderLayout());
        rolePanel.setPreferredSize(new Dimension(0, 50));
        rolePanel.add(roleLabel, BorderLayout.LINE_START);
        rolePanel.add(rolesComboBox, BorderLayout.CENTER);
        piratePanel.add(rolePanel);

        // Crew
        crewLabel = new JLabel("Pirate Crew: ");
        crewLabel.setFont(textFont);
        crewLabel.setPreferredSize(new Dimension(150, 0));
        crewComboBox = new JComboBox<>();

        crewPanel = new JPanel(new BorderLayout());
        crewPanel.setPreferredSize(new Dimension(0, 50));
        crewPanel.add(crewLabel, BorderLayout.LINE_START);
        crewPanel.add(crewComboBox, BorderLayout.CENTER);
        piratePanel.add(crewPanel);

        // Rank
        ranksLabel = new JLabel("Marine Rank: ");
        ranksLabel.setFont(textFont);
        ranksLabel.setPreferredSize(new Dimension(150, 0));
        ranksComboBox = new JComboBox<>();
        for (String[] rank : Marine.RANKS) {
            ranksComboBox.addItem(rank[0]);
        }

        ranksPanel = new JPanel(new BorderLayout());
        ranksPanel.setPreferredSize(new Dimension(0, 50));
        ranksPanel.add(ranksLabel, BorderLayout.LINE_START);
        ranksPanel.add(ranksComboBox, BorderLayout.CENTER);
        marinePanel.add(ranksPanel);

        // Corp
        corpLabel = new JLabel("Marine Corp: ");
        corpLabel.setFont(textFont);
        corpLabel.setPreferredSize(new Dimension(150, 0));
        corpComboBox = new JComboBox<>();

        corpPanel = new JPanel(new BorderLayout());
        corpPanel.setPreferredSize(new Dimension(0, 50));
        corpPanel.add(corpLabel, BorderLayout.LINE_START);
        corpPanel.add(corpComboBox, BorderLayout.CENTER);
        marinePanel.add(corpPanel);

        // Combat Style
        combatLabel = new JLabel("Combat Style: ");
        combatLabel.setFont(textFont);
        combatLabel.setPreferredSize(new Dimension(150, 0));
        combatTextField = new JTextField();
        combatTextField.setFont(textFont);

        combatPanel = new JPanel(new BorderLayout());
        combatPanel.setPreferredSize(new Dimension(0, 50));
        combatPanel.add(combatLabel, BorderLayout.LINE_START);
        combatPanel.add(combatTextField, BorderLayout.CENTER);
        hunterPanel.add(combatPanel);

        // Captures
        captureLabel = new JLabel("Confirmed Captures: ");
        captureLabel.setFont(textFont);
        captureLabel.setPreferredSize(new Dimension(150, 0));
        captureTextField = new JTextField();
        captureTextField.setFont(textFont);

        capturePanel = new JPanel(new BorderLayout());
        capturePanel.setPreferredSize(new Dimension(0, 50));
        capturePanel.add(captureLabel, BorderLayout.LINE_START);
        capturePanel.add(captureTextField, BorderLayout.CENTER);
        hunterPanel.add(capturePanel);

        // Profession
        civroleLabel = new JLabel("Profession: ");
        civroleLabel.setFont(textFont);
        civroleLabel.setPreferredSize(new Dimension(150, 0));
        civrolesComboBox = new JComboBox<>();
        for (String[] profession : Civilian.CIVPROFESSIONS) {
            civrolesComboBox.addItem(profession[0]);
        }

        civrolePanel = new JPanel(new BorderLayout());
        civrolePanel.setPreferredSize(new Dimension(0, 50));
        civrolePanel.add(civroleLabel, BorderLayout.LINE_START);
        civrolePanel.add(civrolesComboBox, BorderLayout.CENTER);
        civPanel.add(civrolePanel);

        // Residence
        residenceLabel = new JLabel("Residence: ");
        residenceLabel.setFont(textFont);
        residenceLabel.setPreferredSize(new Dimension(150, 0));
        residenceTextField = new JTextField();
        residenceTextField.setFont(textFont);

        residencePanel = new JPanel(new BorderLayout());
        residencePanel.setPreferredSize(new Dimension(0, 50));
        residencePanel.add(residenceLabel, BorderLayout.LINE_START);
        residencePanel.add(residenceTextField, BorderLayout.CENTER);
        civPanel.add(residencePanel);

        // Specified Panel
        specifiedPanel = new JPanel(new CardLayout());
        cardLayout = (CardLayout)(specifiedPanel.getLayout());

        specifiedPanel.add(piratePanel, "PIRATE");
        specifiedPanel.add(marinePanel, "MARINE");
        specifiedPanel.add(hunterPanel, "HUNTER");
        specifiedPanel.add(civPanel, "CIVILIAN");

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(generalPanel);
        centerPanel.add(specifiedPanel);

        panel.add(exitButton, BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.PAGE_END);

    }

    public JPanel setFrame()
    {
        return this.panel;
    }

    public void showPanel(String name)
    {
        cardLayout.show(specifiedPanel, name);
    }


}
