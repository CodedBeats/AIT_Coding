package accounts;
import javax.swing.*; 

public class ChequeAccount extends Account {
    // attributes
    private boolean hasChequeBook;


    // constructor
    public ChequeAccount(float balance, int accountNumber, String accountName, String[] transactionHistory, boolean hasChequeBook) {
        super(balance, accountNumber, accountName, transactionHistory);

        this.hasChequeBook = hasChequeBook;
    }


    // overide abstract methods
    @Override
    public void withdraw() {
        // get user input
        String input = JOptionPane.showInputDialog(null, "How much would you like to Withdraw?\n(100/50/20)");

        // check if user input a valid amount
        if (Integer.parseInt(input) != 100 && Integer.parseInt(input) != 50 && Integer.parseInt(input) != 20) {
            JOptionPane.showMessageDialog(null, "You input an invalid amount");
        }
        // process withdrawl
        else {
            // check if user has enough to withdraw this amount
            if (balance - Integer.parseInt(input) < 0) {
                JOptionPane.showMessageDialog(null, "Your balance insn't high enough to withdraw this amount");
                return;
            }

            // handle withdrawl
            // update balance
            balance -= Integer.parseInt(input);
            // show updated balance
            JOptionPane.showMessageDialog(null, "Account Balance: $" + balance);
        }
    }


    // ChequeAccount methods
    public void reorderChequeBook() {
        // check if user already has cheque book
        if (hasChequeBook) {
            JOptionPane.showMessageDialog(null, "You already have a cheque book");
        }
        // hanlde reorderChequeBook
        else {
            // ask user if they want to order a new cheque book
            String input = JOptionPane.showInputDialog(null, "Would you like to order a new cheque book?\n(yes/no)");

            // handle reorder
            if (input.equals("yes")) {
                hasChequeBook = true;
                JOptionPane.showMessageDialog(null, "Your new cheque book is on its way");
            }
            else if (input.equals("no")) {
                return;
            }
            else {
                // handle invalid input
                JOptionPane.showMessageDialog(null, "You input an invalid answer");
            }
        }
    }
}
