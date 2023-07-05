package accounts;

public class ChequeAccount extends Account {
    // attributes
    private boolean hasChequeBook;


    // constructor
    public ChequeAccount(float balance, int accountNumber, String accountName, String[] transactionHistory, boolean hasChequeBook) {
        super(balance, accountNumber, accountName, transactionHistory);

        this.hasChequeBook = hasChequeBook;
    }


    // overide abstract methods
    @Override
    public void deposit() {

    }

    @Override
    public void withdraw() {

    }

    @Override
    public void closeAcc() {

    }


    // ChequeAccount methods
    public void reorderChequeBook() {

    }
}
