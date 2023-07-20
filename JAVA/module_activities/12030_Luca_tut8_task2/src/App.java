 
public class App {
    public static void main(String[] args) throws Exception {
        try {
            Account account = new Account(1000);
            System.out.println("Initial Balance: " + account.getBalance());

            // withdraw 100, then try withdraw 1500
            account.withdraw();

            // If withdraw is successful, this line won't be reached
            System.out.println("Withdraw Successful!");
            System.out.println("Balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
