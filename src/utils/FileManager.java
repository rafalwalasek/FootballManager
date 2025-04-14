package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public void checkOrCreateFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File has been created.");
            } catch (IOException e) {
                System.out.println("Error while creating the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists.");
        }
    }
    public void appendToFile(String fileName, String text) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(text + "\n");
            System.out.println("Data has been appended.");
        } catch (IOException e) {
            System.out.println("Error while appending to the file.");
            e.printStackTrace();
        }
    }
}
