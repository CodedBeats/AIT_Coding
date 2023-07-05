package accounts;

public class FixedAccount extends Account {
    // attributes
    private boolean canWithdraw;
    private boolean earlyWithdrawl;


    // constructor
    public FixedAccount(float balance, int accountNumber, String accountName, String transactionHistory[], boolean canWithdraw, boolean earlyWithdrawl) {
        super(balance, accountNumber, accountName, transactionHistory);

        this.canWithdraw = canWithdraw;
        this.earlyWithdrawl = earlyWithdrawl;
    }


    // overide abstract methods
    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }


    // NetSaverAccount methods
    // calculate and apply interest rate
    public void calcInterest() {

    }

    // handle if user can still withdraw after sucessfull withdrawl
    public void handleWithdrawLimit() {

    }
}
