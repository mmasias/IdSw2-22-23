package models;

import java.util.List;
import java.util.Scanner;

import views.PurchaseView;

public class PurchaseModel {
    private Scanner scanner = new Scanner(System.in);

    public void purchase(MachineModel machine) {
        PurchaseView purchaseView = new PurchaseView();

        System.out.println("Bienvenido");

        showProductSelection(machine.listOfProducts());
        ProductModel selectedProduct = selectProduct(machine.listOfProducts());
        double moneyDeposited = depositMoney();

        while (moneyDeposited < selectedProduct.price) {
            System.out.println("Dinero insuficiente. Ingrese más dinero:");
            moneyDeposited += scanner.nextDouble();
        }

        double change = moneyDeposited - selectedProduct.price;
        String messageChange = calculateChange(change, selectedProduct.price, machine);

        purchaseView.printTicket(selectedProduct, messageChange);
    }

    public String calculateChange(double amountReceived, double amountProduct, MachineModel machine) {
        PurchaseView purchaseView = new PurchaseView();
        double missingAmount = amountProduct - amountReceived;

        if (missingAmount > 0) {
            return String.format("Falta $%.2f para completar la compra.", missingAmount);
        } else if (missingAmount < 0) {
            String messageChange = purchaseView.generateChangeMessage(amountReceived, machine.listOfBills(), machine.listOfCoins());
            if (messageChange.equals("")) {
                return String.format("No se puede dar cambio exacto. Devolviendo $%.2f", amountReceived - amountProduct);
            } else {
                return messageChange;
            }
        } else {
            return "";
        }
    }
    
    private void showProductSelection(List<ProductModel> products) {
        System.out.println("Seleccione un producto:");

        for (int i = 0; i < products.size(); i++) {
            ProductModel product = products.get(i);
            System.out.println((i + 1) + ". " + product.name + " - $" + product.price);
        }
    }
    
    private ProductModel selectProduct(List<ProductModel> products) {
        System.out.println("Ingrese el número del producto que desea comprar:");

        int optionProduct = this.scanner.nextInt();
        return products.get(optionProduct - 1);
    }
    
    private double depositMoney() {
        System.out.println("Ingrese su dinero:");
        return scanner.nextDouble();
    }
}
