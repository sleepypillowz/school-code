//note if file is being written to other txt it can't print here in console.
package cp2.word.guess2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File file = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\word-guess2\\words.txt");
        Scanner s = new Scanner(file);
        String fileContent = "";
        String[] fileContentArray = new String[54];

        while (s.hasNextLine()) {

            for (int i = 0; i < fileContentArray.length; i++) {
                fileContentArray[i] = fileContent.concat(s.nextLine());
            }            
        }

        System.out.println(fileContentArray[53]);
    }
}
