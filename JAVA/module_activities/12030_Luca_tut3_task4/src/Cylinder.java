import java.lang.Math;

// Formulas taken from online explanation

public class Cylinder extends Circle {
    // attribute
    private double height;
    private double volume;

    // constructor
    public Cylinder(double radius, double height, double volume) {
        super(radius);
        this.height = height;
        this.volume = volume;
    }

    // math methods
    @Override public void calculateDiameter() {
        double diameter = 2 * (Math.sqrt(volume / (Math.PI * height)));
        System.out.println("Diameter of Cylinder: " + diameter);
    }

    public void calculateCircumference() {
        double circumference = Math.PI * radius;
        System.out.println("circumference of Cylinder: " + circumference);
    }

    @Override public void calculateArea() {
        double area = (2 * Math.PI) * radius * height + (2 * Math.PI) * (radius * radius);
        System.out.println("Area of Cylinder: " + area);
    }
}