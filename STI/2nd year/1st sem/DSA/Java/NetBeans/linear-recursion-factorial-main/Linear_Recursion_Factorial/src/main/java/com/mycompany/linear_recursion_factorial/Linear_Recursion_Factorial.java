package com.mycompany.linear_recursion_factorial; //folder location
import java.util.*; //for user input

class Linear_Recursion_Factorial{  
 public static void main(String args[]){  
     
  Scanner sc=new Scanner(System.in); //also for user input
  int i,fact=1; //declare i and factorial
  
  
  System.out.println("Factorial Calculator");
  System.out.print("Enter a Number to compute the factorial: ");
  
  int num= sc.nextInt(); //User given number to calculate the Factorial
     System.out.print("The Solution is: ");
     
  for(i=1;i<=num;i++){ //Linear Recursion   
      fact=fact*i; //Multiply each Recursion
      System.out.print(i+("*")); //Solution
  }
  System.out.println(""); 
  System.out.println("The Factorial of "+num+" is: "+fact);     
}
}  
