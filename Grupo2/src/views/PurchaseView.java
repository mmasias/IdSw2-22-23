package views;

import java.util.List;
import java.util.Scanner;

import models.Bill;
import models.Machine;
import models.Coin;
import models.Product;

public class PurchaseView {
    static Scanner input = new Scanner(System.in);

    public void purchaseMenu(List<Machine> maquinas) {
        boolean salir = false;
        MachineView machineView = new MachineView();

        do{
            String option = "";
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("[1] Comprar");
            System.out.println("[2] Salir");
            System.out.println("----------------   Elige una opcion: ");
            option = input.nextLine();

            if(option.equals("1"))
            machineView.machineSelection(maquinas);
            else if(option.equals("2")){
                System.out.println("Saliendo...");
                salir = true;
            }
        }while(!salir);
    }

    public String generateChangeMessage(double monto,  List<Bill> billetes, List<Coin> monedas) {
        System.out.println("montooo: " + monto);
        String mensaje = "";
        for (Bill billete : billetes) {
            if (billete.value <= monto) {
                int cantidad = (int) Math.floor(monto / billete.value);
                monto -= (cantidad * billete.value);
                if (mensaje.equals("")) {
                    mensaje = cantidad + "x $" + billete.value;
                } else {
                    mensaje += ", " + cantidad + "x $" + billete.value;
                }
                if (monto == 0) {
                    return mensaje;
                }
            }
        }
        for (Coin moneda : monedas) {
            if (moneda.value <= monto) {
                int cantidad = (int) Math.floor(monto / moneda.value);
                monto -= (cantidad * moneda.value);
                if (mensaje.equals("")) {
                    mensaje = cantidad + "x $" + moneda.value;
                } else {
                    mensaje += ", " + cantidad + "x $" + moneda.value;
                }
                if (monto == 0) {
                    return mensaje;
                }
            }
        }
        return mensaje;
    }

    public void printTicket(Product producto, String mensajeCambio) {
        System.out.println("---------------------");
        System.out.println("Gracias por su compra. Aquí tiene su " + producto.name + ".");
        if (!mensajeCambio.isEmpty()) {
            System.out.println("Su cambio es: " + mensajeCambio);
        }
    }
}
