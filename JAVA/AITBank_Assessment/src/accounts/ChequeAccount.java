package accounts;

import exceptions.ExistingChequeBookException;
import exceptions.IncorrectWithdrawAmountException;
import exceptions.InssuficientBalanceException; 

public class ChequeAccount extends Account {
    // attributes
    private boolean hasChequeBook;


    // constructor
    public ChequeAccount(float balance, int accountNumber, String accountName, String accountType, int accountPIN, boolean hasChequeBook) {
        super(balance, accountNumber, accountName, accountType, accountPIN);

        this.hasChequeBook = hasChequeBook;
    }


    // overide abstract methods
    @Override
    public void withdraw(int input) throws IncorrectWithdrawAmountException, InssuficientBalanceException {
         // check if user input a valid amount
        if (input != 100 && input != 50 && input != 20) {
            throw new IncorrectWithdrawAmountException("You input an invalid amount");
        }
        // process withdrawl
        else {
            // check if user has enough to withdraw this amount
            if (balance - input < 0) {
                throw new InssuficientBalanceException("Your balance isn't high enough to withdraw this amount");
            }

            // update balance
            balance -= input;
        }
    }


    // ChequeAccount methods
    public void reorderChequeBook() throws ExistingChequeBookException {
        // check if user already has cheque book
        if (hasChequeBook) {
            throw new ExistingChequeBookException("You already have a cheque book");
        }
        // hanlde reorderChequeBook
        else {
            // change status
            hasChequeBook = true;
        }
    }

    // getters
    public boolean getHasChequeBook() {
        return hasChequeBook;
    }
}
