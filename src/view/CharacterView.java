package view;

import java.awt.*;
import javax.swing.*;

public class CharacterView
{
    public JPanel panel;
    public JButton pirateButton, marineButton, hunterButton, civButton, backButton;

    public Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    public CharacterView()
    {

        panel = new JPanel(new GridLayout(5, 1));

        /* Create Pirate Button */
        pirateButton = new JButton("Create Pirate");
        pirateButton.setSize(400, 50);
        pirateButton.setBackground(Color.RED);
        pirateButton.setFont(buttonFont);
        pirateButton.setFocusPainted(false);
        panel.add(pirateButton);
        

        /* Create Marine Button */
        marineButton = new JButton("Create Marine");
        marineButton.setSize(400, 50);
        marineButton.setBackground(Color.RED);
        marineButton.setFont(buttonFont);
        marineButton.setFocusPainted(false);
        panel.add(marineButton);
        


        /* Create Hunter Button */
        hunterButton = new JButton("Create Pirate Hunter");
        hunterButton.setSize(400, 50);
        hunterButton.setBackground(Color.RED);
        hunterButton.setFont(buttonFont);
        hunterButton.setFocusPainted(false);
        panel.add(hunterButton);
        


        /* Create Civilian Button */
        civButton = new JButton("Create Civilian");
        civButton.setSize(400, 50);
        civButton.setBackground(Color.RED);
        civButton.setFont(buttonFont);
        civButton.setFocusPainted(false);
        panel.add(civButton);
        


        /* Back Button */
        backButton = new JButton("Back");
        backButton.setSize(400, 50);
        backButton.setBackground(Color.RED);
        backButton.setFont(buttonFont);
        backButton.setFocusPainted(false);
        panel.add(backButton);

    }

    public JPanel setFrame()
    {
        return this.panel;
    }


}
