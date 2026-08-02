package panel;

import java.awt.*;
import javax.swing.*;

import model.*;

public class BountyDetailPanel extends JPanel {

    private JLabel idLabel, capturedLabel, captorLabel;

    private Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);

    public BountyDetailPanel(CaptureRecord capture) {

        capturedLabel = new JLabel("Captured: " + capture.getCaptured().GetName());
        capturedLabel.setFont(font);

        captorLabel = new JLabel("Captor: " + capture.getCaptor().GetName());
        captorLabel.setFont(font);

        idLabel = new JLabel("Capture ID: " + capture.getCaptureID());
        idLabel.setFont(font);

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 20));

        add(idLabel, BorderLayout.PAGE_START);
        add(capturedLabel, BorderLayout.LINE_START);
        add(captorLabel, BorderLayout.LINE_START);

    }
}