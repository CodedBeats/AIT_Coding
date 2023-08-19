import accounts.ChequeAccount;
import accounts.FixedAccount;
import accounts.NetSaverAccount;
import accounts.SavingsAccount;

public class Testing {
    // ===== variables to pass for tests ===== //
    String[] transactionHistory1 = {"Deposit - 110", "Withdraw - 20"};

    // ===== Objects Created for multiple tests ===== //
    ChequeAccount chequeAccount = new ChequeAccount(100, 1, "Luca", null, "x", 1234, false);
    FixedAccount fixedAccount = new FixedAccount(400, 2, "ManEagle", null, "x", 1234, true, 30);
    NetSaverAccount netSaverAccount = new NetSaverAccount(600, 3, "BoyWonder", null, "x", 1234, 250, 0, true);
    SavingsAccount savingsAccount = new SavingsAccount(200, 3, "BoyWonder", transactionHistory1, "x", 1234, 200, 0, true);

    

    // ===== Tests ===== //
    // account types inherit from Account properly
    public void testInheritence() {
        System.out.println("\n=== Test Inheritance ===");

        // any of these functions will demonstrate correct implementation
        System.out.println(chequeAccount.getBalance());
        System.out.println(fixedAccount.getAccNumber());
        System.out.println(netSaverAccount.getAccName());
        savingsAccount.getTransactionHistory();
    }


    // accounts only withdraw 20 or 50 or 100
    public void testWithdrawAmounts() {
        System.out.println("\n=== Test Withdraw Amounts ===");

        // input 20/50/100 and other values
        chequeAccount.withdraw();
        fixedAccount.withdraw();
        netSaverAccount.withdraw();
        savingsAccount.withdraw();
    }


    // accounts can't withdraw money if their ballance is 0
    public void testEmptyBalanceWithdrawl() {
        System.out.println("\n=== Test Empty Balance Withdrawl ===");

        // create objects with 0 balance just for this test
        ChequeAccount emptyChequeAccount = new ChequeAccount(0, 1, "Luca", null, "x", 1234, false);
        FixedAccount emptyFixedAccount = new FixedAccount(0, 2, "ManEagle", null, "x", 1234, true, 30);
        NetSaverAccount emptyNetSaverAccount = new NetSaverAccount(0, 3, "BoyWonder", null, "x", 1234, 250, 0, true);
        SavingsAccount emptySavingsAccount = new SavingsAccount(0, 3, "BoyWonder", transactionHistory1, "x", 1234, 200, 0, true);

        // input any possitive integer value
        emptyChequeAccount.withdraw();
        emptyFixedAccount.withdraw();
        emptyNetSaverAccount.withdraw();
        emptySavingsAccount.withdraw();
    }


    // Savings Account and NetSaver Account can't withdraw when they exceed their daily withdraw limit
    public void testDailyWithdrawLimit() {
        System.out.println("\n=== Test Daily Withdraw Limit on Savings Account and NetSaver Account ===");

        // create objects with lower daily withdraw limits just for this test
        NetSaverAccount limitedNetSaverAccount = new NetSaverAccount(500, 3, "BoyWonder", null, "x", 1234, 20, 0, true);
        SavingsAccount limitedSavingsAccount = new SavingsAccount(500, 3, "BoyWonder", transactionHistory1, "x", 1234, 50, 0, true);

        // input 20
        limitedNetSaverAccount.withdraw();
        // input 20
        limitedNetSaverAccount.withdraw();

        // input 100
        limitedSavingsAccount.withdraw();
    }


    // Savings Account can set withdraw limit
    public void testSetWithdrawLimit() {
        System.out.println("\n=== Test Set Withdraw Limit on Savings Account ===");

        savingsAccount.setWithdrawLimit();
    }


    // Savings Account and NetSaver Account have interest calculated and applied properly
    public void testCorrectInterestCalculation() {
        System.out.println("\n=== Test Interest calculation on Savings Account and NetSaver Account ===");

        System.out.println(netSaverAccount.getBalance());
        netSaverAccount.calcInterest();
        System.out.println(savingsAccount.getBalance());
        savingsAccount.calcInterest();
    }


    // Fixed Account can only get interest after the fixed period has been met
    public void testFixedAccountInterest() {
        System.out.println("\n=== Test Interest calculation on Fixed Account ===");

        // create objects with different interestPeriods just for this test
        FixedAccount interestPeriodFixedAccount1 = new FixedAccount(400, 2, "ManEagle", null, "x", 1234, true, 31);
        FixedAccount interestPeriodFixedAccount2 = new FixedAccount(400, 2, "ManEagle", null, "x", 1234, true, 10);

        interestPeriodFixedAccount1.withdraw();
        interestPeriodFixedAccount1.calcInterest();
        interestPeriodFixedAccount2.withdraw();
        interestPeriodFixedAccount2.calcInterest();
    }
}
