package controllers;

import java.util.Scanner;

import models.MachineModel;
import models.ProductModel;
import models.PurchaseModel;
import utils.Line;

public class PurchaseController {
    private Scanner scanner = new Scanner(System.in);
    private PurchaseModel purchaseModel;
    private Line line;

    public PurchaseController(PurchaseModel purchaseModel, Line line) {
        this.purchaseModel = purchaseModel;
        this.line = line;
    }

    public void purchase(MachineModel machine) {
        line.printDoubleLine();

        purchaseModel.showProductSelection(machine.listOfProducts());
        final ProductModel selectedProduct = purchaseModel.selectProduct(machine.listOfProducts());
        double moneyDeposited = purchaseModel.depositMoney();

        while (moneyDeposited < selectedProduct.price) {
            System.out.println("Dinero insuficiente. Ingrese más dinero:");
            moneyDeposited += scanner.nextDouble();
        }

        final double change = moneyDeposited - selectedProduct.price;
        final String messageChange = purchaseModel.calculateChange(change, selectedProduct.price, machine);

        printTicket(selectedProduct, messageChange);
    }

    public void printTicket(ProductModel product, String messageChange) {
        line.printLineOfHyphens();
        System.out.println("Gracias por su compra. Aquí tiene su " + product.name + ".");

        if (!messageChange.isEmpty()) {
            System.out.println("Su cambio es: " + messageChange);
        }
    }

}
