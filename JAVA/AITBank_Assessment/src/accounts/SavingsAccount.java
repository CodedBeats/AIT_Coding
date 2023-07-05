package accounts;

public class SavingsAccount extends Account {
    // attributes
    private float withdrawLimit;
    private float dailyWithdrawed;
    private boolean canWithdraw;


    // constructor
    public SavingsAccount(float balance, int accountNumber, String accountName, String transactionHistory[], float withdrawLimit, float dailyWithdrawed, boolean canWithdraw) {
        super(balance, accountNumber, accountName, transactionHistory);

        this.withdrawLimit = withdrawLimit;
        this.dailyWithdrawed = dailyWithdrawed;
        this.canWithdraw = canWithdraw;
    }


    // overide abstract methods
    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }


    // SavingsAccount methods
    // calculate and apply interest rate
    public void calcInterest() {

    }

    // let user set withdraw limit
    public void setWithdrawLimit() {
        
    }
}
