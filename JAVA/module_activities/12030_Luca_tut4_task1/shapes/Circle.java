package shapes;

// sub class
public class Circle extends Poly {
    // attributes
    private double radius;
    private double area;
    
    // constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // methods
    public void calculateArea() {
        area = Math.PI * (radius * radius);
    }
    
    public void displayArea() {
        System.out.println("Circle area: " + area + "cm²");
    }
}
