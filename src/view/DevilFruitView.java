package view;

import java.awt.*;
import javax.swing.*;

public class DevilFruitView
{
    public JPanel panel;
    public JButton createButton, viewButton, assignButton, backButton;

    public Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    public DevilFruitView()
    {

        panel = new JPanel(new GridLayout(5, 1));

        /* Create Devil Fruit Button */
        createButton = new JButton("Create Devil Fruit");
        createButton.setSize(400, 50);
        createButton.setBackground(Color.RED);
        createButton.setFont(buttonFont);
        createButton.setFocusPainted(false);
        panel.add(createButton);
        

        /* View Devil Fruit Button */
        viewButton = new JButton("View Devil Fruit");
        viewButton.setSize(400, 50);
        viewButton.setBackground(Color.RED);
        viewButton.setFont(buttonFont);
        viewButton.setFocusPainted(false);
        panel.add(viewButton);
        


        /* Assign Devil Fruit Button */
        assignButton = new JButton("Assign Devil Fruit");
        assignButton.setSize(400, 50);
        assignButton.setBackground(Color.RED);
        assignButton.setFont(buttonFont);
        assignButton.setFocusPainted(false);
        panel.add(assignButton);
        


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
