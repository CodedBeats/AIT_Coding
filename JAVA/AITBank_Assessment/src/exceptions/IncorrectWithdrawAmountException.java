package exceptions;

// exception to handle an incorrect withdraw amount
public class IncorrectWithdrawAmountException extends Exception {
    public IncorrectWithdrawAmountException(String message) {
        super(message);
    }
}
