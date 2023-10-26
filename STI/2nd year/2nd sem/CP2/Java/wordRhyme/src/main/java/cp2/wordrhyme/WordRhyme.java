package cp2.wordrhyme;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WordRhyme {
    public static void main(String[] args) {
        
        // User input
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter 3-4 letter word");
        System.out.print("Enter the 1st word: ");
        String word1 = s.next();
        System.out.print("Enter the 2nd word: ");
        String word2 = s.next();

        // Getting the last two digits of word1
        String sub = word1.substring(word1.length() - 2); //example "cat" 3 - 2 = 1 so sub will be "at" because it is index 0 
        
        // Compiles a pattern to be used for the matcher wherein
        // Any letter capital or lowercase which is 1-2 digits before sub and does not follow any digits
        Pattern pattern = Pattern.compile("[a-zA-Z]{1,2}" + sub + ""); 
        // Checks if word2 matches with word1
        Matcher matcher = pattern.matcher(word2);

        // Returns true if it matches else false
        boolean rhymes = matcher.matches();
        
        if (rhymes) {
            System.out.println("Does " + word1 + " rhyme with " + word2 + ": " + "Yes");
        } else {
            System.out.println("Does " + word1 + " rhyme with " + word2 + ": " + "No");
        }
    }
}