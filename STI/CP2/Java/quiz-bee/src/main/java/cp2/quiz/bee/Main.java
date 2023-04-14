package cp2.quiz.bee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner s = new Scanner(System.in);
        String[][] values = {{"q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10"}, {"A", "B", "C"}};
        String ans;
        final long person = 1;
        long done = 0;
        String[] correctAns = {"B", "A", "A", "C", "A", "C", "C", "C", "A", "C"};
        long score;

        while (person != done) {
            try {
                score = 0;
                for (int i = 0; i < 10; i++) {

                    if (i == 0) {
                        //values[which array][location]
                        values[0][i] = "What is a correct syntax to output \"Hello World\" in Java?";
                        values[1][0] = "A. Console.WriteLine(\"Hello World\");";
                        values[1][1] = "B. System.out.println(\"Hello World\");";
                        values[1][2] = "C. print (\"Hello World\");";

                    }
                    if (i == 1) {
                        values[0][i] = "Java is short for \"JavaScript\".";
                        values[1][0] = "A. False";
                        values[1][1] = "B. True";
                        values[1][2] = "C. Both";

                    }
                    if (i == 2) {
                        values[0][i] = "How do you insert COMMENTS in Java code?";
                        values[1][0] = "A.  // This is a comment";
                        values[1][1] = "B.  # This is a comment";
                        values[1][2] = "C.  /* This is a comment";
                    }
                    if (i == 3) {
                        values[0][i] = "Which data type is used to create a variable that should store text?";
                        values[1][0] = "A. string";
                        values[1][1] = "B. myString";
                        values[1][2] = "C. String";
                    }
                    if (i == 4) {
                        values[0][i] = "How do you create a variable with the numeric value 5?";
                        values[1][0] = "A. int x = 5;";
                        values[1][1] = "B. x = 5;";
                        values[1][2] = "C. num x = 5";
                    }
                    if (i == 5) {
                        values[0][i] = "How do you create a variable with the floating number 2.8?";
                        values[1][0] = "A. int x = 2.8f;";
                        values[1][1] = "B. byte x = 2.8f";
                        values[1][2] = "C. float x = 2.8f;";
                    }
                    if (i == 6) {
                        values[0][i] = "Which method can be used to find the length of a string?";
                        values[1][0] = "A. getLength()";
                        values[1][1] = "B. len()";
                        values[1][2] = "C. length()";
                    }
                    if (i == 7) {
                        values[0][i] = "Which operator is used to add together two values?";
                        values[1][0] = "A. The & sign";
                        values[1][1] = "B. The * sign";
                        values[1][2] = "C. The + sign";
                    }
                    if (i == 8) {
                        values[0][i] = "The value of a string variable can be surrounded by single quotes.";
                        values[1][0] = "A. True";
                        values[1][1] = "B. False";
                        values[1][2] = "C. Both";
                    }
                    if (i == 9) {
                        values[0][i] = "Which method can be used to return a string in upper case letters?";
                        values[1][0] = "A. upperCase()";
                        values[1][1] = "B. touppercase()";
                        values[1][2] = "C. toUpperCase()";
                    }
                    System.out.println("------------------------------------------------------------------------");
                    System.out.println(values[0][i]);
                    System.out.println("------------------------------------------------------------------------");

                    for (int j = 0; j < 3; j++) {
                        System.out.println(values[1][j]);

                    }
                    System.out.print("ans: ");
                    ans = s.nextLine().toUpperCase();

                    if (ans.equals(correctAns[i])) {
                        score++;
                    }

                    if (!"A".equals(ans) && !"B".equals(ans) && !"C".equals(ans)) {
                        throw new Exception("Out of range, Try again.");

                    }
                }
                done = 1;
                System.out.println("Your score is: " + score);

            } catch (InputMismatchException ex) {

                System.out.println("Invalid data type");
                System.out.println("Please enter an integer");

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}
