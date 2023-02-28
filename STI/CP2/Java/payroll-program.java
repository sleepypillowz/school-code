import java.util.Scanner; //Import the Scanner class

import java.text.DecimalFormat; //Importing for the Two Decimal Places
 
public class PayrollSystem {
    
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public static void main(String[] args) {
        
        //General Variables
        String hline = "___________________________"; //horizontal line       
        Scanner myObj = new Scanner(System.in); //Create a new Scanner object
        
        System.out.print("Enter name: ");
        String empName = myObj.nextLine(); //Read user input
        
        System.out.println("Press F for Full Time or P for Part Time: ");
        String choice = myObj.nextLine();
        
        if (choice == null) {
            System.out.print("--- Invalid Key Entered ---");
        }
        else switch (choice) {
            
            case "F":
            case "f":
                
                //input
                System.out.println("--- Full Time Employee ---");
                System.out.print("Enter Basic Pay: ");
                float fbpay = myObj.nextFloat(); //fulltime basic pay
                
                //output
                System.out.println(hline);
                System.out.println("Employee Name: " + empName);
                System.out.println("Basic Pay: " + fbpay);
                System.out.println(hline);
                System.out.println("Gross Pay: " + fbpay);
                break;
                
            case "P":
            case "p":
                
                //input
                System.out.println("--- Part Time Employee ---");
                
                System.out.println("Enter rate per hour and  no. of hours worked seperated by a space:");
                float rph = myObj.nextFloat(); //Rate per Hour
                float hrs = myObj.nextFloat(); //no. of Hours Worked
                
                float pbpay = rph*hrs; //part time basic pay
                
                //output
                System.out.println(hline);
                System.out.println("Name: " + empName);
                System.out.println("Wage: " + pbpay);

                break;
                               
            default:
                System.out.print("--- Invalid Key Entered ---");
                break;
            }
        }
    }
