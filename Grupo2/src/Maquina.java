public class Maquina {
    String nombre;
    Dinero[] dinero;
    Producto[] productos;

    Maquina(String nombre, Dinero[] dinero, Producto[] productos) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.productos = productos;
    }

    Maquina() {
        this.nombre = "";
        this.dinero = null;
        this.productos = null;
    }

    public int totalDinero() {
        return this.dinero.length;
    }

    public int totalProductos() {
        return this.productos.length;
    }
}
