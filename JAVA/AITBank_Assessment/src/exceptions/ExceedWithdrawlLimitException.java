package exceptions;

public class ExceedWithdrawlLimitException extends Exception {
    public ExceedWithdrawlLimitException(String message) {
        super(message);
    }
}
