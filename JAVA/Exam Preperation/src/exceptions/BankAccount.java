package exceptions;

public class BankAccount {
    private double balance;

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid deposit amount: " + amount);
        }
        balance += amount;
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

// Custom exception class
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}
