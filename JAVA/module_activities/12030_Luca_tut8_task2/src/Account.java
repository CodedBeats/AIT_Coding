import javax.swing.*; 

public class Account {
    private double balance;

    
    // constructor
    public Account(double balance) {
        this.balance = balance;
    }


    public void withdraw() throws InsufficientFundsException {
        double withdrawAmount;

        // get user withdraw amount
        String input = JOptionPane.showInputDialog("Enter withdraw amount");   
        // convert string to double
        withdrawAmount = Double.parseDouble(input);

        // check if user can withdraw amount
        if (withdrawAmount > balance) {
            throw new InsufficientFundsException("Insufficient funds in the account");
        }
        balance -= withdrawAmount;
    }


    public double getBalance() {
        return balance;
    }
}
