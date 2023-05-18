package cp2.carDemo;

public class CarDemo {

    public static void main(String[] args) {

        // Instantiate (Create) the Car object
        Car car1 = new Car(2020, Model.HATCHBACK, Color.YELLOW);
        Car car2 = new Car(2022, Model.CONVERTIBLE, Color.BLUE);

        //Statements that Calls display function inside the car class
        car1.display();
        car2.display();
    }
}
