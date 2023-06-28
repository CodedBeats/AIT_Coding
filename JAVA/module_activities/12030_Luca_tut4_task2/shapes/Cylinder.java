package shapes;

public class Cylinder implements Shape2D, Shape3D {
    // attributes
    private double radius;
    private double height;
    private double diameter;
    private double circumference;
    private double area;
    private double volume;
    
    // constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    // methods
    public void calculateDiameter() {
        diameter = 2 * Math.sqrt(volume / (Math.PI * height));
    }
    
    public void calculateCircumference(){
        circumference = 2 * Math.PI * radius;
    }
    
    public void calculateArea(){
        area = (2 * Math.PI * radius * height) + (2 * Math.PI * (radius * radius));
    }
    
    public void calculateVolume() {
        volume = Math.PI * (radius * radius) * height;
    }
    
    public void showCharacteristics(){
        System.out.println("Cylinder Measurements:\n"
                + "Diameter: " + diameter + "cm\n"
                + "Circumference: " + circumference + "cm\n"
                + "Area: " + area + "cm²\n" 
                + "Volume: " + volume + "cm³"
        );
    }
}
