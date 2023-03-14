import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maquina {
    String nombre;
    List<Billete> billetes;
    List<Moneda> monedas;
    List<Producto> productos;

    Maquina(String nombre, List<Billete> billetes, List<Moneda> monedas, List<Producto> productos) {
        this.nombre = nombre;
        this.billetes = billetes;
        this.monedas = monedas;
        this.productos = productos;
    }

    public int totalBilletes() {
        return (this.billetes.size());
    }

    public int totalMonedas() {
        return this.monedas.size();
    }

    public int totalProductos() {
        return this.productos.size();
    }

    public static List<Maquina> menuMaquinas(Scanner scanner) {
        try {
            boolean salir = false;
            List<Maquina> maquinas = new ArrayList<Maquina>();
            Scanner input = new Scanner(System.in);

            do {
                String option = "";
                System.out.println("-----------------------------------------------------");
                System.out.println("[1|si] Agregar maquinas?");
                System.out.println("[2] Salir");
                System.out.println("----------------                   Elige una opcion: ");
                option = input.nextLine();

                if (option.equals("1"))
                    agregarMaquinas(input, maquinas);
                else if (option.equals("2")) {
                    System.out.println("Saliendo...");
                    salir = true;
                }
            } while (!salir);

            return maquinas;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Maquina> agregarMaquinas(Scanner scanner, List<Maquina> maquinas) {
        try {
            System.out.println("=================================================================");
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Billetes: ");
            List<Billete> billetes = Billete.menu(scanner);
            System.out.println("Monedas: ");
            List<Moneda> monedas = Moneda.menu(scanner);
            System.out.println("Productos: ");
            List<Producto> productos = Producto.menu(scanner);
            maquinas.add(new Maquina(nombre, billetes, monedas, productos));
            System.out.println("=================================================================");

            return maquinas;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
