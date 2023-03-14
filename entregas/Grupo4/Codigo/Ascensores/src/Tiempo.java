class Tiempo {
    private int contador;
    private int estancia;

    public Tiempo(int estancia) {
        this.estancia = estancia;
        contador = 0;
    }

    public void incrementar() {
        contador++;
    }

    public boolean haPasado() {
        return contador >= estancia;
    }

}