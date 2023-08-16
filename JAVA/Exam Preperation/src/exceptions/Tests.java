package exceptions;

public class Tests {
    public static void main(String[] args) {
        try {
            BankAccount acc = new BankAccount();
            acc.deposit(-2);
            System.out.println("Deposit successful.");
        } catch (InvalidAmountException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }
}
