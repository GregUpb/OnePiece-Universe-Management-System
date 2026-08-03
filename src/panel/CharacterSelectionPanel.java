package panel;

import java.awt.*;
import javax.swing.*;

public class CharacterSelectionPanel extends JPanel {

    public JCheckBox checkBox;
    private JLabel label;

    public CharacterSelectionPanel(String name) {

        checkBox = new JCheckBox();
        label = new JLabel(name);
        label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 30));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(checkBox, BorderLayout.LINE_START);
        add(label, BorderLayout.CENTER);
    }

    public boolean isSelected()
    {
        return this.checkBox.isSelected();
    }

    public void setChecked(boolean isMember) {this.checkBox.setSelected(isMember);}

    public String getName()
    {
        return this.label.getText();
    }
}