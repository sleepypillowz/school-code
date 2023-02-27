package cp2.receipt;

import java.util.*;
import java.text.DecimalFormat;

public class Receipt {
    
    Scanner s = new Scanner(System.in);
    
    //declaring variables
    private String ItemName;
    private double ItemPrice;
    private int ItemQuantity;
    private double amountDue;
    

    public void setItemName (String newItemName) {
        ItemName = ItemName + newItemName;
    }
    
    public void setTotalCost (int quantity, double price) {
        ItemQuantity = quantity; //this doin nothin
        ItemPrice = price;
    }
    
    public double getTotalCost() {
        amountDue = ItemQuantity * ItemPrice;
        return amountDue;
    } 
    
    public void readInput(){
        System.out.println("Enter the name of the item you are purchasing.");
        ItemName = s.nextLine();  
        
        System.out.println("Enter the quantity and price seperated by a space.");
        ItemQuantity = s.nextInt();
        ItemPrice = s.nextInt();
    }
    
    public String getItemName() {
        return ItemName; 
    }
    
    public void writeOutput() {
        System.out.println("You are purchasing  " + ItemQuantity + " " + ItemName + " at " + ItemPrice + " each.");
        System.out.printf("Amount due is %.2f", getTotalCost());
    }   
    
    public static void main(String[] args) {
 
        Mavenproject3 exe = new Mavenproject3();

        exe.readInput();
        exe.setItemName("(s)");
        exe.getTotalCost();
        exe.writeOutput();
        
    }
}

//source 
//https://mkyong.com/java/java-display-double-in-2-decimal-points/
//https://stackoverflow.com/questions/59342568/getting-two-data-separated-by-space-and-calculate-in-java
//https://pastebin.com/4BFn60G6?fbclid=IwAR1b-uD2YG-3oaJ0LQ2-FCh9nL1hwp00fnRgiuTkqXBUasd7vOIAe-7C5xE
