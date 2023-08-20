package exceptions;

public class ExistingChequeBookException extends Exception {
    public ExistingChequeBookException(String message) {
        super(message);
    }
}
