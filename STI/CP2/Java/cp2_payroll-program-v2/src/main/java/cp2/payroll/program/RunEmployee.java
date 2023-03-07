package cp2.payroll.program;

import java.util.Scanner;
import java.text.DecimalFormat;

public abstract class RunEmployee implements Employee.employeeInfo {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("0.00");
        RunEmployee e = new RunEmployee() {
            @Override
            public void setName(String newName) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public String getName() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void setMonthlySalary(double newMonthlySalary) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double getMonthlySalary() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void setRatePerHour(double newRatePerHour) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double getRatePerHour() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void setHoursWorked(int newHoursWorked) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public int getHoursWorked() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void setWage(double newWage) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double getWage() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        
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
                    System.out.print("Enter Monthly Salary: ");
                    e.setMonthlySalary(s.nextDouble());

                    //output
                    System.out.println("Name: " + e.getName());
                    System.out.println("Monthly Salary: " + e.getMonthlySalary());
                    break;

                case "P":
                case "p":

                    //input
                    System.out.println("--- Part Time Employee ---");
                    System.out.println("Enter rate per hour and  no. of hours worked seperated by a space:");
                    e.setRatePerHour(s.nextDouble());
                    e.setHoursWorked(s.nextInt());
                    e.setWage(e.getRatePerHour() * e.getHoursWorked());

                    //output   
                    System.out.println("Name: " + e.getName());
                    System.out.printf("Wage: " + f.format(e.getWage()));
                    break;

                default:
                    System.out.print("--- Invalid Key Entered ---");
                    break;
            }
        }
    }
}
