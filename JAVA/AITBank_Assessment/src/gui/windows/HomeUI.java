package gui.windows;

// import libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeUI extends WindowUI {
    // init JFrame elements
    private JPanel panel;
    private JLabel welcomeLabel;
    private JLabel promptLabel;
    private JButton enterChequeCardBtn;
    private JButton enterFixedCardBtn;
    private JButton enterNetSaverCardBtn;
    private JButton enterSavingsCardBtn;

    // constructor
    public HomeUI() {
        super("Home", 700, 200);
        // add content to frame
        initComponents();
    }

    // override abstract parent method
    @Override
    protected void initComponents() {
        // set frame style
        frame.getContentPane().setBackground(Color.WHITE);

        // put everything on a pannel
        panel = new JPanel();
        // set layout
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;

        // create labels
        welcomeLabel = new JLabel("Welcome to AITBank");
        promptLabel = new JLabel("Please enter your card to begin");
        // set label layout
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // create button elements
        enterChequeCardBtn = new JButton("Enter Cheque card");
        enterFixedCardBtn = new JButton("Enter Fixed card");
        enterNetSaverCardBtn = new JButton("Enter Net-Saver card");
        enterSavingsCardBtn = new JButton("Enter Savings card");

        // set structure of elements
        // position x middle and y top
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        // add label to panel
        panel.add(welcomeLabel, constraints);

        // position x middle and y middle
        constraints.gridx = 1;
        constraints.gridy = 1;
        // add label to panel
        panel.add(promptLabel, constraints);

        // position x left and y bottom
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2;
        // add btn to panel
        panel.add(enterChequeCardBtn, constraints);

        // position x 2nd from left and y top
        constraints.gridx = 1;
        // add btn to panel
        panel.add(enterFixedCardBtn, constraints);

        // position x 2nd from right and y top
        constraints.gridx = 2;
        // add btn to panel
        panel.add(enterNetSaverCardBtn, constraints);

        // position x right and y top
        constraints.gridx = 3;
        // add btn to panel
        panel.add(enterSavingsCardBtn, constraints);

        // add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // button action listeners for outside implementation
    public void chequeCardEvent(ActionListener listener) {
        enterChequeCardBtn.addActionListener(listener);
    }
    public void fixedCardEvent(ActionListener listener) {
        enterFixedCardBtn.addActionListener(listener);
    }
    public void netSaverCardEvent(ActionListener listener) {
        enterNetSaverCardBtn.addActionListener(listener);
    }
    public void savingsCardEvent(ActionListener listener) {
        enterSavingsCardBtn.addActionListener(listener);
    }
}
