package shapes;

import javax.swing.JOptionPane;

public class Circle {
    // attributes
    private double radius;
    private double area;

    // input radius
    public void setRadius() {
        String sRadius;
        sRadius = JOptionPane.showInputDialog("Enter circle radius");
        radius = Double.parseDouble(sRadius);
    }

    // calculate area
    public void calculateArea() {
        area = Math.PI * (radius * radius);
    }

    // return area
    public double getArea() {
        return area;
    }
}
