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

    public void actualizarPrecio(double precio) {
        this.precio = precio;
    }

    public void actualizarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void actualizarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
