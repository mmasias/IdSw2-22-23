package views;

import java.util.List;
import java.util.Scanner;

import models.Machine;
import models.PurchaseModel;

public class MachineView {
    static Scanner input = new Scanner(System.in);

    public void printMachineName(List<Machine> maquinas) {
        maquinas.forEach(maquina -> {
            int width = 28;
            int padding = (width - maquina.showName().length()) / 2;
            System.out.print(String.format("%" + padding + "s%s%" + padding + "s", "", maquina.showName(), ""));
        });
        System.out.print("\n|__________________________|");
        for(int j=0;j<maquinas.size() -1;j++)
        {
            System.out.print("___________________________|");            
        }
        System.out.println();
    }

    public void machineSelection(List<Machine> maquinas) {
        boolean salir = false;
        PurchaseModel purchaseModel = new PurchaseModel();

        do{
            String option = "";
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("[1]" + maquinas.get(0).showName());
            System.out.println("[2]" + maquinas.get(1).showName());
            System.out.println("[3]" + maquinas.get(2).showName());
            System.out.println("[4] Salir");
            System.out.println("----------------   Elige una opcion: ");
            option = input.nextLine();

            if(option.equals("1"))
                purchaseModel.purchase(maquinas.get(0));
            else if(option.equals("2"))
                purchaseModel.purchase(maquinas.get(1));
            else if(option.equals("3"))
                purchaseModel.purchase(maquinas.get(2));
            else if(option.equals("4")){
                System.out.println("Saliendo...");
                salir = true;
            }
        }while(!salir);
    }
}
