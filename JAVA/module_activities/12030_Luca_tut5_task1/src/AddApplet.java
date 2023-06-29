import javax.swing.*;
import java.awt.Graphics;

public class AddApplet extends JApplet {
    // attributes
    private String message; 

    // constructor
    AddApplet(String message) {
        this.message = message;
    }

    // Overriding paint() method
    @Override
    public void paint(Graphics g) {
        // Invoke super.paint() to set up the graphics context
        super.paint(g);

        g.drawString("Area of circle is: " + message, 20, 20);
    }
}
