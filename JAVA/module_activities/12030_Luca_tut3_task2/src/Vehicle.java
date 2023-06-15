// package pkg12030_luca_tut3_task1;

// just for fun
import javax.swing.JOptionPane;


class Vehicle {
    // Vehicle attributes
    protected String color;
    protected String kick;
    
    // Vehicle Constructor
    public Vehicle(String color) {
        this.color = color;
    }
    
    // Vehicle methods
    public void handleKick() {
        kick = JOptionPane.showInputDialog(null, "Would you like to kick the vehicle? (yes, no)"); 
        
        // handle kicking the vehicle
        if (kick.equals("yes")) {
            // why did you kick the vehicle?
            JOptionPane.showMessageDialog(null, "You kicked your vehicle....your foot hurts"); 
        }
        else if (kick.equals("no")) {
            // good job
            JOptionPane.showMessageDialog(null, "You quell your anger");
        }
        else {
            // sort of error/exception handling
            JOptionPane.showMessageDialog(null, "You don't know what to do"); 
        }
    }
}






