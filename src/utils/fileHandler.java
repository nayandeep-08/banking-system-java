package utils;

import java.io.*;
import java.util.HashMap;
import model.User;

public class fileHandler {

    // Save data
    public static void saveData(HashMap<String, User> users) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("bank_data.ser")
            );

            oos.writeObject(users);
            oos.close();

            System.out.println("Data saved successfully!");

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load data
    public static HashMap<String, User> loadData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("bank_data.ser")
            );

            HashMap<String, User> users =
                    (HashMap<String, User>) ois.readObject();

            ois.close();

            System.out.println("Data loaded successfully!");
            return users;

        } catch (Exception e) {
            System.out.println("No previous data found.");
            return new HashMap<>();
        }
    }
}