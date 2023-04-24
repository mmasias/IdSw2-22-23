package views;

import java.util.List;
import java.util.Scanner;

import models.BillModel;
import models.MachineModel;
import models.CoinModel;
import models.ProductModel;

public class PurchaseView {
    static Scanner input = new Scanner(System.in);

    public void purchaseMenu(final List<MachineModel> machines) {
        boolean exit = false;
        final MachineView machineView = new MachineView();

        do{
            String option = "";
            System.out.println(
                "---------------------------------------------------------------------------------"
            );
            System.out.println("[1] Comprar");
            System.out.println("[2] Salir");
            System.out.println("----------------   Elige una opcion: ");
            option = input.nextLine();

            if(option.equals("1"))
            machineView.machineSelection(machines);
            else if(option.equals("2")){
                System.out.println("Saliendo...");
                exit = true;
            }
        }while(!exit);
    }

    public String generateChangeMessage(
        double amount,  List<BillModel> bills, List<CoinModel> coins
    ) {
        System.out.println("montooo: " + amount);
        String message = "";
        for (BillModel bill : bills) {
            if (bill.value <= amount) {
                int quantity = (int) Math.floor(amount / bill.value);
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
                int quantity = (int) Math.floor(amount / coin.value);
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

    public void printTicket(ProductModel product, String messageChange) {
        System.out.println("---------------------");
        System.out.println("Gracias por su compra. Aquí tiene su " + product.name + ".");

        if (!messageChange.isEmpty()) {
            System.out.println("Su cambio es: " + messageChange);
        }
    }
}
