import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Maquina {
    public String nombre;
    public static List<Moneda> monedas;
    public static List<Billete> billetes;
    public static List<Producto> productos;
    static Scanner input = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);

    public Maquina(String nombre, List<Billete> billetes, List<Moneda> monedas, List<Producto> productos) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.billetes = billetes;
        this.productos = productos;
    }

    public Maquina() {
        this.nombre = "";
        this.monedas = new ArrayList<Moneda>();
        this.billetes = new ArrayList<Billete>();
        this.productos = new ArrayList<Producto>();
    }

    public int totalBilletes() {
        return this.billetes.size();
    }

    public int totalMonedas() {
        return this.monedas.size();
    }

    public int totalProductos() {
        return this.productos.size();
    }

    public static String cambio(double montoRecibido, double montoProducto) {
        double montoFaltante = montoProducto - montoRecibido;
        if (montoFaltante > 0) {
            return String.format("Falta $%.2f para completar la compra.", montoFaltante);
        } else if (montoFaltante < 0) {
            double montoSobrante = -montoFaltante;
            List<String> cambio = new ArrayList<String>();
            for (Billete billete : billetes) {
                if (billete.valor <= montoSobrante) {
                    int cantidad = (int) Math.floor(montoSobrante / billete.valor);
                    montoSobrante -= cantidad * billete.valor;
                    cambio.add(cantidad + "x $" + billete.valor);
                }
            }
            for (Moneda moneda : monedas) {
                if (moneda.valor <= montoSobrante) {
                    int cantidad = (int) Math.floor(montoSobrante / moneda.valor);
                    montoSobrante -= cantidad * moneda.valor;
                    cambio.add(cantidad + "x $" + moneda.valor);
                }
            }
            if (montoSobrante > 0) {
                return "No se puede dar cambio exacto. Devolviendo $" + (montoRecibido - montoProducto);
            } else {
                Collections.reverse(cambio);
                return String.join(", ", cambio);
            }
        } else {
            return "";
        }
    }

    public void compra() {
        System.out.println("Bienvenido");
        System.out.println("Seleccione un producto:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.nombre + " - $" + producto.precio);
        }
        int opcionProducto = scanner.nextInt();
        Producto productoSeleccionado = productos.get(opcionProducto - 1);
        System.out.println("Ha seleccionado " + productoSeleccionado.nombre + " por $" + productoSeleccionado.precio);
        
        System.out.println("Ingrese su dinero:");
        double dineroIngresado = scanner.nextDouble();
        
        while (dineroIngresado < productoSeleccionado.precio) {
            System.out.println("Dinero insuficiente. Ingrese más dinero:");
            dineroIngresado += scanner.nextDouble();
        }
        
        double cambio = dineroIngresado - productoSeleccionado.precio;
        String mensajeCambio = cambio(cambio, productoSeleccionado.precio);
        System.out.println("---------------------");
        System.out.println("Gracias por su compra. Aquí tiene su " + productoSeleccionado.nombre + ".");
        if (!mensajeCambio.isEmpty()) {
            System.out.println("Su cambio es: " + mensajeCambio);
        }

    }

}
