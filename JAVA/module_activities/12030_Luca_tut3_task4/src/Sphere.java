

// Formulas taken from online explanation

public class Sphere extends Circle {
    // attribute
    private String color;

    // constructor
    public Sphere(double radius, String color) {
        super(radius);
        this.color = color;
    }

    // math methods
    public void calculateDiameter() {
        double diameter = 2 * radius;
        System.out.println("Diameter: " + diameter);
    }

    @Override public void calculateCircumference() {
        double circumference = 2 * (Math.PI * radius);
        System.out.println("circumference: " + circumference);
    }

    @Override public void calculateArea() {
        double area = 4 * (Math.PI * (radius * radius));
        System.out.println("Area: " + area);
    }

    public void displayColor() {
        System.out.println("Color: " + color);
    }
}
