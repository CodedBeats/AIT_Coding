import javax.swing.JFrame;
import shapes.Circle;

public class App {
    public static void main(String[] args) throws Exception {
        // init JFrame
        JFrame frame = new JFrame("Applet Container");
        
        // init circle
        Circle c1 = new Circle();
        // get circle radius
        c1.setRadius();
        // calculate area
        c1.calculateArea();

        // init Applet Container
        AddApplet a1 = new AddApplet(String.valueOf(c1.getArea()));

        // create frame
        frame.getContentPane().add(a1);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
