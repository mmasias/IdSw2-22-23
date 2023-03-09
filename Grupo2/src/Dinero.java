public abstract class  Dinero {
    double valor;

    Dinero(double valor) {
        this.valor = valor;
    }

    void actualizarPrecio(double valor) {
        this.valor = valor;
    }
}
