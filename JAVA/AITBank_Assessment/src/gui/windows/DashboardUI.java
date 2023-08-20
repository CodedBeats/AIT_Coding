package gui.windows;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashboardUI extends WindowUI {
    // init JFrame elements
    private JLabel welcomeLabel;
    private JPanel buttonPanel;
    private JButton withdrawbtn;
    private JButton depositbtn;
    private JButton checkBalancebtn;
    private JButton checkDetailsbtn;

    // constructor
    public DashboardUI() {
        super("Dashboard", 400, 200);
        // add content to frame
        initComponents();
        // style components
        setComponentStyle();
    }

    // override abstract parent method 
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns

        // set up welcome label
        welcomeLabel = new JLabel("Welcome ");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(welcomeLabel);

        // set up buttons
        withdrawbtn = new JButton("Withdraw");
        depositbtn = new JButton("Deposit");
        checkBalancebtn = new JButton("Check Balance");
        checkDetailsbtn = new JButton("Check Account Details");

        // panel for dashboard menu buttons
        buttonPanel = new JPanel(new GridLayout(2, 2, 10, 0)); // 2 rows, 2 columns with horizontal gap
        buttonPanel.add(withdrawbtn);
        buttonPanel.add(depositbtn);
        buttonPanel.add(checkBalancebtn);
        buttonPanel.add(checkDetailsbtn);
        frame.add(buttonPanel);

        // set frame visible
        frame.setVisible(false);
    }

    // style components
    @Override
    public void setComponentStyle() {
        // style labels
        Font customFont = new Font("Arial", Font.BOLD, 20);
        welcomeLabel.setFont(customFont);
        welcomeLabel.setForeground(Color.BLACK);

        // style btns
        withdrawbtn.setBackground(Color.BLACK);
        withdrawbtn.setForeground(Color.WHITE);
        depositbtn.setBackground(Color.BLACK);
        depositbtn.setForeground(Color.WHITE);
        checkBalancebtn.setBackground(Color.BLACK);
        checkBalancebtn.setForeground(Color.WHITE);
        checkDetailsbtn.setBackground(Color.BLACK);
        checkDetailsbtn.setForeground(Color.WHITE);
    }

    // button action listeners for outside implementation
    public void withdrawOptionEvent(ActionListener listener) {
        withdrawbtn.addActionListener(listener);
    }
    public void depositOptionEvent(ActionListener listener) {
        depositbtn.addActionListener(listener);
    }
    public void checkBalanceOptionEvent(ActionListener listener) {
        checkBalancebtn.addActionListener(listener);
    }
    public void checkDetailsOptionEvent(ActionListener listener) {
        checkDetailsbtn.addActionListener(listener);
    }

    // set account name 
    public void setAccountName(String accountName) {
        welcomeLabel.setText(welcomeLabel.getText() + accountName);
    }
}
