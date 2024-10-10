package appdev.teststrategy;

public class Cart {
    private double amount;

    public Cart(double amount) {
        this.amount = amount;
    }

    public void pay(Payment mode) {
        mode.pay(amount);
    }
}
