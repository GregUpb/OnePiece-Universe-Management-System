package panel;

import java.awt.*;
import javax.swing.*;

public class CharacterViewPanel extends JPanel {

    private JLabel label;

    public CharacterViewPanel(String name) {

        label = new JLabel(name);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLineBorder(Color.BLACK)));

        add(label, BorderLayout.CENTER);
    }

    public String getName()
    {
        return this.label.getText();
    }
}