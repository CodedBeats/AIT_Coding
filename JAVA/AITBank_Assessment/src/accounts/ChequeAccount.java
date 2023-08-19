package accounts;
import javax.swing.*;

import exceptions.IncorrectWithdrawAmountException;
import exceptions.InssuficientBalanceException; 

public class ChequeAccount extends Account {
    // attributes
    private boolean hasChequeBook;


    // constructor
    public ChequeAccount(float balance, int accountNumber, String accountName, String accountType, int accountPIN, boolean hasChequeBook) {
        super(balance, accountNumber, accountName, accountType, accountPIN);

        this.hasChequeBook = hasChequeBook;
    }


    // overide abstract methods
    @Override
    public void withdraw(int input) throws IncorrectWithdrawAmountException, InssuficientBalanceException {
         // check if user input a valid amount
        if (input != 100 && input != 50 && input != 20) {
            throw new IncorrectWithdrawAmountException("You input an invalid amount");
        }
        // process withdrawl
        else {
            // check if user has enough to withdraw this amount
            if (balance - input < 0) {
                throw new InssuficientBalanceException("Your balance isn't high enough to withdraw this amount");
            }

            // update balance
            balance -= input;
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

    // getters
    public boolean getHasChequeBook() {
        return hasChequeBook;
    }
}
