package shapes;

public class Square implements Shape2D {
    // attributes
    private double length;
    private double diameter;
    private double circumference;
    private double area;
    
    // constructor
    public Square(double length) {
        this.length = length;
    }
    
    // methods
    // ASSUMPTION: the diameter of a square is the diagonal length
    public void calculateDiameter() {
        diameter = Math.sqrt((length * length) + (length * length));
    }
    
    public void calculateCircumference(){
        circumference = length * 4;
    }
    
    public void calculateArea(){
        area = length * length;
    }
    
    public void showCharacteristics(){
        System.out.println("Square Measurements:\n"
                + "Diameter: " + diameter + "cm\n"
                + "Circumference: " + circumference + "cm\n"
                + "Area: " + area + "cm²"
        );
    }
}
