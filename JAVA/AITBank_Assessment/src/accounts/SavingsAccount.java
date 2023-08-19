package accounts;
import javax.swing.*; 

public class SavingsAccount extends Account {
    // attributes
    private float dailyWithdrawLimit;
    private float dailyWithdrawed;
    private boolean canWithdraw = true;
    private double interestRate = 0.035;


    // constructor
    public SavingsAccount(float balance, int accountNumber, String accountName, String transactionHistory[], String accountType, int accountPIN, float dailyWithdrawLimit, float dailyWithdrawed, boolean canWithdraw) {
        super(balance, accountNumber, accountName, transactionHistory, accountType, accountPIN);

        this.dailyWithdrawLimit = dailyWithdrawLimit;
        this.dailyWithdrawed = dailyWithdrawed;
        this.canWithdraw = canWithdraw;
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
        // check if user has hit (or will exceed) their daily withdrawl limit
        else if (!canWithdraw || dailyWithdrawed + Integer.parseInt(input) > dailyWithdrawLimit) {
            JOptionPane.showMessageDialog(null, "You can't withdraw becuase you have hit (or will exceed) your daily withdrawl limit.\n" + 
            "(Daily Withdrawed: " + dailyWithdrawed + " / Daily Withdrawl limit: " + dailyWithdrawLimit + ")"
            );
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
            // increase dailyWithdrawed
            dailyWithdrawed += Integer.parseInt(input);
            // check if user can still withdraw
            handleWithdrawLimit();

            // show updated balance
            JOptionPane.showMessageDialog(null, "Account Balance: $" + balance);
        }
    }


    // SavingsAccount methods
    // calculate and apply interest rate
    public void calcInterest() {
        // ASSUMPTION: this function would be called after a set period (but will be called in main just for testing purposes)
        // ASSUMPTION: saving account rate is 3.5% of balance every {set period}

        // apply interest
        balance += (balance * interestRate);
        JOptionPane.showMessageDialog(null, "Account Balance after interest: $" + balance);
    }

    // let user set withdraw limit
    public void setWithdrawLimit() {
        // ASSUMPTION: users can't set a new withdrawl limit if they have already hit their daily withdraw limit
        if (!canWithdraw) {
            JOptionPane.showMessageDialog(null, "You can't set a new withdraw limit because you already hit your daily withdrawl limit");
            return;
        }

        // get user input
        String input = JOptionPane.showInputDialog(null, "What would you like to set your new Daily Withdrawl Limit to be?");
        // update daily withdraw limit
        dailyWithdrawLimit = Integer.parseInt(input);
        JOptionPane.showMessageDialog(null, "New daily Withdrawl Limit: " + dailyWithdrawLimit);
    }

    // handle if user can still withdraw after sucessfull withdrawl
    public void handleWithdrawLimit() {
        // ASSUMPTION: users can't withdraw if (dailyWithdrawLimit - dailyWithdrawed < 20) becuase the smallest amount to withdraw is 20
        if (dailyWithdrawLimit - dailyWithdrawed < 20 || dailyWithdrawed == dailyWithdrawLimit) {
            canWithdraw = false;
        }
        // no need for an else becuase default value is true
    }
}
