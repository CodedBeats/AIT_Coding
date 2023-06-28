package shapes;

// sub class
public class Square extends Poly {
    // attributes
    private double length;
    private double area;
    
    // constructor
    public Square(double length) {
        this.length = length;
    }
    
    // methods
    public void calculateArea() {
        area = length * length;
    }
    
    public void displayArea() {
        System.out.println("Square area: " + area + "cm²");
    }
}
