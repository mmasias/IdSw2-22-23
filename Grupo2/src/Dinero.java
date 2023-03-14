public abstract class  Dinero {
    double valor;
    int cantidad;

    Dinero(double valor, int cantidad) {
        this.valor = valor;
        this.cantidad = cantidad;
    }

    void actualizarPrecio(double valor) {
        this.valor = valor;
    }

    void actualizarCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
