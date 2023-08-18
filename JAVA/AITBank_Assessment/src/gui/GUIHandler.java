package gui;

// import classes
import gui.reusable_components.KeypadPanel;

// import libraries
import javax.swing.*;


public class GUIHandler {

    // just for testing purposes
    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Frame 1");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 400);
        
        KeypadPanel keypadPanel = new KeypadPanel();
        JButton btn = new JButton("xx");

        frame1.add(btn);
        frame1.add(keypadPanel);
        
        frame1.setVisible(true);

    }
}
