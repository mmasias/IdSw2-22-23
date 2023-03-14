package Renderizacion;
import java.util.Scanner;

public class InOut {
    
    public static void pausa() {
        Scanner entrada = new Scanner(System.in);
        entrada.nextLine();
    }

    public static int pideValorEntero() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

}
