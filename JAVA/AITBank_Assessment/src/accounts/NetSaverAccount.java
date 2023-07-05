package accounts;

public class NetSaverAccount extends Account {
    // attributes
    private float dailyWithdrawLimit;
    private float dailyWithdrawed;
    private boolean canWithdraw;


    // constructor
    public NetSaverAccount(float balance, int accountNumber, String accountName, String transactionHistory[], float dailyWithdrawLimit, float dailyWithdrawed, boolean canWithdraw) {
        super(balance, accountNumber, accountName, transactionHistory);

        this.dailyWithdrawLimit = dailyWithdrawLimit;
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


    // NetSaverAccount methods
    // calculate and apply interest rate
    public void calcInterest() {

    }

    // handle if user can still withdraw after sucessfull withdrawl
    public void handleWithdrawLimit() {

    }
}
