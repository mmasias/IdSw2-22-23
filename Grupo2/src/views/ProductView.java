package views;
import java.util.List;
import models.Machine;

public class ProductView {
    public void printProducts(List<Machine> maquinas) {
        try {
            System.out.println("____________________________________________________________________________________");  
            for (int i = 0; i < maquinas.get(0).listOfProducts().size(); i++) {
                System.out.print("|");
                System.out.printf("%26s|",maquinas.get(0).listOfProducts().get(i).name + " $: " + maquinas.get(0).listOfProducts().get(i).price);
                for (int j = 1; j < maquinas.size(); j++) {
                    System.out.printf("%26s |",maquinas.get(j).listOfProducts().get(i).name + " $: " + maquinas.get(j).listOfProducts().get(i).price);
                }
                System.out.println();
            }
            System.out.println("____________________________________________________________________________________"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
