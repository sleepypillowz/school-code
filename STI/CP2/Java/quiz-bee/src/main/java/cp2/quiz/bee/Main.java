package cp2.quiz.bee;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String[][] values = {{"q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10"}, {"A", "B", "C"}};
        String ans;

        try {

            for (int i = 0; i < 10; ++i) {
                if (i == 0) {
                    values[0][i] = "How was your day?";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";

                }
                if (i == 1) {
                    values[0][i] = "How is School?";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";

                }
                if (i == 2) {
                    values[0][i] = "What are your habits?";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 3) {
                    values[0][i] = "What are you gonna do later?";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 4) {
                    values[0][i] = "How do u sleep?";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 5) {
                    values[0][i] = "What is 1+1";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 6) {
                    values[0][i] = "What 2+2";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 7) {
                    values[0][i] = "What is 3+3";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 8) {
                    values[0][i] = "What is 4+4";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                if (i == 9) {
                    values[0][i] = "What is 5+5";
                    values[1][0] = "A. Good";
                    values[1][1] = "B. Fine";
                    values[1][2] = "C. Bad";
                }
                System.out.println(values[0][i]);

                for (int j = 0; j < 3; j++) {
                    System.out.println(values[1][j]);
                }
                System.out.println("ans: ");
                ans = s.nextLine();
                if (!"a".equals(ans) || !"b".equals(ans) || !"c".equals(ans)) {
                    throw new Exception("Out of range.");
                }
                else
                    System.out.println("No error");
            }

        } catch (InputMismatchException ex) {

            System.out.println("Invalid data type");
            System.out.println("Please enter an integer");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
