import java.util.Scanner;

public class TwoSum {
    
    Scanner s = new Scanner(System.in);
    
    private int num1;
    private int num2;
    
    public void readInput(){
        System.out.println("Sum A + B");
        System.out.print("Enter The 1st number: ");
        num1 = s.nextInt();
        System.out.print("Enter The 2nd number: ");
        num2 = s.nextInt();
    }
    
    public void sum(){
        int sum = num1+num2;
        System.out.println("The sum of " + num1 +" and " + num2 + " is " + sum);
    }
    
    public static void main(String[] args) {
        
        TwoSum exe = new TwoSum();
        
        exe.readInput();
        exe.sum();
        
    }
}