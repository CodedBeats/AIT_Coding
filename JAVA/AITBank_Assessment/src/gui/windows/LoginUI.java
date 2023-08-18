package gui.windows;

// import reusable components
import gui.reusable_components.KeypadPanel;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginUI {
    // init JFrame
    private JFrame frame;
    // label 
    private JLabel promptLabel;
    // keypad
    private KeypadPanel keypadPanel;
    // error message text field
    private JTextField errorMessageField;
    // submit btn
    private JPanel buttonPanel;
    private JButton submitBtn;
    
    // constructor 
    public LoginUI() {
        frame = new JFrame("Password Screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Prompt label
        promptLabel = new JLabel("Please enter your 4 digit PIN");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(promptLabel, BorderLayout.NORTH);

        // Keypad panel
        keypadPanel = new KeypadPanel(false, true);
        frame.add(keypadPanel, BorderLayout.CENTER);

        // Error message text field
        errorMessageField = new JTextField();
        errorMessageField.setEditable(false);
        errorMessageField.setForeground(Color.RED);
        errorMessageField.setHorizontalAlignment(JTextField.CENTER);
        frame.add(errorMessageField, BorderLayout.SOUTH);

        // submit btn panel
        buttonPanel = new JPanel(new BorderLayout());
        submitBtn = new JButton("OK");
        buttonPanel.add(submitBtn, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
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
}
