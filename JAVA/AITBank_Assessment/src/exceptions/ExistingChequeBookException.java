package exceptions;

// an exception to handle when a user already has a cheque book
public class ExistingChequeBookException extends Exception {
    public ExistingChequeBookException(String message) {
        super(message);
    }
}
