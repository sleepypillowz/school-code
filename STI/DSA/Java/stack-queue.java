import java.util.*; //Import Full Package of Java Utility

public class Main {
  public static void main(String[] args) {

    Stack<String> stk= new Stack<>();
    
    Scanner scn = new Scanner(System.in); //medium for user input
    System.out.println("Enter four book titles. ");
    
    
     // loops while there is a next line and user is inputting something then ends when the user inputs nothing.
    for (int i = 1; i < 5; i++)
    {
    System.out.print("Book " + i + ": ");
    String inp = scn.nextLine();
    stk.push(inp); //pushes input into stack
    
    }

    System.out.println("Stack: " + stk);

    System.out.print("Queue: ");
    
    Queue que = new LinkedList();
    
    while (!stk.isEmpty()) { //while stack contains something keep popping its contents and offer popped to queue
  que.offer(stk.pop()); //offer in queue the popped stack
}
    System.out.print(que);
    }
}