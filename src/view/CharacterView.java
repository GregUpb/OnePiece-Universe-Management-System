package view;

import java.awt.*;
import javax.swing.*;

public class CharacterView
{
    public JPanel panel;
    public JButton createButton, viewButton, modifyButton, deleteButton, backButton;

    public Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    public CharacterView()
    {

        panel = new JPanel(new GridLayout(5, 1));

        /* Create Pirate Button */
        createButton = new JButton("Create Character");
        createButton.setSize(400, 50);
        createButton.setBackground(Color.RED);
        createButton.setFont(buttonFont);
        createButton.setFocusPainted(false);
        panel.add(createButton);
        

        /* Create Marine Button */
        viewButton = new JButton("View Character");
        viewButton.setSize(400, 50);
        viewButton.setBackground(Color.RED);
        viewButton.setFont(buttonFont);
        viewButton.setFocusPainted(false);
        panel.add(viewButton);
        


        /* Create Hunter Button */
        modifyButton = new JButton("Modify Character");
        modifyButton.setSize(400, 50);
        modifyButton.setBackground(Color.RED);
        modifyButton.setFont(buttonFont);
        modifyButton.setFocusPainted(false);
        panel.add(modifyButton);
        


        /* Create Civilian Button */
        deleteButton = new JButton("Unalive Character");
        deleteButton.setSize(400, 50);
        deleteButton.setBackground(Color.RED);
        deleteButton.setFont(buttonFont);
        deleteButton.setFocusPainted(false);
        panel.add(deleteButton);
        


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
