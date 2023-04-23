package models;
import java.util.List;

public class Machine {
    private String name;
    private List<Coin> coins;
    private List<Bill> bills;
    private List<Product> products;

    public Machine(String name, List<Bill> bills, List<Coin> coins, List<Product> products) {
        this.name = name;
        this.coins = coins;
        this.bills = bills;
        this.products = products;
    }

    public void addBills(Bill bill) {
        bills.add(bill);
    }

    public void addCoins(Coin coin) {
        coins.add(coin);
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public String showName() {
        return name;
    }

    public List<Bill> listOfBills() {
        return bills;
    }

    public List<Coin> listOfCoins() {
        return coins;
    }

    public List<Product> listOfProducts() {
        return products;
    }

}
