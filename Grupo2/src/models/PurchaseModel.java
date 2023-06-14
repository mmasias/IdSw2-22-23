package models;

import java.util.List;
import java.util.Scanner;

import controllers.BillController;

public class PurchaseModel {
    private Scanner scanner = new Scanner(System.in);
    final BillController billController = new BillController();

    public String returnChange(double changeValue, MachineModel machine){
        int change = (int) changeValue;
        int highestValue = billController.getHighestValue(machine.listOfBills());
        return outputMessage(change, highestValue, machine.listOfBills());
    }

    private String outputMessage(int value, int moneySize, List<BillModel> bills){
        if(value == 0){
            return "-------------"+"\n";
        }
        int quantity = value/moneySize;
        int remainder = value%moneySize;
        int nextSize = nextMoneySize(moneySize);
        String text = "";

        BillModel descountBill = getBillModelByValue(moneySize, bills);
        int billCurrentQuantity = descountBill.quantity;
        descountBill.updateQuantity(billCurrentQuantity-quantity);

        if(quantity != 0){
            text = "$"+moneySize+" x "+quantity+"\n";
        }

        return text + outputMessage(remainder, nextSize, bills);
    }

    private int nextMoneySize(int moneySize){
        int nextSize = 0;
        switch (moneySize){
            case 20: nextSize= 10; break;
            case 10: nextSize= 5; break;
            case 5: nextSize= 2; break;
            case 2: nextSize= 1; break;
        }
        return nextSize;
    }

    public void showProductSelection(List<ProductModel> products) {
        System.out.println("Seleccione un producto:");

        for (int i = 0; i < products.size(); i++) {
            final ProductModel product = products.get(i);
            System.out.println((i + 1) + ". " + product.name + " - $" + product.price);
        }
    }
    
    public ProductModel selectProduct(List<ProductModel> products) {
        System.out.println("----   Elige una opcion: ");

        final int optionProduct = this.scanner.nextInt();
        ProductModel selectedProduct = products.get(optionProduct - 1);
        selectedProduct.updateQuantity(selectedProduct.getQuantity() - 1);
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
    
    public double depositMoney(List<BillModel> bills) {
        boolean correctSize = true;
        double sizeMoney = 0;
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

        double balance = billSelect.value * quantity;
        return balance;
    }

    public CoinModel depositMoney(CoinModel coin) {
        System.out.println("Ingrese el tamaño: ");
        double sizeMoney = scanner.nextDouble();
        coin.updateValue(sizeMoney);

        System.out.println("Ingrese la cantidad: ");
        double quantity = scanner.nextDouble();
        coin.updateQuantity((int) quantity);

        return coin;
    }
}
