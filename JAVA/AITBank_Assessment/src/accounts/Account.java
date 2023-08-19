package accounts;

public abstract class Account {
    // abstract attributes
    protected float balance;
    protected int accountNumber;
    protected String accountName;
    protected String accountType;
    protected int accountPIN;


    // constructor
    public Account(float balance, int accountNumber, String accountName, String accountType, int accountPIN) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountPIN = accountPIN;
    }


    // abstract methods
    public abstract void withdraw();


    // depost won't change across different account types so implement here
    public void deposit(double amount) {
        // update balance
        balance += amount;
    }
    
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

    public String getAccType() {
        return accountType;
    }

    public int getAccPIN() {
        return accountPIN;
    }

}
