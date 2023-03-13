public class Compra {
    String descripcion;
    String fechaDeCompra;
    
    Compra(String descripcion, String fechaDeCompra) {
        this.descripcion = descripcion;
        this.fechaDeCompra = fechaDeCompra;
    }

    void realizarCompra(double coste, double pago) {
        

        double cambio = this.pago - this.coste;
        return this.cambio;
    }
}
