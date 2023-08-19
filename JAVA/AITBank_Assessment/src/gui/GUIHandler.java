package gui;

// import classes
import gui.reusable_components.KeypadPanel;
import gui.windows.DashboardUI;
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
    String menuOption;

    // constructor
    public GUIHandler() {

    }


    // handle home screen
    public void handleHomeUI() {
        HomeUI homeUI = new HomeUI();
        
        // add functionality to home card type btns (perhaps an unconventional way to do this but it makes sense to me)
        homeUI.chequeCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "cheque";
                homeUI.hideWindow();
                System.out.println(accountType);
            }
        });
        homeUI.fixedCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "fixed";
                homeUI.hideWindow();
                System.out.println(accountType);
            }
        });
        homeUI.netSaverCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "netSaver";
                homeUI.hideWindow();
                System.out.println(accountType);
            }
        });
        homeUI.savingsCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "savings";
                homeUI.hideWindow();
                System.out.println(accountType);
            }
        });
    }


    // handle login screen
    public void handleLogin(int accPIN) {
        LoginUI loginUI = new LoginUI();

        // add functionality to PIN submit btn
        loginUI.submitPIN(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = loginUI.getPIN();
                System.out.println(pin);
                // verify PIN
                boolean verified = loginUI.verifyPIN(accPIN, pin);
                if (verified) {
                    // hide window
                    loginUI.hideWindow();
                }
            }
        });
    }


    // handle dashbaord screen
    public void handleDashbaord(String accName) {
        DashboardUI dashboardUI = new DashboardUI(accName);

        // add functionality to dashboard menu btns (perhaps an unconventional way to do this but it makes sense to me)
        dashboardUI.withdrawEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "withdraw";
                System.out.println(menuOption);
                // hide window
                dashboardUI.setFrameVisibility();
            }
        });
        dashboardUI.depositEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "deposit";
                System.out.println(menuOption);
                // hide window
                dashboardUI.setFrameVisibility();
            }
        });
        dashboardUI.checkBalanceEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "checkBalance";
                System.out.println(menuOption);
                // hide window
                dashboardUI.setFrameVisibility();
            }
        });
        dashboardUI.checkDetailsEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "checkDetails";
                System.out.println(menuOption);
                // hide window
                dashboardUI.setFrameVisibility();
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
