package view;

import java.awt.*;
import javax.swing.*;

public class BountyView
{
    public JPanel panel;
    public JButton registerButton, viewButton, backButton;

    public Font buttonFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
    
    public BountyView()
    {

        panel = new JPanel(new GridLayout(0, 1));

        /* Create Button */
        registerButton = new JButton("Register Bounty");
        registerButton.setBackground(Color.RED);
        registerButton.setFont(buttonFont);
        registerButton.setFocusPainted(false);
        panel.add(registerButton);
        

        /* View Button */
        viewButton = new JButton("View Historical Captures");
        viewButton.setBackground(Color.RED);
        viewButton.setFont(buttonFont);
        viewButton.setFocusPainted(false);
        panel.add(viewButton);
        


        /* Back Button */
        backButton = new JButton("Back");
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
