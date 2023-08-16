package abstract_interface;

public class Tests {
    public static void main(String[] args) {
        // Create an array of Toy interface type
        Toy[] toys = new Toy[3];

        // Instantiate Car objects and add them to the array
        toys[0] = new Car("Toyota", "Camry", 2023);
        toys[1] = new Car("Tesla", "Model S", 2023);
        toys[2] = new Car("Ford", "Mustang", 2023);

        // Loop through the array and call methods
        for (Toy toy : toys) {
            toy.play();
            toy.displayInfo();
            System.out.println();
        }
    }
}
