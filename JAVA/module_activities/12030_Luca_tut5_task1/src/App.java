// === IDE Note === //
// the only way to not have a main file is to use an extention that I don't think will work in netbeans
// therefore I will just use the main function as a way to test the applet, doing all coding inside it

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        // init JFrame
        JFrame frame = new JFrame("Applet Container");

        // init Applet Container
        AddApplet a1 = new AddApplet();
        a1.setMessage();

        // create frame
        frame.getContentPane().add(a1);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
