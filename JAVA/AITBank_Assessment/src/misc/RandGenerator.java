package misc;

// import random library
import java.util.Random;

// essentially just a class to generate random values for accounts...for fun
public class RandGenerator {
    // get random int between a min and max value
    public int generateRandomInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // get random name from some class mates that I remember and our tutor :)
    public String generateRandomName() {
        String[] names = {"Luca", "Connor", "Sabin", "Arturo", "Roshan", "Wellington", "Chanda", "Sabina", "Karanvir"};
        
        if (names.length == 0) {
            throw new IllegalArgumentException("Array of random names is empty");
        }
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(names.length);
        return names[randomIndex];
    }
}
