public class Maquina {
    String nombre;
    Billete[] billetes;
    Moneda[] monedas;
    Producto[] productos;

    Maquina(String nombre, Billete[] billetes, Moneda[] monedas, Producto[] productos) {
        this.nombre = nombre;
        this.billetes = billetes;
        this.monedas = monedas;
        this.productos = productos;
    }

    public int totalBilletes() {
        return (this.billetes.length);
    }

    public int totalMonedas() {
        return this.monedas.length;
    }

    public int totalProductos() {
        return this.productos.length;
    }
}
