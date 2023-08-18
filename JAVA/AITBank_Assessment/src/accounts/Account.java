package accounts;

import javax.swing.JOptionPane;

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
    public abstract void withdraw();


    // depost won't change across different account types so implement here
    public void deposit() {
        // get user input
        String depositInput = JOptionPane.showInputDialog(null, "How much would you like to Deposit?");
        // update balance
        balance += Float.parseFloat(depositInput);
        // show updated balance
        JOptionPane.showMessageDialog(null, "Account Balance: $" + balance);
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

    public void getTransactionHistory() {
        for (int i = 0; i < transactionHistory.length; i++) {
            System.out.println(transactionHistory[i]);
        }
    }

}
