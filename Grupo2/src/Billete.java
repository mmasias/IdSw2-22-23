import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Billete extends Dinero {
    Billete(double valor, int cantidad) {
        super(valor, cantidad);
    }

    public static List<Billete> menu(Scanner scanner) {
        try {
            boolean salir = false;
            List<Billete> billetes = new ArrayList<Billete>();
            Scanner input = new Scanner(System.in);

            do {
                String option = "";
                System.out.println("-----------------------------------------------------");
                System.out.println("[1|si] Agregar billetes?");
                System.out.println("[2] Salir");
                System.out.println("----------------                   Elige una opcion: ");
                option = input.nextLine();

                if (option.equals("1"))
                    agregar(input, billetes);
                else if (option.equals("2")) {
                    System.out.println("Saliendo...");
                    salir = true;
                }
            } while (!salir);

            return billetes;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Billete> agregar(Scanner scanner, List<Billete> billetes) {
        try {
            System.out.println("=================================================================");
            System.out.println("Valor: ");
            double valor = scanner.nextDouble();
            System.out.println("Cantidad: ");
            int cantidad = scanner.nextInt();
            billetes.add(new Billete(valor, cantidad));
            System.out.println("=================================================================");
            return billetes;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
