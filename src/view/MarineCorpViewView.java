package view;

import java.awt.*;
import javax.swing.*;

public class MarineCorpViewView
{

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox charSelectComboBox;

    public JLabel  locationLabel, fundsLabel, commanderLabel, membersLabel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public MarineCorpViewView()
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
        locationLabel = new JLabel("Marine Corp Location: ");
        locationLabel.setFont(textFont);
        infoPanel.add(locationLabel);

        fundsLabel = new JLabel("Operational Funds: ");
        fundsLabel.setFont(textFont);
        infoPanel.add(fundsLabel);

        commanderLabel = new JLabel("Commander's Name: ");
        commanderLabel.setFont(textFont);
        infoPanel.add(commanderLabel);

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
