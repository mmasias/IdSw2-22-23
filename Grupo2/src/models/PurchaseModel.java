package models;

import java.util.List;
import java.util.Scanner;

import views.PurchaseView;

public class PurchaseModel {
    private Scanner scanner = new Scanner(System.in);

    public void purchase(Machine maquina) {
        PurchaseView purchaseView = new PurchaseView();

        System.out.println("Bienvenido");
        showProductSelection(maquina.listOfProducts());
        Product productoSeleccionado = selectProduct(maquina.listOfProducts());
        double dineroIngresado = depositMoney();
        while (dineroIngresado < productoSeleccionado.price) {
            System.out.println("Dinero insuficiente. Ingrese más dinero:");
            dineroIngresado += scanner.nextDouble();
        }
        double cambio = dineroIngresado - productoSeleccionado.price;
        String mensajeCambio = calculateChange(cambio, productoSeleccionado.price, maquina);
        purchaseView.printTicket(productoSeleccionado, mensajeCambio);
    }

    public String calculateChange(double montoRecibido, double montoProducto, Machine maquina) {
        PurchaseView purchaseView = new PurchaseView();

        double montoFaltante = montoProducto - montoRecibido;
        System.out.println("montoRecibido: " + montoRecibido);
        System.out.println("montoProducto: " + montoProducto);
        System.out.println("montoFaltante: " + montoFaltante);
        if (montoFaltante > 0) {
            return String.format("Falta $%.2f para completar la compra.", montoFaltante);
        } else if (montoFaltante < 0) {
            String mensajeCambio = purchaseView.generateChangeMessage(montoRecibido, maquina.listOfBills(), maquina.listOfCoins());
            if (mensajeCambio.equals("")) {
                return String.format("No se puede dar cambio exacto. Devolviendo $%.2f", montoRecibido - montoProducto);
            } else {
                return mensajeCambio;
            }
        } else {
            return "";
        }
    }
    
    private void showProductSelection(List<Product> productos) {
        System.out.println("Seleccione un producto:");
        for (int i = 0; i < productos.size(); i++) {
            Product producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.name + " - $" + producto.price);
        }
    }
    
    private Product selectProduct(List<Product> productos) {
        System.out.println("Ingrese el número del producto que desea comprar:");
        int opcionProducto = this.scanner.nextInt();
        return productos.get(opcionProducto - 1);
    }
    
    private double depositMoney() {
        System.out.println("Ingrese su dinero:");
        return scanner.nextDouble();
    }
}
