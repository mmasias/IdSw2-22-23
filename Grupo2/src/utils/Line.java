package utils;

public class Line {
    private int length;

    public Line(int length) {
        this.length = length;
    }

    public void printLine() {
        String line = "_".repeat(this.length);
        System.out.println(line);
    }

    public void printLineOfHyphens() {
        String hyphens = "-".repeat(this.length);
        System.out.println(hyphens);
    }

    public void printDoubleLine() {
        String equal = "=".repeat(this.length);
        System.out.println(equal);
    }

    public void printTitle() {
        System.out.println("   MAQUINAS EXPENDEDORAS   ");
    }
}
