import java.util.List;
import java.util.Scanner;

public class Maquina {
    private String nombre;
    private static List<Moneda> monedas;
    private static List<Billete> billetes;
    private static List<Producto> productos;
    private Scanner scanner;

    public Maquina(String nombre, List<Billete> billetes, List<Moneda> monedas, List<Producto> productos) {
        this.nombre = nombre;
        this.monedas = monedas;
        this.billetes = billetes;
        this.productos = productos;
        this.scanner = new Scanner(System.in);
    }

    public void agregarBillete(Billete billete) {
        billetes.add(billete);
    }

    public void agregarMoneda(Moneda moneda) {
        monedas.add(moneda);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public String mostrarNombre() {
        return nombre;
    }

    public List<Billete> listaDeBilletes() {
        return billetes;
    }

    public List<Moneda> listaDeMonedas() {
        return monedas;
    }

    public List<Producto> listaDeProductos() {
        return productos;
    }

    public static String calcularCambio(double montoRecibido, double montoProducto) {
        double montoFaltante = montoProducto - montoRecibido;
        System.out.println("montoRecibido: " + montoRecibido);
        System.out.println("montoProducto: " + montoProducto);
        System.out.println("montoFaltante: " + montoFaltante);
        if (montoFaltante > 0) {
            return String.format("Falta $%.2f para completar la compra.", montoFaltante);
        } else if (montoFaltante < 0) {
            // double montoSobrante = -montoFaltante;
            String mensajeCambio = generarMensajeCambio(montoRecibido);
            if (mensajeCambio.equals("")) {
                return String.format("No se puede dar cambio exacto. Devolviendo $%.2f", montoRecibido - montoProducto);
            } else {
                return mensajeCambio;
            }
        } else {
            return "";
        }
    }
    
    private static String generarMensajeCambio(double monto) {
        System.out.println("montooo: " + monto);
        String mensaje = "";
        for (Billete billete : billetes) {
            if (billete.valor <= monto) {
                int cantidad = (int) Math.floor(monto / billete.valor);
                monto -= (cantidad * billete.valor);
                if (mensaje.equals("")) {
                    mensaje = cantidad + "x $" + billete.valor;
                } else {
                    mensaje += ", " + cantidad + "x $" + billete.valor;
                }
                if (monto == 0) {
                    return mensaje;
                }
            }
        }
        for (Moneda moneda : monedas) {
            if (moneda.valor <= monto) {
                int cantidad = (int) Math.floor(monto / moneda.valor);
                monto -= (cantidad * moneda.valor);
                if (mensaje.equals("")) {
                    mensaje = cantidad + "x $" + moneda.valor;
                } else {
                    mensaje += ", " + cantidad + "x $" + moneda.valor;
                }
                if (monto == 0) {
                    return mensaje;
                }
            }
        }
        return mensaje;
    }

    public void compra() {
        System.out.println("Bienvenido");
        mostrarProductos();
        Producto productoSeleccionado = seleccionarProducto();
        double dineroIngresado = ingresarDinero();
        while (dineroIngresado < productoSeleccionado.precio) {
            System.out.println("Dinero insuficiente. Ingrese más dinero:");
            dineroIngresado += scanner.nextDouble();
        }
        double cambio = dineroIngresado - productoSeleccionado.precio;
        String mensajeCambio = calcularCambio(cambio, productoSeleccionado.precio);
        imprimirTicket(productoSeleccionado, mensajeCambio);
    }
    
    private void mostrarProductos() {
        System.out.println("Seleccione un producto:");
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            System.out.println((i + 1) + ". " + producto.nombre + " - $" + producto.precio);
        }
    }
    
    private Producto seleccionarProducto() {
        System.out.println("Ingrese el número del producto que desea comprar:");
        int opcionProducto = scanner.nextInt();
        return productos.get(opcionProducto - 1);
    }
    
    private double ingresarDinero() {
        System.out.println("Ingrese su dinero:");
        return scanner.nextDouble();
    }
    
    private void imprimirTicket(Producto producto, String mensajeCambio) {
        System.out.println("---------------------");
        System.out.println("Gracias por su compra. Aquí tiene su " + producto.nombre + ".");
        if (!mensajeCambio.isEmpty()) {
            System.out.println("Su cambio es: " + mensajeCambio);
        }
    }

}
