package cp2.carDemo;

public class Car {

    // 3 private fields
    private final int year;
    private final Model model; //refers to the model class
    private final Color color; //refers to the color class

    // Constructor
    public Car(int yr, Model m, Color c) // parameters
    {
        // passing arguments to local variable
        year = yr;
        model = m;
        color = c;
    }

    // Display function
    public void display() {
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println();
    }
}
