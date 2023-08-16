package random;

public class RandomExample {
    public static void main(String[] args) {
        // Generating random integers within a range
        int randomNumber1 = (int) (Math.random() * 10); // Generates a random integer from 0 to 9
        int randomNumber2 = (int) (Math.random() * 101); // Generates a random integer from 0 to 100

        System.out.println("Random number 1: " + randomNumber1);
        System.out.println("Random number 2: " + randomNumber2);

        // Generating random double values
        double randomDouble1 = Math.random(); // Generates a random double between 0 (inclusive) and 1 (exclusive)
        double randomDouble2 = Math.random() * 100; // Generates a random double between 0 (inclusive) and 100 (exclusive)

        System.out.println("Random double 1: " + randomDouble1);
        System.out.println("Random double 2: " + randomDouble2);

        // Generating random boolean values
        boolean randomBoolean = Math.random() < 0.5; // Generates a random boolean with roughly equal chances of being true or false
        System.out.println("Random boolean: " + randomBoolean);
    }
}
