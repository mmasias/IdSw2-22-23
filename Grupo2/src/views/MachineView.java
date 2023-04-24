package views;

import java.util.List;
import java.util.Scanner;
import models.MachineModel;
import models.PurchaseModel;

public class MachineView {
    static Scanner input = new Scanner(System.in);

    public void printMachineName(List<MachineModel> machines) {
        System.out.println(
                "____________________________________________________________________________________"
        );
        machines.forEach(machine -> {
            final int width = 28;
            final int padding = (width - machine.showName().length()) / 2;
            System.out.print(
                String.format("%" + padding + "s%s%" + padding + "s", "", machine.showName(), "")
            );
        });
        System.out.print("\n|__________________________|");
        for(int j=0;j<machines.size() -1;j++)
        {
            System.out.print("___________________________|");            
        }
        System.out.println();
    }

    public void machineSelection(List<MachineModel> machines) {
        boolean exit = false;
        final PurchaseModel purchaseModel = new PurchaseModel();

        do{
            String option = "";
            System.out.println(
                "------------------------------------------------------------------------------------"
            );
            System.out.println("[1]" + machines.get(0).showName());
            System.out.println("[2]" + machines.get(1).showName());
            System.out.println("[3]" + machines.get(2).showName());
            System.out.println("[4] Salir");
            System.out.println("----------------   Elige una opcion: ");
            option = input.nextLine();

            if(option.equals("1"))
                purchaseModel.purchase(machines.get(0));
            else if(option.equals("2"))
                purchaseModel.purchase(machines.get(1));
            else if(option.equals("3"))
                purchaseModel.purchase(machines.get(2));
            else if(option.equals("4")){
                System.out.println("Saliendo...");
                exit = true;
            }
        }while(!exit);
    }
}
