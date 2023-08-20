package accounts;
import javax.swing.JOptionPane;

// import exceptions
import exceptions.IncorrectWithdrawAmountException;
import exceptions.InssuficientBalanceException;

public class FixedAccount extends Account {
    // attributes
    private boolean earlyWithdrawl = false;
    // ASSUMPTION: a fixed period is 30 days (represented as 30 in the successful interest test, the value will be less than 30 for one of the unsucessful interest tests indicating less than 30 days have been waited)
    private int interestPeriod;
    private double interestRate = 0.05;


    // constructor
    public FixedAccount(float balance, int accountNumber, String accountName, String accountType, int accountPIN, boolean earlyWithdrawl, int interestPeriod) {
        super(balance, accountNumber, accountName, accountType, accountPIN);

        this.earlyWithdrawl = earlyWithdrawl;
        this.interestPeriod = interestPeriod;
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

            // update earlyWithdrawl if interestPeriod is < 30 (the assumed fixed period needed to be waited to recieve interest)
            if (interestPeriod < 30) {
                earlyWithdrawl = true;
            }
        }
    }


    // NetSaverAccount methods
    // calculate and apply interest rate
    public void calcInterest() {
        // ASSUMPTION: this function would be called after a set period
        // ASSUMPTION: Fixed account rate is 5% of balance every 30 days/month
        // ASSUMPTION: The period until interest is calculated only has to be waited once (it doen't need to be reset after interest has been calculated and given)

        // check if user withdrew too early
        if (earlyWithdrawl && interestPeriod < 30) {
            JOptionPane.showMessageDialog(null, "You won't recieve interest becuase you withdrew before your fixed period was up");
        }
        // check if user has waited fixed period
        else if (interestPeriod < 30) {
            JOptionPane.showMessageDialog(null, "You won't receive interest becuase your fixed period isn't up yet");
        }
        // apply interest
        else {
            balance += (balance * interestRate);
            JOptionPane.showMessageDialog(null, "Account Balance after interest: $" + balance);
        }
    }

    // getters
    public boolean getEarlyWithdrawl() {
        return earlyWithdrawl;
    }
    public double getInterestRate() {
        return interestRate;
    }
}
