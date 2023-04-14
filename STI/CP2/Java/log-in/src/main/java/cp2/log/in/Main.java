package cp2.log.in;

import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.text.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
                
        //example 8 StandardOpenOption Arguments
        /*
        Path file = Paths.get("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\log-in\\first_name.txt");
        String s = "RANIKA";
        byte[] data = s.getBytes();
        OutputStream output = null;
        try {
            output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            output.write(data);
            output.flush();
            output.close();
        }
        catch (Exception e) {
            System.out.println("Messsage: " + e);
        }
        */
        
        //example 9 BuffedWriter Methods
        
        Scanner input = new Scanner(System.in);
        Path file = Paths.get("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\log-in\\grades.txt");
        String s = "";
        String delimiter = ",";
        long id;
        String name;
        double grade;
        final long QUIT = 0;
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new
        BufferedWriter(new OutputStreamWriter(output));
            System.out.print("Enter student iD number: ");
            id = input.nextLong();
            while(id != QUIT) {
                System.out.print("Enter name for student no. " + id + ": ");
                input.nextLine();
                name = input.nextLine();
                System.out.print("Enter the subject grade: ");
                grade = input.nextDouble();
                DecimalFormat df = new DecimalFormat("0.00");
                s = id + delimiter + name + delimiter + df.format(grade);
                writer.write(s, 0, s.length());
                writer.newLine();
                System.out.print("Enter next ID number or " + QUIT + " to quit: ");
                id = input.nextLong();
            }
            writer.close();
        }
        catch(Exception e) {
            System.out.println("Message: " + e);
        }
        
    }
}