import accounts.ChequeAccount;
import accounts.FixedAccount;
import accounts.NetSaverAccount;
import accounts.SavingsAccount;

public class Testing {
    // ===== variables to pass for tests ===== //
    String[] transactionHistory1 = {"Deposit - 110", "Withdraw - 20"};

    // ===== Objects Created for tests ===== //
    ChequeAccount chequeAccount1 = new ChequeAccount(50, 1, "Luca", null, false);
    FixedAccount fixedAccount1 = new FixedAccount(400, 2, "ManEagle", null, true, 30);
    NetSaverAccount netSaverAccount1 = new NetSaverAccount(600, 3, "BoyWonder", null, 50, 0, true);
    SavingsAccount savingsAccount1 = new SavingsAccount(100, 3, "BoyWonder", transactionHistory1, 100, 0, true);

    

    // ===== Tests ===== //
    // account types inherit from Account properly
    public void testInheritence() {
        System.out.println("\n=== Test Inheritance ===");
        // any of these functions will demonstrate correct implementation
        System.out.println(chequeAccount1.getBalance());
        System.out.println(fixedAccount1.getAccNumber());
        System.out.println(netSaverAccount1.getAccName());
        savingsAccount1.getTransactionHistory();
    }


    // accounts only withddraw 20 or 50 or 100



    // accounts can't withdraw money if their ballance is 0



    // Savings Account and NetSaver Account can't withdraw when they exceed their daily withdraw limit



    // Savings Account can set withdraw limit
}
