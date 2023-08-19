package gui;

// import gui classes
import gui.windows.DashboardUI;
import gui.windows.HomeUI;
import gui.windows.LoginUI;
import gui.windows.WithdrawUI;
import misc.RandGenerator;
import gui.windows.DepositUI;
import gui.windows.BalanceUI;
import gui.windows.AccountDetailsUI;
//import account classes
import accounts.ChequeAccount;
import accounts.FixedAccount;
import accounts.NetSaverAccount;
import accounts.SavingsAccount;

// import libraries
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GUIHandler {
    // init accounts
    protected ChequeAccount chequeAccount;
    protected FixedAccount fixedAccount;
    protected NetSaverAccount netSaverAccount;
    protected SavingsAccount savingsAccount;

    // handler attributes
    private String accType;
    private int accPIN;
    private String accName;
    private double accBalance;

    // init ui windows
    private HomeUI homeUI;
    private LoginUI loginUI;
    private DashboardUI dashboardUI;
    private WithdrawUI withdrawUI;
    private DepositUI depositUI;
    private BalanceUI balanceUI;
    private AccountDetailsUI accountDetailsUI;

    // init randGenerator
    private RandGenerator rand = new RandGenerator();

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
                // create cheque account
                chequeAccount = new ChequeAccount(
                    rand.generateRandomInt(200, 1000), 
                    1, 
                    rand.generateRandomName(), 
                    "cheque", 
                    7777, 
                    false
                );
                accType = chequeAccount.getAccType();
                accPIN = chequeAccount.getAccPIN();
                accName = chequeAccount.getAccName();
                accBalance = chequeAccount.getBalance();
                
                // hide home ui
                homeUI.setFrameVisibility();

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
        homeUI.fixedCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create fixed account
                fixedAccount = new FixedAccount(
                    rand.generateRandomInt(200, 1000), 
                    2, 
                    rand.generateRandomName(), 
                    "fixed", 
                    5555, 
                    false, 
                    20
                );
                accType = fixedAccount.getAccType();
                accPIN = fixedAccount.getAccPIN();
                accName = fixedAccount.getAccName();
                accBalance = fixedAccount.getBalance();
                
                // hide home ui
                homeUI.setFrameVisibility();

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
        homeUI.netSaverCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create Net-Saver account
                netSaverAccount = new NetSaverAccount(
                    rand.generateRandomInt(200, 1000), 
                    3, 
                    rand.generateRandomName(), 
                    "netSaver", 
                    2020, 
                    150, 
                    0, 
                    true
                );
                accType = netSaverAccount.getAccType();
                accPIN = netSaverAccount.getAccPIN();
                accName = netSaverAccount.getAccName();
                accBalance = netSaverAccount.getBalance();
                
                
                // hide home ui
                homeUI.setFrameVisibility();

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
        homeUI.savingsCardEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create savings account
                savingsAccount = new SavingsAccount(
                    rand.generateRandomInt(200, 1000), 
                    4, 
                    rand.generateRandomName(), 
                    "savings", 
                    1234, 
                    50, 
                    0, 
                    true
                );
                accType = savingsAccount.getAccType();
                accPIN = savingsAccount.getAccPIN();
                accName = savingsAccount.getAccName();
                accBalance = savingsAccount.getBalance();
                
                
                // hide home ui
                homeUI.setFrameVisibility();

                // display login ui
                loginUI.setFrameVisibility();
            }
        });
    }


    // handle login screen
    public void handleLoginUI() {
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
    public void handleDashbaordUI() {

        dashboardUI = new DashboardUI(accName);

        // add functionality to dashboard menu btns
        dashboardUI.withdrawOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display menuOption's ui
                withdrawUI.setFrameVisibility();
            }
        });
        dashboardUI.depositOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display menuOption's ui
                depositUI.setFrameVisibility();
            }
        });
        dashboardUI.checkBalanceOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display balance ui
                handleBalanceUI();
                balanceUI.setFrameVisibility();
            }
        });
        dashboardUI.checkDetailsOptionEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide dashboard ui
                dashboardUI.setFrameVisibility();

                // display account details
                accountDetailsUI = new AccountDetailsUI(accType);
                handleAccountDetailsUI();
                accountDetailsUI.setFrameVisibility();
            }
        });
    }


    // handle withdraw screen
    public void handleWithdrawUI() {
        withdrawUI = new WithdrawUI();

        // back to dashboard btn
        withdrawUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide window
                withdrawUI.setFrameVisibility();
                // display dashboard
                dashboardUI.setFrameVisibility();
            }
        });
        // handle withdraw
        withdrawUI.withdrawEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
    }


    // handle deposit screen
    public void handleDepositUI() {
        depositUI = new DepositUI();

        // back to dashboard btn
        depositUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide window
                depositUI.setFrameVisibility();
                // display dashboard
                dashboardUI.setFrameVisibility();
            }
        });
        // handle deposit
        depositUI.depositEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
            }
        });
    }


    // handle balance screen
    public void handleBalanceUI() {
        balanceUI = new BalanceUI();

        balanceUI.setBalance(accBalance);

        // back to dashboard btn
        balanceUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide window
                balanceUI.setFrameVisibility();
                // display dashboard
                dashboardUI.setFrameVisibility();
            }
        });
    }


    // handle account details screen
    public void handleAccountDetailsUI() {
        // populate data fields
        switch (accType) {
            case "cheque":
                accountDetailsUI.setAccountDetailValues(
                    chequeAccount.getHasChequeBook(), 
                    false, 
                    0, 
                    0, 
                    0, 
                    false
                );
                break;
            case "fixed":
                accountDetailsUI.setAccountDetailValues(
                    false, 
                    fixedAccount.getEarlyWithdrawl(), 
                    fixedAccount.getInterestRate(), 
                    0, 
                    0, 
                    false
                );
                break;
            case "netSaver":
                accountDetailsUI.setAccountDetailValues(
                    false, 
                    false, 
                    netSaverAccount.getInterestRate(), 
                    netSaverAccount.getDailyWithdrawLimit(), 
                    netSaverAccount.getDailyWithdrawed(), 
                    netSaverAccount.getCanWithdraw()
                );
                break;
            case "savings":
                accountDetailsUI.setAccountDetailValues(
                    false, 
                    false, 
                    savingsAccount.getInterestRate(), 
                    savingsAccount.getDailyWithdrawLimit(), 
                    savingsAccount.getDailyWithdrawed(), 
                    savingsAccount.getCanWithdraw()
                );
                break;
        }

        // back to dashboard btn
        accountDetailsUI.backEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide window
                accountDetailsUI.setFrameVisibility();
                // display dashboard
                dashboardUI.setFrameVisibility();
            }
        });
    }
}
