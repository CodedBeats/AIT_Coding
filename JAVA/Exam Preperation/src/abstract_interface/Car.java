package abstract_interface;

public class Car implements Toy {
    private String brand;
    private String model;
    private int year;

    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public void play() {
        System.out.println("Zooming the toy car around!");
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " " + model + " " + year);
    }
}
