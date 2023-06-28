package shapes;

public class Sphere implements Shape2D, Shape3D {
    // attributes
    private double radius;
    private double diameter;
    private double circumference;
    private double area;
    private double volume;
    
    // constructor
    public Sphere(double radius) {
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
        area = 4 * Math.PI * (radius * radius);
    }
    
    public void calculateVolume() {
        volume = (4 / 3) * Math.PI * (radius * radius * radius);
    }
    
    public void showCharacteristics(){
        System.out.println("Sphere Measurements:\n"
                + "Diameter: " + diameter + "cm\n"
                + "Circumference: " + circumference + "cm\n"
                + "Area: " + area + "cm²\n" 
                + "Volume: " + volume + "cm³"
        );
    }
}
