package views;

import java.util.List;
import models.MachineModel;

public class ProductView {
    public void printProducts(final List<MachineModel> machines) {
        try {
            System.out.println("____________________________________________________________________________________");  
            for (int i = 0; i < machines.get(0).listOfProducts().size(); i++) {
                System.out.print("|");
                System.out.printf("%26s|",machines.get(0).listOfProducts().get(i).name + " $: " + machines.get(0).listOfProducts().get(i).price);
                for (int j = 1; j < machines.size(); j++) {
                    System.out.printf("%26s |",machines.get(j).listOfProducts().get(i).name + " $: " + machines.get(j).listOfProducts().get(i).price);
                }
                System.out.println();
            }
            System.out.println("____________________________________________________________________________________"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
