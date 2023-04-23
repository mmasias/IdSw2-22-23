package models;
public abstract class  MoneyModel {
    public double value;
    public int quantity;

    MoneyModel(double value, int quantity) {
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
