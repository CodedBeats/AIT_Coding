// package pkg12030_luca_tut3_task1;
import java.util.Random;


class LandVehicle extends Vehicle {
    // LandVehicle attributes
    protected int numberWheels;
    
    // LandVehicle Constructor
    public LandVehicle(String color, int numberWheels) {
        // invoking base-class(Vehicle) constructor
        super(color);
        this.numberWheels = numberWheels;
    }
    
    // LandVehicle methods
    public void handleTrafic() {
        System.out.println("You are headed into on-coming trafic");
        Random rand = new Random();
        
        // Obtain a number between [0 - 4]
        int n = rand.nextInt(5);
        
        // crash vehicle if n <= 1 (2/5 chance)
        if (n <= 1) {
            System.out.println("AHHHHHHHHHHHHHHHHH!");
        }
        else {
            System.out.println("That was a close one!");
        }
    }
}
