import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // Method to write to a file (create if not exists)
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Content written successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- File Content ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("---------------------\n");
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please check the file name.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to append/modify the file
    public static void modifyFile(String fileName, String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine();
            writer.write(newContent);
            System.out.println("Content appended successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }

    // Main menu-driven program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== File Handling Utility ======");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify (Append) File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter file name: ");
                    String writeFileName = sc.nextLine();
                    System.out.print("Enter content to write: ");
                    String writeContent = sc.nextLine();
                    writeToFile(writeFileName, writeContent);
                    break;

                case 2:
                    System.out.print("Enter file name to read: ");
                    String readFileName = sc.nextLine();
                    readFromFile(readFileName);
                    break;

                case 3:
                    System.out.print("Enter file name to modify: ");
                    String modifyFileName = sc.nextLine();
                    System.out.print("Enter content to append: ");
                    String modifyContent = sc.nextLine();
                    modifyFile(modifyFileName, modifyContent);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}
