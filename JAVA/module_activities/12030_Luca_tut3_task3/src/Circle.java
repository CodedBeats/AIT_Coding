public class Circle {
    // class attributes
    private double radius;
    // would add a diameter attribute here since it would be re-used, but the task was specific in only 1 attribute

    // constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // math methods
    public void calculateDiameter() {
        double diameter = 2 * radius;
        System.out.println("Diameter: " + diameter);
    }

    public void calculateCircumference() {
        double circumference = Math.PI * radius;
        System.out.println("circumference: " + circumference);
    }

    public void calculateArea() {
        double area = Math.PI * (radius * radius);
        System.out.println("Area: " + area);
    }
}
