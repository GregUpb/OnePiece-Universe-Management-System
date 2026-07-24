package view;

import java.awt.*;
import javax.swing.*;

public class MarineCorpView
{
    public JPanel panel;
    public JButton createButton, viewButton, editButton, backButton;

    public Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    public MarineCorpView()
    {

        panel = new JPanel(new GridLayout(4, 1));

        /* Create Button */
        createButton = new JButton("Create Pirate");
        createButton.setSize(400, 50);
        createButton.setBackground(Color.RED);
        createButton.setFont(buttonFont);
        createButton.setFocusPainted(false);
        panel.add(createButton);
        

        /* View Button */
        viewButton = new JButton("Create Marine");
        viewButton.setSize(400, 50);
        viewButton.setBackground(Color.RED);
        viewButton.setFont(buttonFont);
        viewButton.setFocusPainted(false);
        panel.add(viewButton);
        


        /* Modify Button */
        editButton = new JButton("Create Pirate Hunter");
        editButton.setSize(400, 50);
        editButton.setBackground(Color.RED);
        editButton.setFont(buttonFont);
        editButton.setFocusPainted(false);
        panel.add(editButton);
        
        

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
