//note if file is being written to other txt it can't print here in console.
package cp2.word.guess;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\alexa\\OneDrive\\Documents\\GitHub\\school-code\\STI\\CP2\\Java\\word-guess\\words.txt");
        Scanner sf = new Scanner(file);
        Scanner s = new Scanner(System.in);
        String fileContent = "";
        String[] fileContentArray = new String[54];
        int min = 1;
        int max = 53;
        int range = max - min + 1;
        int randomNum = (int) Math.floor(Math.random() * range + min);
        String randomWord;
        char ans;
        int same = 1;

        while (sf.hasNextLine()) {

            for (int i = 0; i < fileContentArray.length; i++) {
                fileContentArray[i] = fileContent.concat(sf.nextLine());
            }
        }

        randomWord = fileContentArray[randomNum];

        char[] randomWordArray = randomWord.toCharArray();
        char[] jumbledRandomWordArray = randomWord.toCharArray();

        for (int j = 0; j < jumbledRandomWordArray.length; j++) {
            if (j % 2 != 0) {
                jumbledRandomWordArray[j] = '?';

            }
        }

        while (same != 0) {
            same = Arrays.compare(randomWordArray, jumbledRandomWordArray);
            System.out.println(jumbledRandomWordArray);

            if (same != 0) {

                System.out.print("Input a Letter: ");
                ans = s.next().charAt(0);
                for (int k = 0; k < jumbledRandomWordArray.length; k++) {

                    if (k % 2 != 0) {
                        if (ans == randomWordArray[k]) {
                            jumbledRandomWordArray[k] = ans;
                        }

                        if (ans != randomWordArray[k]) {
                            System.out.println("x");
                        }
                    }
                }
            }

            if (same == 0) {
                System.out.println("You won!");
            }
        }

    }
}
