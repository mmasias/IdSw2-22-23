package models;
import java.util.List;

public class Machine {
    private String name;
    private List<Coin> monedas;
    private List<Bill> billetes;
    private List<Product> productos;

    public Machine(String name, List<Bill> billetes, List<Coin> monedas, List<Product> productos) {
        this.name = name;
        this.monedas = monedas;
        this.billetes = billetes;
        this.productos = productos;
    }

    public void addBills(Bill billete) {
        billetes.add(billete);
    }

    public void addCoins(Coin moneda) {
        monedas.add(moneda);
    }

    public void addProducts(Product producto) {
        productos.add(producto);
    }

    public String showName() {
        return name;
    }

    public List<Bill> listOfBills() {
        return billetes;
    }

    public List<Coin> listOfCoins() {
        return monedas;
    }

    public List<Product> listOfProducts() {
        return productos;
    }

}
