package pkg12030_luca_tut2_task3;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        // === ASSUMPTION === //
        // In (fake) Australia, you can apply for a driving license if you ARE an Australian Citizen AND ARE 16 years of age or older
        
        boolean canApply = false;
        char isAusCitizen;
        int age = 0;
        String messageInput;
        
        // prompt user if they are an australian citizen
        messageInput = JOptionPane.showInputDialog(null, "Are you an Australian Citizen?\nAnswer 'y' or 'n'");
        isAusCitizen = messageInput.charAt(0);
        
        // if user is an Australian citizen, prompt user for their age
        if (isAusCitizen == 'y') {
            messageInput = JOptionPane.showInputDialog(null, "Enter your age");
            age = Integer.parseInt(messageInput);
            
            // set canApply to true if user is 16 or older
            if (age >= 16) {
                canApply = true;
            }
        }
        
        // display if user can apply for driving license or not
        if (canApply) {
            JOptionPane.showMessageDialog(null, "You CAN apply for a driving license"); 
        }
        else {
            JOptionPane.showMessageDialog(null, "You CANNOT apply for a driving license"); 
        }
    }
}
