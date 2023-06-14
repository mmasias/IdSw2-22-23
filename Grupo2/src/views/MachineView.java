package views;

import java.util.Scanner;

import models.MachineModel;
import utils.Line;

public class MachineView {
    static Scanner input = new Scanner(System.in);
    private Line line;

    public MachineView(Line line) {
        this.line = line;
    }

    public void printMachineName(MachineModel machine) {
        line.printLine();

        final int width = 28;
        final int padding = (width - machine.showName().length()) / 2;
        System.out.println(
            String.format("%" + padding + "s%s%" + padding + "s", "", machine.showName(), "")
        );
    }
}
