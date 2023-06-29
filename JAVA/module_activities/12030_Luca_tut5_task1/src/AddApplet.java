import javax.swing.*;
import java.awt.Graphics;
import shapes.Circle;

public class AddApplet extends JApplet {
    // attributes
    private String message; 

    // set message content
    public void setMessage() {
        // get user input
        String input;
        input = JOptionPane.showInputDialog("Enter circle radius");

        // init circle
        Circle c1 = new Circle();
        // get circle radius
        c1.setRadius(input);
        // calculate area
        c1.calculateArea();
        // get area as string
        message = String.valueOf(c1.getArea());
    }

    // Override paint()
    @Override
    public void paint(Graphics g) {

        // Invoke super.paint() to set up the graphics context
        // super.paint(g);
        g.drawString("Area of circle is: " + message, 20, 20);
    }
}
