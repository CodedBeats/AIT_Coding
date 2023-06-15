// import java.util.Random;
import java.util.Random;

public class Boat extends Vehicle {
    // LandVehicle attributes
    private boolean weatherProtected;
    
    // LandVehicle Constructor
    public Boat(String color, boolean weatherProtected) {
        // invoking base-class(Vehicle) constructor
        super(color);
        this.weatherProtected = weatherProtected;
    }
    
    // LandVehicle methods
    public void handleIceburg() {
        System.out.println("Iceburg straight ahead!!!!");
        Random rand = new Random();
        
        // Obtain a number between [0 - 4]
        int n = rand.nextInt(5);
        
        // throw jack overboard if n <= 3 (4/5 chance)
        if (n <= 3) {
            System.out.println("You push jack overboard");
        }
        else {
            System.out.println("Jack does that annoying thing from Titanic");
        }
    }
}
