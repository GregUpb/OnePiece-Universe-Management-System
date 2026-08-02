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

    }
}
