// package pkg12030_luca_tut3_task4;

public class App {
    public static void main(String[] args) {
        // Create a Circle object
        Circle cir1 = new Circle(2);
        // Create a Cylinder object
        Cylinder cil1 = new Cylinder(2, 3, 15);
        // Create a Sphere object
        Sphere sph1 = new Sphere(2, "Red");
        
        System.out.println("=== Circle ===");
        // call circle methods
        cir1.calculateDiameter();
        cir1.calculateCircumference();
        cir1.calculateArea();
        
        System.out.println("\n=== Cylinder ===");
        // call cylinder methods
        cil1.calculateDiameter();
        cil1.calculateCircumference();
        cil1.calculateArea();
        
        System.out.println("\n=== Sphere ===");
        // call sphere methods
        sph1.calculateDiameter();
        sph1.calculateCircumference();
        sph1.calculateArea();
        sph1.displayColor();
    }
}




