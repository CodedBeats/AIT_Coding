package gui;

// import classes
import gui.reusable_components.KeypadPanel;
import gui.windows.HomeUI;
import gui.windows.LoginUI;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIHandler {
    // handler attributes
    String accountType;

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
                accountType = "cheque";
                homeUI.closeWindow();
                System.out.println(accountType);
            }
        });
        homeUI.addFixedCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "fixed";
                homeUI.closeWindow();
                System.out.println(accountType);
            }
        });
        homeUI.addNetSaverCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "netSaver";
                homeUI.closeWindow();
                System.out.println(accountType);
            }
        });
        homeUI.addSavingsCardBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "savings";
                homeUI.closeWindow();
                System.out.println(accountType);
            }
        });
    }


    // handle login screen
    public void handleLogin() {
        LoginUI loginUI = new LoginUI();

        // add functionality to PIN submit btn
        loginUI.submitPIN(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = loginUI.getPIN();
                System.out.println(pin);
                // verify PIN
                // close window
            }
        });
    }


    // just for testing purposes
    public static void main(String[] args) {

        /* ============================================================= */
        // JFrame frame1 = new JFrame("Frame 1");
        // frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame1.setSize(300, 400);
        
        // KeypadPanel keypadPanel = new KeypadPanel(true, false);

        // frame1.add(keypadPanel);
        
        // frame1.setVisible(true);
        /* ============================================================= */
    }
}
