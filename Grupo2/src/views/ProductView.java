package views;

import java.util.List;
import models.MachineModel;
import utils.Line;

public class ProductView {
    private Line line;

    public ProductView(Line line) {
        this.line = line;
    }

    public void printProducts(final List<MachineModel> machines) {
        try {
            line.printLine();

            for (int i = 0; i < machines.get(0).listOfProducts().size(); i++) {
                System.out.print("|");
                System.out.printf(
                    "%26s|",machines.get(0).listOfProducts().get(i).name +
                    " $: " + machines.get(0).listOfProducts().get(i).price
                );
                for (int j = 1; j < machines.size(); j++) {
                    System.out.printf(
                        "%26s |",machines.get(j).listOfProducts().get(i).name + " $: " +
                        machines.get(j).listOfProducts().get(i).price

                    );
                }
                System.out.println();
            }
            
            line.printLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
