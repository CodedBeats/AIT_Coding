import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    public static void main(String[] args) {
        try {
            // Input file
            File inputFile = new File("input.txt");
            // Output file
            File outputFile = new File("output.txt");

            // Create FileReader and FileWriter objects
            FileReader fileReader = new FileReader(inputFile);
            FileWriter fileWriter = new FileWriter(outputFile);

            // Create BufferedReader and BufferedWriter objects to read and write data
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // create list of user objects
            List<User> userList = new ArrayList<>();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process each line (assuming it's comma-separated data)
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                int age = Integer.parseInt(data[3]);

                // Create a User object for each line
                User user = new User(id, firstName, lastName, age);
                userList.add(user);
            }

            // Close the streams
            bufferedReader.close();

            // Write the user data to the output file
            for (User user : userList) {
                String userData = "ID: " + user.getId() + ", Name: " + user.getFirstName() + " " + user.getLastName() + ", Age: " + user.getAge();
                bufferedWriter.write(userData);
                bufferedWriter.newLine();
            }

            // Close the output stream
            bufferedWriter.close();

            System.out.println("Data has been successfully read from input.txt and written to output.txt.");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
