import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        
        // potentially add loop for reusability
        
        // get user input for operator
        c1.getOperatorChoice();
        // get user input for num values
        c1.getNumvalues();
        // handle operator choice
        c1.handleOperator();
    }
}

class Calculator {
    // create scanner class to get user input
    Scanner myObj = new Scanner(System.in);
    // could add arrays as params for operator functions to pass more than 2 values
    double num1, num2, ans;
    int operatorChoice;
    
    // get both num values from user
    public void getNumvalues() {
        System.out.println("Enter first number:");
        num1 = myObj.nextInt();
        System.out.println("Enter second number:");
        num2 = myObj.nextInt();
    }
    
    // get the user's operator choice
    public void getOperatorChoice() {
        System.out.println("Choose your operator\n"
                + "\n1 - add"
                + "\n2 - subtract"
                + "\n3 - multiply"
                + "\n4 - divide");
        operatorChoice = myObj.nextInt();
    }
    
    // clear data (only needed in a loop to do differe operations one after the other)
    public void clearData() {
        System.out.println("Clearing data");
        num1 = 0;
        num2 = 0;
        ans = 0;
        operatorChoice = 0;
    }
    
    // get result by adding nums
    public void add() {
        ans = num1 + num2;
    }
    
    // get result by subtracting nums
    public void subtract() {
        ans = num1 - num2;
    }
    
    // get result by multiplying nums
    public void multply() {
        ans = num1 * num2;
    }
    
    // get result by dividing nums
    public void divide() {
        ans = num1 / num2;
    }
    
    // handle which operation function to call based on user operator choice
    public void handleOperator() {
        switch (operatorChoice) {
            case 1:
                add();
                System.out.println("Num1 + Num2: " + ans);
                break;
            case 2:
                subtract();
                System.out.println("Num1 - Num2: " + ans);
                break;
            case 3:
                multply();
                System.out.println("Num1 * Num2: " + ans);
                break;
            case 4:
                divide();
                System.out.println("Num1 / Num2: " + ans);
                break;
            default:
                // maybe add messgae asking for correct operator value
                break;
        }
    }
}


