import java.util.*; //imports java utility for Scanner

public class MyClass {
    public static void main(String args[]) {
        
    Scanner scn = new Scanner(System.in); //creates a scanner to recieve user input
    System.out.println("List your Subjects: "); //Guide for User
    
    Queue<String> subs = new LinkedList(); //creates a LinkedList a LinkedLists is a linear collecton of data elements
    
    String inp; //storage for inputs that then gets stored to LinkedList
    
    while (scn.hasNextLine() && (inp = scn.nextLine()).length() != 0)  // loops while there is a next line and user is inputting something then ends when the user inputs nothing.
    {
    subs.add(inp); //adds a subject from the user input
    }
    System.out.println("Subjects: " + subs); //prints the list of subjects
 }
}