// package pkg12030_luca_tut3_task1;

/*
    === ASSUMPTION ===
    Vehicle is the super-class of LandVehicle, LandVehicle is the sub-class of Vehicle and super-class of Bicycle, Bicycle is the sub-class of LandVehicle
    (Attributes of each class aren't all the same as real world)
*/

public class App {
    public static void main(String[] args) {
        // Create a Bicycle object
        Bicycle myBike = new Bicycle("Red", 2, 6, 4, 3, 2, 15.5, "Jelly");
        
        // call methods from Vehicle, LandVehicle and Bicycle class on the myBike object/reference
        myBike.displayData();
        myBike.handleTrafic();
        myBike.handleKick();
    }
}




