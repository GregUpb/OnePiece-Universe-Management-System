package view;

import java.awt.*;
import javax.swing.*;
import panel.*;

public class DevilFruitViewView
{
    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox<String> dfSelectComboBox;

    public JLabel nameLabel, categoryLabel, abilityLabel, currentOwnerLabel, historicalOwnersLabel;

    public JScrollPane scrollPane;
    public JPanel innerPanel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);

    public DevilFruitViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        dfSelectComboBox = new JComboBox<>();
        topPanel.add(dfSelectComboBox, BorderLayout.CENTER);

        // Devil Fruit Info Labels
        nameLabel = new JLabel("Fruit Name: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(nameLabel);

        categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(textFont);
        categoryLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(categoryLabel);

        abilityLabel = new JLabel("Primary Ability: ");
        abilityLabel.setFont(textFont);
        abilityLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(abilityLabel);

        currentOwnerLabel = new JLabel("Current Owner: ");
        currentOwnerLabel.setFont(textFont);
        currentOwnerLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(currentOwnerLabel);

        historicalOwnersLabel = new JLabel("Historical Owners: ");
        historicalOwnersLabel.setFont(textFont);
        historicalOwnersLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(historicalOwnersLabel);

        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(innerPanel);
        infoPanel.add(scrollPane);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(infoPanel, BorderLayout.CENTER);
    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }

    public void setHistoricalOwners(java.util.List<model.Character> characters)
    {
        innerPanel.removeAll();

        for (model.Character c : characters)
        {
            this.innerPanel.add(new CharacterViewPanel(c.GetName()));
        }

    }
}