package view;

import java.awt.*;
import javax.swing.*;

public class DevilFruitViewView
{
    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox<String> dfSelectComboBox;

    public JLabel nameLabel, categoryLabel, abilityLabel, currentOwnerLabel, historicalOwnersLabel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);

    public DevilFruitViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel(new GridLayout(0, 1));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        dfSelectComboBox = new JComboBox<>();
        topPanel.add(dfSelectComboBox, BorderLayout.CENTER);

        // Devil Fruit Info Labels
        nameLabel = new JLabel("Fruit Name: ");
        nameLabel.setFont(textFont);
        infoPanel.add(nameLabel);

        categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(textFont);
        infoPanel.add(categoryLabel);

        abilityLabel = new JLabel("Primary Ability: ");
        abilityLabel.setFont(textFont);
        infoPanel.add(abilityLabel);

        currentOwnerLabel = new JLabel("Current Owner: ");
        currentOwnerLabel.setFont(textFont);
        infoPanel.add(currentOwnerLabel);

        historicalOwnersLabel = new JLabel("Historical Owners: ");
        historicalOwnersLabel.setFont(textFont);
        infoPanel.add(historicalOwnersLabel);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }
}