package pkg12030_luca_tut2_task2;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        int examMark;
        String input;
        
        
        // prompt user for exam mark input
        input = JOptionPane.showInputDialog(null, "Enter your exam marks");
        // convert input to int
        examMark = Integer.parseInt(input);
        
        // display grade depening on range
        if (examMark < 50) {
            JOptionPane.showMessageDialog(null, "FAIL"); 
        } 
        else if (examMark >= 50 && examMark <= 64) {
            JOptionPane.showMessageDialog(null, "PASS"); 
        } 
        else if (examMark >= 65 && examMark <= 74) {
            JOptionPane.showMessageDialog(null, "CREDIT"); 
        } 
        else if (examMark >= 75 && examMark <= 84) {
            JOptionPane.showMessageDialog(null, "DISTINCTION"); 
        }
        else {
            JOptionPane.showMessageDialog(null, "HIGH DISTINCTION"); 
        }
    }
    
}
