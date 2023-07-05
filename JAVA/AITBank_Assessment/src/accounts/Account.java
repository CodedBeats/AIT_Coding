package accounts;

public abstract class Account {
    // abstract attributes
    protected float balance;
    protected int accountNumber;
    protected String accountName;
    protected String[] transactionHistory;


    // constructor
    public Account(float balance, int accountNumber, String accountName, String[] transactionHistory) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.transactionHistory = transactionHistory;
    }


    // abstract methods
    public abstract void deposit();

    public abstract void withdraw();

    
    // getter methods
    public float getBalance() {
        return balance;
    }

    public int getAccNumber() {
        return accountNumber;
    }

    public String getAccName() {
        return accountName;
    }

}
