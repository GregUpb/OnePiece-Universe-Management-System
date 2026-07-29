package view;

import java.awt.*;
import javax.swing.*;

import panel.*;

public class MarineCorpViewView
{

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox charSelectComboBox;

    public JLabel  locationLabel, fundsLabel, commanderLabel, membersLabel;

    public JScrollPane scrollPane;
    public JPanel innerPanel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public MarineCorpViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        charSelectComboBox = new JComboBox<>();
        topPanel.add(charSelectComboBox, BorderLayout.CENTER);

        // Character Information
        locationLabel = new JLabel("Marine Corp Location: ");
        locationLabel.setFont(textFont);
        locationLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(locationLabel);

        fundsLabel = new JLabel("Operational Funds: ");
        fundsLabel.setFont(textFont);
        fundsLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(fundsLabel);

        commanderLabel = new JLabel("Commander's Name: ");
        commanderLabel.setFont(textFont);
        commanderLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(commanderLabel);

        membersLabel = new JLabel("Members: ");
        membersLabel.setFont(textFont);
        membersLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(membersLabel);

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

    public void setMembers(java.util.List<model.Marine> members)
    {
        innerPanel.removeAll();

        for (model.Marine m : members)
        {
            this.innerPanel.add(new CharacterViewPanel(m.GetName()));
        }

    }

}
