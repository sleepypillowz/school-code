package cp2.regexlogin;

import java.util.Scanner;

public class RegexLogin {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String studentNum;
        String studentNumDB = "0200-11-241";

        do {
            System.out.print("Enter your student number: ");
            studentNum = s.nextLine();
        } while (studentNum.length() != 11);

        if (studentNum.length() == 11) {
            boolean match = studentNum.matches("[0-9]{4}-[0-9]{2}-[0-9]{3}");
            if (match && studentNum.equals(studentNumDB)) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }
        }
    }
}
