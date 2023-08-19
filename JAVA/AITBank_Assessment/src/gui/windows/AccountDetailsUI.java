package gui.windows;

// import libraries
import java.awt.BorderLayout;
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
    private JButton btn1;
    private JButton btn2;
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


        // Account type fields
        // Cheque
        if (accType.equals("cheque")) {
            // create pannel to hold account details
            accountTypeDetailsPanel = new JPanel(new GridLayout(1, 1, 10, 5)); // 1 row, 2 columns

            // define elements
            hasChequeBookLabel = new JLabel("Has Cheque Book:");
            // add labels to acc type frame
            accountTypeDetailsPanel.add(hasChequeBookLabel);
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
        }

        // add acc type details to main frame
        mainPanel.add(accountTypeDetailsPanel);

        // panel to hold buttons
        btnPanel = new JPanel(new GridLayout(1, 0, 10, 5)); // 1 row, any number of columns
        // create buttons
        backBtn = new JButton("<- Back");
        btn1 = new JButton("Btn1");
        btn2 = new JButton("Btn2");
        // add buttons to button panel
        btnPanel.add(backBtn);
        btnPanel.add(btn1);
        btnPanel.add(btn2);

        // add btn container to main panel
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        
        // Add main panel to the frame
        frame.add(mainPanel); 

        frame.setVisible(false);
    }

    // button action listeners for outside implementation
    public void backEvent(ActionListener listener) {
        backBtn.addActionListener(listener);
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
        }
        // fixed
        else if (accType == "fixed") {
            earlyWithdrawalLabel.setText(earlyWithdrawalLabel.getText() + "    " + earlyWithdrawl);
            interestRateLabel.setText(interestRateLabel.getText() + "    " + interestRate);
        }
        // both netSaver and savings gave the same fields
        else {
            // add account specific values
            interestRateLabel.setText(interestRateLabel.getText() + "    " + interestRate);
            dailyWithdrawalLimitLabel.setText(dailyWithdrawalLimitLabel.getText() + "    " + dailyWithdrawlLimit);
            dailyWithdrawedLabel.setText(dailyWithdrawedLabel.getText() + "    " + dailyWithdrawed);
            canWithdrawLabel.setText(canWithdrawLabel.getText() + "    " + canWithdraw);
        }
    }
}
