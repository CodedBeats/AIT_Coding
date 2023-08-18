package gui;

// import classes
import gui.reusable_components.KeypadPanel;
import gui.windows.HomeUI;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIHandler {

    // constructor
    public GUIHandler() {

    }


    // handle home screen
    public void handleHomeUI() {
        HomeUI homeUI = new HomeUI();
        
        // add functionality to home card type btns (perhaps an unconventional way to do this but it makes sense to me)
        homeUI.addChequeCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addChequeCardBtnListener");
                // 
            }
        });
        homeUI.addCFixedCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addCFixedCardBtnListener");
                // 
            }
        });
        homeUI.addNetSaverCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addNetSaverCardBtnListener");
                // 
            }
        });
        homeUI.addSavingsCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("addSavingsCardBtnListener");
                // 
            }
        });
    }


    // just for testing purposes
    public static void main(String[] args) {

        /* ============================================================= */
        // JFrame frame1 = new JFrame("Frame 1");
        // frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame1.setSize(300, 400);
        
        // KeypadPanel keypadPanel = new KeypadPanel();
        // JButton btn = new JButton("xx");
        
        // // keypadPanel.setTxtFieldType();

        // frame1.add(btn);
        // frame1.add(keypadPanel);
        
        // frame1.setVisible(true);
        /* ============================================================= */
    }
}
