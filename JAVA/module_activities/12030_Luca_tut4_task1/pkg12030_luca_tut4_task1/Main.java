package pkg12030_luca_tut4_task1;
// import shapes.Poly;
import shapes.Square;
import shapes.Circle;

public class Main {
    public static void main(String[] args) {
        // create shape objects (with presumed cm values)
        Square s1 = new Square(4);
        Circle c1 = new Circle(2);
        
        // call shape methods
        s1.calculateArea();
        s1.displayArea();
        c1.calculateArea();
        c1.displayArea();
    }
}
