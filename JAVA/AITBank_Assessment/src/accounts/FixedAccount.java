package accounts;
import javax.swing.JOptionPane;

public class FixedAccount extends Account {
    // attributes
    private boolean earlyWithdrawl = false;
    // ASSUMPTION: a fixed period is 30 days (represented as 30 in the successful interest test, the value will be less than 30 for one of the unsucessful interest tests indicating less than 30 days have been waited)
    private int interestPeriod;
    private double interestRate = 0.05;


    // constructor
    public FixedAccount(float balance, int accountNumber, String accountName, String transactionHistory[], boolean earlyWithdrawl, int interestPeriod) {
        super(balance, accountNumber, accountName, transactionHistory);

        this.earlyWithdrawl = earlyWithdrawl;
        this.interestPeriod = interestPeriod;
    }


    // overide abstract methods
    @Override
    public void deposit() {
        // get user input
        String depositInput = JOptionPane.showInputDialog(null, "How much would you like to Deposit?");
        // update balance
        balance += Float.parseFloat(depositInput);
        // show updated balance
        JOptionPane.showMessageDialog(null, "Account Balance: $" + balance);
    }

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

            // update earlyWithdrawl if interestPeriod is < 30 (the assumed fixed period needed to be waited to recieve interest)
            if (interestPeriod < 30) {
                earlyWithdrawl = true;
            }

            // show updated balance
            JOptionPane.showMessageDialog(null, "Account Balance: $" + balance);
        }
    }


    // NetSaverAccount methods
    // calculate and apply interest rate
    public void calcInterest() {
        // ASSUMPTION: this function would be called after a set period (but will be called in main just for testing purposes)
        // ASSUMPTION: Fixed account rate is 5% of balance every {set period}
        // ASSUMPTION: The period until interest is calculated only has to be waited once (it doen't need to be reset after interest has been calculated and given)

        // check if user withdrew too early
        if (earlyWithdrawl) {
            JOptionPane.showMessageDialog(null, "You won't recieve interest becuase you withdrew before your fixed period was up");
        }
        // check if user has waited fixed period
        else if (interestPeriod < 30) {
            JOptionPane.showMessageDialog(null, "You won't receive interest becuase your fixed period isn't up yet");
        }
        // apply interest
        else {
            balance += (balance * interestRate);
            JOptionPane.showMessageDialog(null, "Account Balance: $" + balance);
        }
    }
}
