package exceptions;

public class IncorrectWithdrawAmountException extends Exception {
    public IncorrectWithdrawAmountException(String message) {
        super(message);
    }
}
