import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

public class AddApplet extends JApplet {
    // attributes
    final int NUM_POINTS = 20;
    final double RADIUS = 100d;
    final Point[] points = new Point[NUM_POINTS];

    // set circle coords
    public void setCircleCoords() {
        for (int i = 0; i < NUM_POINTS; i++) {
            final double angle = Math.toRadians(((double) i / NUM_POINTS) * 360d);

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
        // would set background color here, but that stuff broke haha.

        // there aren't as many colors as there are on the task, so I'll go abit random after the rainbow
        Color[] rainbow = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, Color.magenta, Color.PINK, Color.CYAN, Color.GRAY};

        for (int i = 0; i < points.length; i++) {
            // get random color from rainbow
            int rnd = new Random().nextInt(rainbow.length);
            g.setColor(rainbow[rnd]);
            
            // draw text at circle coords (+ 300 to be in view, otherwise negatives are hidden)
            g.drawString("Color", (points[i].getX() + 300), (points[i].getY() + 300));
        }
    }
}
