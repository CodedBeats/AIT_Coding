package gui.windows;

// import reusable components
import gui.reusable_components.KeypadPanel;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DepositUI extends WindowUI {
    // init JFrame elements
    private JLabel promptLabel;
    private KeypadPanel keypadPanel;
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JTextField errMessageField;
    private JButton backBtn;
    private JButton depositBtn;

    // constructor 
    public DepositUI() {
        super("Deposit", 400, 500);
        // add content to frame
        initComponents();
    }
    
    // override abstract parent method
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new BorderLayout());

        // Prompt label
        promptLabel = new JLabel("Enter amount to deposit");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(promptLabel, BorderLayout.NORTH);

        // Keypad panel
        keypadPanel = new KeypadPanel(true, false);
        frame.add(keypadPanel, BorderLayout.CENTER);

        // Combined panel for error message field and submit button
        bottomPanel = new JPanel(new BorderLayout());

        // Err message text field
        errMessageField = new JTextField();
        errMessageField.setEditable(false);
        errMessageField.setForeground(Color.GREEN);
        errMessageField.setHorizontalAlignment(JTextField.CENTER);
        bottomPanel.add(errMessageField, BorderLayout.NORTH);

        // buttons
        buttonPanel = new JPanel(new FlowLayout()); // Use FlowLayout for button alignment
        // back to dashboard btn
        backBtn = new JButton("<< Back");
        // withdraw btn
        depositBtn = new JButton("Deposit");
        buttonPanel.add(backBtn);
        buttonPanel.add(depositBtn);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add combined panel to the SOUTH position
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(false);
    }

    // button action listeners for outside implementation
    public void backEvent(ActionListener listener) {
        backBtn.addActionListener(listener);
    }
    public void depositEvent(ActionListener listener) {
        depositBtn.addActionListener(listener);
    }

    // get input amount
    public double getInputAmount() {
        return keypadPanel.getMoneyValue();
    }
    
    // set successfull deposit message (it's actually impossible to not deposit successfully lol)
    public void setSuccessfullDeposit(double input) {
        errMessageField.setText("Successfully deposited $" + input);
    }
}
