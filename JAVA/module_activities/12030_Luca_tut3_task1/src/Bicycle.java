// package pkg12030_luca_tut3_task1;


class Bicycle extends LandVehicle {
    // Bicycle attributes
    private int numberGears;
    private int actualGear;
    private int numberCogsFront;
    private int numberCogsBack;
    private double actualSpeed;
    private String frameMaterial;

    // Bicycle Constructor
    public Bicycle(String color, int numberWheels, int numberGears, int actualGear, int numberCogsFront, int numberCogsBack, double actualSpeed, String frameMaterial) {
        // invoking base-class(LandVehicle) constructor
        super(color, numberWheels);
        this.numberGears = numberGears;
        this.actualGear = actualGear;
        this.numberCogsFront = numberCogsFront;
        this.numberCogsBack = numberCogsBack;
        this.actualSpeed = actualSpeed;
        this.frameMaterial = frameMaterial;
    }
   
    // display Bisycle data
    public void displayData() {
        System.out.println(
                "My Bike:\n" + 
                "Color: " + color + "\n" + 
                "Number of Wheels: " + numberWheels + "\n" + 
                "Number of Gears: " + numberGears + "\n" + 
                "Actual Gear: " + actualGear + "\n" + 
                "Number of Cogs in the front: " + numberCogsFront + "\n" + 
                "Number of Cogs in the back: " + numberCogsBack + "\n" + 
                "Actual Speed: " + actualSpeed + "\n" + 
                "Frame Material: " + frameMaterial + "\n"
        );
    }
}
