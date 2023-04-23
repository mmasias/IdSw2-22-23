package models;
public abstract class  Money {
    public double value;
    public int quantity;

    Money(double value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    void updatePrice(double value) {
        this.value = value;
    }

    void updateQuantity(int quantity) {
        this.quantity = quantity;
    }
}
