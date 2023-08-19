package gui.windows;

// import libraries
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountDetailsUI extends WindowUI {
    // class attributes
    private String accType;

    // init JFrame elements
    private JPanel commonDetailsPannel;
    private JPanel accountTypeFieldsPannel;
    private JPanel mainPanel;
    // account details
    private JLabel accountNumberLabel;
    private JTextField accountNumberField;
    private JLabel accountTypeLabel;
    private JTextField accountTypeField;
    private JLabel accountNameLabel;
    private JTextField accountNameField;
    private JLabel accountInterestLabel;
    private JTextField accountInterestField;
    // account type fields
    private JLabel earlyWithdrawalLabel;
    private JTextField earlyWithdrawalField;
    private JLabel interestRateLabel;
    private JTextField interestRateField;
    private JLabel dailyWithdrawalLimitLabel;
    private JTextField dailyWithdrawalLimitField;
    private JLabel dailyWithdrawedLabel;
    private JTextField dailyWithdrawedField;
    private JLabel canWithdrawLabel;
    private JTextField canWithdrawField;
    // cheque account specific
    private JLabel hasChequeBookLabel;
    private JTextField hasChequeBookField;
    

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
        frame.setLayout(new GridLayout(1, 2)); // 1 row, 2 columns

        // Account Number
        accountNumberLabel = new JLabel("Account Number:");
        accountNumberField = new JTextField();
        accountNumberField.setEditable(false);

        // Account Type
        accountTypeLabel = new JLabel("Account Type:");
        accountTypeField = new JTextField(accType);
        accountTypeField.setEditable(false);

        // Account Name
        accountNameLabel = new JLabel("Account Name:");
        accountNameField = new JTextField();
        accountNameField.setEditable(false);

        // Account Interest
        accountInterestLabel = new JLabel("Account Interest Time Period:");
        accountInterestField = new JTextField();
        accountInterestField.setEditable(false);

        // panel to hold common account detail labels and fields
        commonDetailsPannel = new JPanel(new GridLayout(2, 2, 10, 5)); // 4 rows, 2 columns
        commonDetailsPannel.add(accountNumberLabel);
        commonDetailsPannel.add(accountNumberField);
        commonDetailsPannel.add(accountTypeLabel);
        commonDetailsPannel.add(accountTypeField);
        commonDetailsPannel.add(accountNameLabel);
        commonDetailsPannel.add(accountNameField);
        commonDetailsPannel.add(accountInterestLabel);
        commonDetailsPannel.add(accountInterestField);


        // Account type fields
        // Cheque
        if (accType.equals("cheque")) {
            // create pannel hold specific account type fields
            accountTypeFieldsPannel = new JPanel(new GridLayout(1, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            hasChequeBookLabel = new JLabel("Has Cheque Book:");
            hasChequeBookField = new JTextField();
            hasChequeBookField.setEditable(false);
            // add to accType panel
            accountTypeFieldsPannel.add(hasChequeBookLabel);
            accountTypeFieldsPannel.add(hasChequeBookField);
        } 
        // Fixed
        else if (accType.equals("fixed")) {
            // create pannel hold specific account type fields
            accountTypeFieldsPannel = new JPanel(new GridLayout(1, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            earlyWithdrawalLabel = new JLabel("Early Withdrawal Status:");
            earlyWithdrawalField = new JTextField();
            earlyWithdrawalField.setEditable(false);
            interestRateLabel = new JLabel("Interest Rate:");
            interestRateField = new JTextField();
            interestRateField.setEditable(false);
            // add to accType panel
            accountTypeFieldsPannel.add(earlyWithdrawalLabel);
            accountTypeFieldsPannel.add(earlyWithdrawalField);
            accountTypeFieldsPannel.add(interestRateLabel);
            accountTypeFieldsPannel.add(interestRateField);
        } 
        // Net-Saver
        else if (accType.equals("netSaver")) {
            // create pannel hold specific account type fields
            accountTypeFieldsPannel = new JPanel(new GridLayout(2, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            dailyWithdrawalLimitLabel = new JLabel("Daily Withdrawal Limit:");
            dailyWithdrawalLimitField = new JTextField();
            dailyWithdrawalLimitField.setEditable(false);
            dailyWithdrawedLabel = new JLabel("Daily Withdrawed:");
            dailyWithdrawedField = new JTextField();
            dailyWithdrawedField.setEditable(false);
            canWithdrawLabel = new JLabel("Can Withdraw:");
            canWithdrawField = new JTextField();
            canWithdrawField.setEditable(false);
            interestRateLabel = new JLabel("Interest Rate:");
            interestRateField = new JTextField();
            interestRateField.setEditable(false);
            // add to accType panel
            accountTypeFieldsPannel.add(dailyWithdrawalLimitLabel);
            accountTypeFieldsPannel.add(dailyWithdrawalLimitField);
            accountTypeFieldsPannel.add(dailyWithdrawedLabel);
            accountTypeFieldsPannel.add(dailyWithdrawedField);
            accountTypeFieldsPannel.add(canWithdrawLabel);
            accountTypeFieldsPannel.add(canWithdrawField);
            accountTypeFieldsPannel.add(interestRateLabel);
            accountTypeFieldsPannel.add(interestRateField);
        } 
        // Savings
        else if (accType.equals("savings")) {
            // create pannel hold specific account type fields
            accountTypeFieldsPannel = new JPanel(new GridLayout(2, 2, 10, 5)); // 1 row, 2 columns

            // define elements
            dailyWithdrawalLimitLabel = new JLabel("Daily Withdrawal Limit:");
            dailyWithdrawalLimitField = new JTextField();
            dailyWithdrawalLimitField.setEditable(false);
            dailyWithdrawedLabel = new JLabel("Daily Withdrawed:");
            dailyWithdrawedField = new JTextField();
            dailyWithdrawedField.setEditable(false);
            canWithdrawLabel = new JLabel("Can Withdraw:");
            canWithdrawField = new JTextField();
            canWithdrawField.setEditable(false);
            interestRateLabel = new JLabel("Interest Rate:");
            interestRateField = new JTextField();
            interestRateField.setEditable(false);
            // add to accType panel
            accountTypeFieldsPannel.add(dailyWithdrawalLimitLabel);
            accountTypeFieldsPannel.add(dailyWithdrawalLimitField);
            accountTypeFieldsPannel.add(dailyWithdrawedLabel);
            accountTypeFieldsPannel.add(dailyWithdrawedField);
            accountTypeFieldsPannel.add(canWithdrawLabel);
            accountTypeFieldsPannel.add(canWithdrawField);
            accountTypeFieldsPannel.add(interestRateLabel);
            accountTypeFieldsPannel.add(interestRateField);
        }

        // Create a panel for the overall layout using BorderLayout
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(commonDetailsPannel, BorderLayout.NORTH); // Place the common details at top
        mainPanel.add(accountTypeFieldsPannel, BorderLayout.CENTER); // Place card type fields in center
        // Add the main panel to the frame
        frame.add(mainPanel); 

        frame.setVisible(false);
    }

    // button action listeners for outside implementation
    public void backEvent(ActionListener listener) {
        // backBtn.addActionListener(listener);
    }

    // set field values
    public void setAccountDetailValues(boolean hasChequeBook, boolean earlyWithdrawl, String interestRate, double dailyWithdrawlLimit, double dailyWithdrawed, boolean canWithdraw) {

    }
}
