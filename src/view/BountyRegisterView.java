package view;

import java.awt.*;
import javax.swing.*;

public class BountyRegisterView
{

    String[] temp = {"None", "Cheese", "McBalls", "McMc"};

    public JPanel panel, centerPanel;
    
    public JPanel captorPanel, capturedPanel, statusPanel, statusButtonPanel;
    public JLabel captorLabel, capturedLabel, statusLabel;
    public JComboBox captorComboBox, capturedComboBox;

    public JRadioButton aliveRadioButton, deadRadioButton;
    public ButtonGroup statusButtonGroup;

    public JButton exitButton, submitButton;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public BountyRegisterView()
    {
        panel = new JPanel(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Captured
        capturedLabel = new JLabel("Captured Pirate: ");
        capturedLabel.setFont(textFont);
        capturedLabel.setPreferredSize(new Dimension(150, 0));
        capturedComboBox = new JComboBox<>(temp);
        capturedComboBox.setFont(textFont);

        capturedPanel = new JPanel(new BorderLayout());
        capturedPanel.setPreferredSize(new Dimension(0, 50));
        capturedPanel.add(capturedLabel, BorderLayout.LINE_START);
        capturedPanel.add(capturedComboBox, BorderLayout.CENTER);
        centerPanel.add(capturedPanel);

        // Status
        statusLabel = new JLabel("Dead or Alive: ");
        statusLabel.setFont(textFont);
        statusLabel.setPreferredSize(new Dimension(150, 0));

        aliveRadioButton = new JRadioButton("Alive");
        aliveRadioButton.setFont(textFont);
        aliveRadioButton.setSelected(true);
        deadRadioButton = new JRadioButton("Dead");
        deadRadioButton.setFont(textFont);
        statusButtonGroup = new ButtonGroup();
        statusButtonGroup.add(aliveRadioButton);
        statusButtonGroup.add(deadRadioButton);
        statusButtonPanel = new JPanel(new GridLayout(1 , 0));
        statusButtonPanel.add(aliveRadioButton);
        statusButtonPanel.add(deadRadioButton);

        statusPanel = new JPanel(new BorderLayout());
        statusPanel.setPreferredSize(new Dimension(0, 50));
        statusPanel.add(statusLabel, BorderLayout.LINE_START);
        statusPanel.add(statusButtonPanel, BorderLayout.CENTER);
        centerPanel.add(statusPanel);

        // Captor
        captorLabel = new JLabel("Captor: ");
        captorLabel.setFont(textFont);
        captorLabel.setPreferredSize(new Dimension(150, 0));
        captorComboBox = new JComboBox<>(temp);
        captorComboBox.setFont(textFont);

        captorPanel = new JPanel(new BorderLayout());
        captorPanel.setPreferredSize(new Dimension(0, 50));
        captorPanel.add(captorLabel, BorderLayout.LINE_START);
        captorPanel.add(captorComboBox, BorderLayout.CENTER);
        centerPanel.add(captorPanel);

        exitButton = new JButton("CANCEL");
        exitButton.setFont(buttonFont);
        
        submitButton = new JButton("SUBMIT");
        submitButton.setFont(buttonFont);

        panel.add(exitButton, BorderLayout.PAGE_START);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.PAGE_END);

    }

    public JPanel setFrame()
    {
        return this.panel;
    }
    

}
