package exceptions;

// exception to handle when the user exceeds their daily withdraw limit
public class ExceedWithdrawlLimitException extends Exception {
    public ExceedWithdrawlLimitException(String message) {
        super(message);
    }
}
