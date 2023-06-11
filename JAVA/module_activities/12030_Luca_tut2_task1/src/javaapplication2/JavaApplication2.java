package javaapplication2;
import javax.swing.*;


public class JavaApplication2 {
    public static void main(String[] args) {
        String input;
        float celcius = 0;
        float fahrenheit  = 0;
        
        // prompt user for farenheight input
        input = JOptionPane.showInputDialog(null, "Enter Temperature in Fahrenheit"); 
        // convert string input to float
        fahrenheit = Float.parseFloat(input);
        
        // convert to celcius
        // °C = (°F - 32) * 5/9
        celcius = (fahrenheit - 32) * 5 / 9;
        
        // output
        JOptionPane.showMessageDialog(null, "Temperature in Celcius\n" + celcius); 
    }
}
