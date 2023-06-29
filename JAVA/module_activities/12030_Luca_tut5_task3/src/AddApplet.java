import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class AddApplet extends JApplet {
    // attributes
    // input num of shape corners
    private int NUM_POINTS = 8;
    private double RADIUS = 100d;
    private Point[] points;

    // set shape cornders
    public void setShapeCorners() {
        String sInput = JOptionPane.showInputDialog("How many corners do you want on your shape");
        NUM_POINTS = Integer.parseInt(sInput);
    }

    // set circle coords
    public void setCircleCoords() {
        points = new Point[NUM_POINTS];
        for (int i = 0; i < NUM_POINTS; i++) {
            double angle = Math.toRadians(((double) i / NUM_POINTS) * 360d);

            points[i] = new Point(
                Math.cos(angle) * RADIUS, 
                Math.sin(angle) * RADIUS
            );
        }
        // System.out.println(Arrays.toString(points));
    }

    // Override paint()
    @Override
    public void paint(Graphics g) {
        // draw final connecting line first
        g.drawLine((points[points.length - 1].getX() + 300), (points[points.length - 1].getY() + 300), (points[0].getX() + 300), (points[0].getY() + 300));

        // will get different shape pased on NUM_POINTS
        for (int i = 0; i < points.length; i++) {
            // draw text at circle coords (+ 300 to be in view, otherwise negatives are hidden)
            g.drawLine((points[i].getX() + 300), (points[i].getY() + 300), (points[i + 1].getX() + 300), (points[i + 1].getY() + 300));
        }
    }
}
