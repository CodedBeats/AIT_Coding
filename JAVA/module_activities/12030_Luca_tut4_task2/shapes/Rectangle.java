package shapes;

public class Rectangle implements Shape2D {
    // attributes
    private double length;
    private double width;
    private double diameter;
    private double circumference;
    private double area;
    
    // constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    // methods
    // ASSUMPTION: the diameter of a rectangle is the diagonal length
    public void calculateDiameter() {
        diameter = Math.sqrt((length * length) + (width * width));
    }
    
    public void calculateCircumference(){
        circumference = (length * 2) + (width * 2);
    }
    
    public void calculateArea(){
        area = length * width;
    }
    
    public void showCharacteristics(){
        System.out.println("Rectangle Measurements:\n"
                + "Diameter: " + diameter + "cm\n"
                + "Circumference: " + circumference + "cm\n"
                + "Area: " + area + "cm²"
        );
    }
}
