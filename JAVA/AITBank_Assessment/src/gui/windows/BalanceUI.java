package gui.windows;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BalanceUI extends WindowUI {
    // init JFrame elements
    private JPanel buttonPanel;
    private JTextField balanceField;
    private JButton backBtn;

    // constructor 
    public BalanceUI() {
        super("Balance", 200, 200);
        // add content to frame
        initComponents();
    }
    
    // override abstract parent method
    @Override
    protected void initComponents() {
        // set frame layout
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Your Balance");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        balanceField = new JTextField();
        balanceField.setEditable(false);
        frame.add(balanceField, BorderLayout.CENTER);

        backBtn = new JButton("<- Back");

        buttonPanel = new JPanel();
        buttonPanel.add(backBtn);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(false);
    }

    // button action listeners for outside implementation
    public void backEvent(ActionListener listener) {
        backBtn.addActionListener(listener);
    }

    // display balance
    public void setBalance(double balance) {
        balanceField.setText("$" + balance);
    }
}
