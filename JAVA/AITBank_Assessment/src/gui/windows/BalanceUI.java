package gui.windows;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BalanceUI extends WindowUI {
    // init JFrame elements
    private JPanel buttonPanel;
    private JLabel titleLabel;
    private JTextField balanceField;
    private JButton backBtn;

    // constructor 
    public BalanceUI() {
        super("Balance", 200, 200);
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

        titleLabel = new JLabel("Your Balance");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.add(titleLabel, BorderLayout.NORTH);

        balanceField = new JTextField();
        balanceField.setEditable(false);
        frame.add(balanceField, BorderLayout.CENTER);

        backBtn = new JButton("<< Back");

        buttonPanel = new JPanel();
        buttonPanel.add(backBtn);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(false);
    }

    // style components
    @Override
    public void setComponentStyle() {
        // style frame
        frame.setBackground(Color.GRAY);

        // style label
        Font customFont1 = new Font("Arial", Font.BOLD, 20);
        titleLabel.setFont(customFont1);
        titleLabel.setForeground(Color.BLACK);

        // style field
        Font customFont2 = new Font("Arial", Font.PLAIN, 30);
        balanceField.setFont(customFont2);
        balanceField.setForeground(Color.BLACK);
        balanceField.setHorizontalAlignment(SwingConstants.CENTER);
        
        // style btn
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
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
