package view;

import java.awt.*;
import javax.swing.*;

import model.CaptureRecord;

import java.util.*;

import panel.*;

public class BountyViewView
{

    public JPanel mainPanel, topPanel, infoPanel;
    public JButton backButton;

    public JLabel  titleLabel;

    public JScrollPane scrollPane;
    public JPanel innerPanel;

    private Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    private Font textFont = new Font(Font.SERIF, Font.CENTER_BASELINE, 15);
    
    public BountyViewView()
    {
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new BorderLayout());
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        topPanel.add(backButton, BorderLayout.PAGE_START);

        titleLabel = new JLabel("Historical Captures:");
        titleLabel.setFont(textFont);
        infoPanel.add(titleLabel);

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

    public void setHistoricalCaptures(java.util.List<CaptureRecord> captures)
    {
        innerPanel.removeAll();

        for (CaptureRecord c : captures)
        {
            this.innerPanel.add(new BountyDetailPanel(c));
        }

    }
}
