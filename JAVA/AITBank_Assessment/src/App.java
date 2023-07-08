/*
    ===== Project Notes =====
    1. The project was coded on the VS Code IDE, I don't beleive there are any changes needed when converting to Netbeans, but please be open to potential difference they have that could cause errors

    
    ===== ASSUMPTION NOTES =====
    1. Only a demonstration of functions is required, the tester is required to run the code testing different inputs (there are no loops asking for inputs)
    2. Since these are just tests to show functionality, edge cases such as negative numbers or letters instead of numbers (etc.) won't be checked for (but will be implemente in the final version)
    3. Tester is free to write more tests in main if they want to test functionality they don't beleive was covered
    4. Only tests based off the functionality required of each accont type will be displayed, extra functionality that was added in won't have tests (but the tester is free to write some for them if they want)
    5. The test class only exists to run tests, it won't exist in the final product and isn't part of the system (so it doesn't appear on the class diagram)
*/

public class App {
    public static void main(String[] args) throws Exception {
        Testing testSystem = new Testing();
        
        testSystem.testInheritence();
        testSystem.testWithdrawAmounts();
        testSystem.testEmptyBalanceWithdrawl();
        testSystem.testDailyWithdrawLimit();
        testSystem.testSetWithdrawLimit();
        testSystem.testCorrectInterestCalculation();
        testSystem.testFixedAccountInterest();
    }
}
