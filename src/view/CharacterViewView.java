package view;

import java.awt.*;
import javax.swing.*;

public class CharacterViewView
{
    String[] temp = {"Cheese", "STUFFF", "McMuffin", "JACOB na backshot"};

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox charSelectComboBox;

    private JLabel nameLabel, aliasLabel, originLabel, statusLabel, dfLabel, walletLabel, specifiedLabel1, specifiedLabel2, specifiedLabel3, specifiedLabel4;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public CharacterViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel(new GridLayout(0, 1));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        charSelectComboBox = new JComboBox<>(temp);
        topPanel.add(charSelectComboBox, BorderLayout.CENTER);

        // Character Information
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(textFont);
        infoPanel.add(nameLabel);

        aliasLabel = new JLabel("Alias: ");
        aliasLabel.setFont(textFont);
        infoPanel.add(aliasLabel);
        
        originLabel = new JLabel("Origin: ");
        originLabel.setFont(textFont);
        infoPanel.add(originLabel);
        
        statusLabel = new JLabel("Status: ");
        statusLabel.setFont(textFont);
        infoPanel.add(statusLabel);
        
        dfLabel = new JLabel("Devil Fruit: ");
        dfLabel.setFont(textFont);
        infoPanel.add(dfLabel);
        
        walletLabel = new JLabel("Wallet: ");
        walletLabel.setFont(textFont);
        infoPanel.add(walletLabel);
        
        specifiedLabel1 = new JLabel("Name: ");
        specifiedLabel1.setFont(textFont);
        infoPanel.add(specifiedLabel1);
        
        specifiedLabel2 = new JLabel("Name: ");
        specifiedLabel2.setFont(textFont);
        infoPanel.add(specifiedLabel2);
        
        specifiedLabel3 = new JLabel("Name: ");
        specifiedLabel3.setFont(textFont);
        infoPanel.add(specifiedLabel3);
        
        specifiedLabel4 = new JLabel("Name: ");
        specifiedLabel4.setFont(textFont);
        infoPanel.add(specifiedLabel4);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }

}
