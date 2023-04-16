package cp2.log.in;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\log-in\\records.txt");
        Scanner sf = new Scanner(file);
        Scanner s = new Scanner(System.in);
        int choice;
        String username = "";
        String password = "";
        String registeredUsername = "";
        String registeredPassword = "";
        String[] fileContentArray = new String[2];
        String login;

        String fileContent = "";

        while (sf.hasNextLine()) {

            for (int i = 0; i < fileContentArray.length; i++) {
                fileContentArray[i] = fileContent.concat(sf.nextLine());
                System.out.println(fileContentArray[i]);
            }
        }
        registeredUsername = fileContentArray[0];
        registeredPassword = fileContentArray[1];

        System.out.println("Would you like to Register or Login?\nPress 0 for Register\nPress 1 for Login");
        try {
        choice = s.nextInt();
        
            if (choice == 0) {

                System.out.println("REGISTER");
                System.out.print("Enter Username: ");
                registeredUsername = s.next();
                System.out.print("Enter Password: ");
                registeredPassword = s.next();

                FileWriter writer = new FileWriter("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\log-in\\records.txt");
                writer.write(registeredUsername + "\n");
                writer.write(registeredPassword);
                writer.close();

                System.out.println("Registered!");
                System.out.println("Welcome, " + registeredUsername);
                System.out.println("Your Password is: " + registeredPassword);
                System.out.println("Would you like to login?\nenter y or n");
                login = s.next();
                if ("y".equals(login)) {
                    choice = 1;
                } else {
                    System.out.println("Bye!");
                }

            }
            if (choice == 1) {
                while (!username.equals(registeredUsername) && !password.equals(registeredPassword)) {
                    System.out.println("LOGIN");
                    System.out.print("Enter Username: ");
                    username = s.next();
                    System.out.print("Enter Password: ");
                    password = s.next();
                    if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
                        System.out.println("Logged in!");
                    } else {
                        System.out.println("Wrong username or psssword.");
                    }
                }

            }
            if (choice != 0 && choice != 1) {
                throw new Exception("Out of range, Try again.");

            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
