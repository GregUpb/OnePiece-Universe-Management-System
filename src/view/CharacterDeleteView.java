package view;

import java.awt.*;
import javax.swing.*;

public class CharacterDeleteView
{
    String[] temp = {"Cheese", "STUFFF", "McMuffin", "JACOB na backshot"};

    public JPanel mainPanel, topPanel, centerPanel;
    public JButton backButton, deleteButton;
    public JComboBox charSelectComboBox;

    public JOptionPane optionPane;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public CharacterDeleteView()
    {
        optionPane = new JOptionPane("Are you sure?", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);

        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        centerPanel = new JPanel(new GridLayout(2, 1));
        charSelectComboBox = new JComboBox<>(temp);
        charSelectComboBox.setPreferredSize(new Dimension(300, 150));
        deleteButton = new JButton("Delete");
        deleteButton.setFont(buttonFont);
        deleteButton.setPreferredSize(new Dimension(100, 50));
        centerPanel.add(charSelectComboBox);
        centerPanel.add(deleteButton);

        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }

}
