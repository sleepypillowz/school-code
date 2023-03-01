package cp2.payroll.program;

import java.util.Scanner;

public class RunEmployee extends Employee {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        RunEmployee e = new RunEmployee();

        System.out.print("Enter name: ");
        e.setName(s.nextLine());

        System.out.println("Press F for Full Time or P for Part Time: ");
        String choice = s.nextLine();

        if (choice == null) {
            System.out.print("--- Invalid Key Entered ---");
        } else {
            switch (choice) {

                case "F":
                case "f":

                    //input
                    System.out.println("--- Full Time Employee ---");
                    //System.out.print("Enter Monthly Salary: ");
                    //e.setMonthlySalary(s.nextDouble());

                    //output
                    System.out.println("Name: " + e.getName());
                    //System.out.println("Monthly Salary: " + e.getMonthlySalary());
                    break;

                case "P":
                case "p":

                    //input
                    System.out.println("--- Part Time Employee ---");
                    //System.out.println("Enter rate per hour and  no. of hours worked seperated by a space:");
                    // e.setRatePerHour(s.nextDouble());
                    //  e.setHoursWorked(s.nextInt());
                    //  e.setWage(e.getRatePerHour()*e.getHoursWorked());

                    //output   
                    System.out.println("Name: " + e.getName());
                    //  System.out.println("Wage: " + e.getWage());
                    break;

                default:
                    System.out.print("--- Invalid Key Entered ---");
                    break;
            }
        }
    }
}
