// import account classes
import accounts.ChequeAccount;
import accounts.FixedAccount;
import accounts.NetSaverAccount;
import accounts.SavingsAccount;

public class App {
    public static void main(String[] args) throws Exception {
        // test each class creation
        ChequeAccount a1 = new ChequeAccount(50, 1, "Luca", null, false);
        FixedAccount a2 = new FixedAccount(400, 2, "ManEagle", null, true, false);
        NetSaverAccount a3 = new NetSaverAccount(600, 3, "BoyWonder", null, 50, 0, true);
        SavingsAccount a4 = new SavingsAccount(1000, 3, "BoyWonder", null, 50, 0, true);

        a1.test();
        a2.test();
        a3.test();
        a4.test();

    }
}
