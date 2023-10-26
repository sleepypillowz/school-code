package cp2.num_guess;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        int min = 1;
        int max = 50;
        int range = max - min + 1;
        double randomNum = (int) (Math.random() * range) + min;

        int ans = 0;
        int attempts = 0;

        while (ans != randomNum) {
            attempts++;
            try {
                System.out.print("Guess a number from 1 to 50!\n");
                ans = s.nextInt();

                if (ans > randomNum && ans > 0 && ans < 51) {
                    System.out.println("Too high. Try again.");
                }
                if (ans < randomNum && ans > 0 && ans < 51) {
                    System.out.println("Too low. Try again.");
                }
                if (ans == randomNum) {
                    System.out.println("You got it in " + attempts + " attempt(s)!");
                }
                if (ans > 50) {
                    throw new Exception("Out of range.");
                }
                if (ans < 0) {
                    throw new Exception("Out of range.");
                }

            } catch (InputMismatchException ex) {

                System.out.println("Invalid data type");
                System.out.println("Please enter an integer");

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
