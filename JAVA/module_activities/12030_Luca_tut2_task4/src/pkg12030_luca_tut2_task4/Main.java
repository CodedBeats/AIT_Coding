package pkg12030_luca_tut2_task4;
import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        // === ASSUMPTION === //
        // user wont input incorrect values (so I won't implement many error handling output messages and loops)
        
        String input;
        char conversionType;
        float celsius = 0;
        float fahrenheit  = 0;
        
        // prompt user for desired temperature type to convert to
        input = JOptionPane.showInputDialog(null, "Enter the temperature type you'd like to convert to\n'f' - Fahrenheit, 'c' - Celsius"); 
        conversionType = input.charAt(0);
   
        
        // handle different conversions
        if (conversionType == 'f') {
            // prompt user for temp input
            input = JOptionPane.showInputDialog(null, "Enter temperature in °C");
            celsius = Float.parseFloat(input);

            // convert celsius to fahrenheit        
            // °F = (°C * 9/5) + 32
            fahrenheit = (celsius * 9/5) + 32;
            
            // display converted value
            JOptionPane.showMessageDialog(null, celsius + " °C = " + fahrenheit + " °F"); 
        }
        else if (conversionType == 'c') {
            // prompt user for temp input
            input = JOptionPane.showInputDialog(null, "Enter temperature in °F");
            celsius = Float.parseFloat(input);
            fahrenheit = Float.parseFloat(input);
            
            // convert fahrenheit to celsius  
            // °C = (°F - 32) * 5/9
            celsius = (fahrenheit - 32) * 5 / 9;
            
            // display converted value
            JOptionPane.showMessageDialog(null, fahrenheit + " °F = " + celsius + " °C"); 
        }
        
    }
}
