package gui.windows;

// import reusable components
import gui.reusable_components.KeypadPanel;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetWithdrawlLimitUI extends WindowUI {
    // init JFrame elements
    private JLabel promptLabel;
    private KeypadPanel keypadPanel;
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JTextField errMessageField;
    private JButton backBtn;
    private JButton updateWithdrawLimitBtn;

    // constructor 
    public SetWithdrawlLimitUI() {
        super("Set Withdrawl Limit", 500, 500);
        // add content to frame
        initComponents();
        // style components
        setComponentStyle();
    }
    
    // override abstract parent method
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new BorderLayout());

        // Prompt label
        promptLabel = new JLabel("Enter Your new daily withdraw limit");
        promptLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(promptLabel, BorderLayout.NORTH);

        // Keypad panel
        keypadPanel = new KeypadPanel(true, false);
        frame.add(keypadPanel, BorderLayout.CENTER);

        // panel for submit button
        bottomPanel = new JPanel(new BorderLayout());

        // Err message text field
        errMessageField = new JTextField();
        errMessageField.setEditable(false);
        errMessageField.setForeground(Color.RED);
        errMessageField.setHorizontalAlignment(JTextField.CENTER);
        bottomPanel.add(errMessageField, BorderLayout.NORTH);

        // buttons
        buttonPanel = new JPanel(new FlowLayout()); // Use FlowLayout for button alignment
        // back to dashboard btn
        backBtn = new JButton("<< Back");
        // withdraw btn
        updateWithdrawLimitBtn = new JButton("Update");
        buttonPanel.add(backBtn);
        buttonPanel.add(updateWithdrawLimitBtn);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add combined panel to the SOUTH position
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(false);
    }

    // style components
    @Override
    public void setComponentStyle() {
        // style labels
        Font customFont = new Font("Arial", Font.BOLD, 20);
        promptLabel.setFont(customFont);
        promptLabel.setForeground(Color.BLACK);

        // style btns
        updateWithdrawLimitBtn.setBackground(Color.BLACK);
        updateWithdrawLimitBtn.setForeground(Color.WHITE);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
    }

    // button action listeners for outside implementation
    public void backEvent(ActionListener listener) {
        backBtn.addActionListener(listener);
    }
    public void updateWithdrawLimitEvent(ActionListener listener) {
        updateWithdrawLimitBtn.addActionListener(listener);
    }

    // get input amount
    public double getInputAmount() {
        return keypadPanel.getMoneyValue();
    }

    // set error message (it's actually impossible to not deposit successfully lol)
    public void setErrorMessage(String message) {
        errMessageField.setText(message);
    }
}
