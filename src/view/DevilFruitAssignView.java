package view;

import java.awt.*;
import javax.swing.*;

public class DevilFruitAssignView
{
    public JPanel mainPanel, centerPanel;
    public JPanel dfPanel, charPanel;
    public JButton exitButton, submitButton;

    public JLabel dfLabel, charLabel;
    public JComboBox<String> dfComboBox;
    public JComboBox<String> charComboBox;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);

    public DevilFruitAssignView()
    {
        mainPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new GridLayout(0, 1));

        exitButton = new JButton("CANCEL");
        exitButton.setFont(buttonFont);

        submitButton = new JButton("ASSIGN");
        submitButton.setFont(buttonFont);

        // Devil Fruit Selection
        dfLabel = new JLabel("Select Devil Fruit: ");
        dfLabel.setFont(textFont);
        dfLabel.setPreferredSize(new Dimension(150, 0));

        dfComboBox = new JComboBox<>();

        dfPanel = new JPanel(new BorderLayout());
        dfPanel.add(dfLabel, BorderLayout.LINE_START);
        dfPanel.add(dfComboBox, BorderLayout.CENTER);
        centerPanel.add(dfPanel);

        // Character Selection
        charLabel = new JLabel("Select Character: ");
        charLabel.setFont(textFont);
        charLabel.setPreferredSize(new Dimension(150, 0));

        charComboBox = new JComboBox<>();

        charPanel = new JPanel(new BorderLayout());
        charPanel.add(charLabel, BorderLayout.LINE_START);
        charPanel.add(charComboBox, BorderLayout.CENTER);
        centerPanel.add(charPanel);

        mainPanel.add(exitButton, BorderLayout.PAGE_START);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(submitButton, BorderLayout.PAGE_END);
    }

    public JPanel setFrame()
    {
        return this.mainPanel;
    }
}