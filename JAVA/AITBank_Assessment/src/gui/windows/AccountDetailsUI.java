package gui.windows;

// import libraries
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountDetailsUI extends WindowUI {
    // class attributes
    private String accType;

    // init JFrame elements
    private JPanel accountDetailsPanel;
    private JPanel accountTypeDetailsPanel;
    private JPanel btnPanel;
    private JPanel mainPanel;
    private JButton backBtn;
    private JButton orderChequeBookBtn;
    private JButton setWithdrawLimitBtn;
    // account details
    private JLabel accountNumberLabel;
    private JLabel accountTypeLabel;
    private JLabel accountNameLabel;
    private JLabel accountInterestLabel;
    // account type fields
    private JLabel earlyWithdrawalLabel;
    private JLabel interestRateLabel;
    private JLabel dailyWithdrawalLimitLabel;
    private JLabel dailyWithdrawedLabel;
    private JLabel canWithdrawLabel;
    // cheque account specific
    private JLabel hasChequeBookLabel;
    

    // constructor 
    public AccountDetailsUI(String accType) {
        super("Account Details", 800, 600);
        this.accType = accType;
        // add content to frame
        initComponents();
        // style components
        setComponentStyle();
    }
    
    // override abstract parent method
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new GridLayout(1, 1)); // 1 row, 1 column
        // primary panel
        accountDetailsPanel = new JPanel(new GridLayout(2, 2, 10, 5)); // 1 row, 2 columns

        // Account Number
        accountNumberLabel = new JLabel("Account Number:");
        accountDetailsPanel.add(accountNumberLabel);

        // Account Type
        accountTypeLabel = new JLabel("Account Type:");
        accountDetailsPanel.add(accountTypeLabel);

        // Account Name
        accountNameLabel = new JLabel("Account Name:");
        accountDetailsPanel.add(accountNameLabel);

        // Account Interest
        accountInterestLabel = new JLabel("Account Interest Time Period:");
        accountDetailsPanel.add(accountInterestLabel);
        
        // Create a panel for the overall layout using BorderLayout
        mainPanel = new JPanel(new GridLayout(3, 1, 10, 5));
        mainPanel.add(accountDetailsPanel); 

        // panel to hold buttons
        btnPanel = new JPanel(new GridLayout(1, 0, 10, 5)); // 1 row, any number of columns
        // add back btn
        backBtn = new JButton("<< Back");
        // special cheque account functionality
        orderChequeBookBtn = new JButton("Reorder Cheque Book");
        // special savings account functionality
        setWithdrawLimitBtn = new JButton("Set Withdraw Limit");
        // add back btn to button panel
        btnPanel.add(backBtn);


        // Account type fields
        // Cheque
        if (accType.equals("cheque")) {
            // create pannel to hold account details
            accountTypeDetailsPanel = new JPanel(new GridLayout(1, 1, 10, 5)); // 1 row, 2 columns

            // define elements
            hasChequeBookLabel = new JLabel("Has Cheque Book:");
            // add labels to acc type frame
            accountTypeDetailsPanel.add(hasChequeBookLabel);
            // add btn to btnPanel
            btnPanel.add(orderChequeBookBtn);
        } 
        // Fixed
        else if (accType.equals("fixed")) {
            // create pannel hold specific account type fields
            accountTypeDetailsPanel = new JPanel(new GridLayout(1, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            earlyWithdrawalLabel = new JLabel("Early Withdrawal Status:");
            interestRateLabel = new JLabel("Interest Rate:");
            // add labels to acc type frame
            accountTypeDetailsPanel.add(earlyWithdrawalLabel);
            accountTypeDetailsPanel.add(interestRateLabel);
        } 
        // Net-Saver
        else if (accType.equals("netSaver")) {
            // create pannel hold specific account type fields
            accountTypeDetailsPanel = new JPanel(new GridLayout(2, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            dailyWithdrawalLimitLabel = new JLabel("Daily Withdrawal Limit:");
            dailyWithdrawedLabel = new JLabel("Daily Withdrawed:");
            canWithdrawLabel = new JLabel("Can Withdraw:");
            interestRateLabel = new JLabel("Interest Rate:");
            // add labels to acc type frame
            accountTypeDetailsPanel.add(dailyWithdrawalLimitLabel);
            accountTypeDetailsPanel.add(dailyWithdrawedLabel);
            accountTypeDetailsPanel.add(canWithdrawLabel);
            accountTypeDetailsPanel.add(interestRateLabel);
        } 
        // Savings
        else if (accType.equals("savings")) {
            // create pannel hold specific account type fields
            accountTypeDetailsPanel = new JPanel(new GridLayout(2, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            dailyWithdrawalLimitLabel = new JLabel("Daily Withdrawal Limit:");
            dailyWithdrawedLabel = new JLabel("Daily Withdrawed:");
            canWithdrawLabel = new JLabel("Can Withdraw:");
            interestRateLabel = new JLabel("Interest Rate per month:");
            // add labels to acc type frame
            accountTypeDetailsPanel.add(dailyWithdrawalLimitLabel);
            accountTypeDetailsPanel.add(dailyWithdrawedLabel);
            accountTypeDetailsPanel.add(canWithdrawLabel);
            accountTypeDetailsPanel.add(interestRateLabel);
            // add btn to btnPanel
            btnPanel.add(setWithdrawLimitBtn);
        }

        // add acc type details to main frame
        mainPanel.add(accountTypeDetailsPanel);

        // add btn container to main panel
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        
        // Add main panel to the frame
        frame.add(mainPanel); 

        frame.setVisible(false);
    }

    // style components
    @Override
    public void setComponentStyle() {
        // style labels
        Font customFont1 = new Font("Arial", Font.PLAIN, 15);
        accountNumberLabel.setFont(customFont1);
        accountTypeLabel.setFont(customFont1);
        accountNameLabel.setFont(customFont1);
        accountInterestLabel.setFont(customFont1);
        
        // style btns
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        orderChequeBookBtn.setBackground(Color.BLACK);
        orderChequeBookBtn.setForeground(Color.WHITE);
        setWithdrawLimitBtn.setBackground(Color.BLACK);
        setWithdrawLimitBtn.setForeground(Color.WHITE);
    }

    // button action listeners for outside implementation
    public void backEvent(ActionListener listener) {
        backBtn.addActionListener(listener);
    }
    public void reorderChequeBookEvent(ActionListener listener) {
        orderChequeBookBtn.addActionListener(listener);
    }
    public void setWithdrawLimitEvent(ActionListener listener) {
        setWithdrawLimitBtn.addActionListener(listener);
    }

    // set field values
    public void setAccountDetailValues(int accNum, String accType, String accName, boolean hasChequeBook, boolean earlyWithdrawl, double interestRate, double dailyWithdrawlLimit, double dailyWithdrawed, boolean canWithdraw) {
        // add common account data
        accountNumberLabel.setText(accountNumberLabel.getText() + "    " + accNum);
        accountTypeLabel.setText(accountTypeLabel.getText() + "    " + accType);
        accountNameLabel.setText(accountNameLabel.getText() + "    " + accName);
        accountInterestLabel.setText(accountInterestLabel.getText() + "    " + "30 days/1 month");

        // add account specific values
        // cheque
        if (accType == "cheque") {
            hasChequeBookLabel.setText(hasChequeBookLabel.getText() + "    " + hasChequeBook);
            accountInterestLabel.setText("You don't receive interest on this account");
            
            // style labels
            Font customFont = new Font("Arial", Font.PLAIN, 15);
            accountInterestLabel.setFont(customFont);
            hasChequeBookLabel.setFont(customFont);
        }
        // fixed
        else if (accType == "fixed") {
            earlyWithdrawalLabel.setText(earlyWithdrawalLabel.getText() + "    " + earlyWithdrawl);
            interestRateLabel.setText(interestRateLabel.getText() + "    " + interestRate);
            
            // style labels
            Font customFont = new Font("Arial", Font.PLAIN, 15);
            earlyWithdrawalLabel.setFont(customFont);
            interestRateLabel.setFont(customFont);
        }
        // both netSaver and savings gave the same fields
        else {
            // add account specific values
            interestRateLabel.setText(interestRateLabel.getText() + "    " + interestRate);
            dailyWithdrawalLimitLabel.setText(dailyWithdrawalLimitLabel.getText() + "    " + dailyWithdrawlLimit);
            dailyWithdrawedLabel.setText(dailyWithdrawedLabel.getText() + "    " + dailyWithdrawed);
            canWithdrawLabel.setText(canWithdrawLabel.getText() + "    " + canWithdraw);
            
            // style labels
            Font customFont = new Font("Arial", Font.PLAIN, 15);
            interestRateLabel.setFont(customFont);
            dailyWithdrawalLimitLabel.setFont(customFont);
            dailyWithdrawedLabel.setFont(customFont);
            canWithdrawLabel.setFont(customFont);
        }
    }

    // update chequebook status
    public void setChequebookStatus(boolean status) {
        hasChequeBookLabel.setText("Has Cheque Book:" + "    " + status);
    }
    // update daily withdraw limit status
    public void setDailyWithdrawLimitStatus(double limit) {
        dailyWithdrawalLimitLabel.setText("Daily Withdrawal Limit:" + "    " + limit);
    }

    // display cheque exception status
    public void setChequeExceptionStatus(String message) {
        hasChequeBookLabel.setText("Has Cheque Book:" + "    " + "You already have a cheque book");
    }
}
