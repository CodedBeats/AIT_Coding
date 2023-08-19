package accounts;
import javax.swing.JOptionPane;

import exceptions.ExceedWithdrawlLimitException;
import exceptions.IncorrectWithdrawAmountException;
import exceptions.InssuficientBalanceException;

public class NetSaverAccount extends Account {
    // attributes
    private float dailyWithdrawLimit;
    private float dailyWithdrawed;
    private boolean canWithdraw = true;
    private double interestRate = 0.04;


    // constructor
    public NetSaverAccount(float balance, int accountNumber, String accountName, String accountType, int accountPIN, float dailyWithdrawLimit, float dailyWithdrawed, boolean canWithdraw) {
        super(balance, accountNumber, accountName, accountType, accountPIN);

        this.dailyWithdrawLimit = dailyWithdrawLimit;
        this.dailyWithdrawed = dailyWithdrawed;
        this.canWithdraw = canWithdraw;
    }


    // overide abstract methods
    @Override
    public void withdraw(int input) throws IncorrectWithdrawAmountException, InssuficientBalanceException, ExceedWithdrawlLimitException {
        // check if user input a valid amount
        if (input != 100 && input != 50 && input != 20) {
            throw new IncorrectWithdrawAmountException("You input an invalid amount");
        }
        // check if user has hit (or will exceed) their daily withdrawl limit
        else if (!canWithdraw || dailyWithdrawed + input > dailyWithdrawLimit) {
            throw new ExceedWithdrawlLimitException("You can't withdraw becuase you have hit (or will exceed) your daily withdrawl limit.");
        }
        // process withdrawl
        else {
            // check if user has enough to withdraw this amount
            if (balance - input < 0) {
                throw new InssuficientBalanceException("Your balance isn't high enough to withdraw this amount");
            }

            // update balance
            balance -= input;
            // increase dailyWithdrawed
            dailyWithdrawed += input;
            // check if user can still withdraw
            handleWithdrawLimit();
        }
    }


    // NetSaverAccount methods
    // calculate and apply interest rate
    public void calcInterest() {
        // ASSUMPTION: this function would be called after a set period 
        // ASSUMPTION: Net-Saver Account rate is 4% of balance every 30 days/month

        // apply interest
        balance += (balance * interestRate);
        JOptionPane.showMessageDialog(null, "Account Balance after interest: $" + balance);
    }

    // handle if user can still withdraw after sucessfull withdrawl
    public void handleWithdrawLimit() {
        // ASSUMPTION: users can't withdraw if (dailyWithdrawLimit - dailyWithdrawed < 20) becuase the smallest amount to withdraw is 20
        if (dailyWithdrawLimit - dailyWithdrawed < 20 || dailyWithdrawed == dailyWithdrawLimit) {
            canWithdraw = false;
        }
        // no need for an else becuase default value is true
    }

    // getters
    public double getInterestRate() {
        return interestRate;
    }
    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }
    public double getDailyWithdrawed() {
        return dailyWithdrawed;
    }
    public boolean getCanWithdraw() {
        return canWithdraw;
    }
}
