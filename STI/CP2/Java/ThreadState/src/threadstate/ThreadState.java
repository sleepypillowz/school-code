package threadstate;

import java.util.Scanner;

public class ThreadState extends Thread {

    public static void main(String[] args) {

        //Enable User Input
        Scanner s = new Scanner(System.in);

        //Create Two (2) threads & Ask the user to enter a name for each thread
        System.out.print("Enter the name of the 1st Thread: ");
        String threadName = s.nextLine();
        System.out.print("Enter the name of the 2nd Thread: ");
        String threadName2 = s.nextLine();

        //Craeting object
        ThreadState thread = new ThreadState();
        ThreadState thread2 = new ThreadState();

        //Setting Thread Name
        thread.setName(threadName);
        thread2.setName(threadName2);

        //Thread State: NEW
        System.out.println(thread.getName() + " is " + thread.getState());
        System.out.println(thread2.getName() + " is " + thread2.getState());

        //Thread State: RUNNABLE
        thread.start();
        System.out.println(thread.getName() + " is " + thread.getState());
        thread2.start();
        System.out.println(thread2.getName() + " is " + thread2.getState());

        try {
            //Thread State: TERMINATED
            ThreadState.sleep(500);
            System.out.println(thread.getName() + " is " + thread.getState());
            System.out.println(thread2.getName() + " is " + thread2.getState());
        } catch (InterruptedException ex) {

        }

    }

}
