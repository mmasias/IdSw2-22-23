public class Producto {
    String nombre;
    double precio;

    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void actualizarPrecio(double newPrecio){
        precio = newPrecio;
    }

    public void actualizarNombre(String newNombre){
        nombre = newNombre;
    }
}
