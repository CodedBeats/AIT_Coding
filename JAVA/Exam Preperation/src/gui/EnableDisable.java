package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnableDisable extends JFrame {
    private JButton enableButton;
    private JButton disableButton;

    public EnableDisable() {
        setTitle("Button Enable/Disable Example");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        enableButton = new JButton("Enable");
        disableButton = new JButton("Disable");

        enableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButton.setEnabled(false);
                disableButton.setEnabled(true);
            }
        });

        disableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButton.setEnabled(true);
                disableButton.setEnabled(false);
            }
        });

        // Initially, only the "Enable" button is enabled
        enableButton.setEnabled(true);
        disableButton.setEnabled(false);

        setLayout(new FlowLayout());
        add(enableButton);
        add(disableButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EnableDisable example = new EnableDisable();
            example.setVisible(true);
        });
    }
}
