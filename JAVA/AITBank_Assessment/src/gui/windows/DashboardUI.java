package gui.windows;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DashboardUI extends WindowUI {
    // class attributes
    private String accName;

    // init JFrame elements
    private JLabel welcomeLabel;
    private JPanel buttonPanel;
    private JButton withdrawbtn;
    private JButton depositbtn;
    private JButton checkBalancebtn;
    private JButton checkDetailsbtn;

    // constructor
    public DashboardUI(String accName) {
        super("Dashboard", 400, 200);
        this.accName = accName;
        // add content to frame
        initComponents();
    }

    // override abstract parent method 
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns

        // set up welcome label
        welcomeLabel = new JLabel("Welcome " + accName);
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

    // button action listeners for outside implementation
    public void withdrawEvent(ActionListener listener) {
        withdrawbtn.addActionListener(listener);
    }
    public void depositEvent(ActionListener listener) {
        depositbtn.addActionListener(listener);
    }
    public void checkBalanceEvent(ActionListener listener) {
        checkBalancebtn.addActionListener(listener);
    }
    public void checkDetailsEvent(ActionListener listener) {
        checkDetailsbtn.addActionListener(listener);
    }

    // set frame visibility
    public void setFrameVisibility() {
        // set frame visible if it's hidden
        if (!frame.isShowing()) {
            frame.setVisible(true);
        }
        // hide frame
        else {
            frame.setVisible(false);
        }
    }
}
