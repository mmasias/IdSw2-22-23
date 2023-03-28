import java.util.List;
import java.util.Scanner;

public class Maquina {
    static Scanner input = new Scanner(System.in);
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

    public static void menuCompra() {
        boolean salir = false;

        do{
            String option = "";
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("[1] Comprar");
            System.out.println("[2] Salir");
            System.out.println("----------------   Elige una opcion: ");
            option = input.nextLine();

            if(option.equals("1"))
                System.out.println();
            else if(option.equals("2")){
                System.out.println("Saliendo...");
                salir = true;
            }
        }while(!salir);
    }
}
