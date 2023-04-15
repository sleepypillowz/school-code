//note if file is being written to other txt it can't print here in console.
package cp2.word.guess2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //File Location
        File file = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\word-guess2\\words.txt");

        //Reads the File
        Scanner s = new Scanner(file);
        


        //Print to Console the 1st Line
        //System.out.println(s.nextLine());
        //String storage for fileContent
        String fileContent = "";
        //Array storage for fileContent
        String[] fileContentArray = {};

        //Loops until all is printed to the console
        while (s.hasNextLine()) {
            //System.out.println(s.nextLine());

            //puts fileContent to storage
            fileContent = fileContent.concat(s.nextLine() + "\n");
        }
        //puts String fileContent to an Array
        fileContentArray = fileContent.split(" ", -5);

        //loops til all elements of an array is printed
        
        for (int i = 0; i < fileContentArray.length; i++) {
            System.out.println(fileContentArray[i]);
        }
        
        System.out.println(fileContentArray.length);
    }
}
