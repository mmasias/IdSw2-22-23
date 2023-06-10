package views;

import models.MachineModel;
import utils.Line;

public class ProductView {
    private Line line;

    public ProductView(Line line) {
        this.line = line;
    }

    public void printProduct(final MachineModel machine) {
        try {
            line.printLine();

            for (int i = 0; i < machine.listOfProducts().size(); i++) {
                System.out.print("|");
                System.out.printf(
                    "%26s|",machine.listOfProducts().get(i).name +
                    " $: " + machine.listOfProducts().get(i).price
                );
                System.out.println();
            }

            line.printLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
