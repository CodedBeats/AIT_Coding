package gui;

// import classes
import gui.reusable_components.KeypadPanel;
import gui.windows.BalanceUI;
import gui.windows.DashboardUI;
import gui.windows.DepositUI;
import gui.windows.HomeUI;
import gui.windows.LoginUI;
import gui.windows.WithdrawUI;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIHandler {
    // handler attributes
    String accountType;
    String menuOption;

    // init ui windows
    private HomeUI homeUI;
    private LoginUI loginUI;
    private DashboardUI dashboardUI;
    private WithdrawUI withdrawUI;
    private DepositUI depositUI;
    private BalanceUI balanceUI;

    // constructor
    public GUIHandler() {

    }


    // handle home screen
    public void handleHomeUI() {
        homeUI = new HomeUI();
        
        // add functionality to home card type btns (perhaps an unconventional way to do this but it makes sense to me)
        homeUI.chequeCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "cheque";
                // hide home ui
                homeUI.setFrameVisibility();
                System.out.println(accountType);

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
        homeUI.fixedCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "fixed";
                // hide home ui
                homeUI.setFrameVisibility();
                System.out.println(accountType);

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
        homeUI.netSaverCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "netSaver";
                // hide home ui
                homeUI.setFrameVisibility();
                System.out.println(accountType);

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
        homeUI.savingsCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountType = "savings";
                // hide home ui
                homeUI.setFrameVisibility();
                System.out.println(accountType);

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
    }


    // handle login screen
    public void handleLogin(int accPIN) {
        loginUI = new LoginUI();

        // add functionality to PIN submit btn
        loginUI.submitPIN(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pin = loginUI.getPIN();
                System.out.println(pin);
                // verify PIN
                boolean verified = loginUI.verifyPIN(accPIN, pin);
                if (verified) {
                    // hide login ui
                    loginUI.setFrameVisibility();

                    // display dashboard ui
                    dashboardUI.setFrameVisibility();
                }
            }
        });
    }


    // handle dashbaord screen
    public void handleDashbaord(String accName) {
        dashboardUI = new DashboardUI(accName);

        // add functionality to dashboard menu btns
        dashboardUI.withdrawOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "withdraw";
                System.out.println(menuOption);
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display menuOption's ui
                withdrawUI.setFrameVisibility();
            }
        });
        dashboardUI.depositOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "deposit";
                System.out.println(menuOption);
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display menuOption's ui
                depositUI.setFrameVisibility();
            }
        });
        dashboardUI.checkBalanceOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "checkBalance";
                System.out.println(menuOption);
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display menuOption's ui
                balanceUI.setFrameVisibility();
            }
        });
        dashboardUI.checkDetailsOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // set menuOption
                menuOption = "checkDetails";
                System.out.println(menuOption);
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display menuOption's ui
            }
        });
    }


    // handle withdraw screen
    public void handleWithdraw() {
        withdrawUI = new WithdrawUI();

        // add functionality to withdraw btns
        withdrawUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back");
            }
        });
        withdrawUI.withdrawEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("withdraw");
            }
        });
    }


    // handle deposit screen
    public void handleDeposit() {
        depositUI = new DepositUI();

        // add functionality to withdraw btns
        depositUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back");
            }
        });
        depositUI.depositEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("deposit");
            }
        });
    }


    // handle balance screen
    public void handleBalance(double balance) {
        balanceUI = new BalanceUI();
        balanceUI.setBalance(balance);

        // add functionality to withdraw btns
        balanceUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("back");
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
