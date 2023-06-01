import javax.swing.*;

public class App {
public static void main(String[] args) {
        String userArrSize, inputValue;
        int arrSize, inputNum, sum = 0;
        double avg;
        
        // get arr size from user
        userArrSize = JOptionPane.showInputDialog(null, "How many values would you like to enter?"); 
        // convert input for arr size to int
        arrSize = Integer.parseInt(userArrSize);
        
        // loop until user has entered all their values
        for (int i = 0; i < arrSize; i++) {
            // get input value
            inputValue = JOptionPane.showInputDialog(null, "Enter value " + (i + 1)); 
            // convert value to into int
            inputNum = Integer.parseInt(inputValue);
            // add value to sum
            sum += inputNum;
        }
        
        // calc avg
        avg = sum / arrSize;
        
        // output average
        JOptionPane.showMessageDialog(null, "The average is:\n" + avg); 
    }
    
}
