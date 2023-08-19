package gui.windows;

// import reusable components
import gui.reusable_components.KeypadPanel;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginUI extends WindowUI {
    // init JFrame elements
    private JLabel promptLabel;
    private KeypadPanel keypadPanel;
    private JPanel bottomPanel;
    private JTextField errMessageField;
    private JPanel buttonPanel;
    private JButton submitBtn;
    
    // constructor 
    public LoginUI() {
        super("Login", 400, 500);
        // add content to frame
        initComponents();
    }

    // override abstract parent method
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new BorderLayout());

        // Prompt label
        promptLabel = new JLabel("Please enter your 4 digit PIN");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(promptLabel, BorderLayout.NORTH);

        // Keypad panel
        keypadPanel = new KeypadPanel(false, true);
        frame.add(keypadPanel, BorderLayout.CENTER);

        // Combined panel for error message field and button
        bottomPanel = new JPanel(new BorderLayout());

        // Err message text field
        errMessageField = new JTextField();
        errMessageField.setEditable(false);
        errMessageField.setForeground(Color.RED);
        errMessageField.setHorizontalAlignment(JTextField.CENTER);
        bottomPanel.add(errMessageField, BorderLayout.NORTH);

        // Submit button
        buttonPanel = new JPanel(new FlowLayout()); // Use FlowLayout for button alignment
        submitBtn = new JButton("OK");
        buttonPanel.add(submitBtn);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add combined panel to the SOUTH position
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(false);
    }

    // button action listeners for outside implementation
    public void submitPIN(ActionListener listener) {
        submitBtn.addActionListener(listener);
    }

    // get inserted PIN
    public int getPIN() {
        return keypadPanel.getPINValue();
    }

    // verify PIN
    public boolean verifyPIN(int accPIN, int pin) {
        boolean verified = false;
        // get length of pin
        int pinLength = String.valueOf(pin).length();
        
        // verify if pin is equal to account pin
        if (pin == accPIN) {
            verified = true;
        }
        // handle different incorrect pin and display unverified message
        else {
            // pin less than 4 digits
            if (pinLength < 4) {
                errMessageField.setText("PIN must be 4 digits");
            }
            // pin not equal to account pin
            else {
                errMessageField.setText("Incorrect PIN");
            }
        }

        return verified;
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
