import java.util.ArrayList;
import java.util.List;
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

    public static List<Producto> crearListaDeProductos() {
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("Galletas", 1.50, 10));
        productos.add(new Producto("Chocolates", 1.10, 10));
        productos.add(new Producto("Bebida", 1.05, 10));
        productos.add(new Producto("Bocadillo", 1.75, 10));
        return productos;
    }
}
