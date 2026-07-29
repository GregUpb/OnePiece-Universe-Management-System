package view;

import java.awt.*;
import javax.swing.*;

public class MainView
{
    JFrame mainFrame = new JFrame();
    JPanel border;

    JLabel info;
    JPanel menuPanel;

    JPanel mainPanel;

    public JButton characterButton, devilfruitButton, crewButton, corpButton, bountyButton, backButton;

    CardLayout cardLayout;

    public Font textFont = new Font(Font.SANS_SERIF, 0, 15);
    public Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    public MainView()
    {
        mainFrame = new JFrame("One Piece");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Click X to close
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);      // Centered when open
        
        createMainPanel();

        cardLayout = (CardLayout)(mainPanel.getLayout());

        mainFrame.add(border);

        mainFrame.setVisible(true);

    }

    private void createMainPanel()
    {
        border = new JPanel(new BorderLayout());

        info = new JLabel("Hello WOrld");
        info.setFont(textFont);
        border.add(info, BorderLayout.PAGE_START);

        mainPanel = new JPanel(new CardLayout());

        menuPanel = new JPanel(new GridLayout(5, 1));

        characterButton = new JButton("Character");
        characterButton.setSize(400, 50);
        characterButton.setBackground(Color.RED);
        characterButton.setFont(buttonFont);
        characterButton.setFocusPainted(false);
        menuPanel.add(characterButton);
        
        devilfruitButton = new JButton("Devil Fruit");
        devilfruitButton.setSize(400, 50);
        devilfruitButton.setBackground(Color.RED);
        devilfruitButton.setFont(buttonFont);
        devilfruitButton.setFocusPainted(false);
        menuPanel.add(devilfruitButton);
        
        crewButton = new JButton("Pirate Crew");
        crewButton.setSize(400, 50);
        crewButton.setBackground(Color.RED);
        crewButton.setFont(buttonFont);
        crewButton.setFocusPainted(false);
        menuPanel.add(crewButton);
        
        corpButton = new JButton("Marine Corp");
        corpButton.setSize(400, 50);
        corpButton.setBackground(Color.RED);
        corpButton.setFont(buttonFont);
        corpButton.setFocusPainted(false);
        menuPanel.add(corpButton);

        bountyButton = new JButton("Bounty");
        bountyButton.setSize(400, 50);
        bountyButton.setBackground(Color.RED);
        bountyButton.setFont(buttonFont);
        bountyButton.setFocusPainted(false);
        menuPanel.add(bountyButton);
        
        mainPanel.add(menuPanel, "MENU");

        border.add(mainPanel, BorderLayout.CENTER);

    }

    public JPanel getFrame()
    {
        return this.mainPanel;
    }

    public void setInfoText(String text)
    {

        info.setText(text);

    }

    public void addPanel(JPanel panel, String constraint)
    {

        mainPanel.add(panel, constraint);

    }

    public void showPanel(String name)
    {
        cardLayout.show(mainPanel, name);
    }

}
