package models;

import controllers.BillController;

import java.util.List;
import java.util.Scanner;

public class PurchaseModel {
    private Scanner scanner = new Scanner(System.in);

    public String calculateChange(
        final double amountReceived, double amountProduct, MachineModel machine
    ) {
        final double missingAmount = amountProduct - amountReceived;

        if (missingAmount > 0) {
            return String.format("Falta $%.2f para completar la compra.", missingAmount);
        } else if (missingAmount < 0) {
            final String messageChange = generateChangeMessage(
                amountReceived, machine.listOfBills(), machine.listOfCoins()
            );
            if (messageChange.equals("")) {
                return String.format(
                    "No se puede dar cambio exacto. Devolviendo $%.2f",
                    amountReceived - amountProduct
                );
            } else {
                return messageChange;
            }
        } else {
            return "";
        }
    }

    public String generateChangeMessage(
        double amount,  List<BillModel> bills, List<CoinModel> coins
    ) {
        System.out.println("montooo: " + amount);
        String message = "";
        for (BillModel bill : bills) {
            if (bill.value <= amount) {
                final int quantity = (int) Math.floor(amount / bill.value);
                amount -= (quantity * bill.value);
                if (message.equals("")) {
                    message = quantity + "x $" + bill.value;
                } else {
                    message += ", " + quantity + "x $" + bill.value;
                }
                if (amount == 0) {
                    return message;
                }
            }
        }
        for (CoinModel coin : coins) {
            if (coin.value <= amount) {
                final int quantity = (int) Math.floor(amount / coin.value);
                amount -= (quantity * coin.value);
                if (message.equals("")) {
                    message = quantity + "x $" + coin.value;
                } else {
                    message += ", " + quantity + "x $" + coin.value;
                }
                if (amount == 0) {
                    return message;
                }
            }
        }
        return message;
    }
    
    public void showProductSelection(List<ProductModel> products) {
        System.out.println("Seleccione un producto:");

        for (int i = 0; i < products.size(); i++) {
            final ProductModel product = products.get(i);
            System.out.println((i + 1) + ". " + product.name + " - $" + product.price);
        }
    }
    
    public ProductModel selectProduct(List<ProductModel> products) {
        System.out.println("Ingrese el número del producto que desea comprar:");

        final int optionProduct = this.scanner.nextInt();
        return products.get(optionProduct - 1);
    }

    private Boolean correctBillSize(double moneySize, List<BillModel> billList){
        BillModel billShell = new BillModel(moneySize, 0);
        for(BillModel currentBill:billList){
            if (currentBill.compareValue(billShell)==0){
                return true;
            }
        }
        System.out.println("Debes ingresar un tamaño de billete valido");
        return false;
    }

    private BillModel getBillModelByValue(double value, List<BillModel> billList){
        BillModel billShell = new BillModel(value, 0);
        for (BillModel currentBill:billList) {
            if(currentBill.compareValue(billShell) == 0){
                return currentBill;
            }
        }
        return billShell;
    }

    private void printBillsList(List<BillModel> bills){
        for(BillModel bill:bills){
            System.out.println("Billete: "+bill.value);
            System.out.println("Cantidad: "+bill.quantity);
            System.out.println("-------------------------");
        }
    }
    
    public BillModel depositMoney(List<BillModel> bills) {
        boolean correctSize = true;
        double sizeMoney = 0;
        printBillsList(bills);
        do{
            System.out.println("Ingrese el tamaño: ");
            sizeMoney = scanner.nextDouble();
            correctSize = correctBillSize(sizeMoney, bills);
        }
        while (!correctSize);

        BillModel billSelect = getBillModelByValue(sizeMoney, bills);

        System.out.println("Ingrese la cantidad: ");
        double quantity = scanner.nextDouble();
        double currentQuantity = billSelect.quantity;
        billSelect.updateQuantity(((int)quantity + (int)currentQuantity));
        printBillsList(bills);
        return new BillModel(8,8);
    }

    public CoinModel depositMoney(CoinModel coin) {
        System.out.println("Ingrese el tamaño: ");
        double sizeMoney = scanner.nextDouble();
        coin.updateValue(sizeMoney);

        System.out.println("Ingrese la cantidad: ");
        double quantity = scanner.nextDouble();
        coin.updateQuantity((int)quantity);

        return coin;
    }
}
