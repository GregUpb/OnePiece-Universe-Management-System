// import controller.CharacterController;
// import java.awt.BorderLayout;
// import javax.swing.*;
// import view.CharacterView;

import controller.MainController;
import view.MainView;

public class Driver
{
//     public static JPanel mainPanel;

    public static void main(String[] args)
    {

        MainView mainView = new MainView();
        MainController mainController = new MainController(mainView);

        


        // /* Create a new Window */
        // JFrame mainFrame = new JFrame("One Piece");
        // mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Click X to close
        // mainFrame.setSize(500, 500);
        // mainFrame.setLocationRelativeTo(null);      // Centered when open
        // mainFrame.setLayout(new BorderLayout());

        // /* TOP */




        // /* CENTER */
        // // Initialize an image
        // // ImageIcon img = new ImageIcon(".\\image\\image.jpg");
        // // Image newimg = img.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

        // // // Create a holder for the image
        // // JLabel label = new JLabel(new ImageIcon(newimg));

        // // JPanel panel = new JPanel();
        // // panel.setBackground(Color.BLUE);
        // // panel.setSize(200, 200);

        // // JLabel laa = new JLabel("Hello World");
        // // Font font = new Font(null, 2, 50);
        // // laa.setFont(font);
        // // JLabel laa2 = new JLabel("Hello World");
        // // laa2.setFont(font);

        // // panel.add(label);

        // CharacterView createCharacterFrame = new CharacterView();
        // CharacterController createCharacterController = new CharacterController(createCharacterFrame);
        
        // mainPanel = createCharacterController.setFrame();
        // mainFrame.add(mainPanel);


        // // mainFrame.add(laa, BorderLayout.PAGE_START);
        // // mainFrame.add(laa2, BorderLayout.PAGE_END);
        // // mainFrame.add(panel, BorderLayout.CENTER);

        // mainFrame.setVisible(true);
    }
}
