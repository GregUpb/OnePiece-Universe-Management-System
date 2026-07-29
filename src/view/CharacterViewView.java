package view;

import java.awt.*;
import javax.swing.*;

public class CharacterViewView
{

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;
    public JComboBox charSelectComboBox;

    public JLabel nameLabel, aliasLabel, originLabel, statusLabel, dfLabel, walletLabel, specifiedLabel1, specifiedLabel2, specifiedLabel3, specifiedLabel4;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public CharacterViewView()
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
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(textFont);
        nameLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(nameLabel);

        aliasLabel = new JLabel("Alias: ");
        aliasLabel.setFont(textFont);
        aliasLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(aliasLabel);
        
        originLabel = new JLabel("Origin: ");
        originLabel.setFont(textFont);
        originLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(originLabel);
        
        statusLabel = new JLabel("Status: ");
        statusLabel.setFont(textFont);
        statusLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(statusLabel);
        
        dfLabel = new JLabel("Devil Fruit: ");
        dfLabel.setFont(textFont);
        dfLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(dfLabel);
        
        walletLabel = new JLabel("Wallet: ");
        walletLabel.setFont(textFont);
        walletLabel.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(walletLabel);
        
        specifiedLabel1 = new JLabel("Name: ");
        specifiedLabel1.setFont(textFont);
        specifiedLabel1.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(specifiedLabel1);
        
        specifiedLabel2 = new JLabel("Name: ");
        specifiedLabel2.setFont(textFont);
        specifiedLabel2.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(specifiedLabel2);
        
        specifiedLabel3 = new JLabel("Name: ");
        specifiedLabel3.setFont(textFont);
        specifiedLabel3.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(specifiedLabel3);
        
        specifiedLabel4 = new JLabel("Name: ");
        specifiedLabel4.setFont(textFont);
        specifiedLabel4.setPreferredSize(new Dimension(0, 50));
        infoPanel.add(specifiedLabel4);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(infoPanel, BorderLayout.CENTER);

    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }

}
