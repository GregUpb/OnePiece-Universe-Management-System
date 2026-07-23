package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainWindow
{
    public MainWindow()
    {
        /* Create a new Window */
        JFrame mainFrame = new JFrame("One Piece");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Click X to close
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);      // Centered when open
        mainFrame.setLayout(new BorderLayout());

        /* TOP */




        /* CENTER */
        // Initialize an image
        ImageIcon img = new ImageIcon(".\\image\\image.jpg");
        Image newimg = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        // Create a holder for the image
        JLabel label = new JLabel(new ImageIcon(newimg));

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setSize(200, 200);

        JLabel laa = new JLabel("Hello World");
        Font font = new Font(null, 2, 50);
        laa.setFont(font);
        JLabel laa2 = new JLabel("Hello World");
        laa2.setFont(font);

        panel.add(label);

        mainFrame.add(laa, BorderLayout.PAGE_START);
        mainFrame.add(laa2, BorderLayout.PAGE_END);
        mainFrame.add(panel, BorderLayout.CENTER);

        mainFrame.setVisible(true);

        /*

        // Creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1280, 720);

        // Create a new panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setSize(200, 150);

        JLabel laa = new JLabel("Hello World");
        Font font = new Font(null, 2, 50);
        laa.setFont(font);
        panel.add(laa);

        // Initialize an image
        ImageIcon img = new ImageIcon(".\\image\\image.jpg");

        // Create a holder for the image
        JLabel label = new JLabel(img);

        // Creates a new button (No function yet)
        JButton button = new JButton("BUTTON");
        button.setSize(100, 100);

        // Add all to the window
        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.PAGE_END);
        frame.add(panel, BorderLayout.PAGE_START);
        frame.add(label, BorderLayout.CENTER);

        // Pops out in the center
        frame.setLocationRelativeTo(null);

        // making the frame visible
        frame.setVisible(true);
        
        */
    }

    public ImageIcon getScaledIcon(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(path));
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
