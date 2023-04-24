package models;
public abstract class  MoneyAbstract {
    public double value;

    public int quantity;

    MoneyAbstract(double value, int quantity) {
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
