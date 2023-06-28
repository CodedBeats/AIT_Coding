package shapes;

public class Circle implements Shape2D {
    // attributes
    private double radius;
    private double diameter;
    private double circumference;
    private double area;
    
    // constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // methods
    public void calculateDiameter() {
        diameter = 2 * radius;
    }
    
    public void calculateCircumference(){
        circumference = 2 * Math.PI * radius;
    }
    
    public void calculateArea(){
        area = Math.PI * (radius * radius);
    }
    
    public void showCharacteristics(){
        System.out.println("Circle Measurements:\n"
                + "Diameter: " + diameter + "cm\n"
                + "Circumference: " + circumference + "cm\n"
                + "Area: " + area + "cm²"
        );
    }
}
