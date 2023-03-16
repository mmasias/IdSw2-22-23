import java.util.List;

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
}
