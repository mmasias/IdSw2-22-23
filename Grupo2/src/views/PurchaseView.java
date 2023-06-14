package views;

import java.util.List;
import java.util.Scanner;

import controllers.MachineController;
import controllers.MaintenanceController;
import models.MachineModel;
import utils.Line;

public class PurchaseView {
    static Scanner input = new Scanner(System.in);
    private MachineController machineController;
    private MaintenanceController maintenanceController;
    private Line line;

    public PurchaseView(MachineController machineController, MaintenanceController maintenanceController,Line line) {
        this.machineController = machineController;
        this.maintenanceController = maintenanceController;
        this.line = line;
    }

    public void purchaseMenu(final List<MachineModel> machines) {
        boolean exit = false;

        do{
            line.printDoubleLine();
            line.printTitle();
            line.printDoubleLine();
            System.out.println("[1] Comprar");
            System.out.println("[2] Salir");
            System.out.println("------   Elige una opcion: ");

            String option = "";
            option = input.nextLine();

            if(option.equals("1")){
                maintenanceController.checkAndRefillProducts(machines);
                this.machineController.machineSelection(machines);
            }
            else if(option.equals("2")){
                System.out.println("Saliendo...");
                exit = true;
            }
        }while(!exit);
    }
}
