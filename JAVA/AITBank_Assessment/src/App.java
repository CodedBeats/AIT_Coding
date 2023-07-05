// import account classes
import accounts.ChequeAccount;
import accounts.FixedAccount;
import accounts.NetSaverAccount;
import accounts.SavingsAccount;

/*
    ===== ASSUMPTION NOTES =====
    1. Only a demonstration of functions is required, the tester is required to run the code testing different inputs (there are no loops asking for inputs)
    2. Since these are just tests to show functionality, edge cases such as negative numbers or letters instead of numbers won't be checked for (but will be implemente in the final version)
*/

public class App {
    public static void main(String[] args) throws Exception {
        // test each class creation
        ChequeAccount a1 = new ChequeAccount(50, 1, "Luca", null, false);
        FixedAccount a2 = new FixedAccount(400, 2, "ManEagle", null, true, false);
        NetSaverAccount a3 = new NetSaverAccount(600, 3, "BoyWonder", null, 50, 0, true);
        SavingsAccount a4 = new SavingsAccount(100, 3, "BoyWonder", null, 100, 0, true);

        // Cheque account tests
        // a1.deposit();
        // a1.withdraw();
        // a1.reorderChequeBook();

        // Saving account tests
        // a4.deposit();
        // a4.withdraw();
        // another withdraw to test withdrawl limits
        // a4.withdraw();
        // a4.setWithdrawLimit();
        // a4.calcInterest();

    }
}
