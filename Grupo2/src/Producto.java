import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producto {
    String nombre;
    double precio;
    int cantidad;

    Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public void actualizarPrecio(double newPrecio) {
        this.precio = newPrecio;
    }

    public void actualizarNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public void actualizarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static List<Producto> menu(Scanner scanner) {
        try {
            boolean salir = false;
            List<Producto> productos = new ArrayList<Producto>();
            Scanner input = new Scanner(System.in);

            do {
                String option = "";
                System.out.println("-----------------------------------------------------");
                System.out.println("[1|si] Agregar productos?");
                System.out.println("[2] Salir");
                System.out.println("----------------                   Elige una opcion: ");
                option = input.nextLine();

                if (option.equals("1"))
                    agregar(input, productos);
                else if (option.equals("2")) {
                    System.out.println("Saliendo...");
                    salir = true;
                }
            } while (!salir);

            return productos;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    public static List<Producto> agregar(Scanner scanner, List<Producto> productos) {
        try {
            System.out.println("=================================================================");
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Precio: ");
            double precio = scanner.nextDouble();
            System.out.println("Cantidad: ");
            int cantidad = scanner.nextInt();
            productos.add(new Producto(nombre, precio, cantidad));
            System.out.println("=================================================================");
            return productos;
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
