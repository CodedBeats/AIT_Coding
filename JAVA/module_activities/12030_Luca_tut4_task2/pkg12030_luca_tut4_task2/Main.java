package pkg12030_luca_tut4_task2;

// import shapes
import shapes.Circle;
import shapes.Sphere;
import shapes.Square;
import shapes.Rectangle;
import shapes.Cylinder;

public class Main {
    public static void main(String[] args) {
        // create shape objects (assuming measuerment values are in cm)
        Circle circle1 = new Circle(2);
        Sphere sphere1 = new Sphere(2);
        Square square1 = new Square(4);
        Rectangle rect1 = new Rectangle(4, 2);
        Cylinder cyl1 = new Cylinder (3, 5);
        
        // call Circle methods
        circle1.calculateDiameter();
        circle1.calculateCircumference();
        circle1.calculateArea();
        circle1.showCharacteristics();
        System.out.println("---------------------");
        
        // call Sphere methods
        sphere1.calculateDiameter();
        sphere1.calculateCircumference();
        sphere1.calculateArea();
        sphere1.calculateVolume();
        sphere1.showCharacteristics();
        System.out.println("---------------------");
        
        // call Square methods
        square1.calculateDiameter();
        square1.calculateCircumference();
        square1.calculateArea();
        square1.showCharacteristics();
        System.out.println("---------------------");
        
        // call Rectangle methods
        rect1.calculateDiameter();
        rect1.calculateCircumference();
        rect1.calculateArea();
        rect1.showCharacteristics();
        System.out.println("---------------------");
        
        // call Cylinder methods
        cyl1.calculateVolume();
        cyl1.calculateDiameter();
        cyl1.calculateCircumference();
        cyl1.calculateArea();
        cyl1.showCharacteristics();
        
        
        
        /*
            A way to clean up this code would be add each object to a 2D or 3D list (since they use the same functions)
            Then iterate through each list calling the methods on each object
            Essentially does the same thing as the above code, just makes it a lot cleaner to read
        */
    }
}
