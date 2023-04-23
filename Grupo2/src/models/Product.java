package models;
public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void actualizarPrecio(double price) {
        this.price = price;
    }

    public void actualizarNombre(String name) {
        this.name = name;
    }

    public void actualizarCantidad(int quantity) {
        this.quantity = quantity;
    }
}
