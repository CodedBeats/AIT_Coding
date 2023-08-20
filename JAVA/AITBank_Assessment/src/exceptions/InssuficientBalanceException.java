package exceptions;

// exception to handle when the user doesn't have enough in their balance to withdraw
public class InssuficientBalanceException extends Exception {
    public InssuficientBalanceException(String message) {
        super(message);    
    }
}
