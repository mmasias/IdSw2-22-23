import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Moneda extends Dinero {
    Moneda(double valor, int cantidad) {
        super(valor, cantidad);
    }

    public static List<Moneda> menu(Scanner scanner) {
        try {
            boolean salir = false;
            List<Moneda> monedas = new ArrayList<Moneda>();
            Scanner input = new Scanner(System.in);

            do {
                String option = "";
                System.out.println("-----------------------------------------------------");
                System.out.println("[1|si] Agregar monedas?");
                System.out.println("[2] Salir");
                System.out.println("----------------                   Elige una opcion: ");
                option = input.nextLine();

                if (option.equals("1"))
                    agregar(input, monedas);
                else if (option.equals("2")) {
                    System.out.println("Saliendo...");
                    salir = true;
                }
            } while (!salir);

            return monedas;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Moneda> agregar(Scanner scanner, List<Moneda> monedas) {
        try {
            System.out.println("=================================================================");
            System.out.println("Valor: ");
            double valor = scanner.nextDouble();
            System.out.println("Cantidad: ");
            int cantidad = scanner.nextInt();
            monedas.add(new Moneda(valor, cantidad));
            System.out.println("=================================================================");
            return monedas;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
