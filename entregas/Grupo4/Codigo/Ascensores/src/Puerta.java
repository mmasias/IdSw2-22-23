class Puerta {

    private Boton boton;
    private boolean abierta;

    public Puerta(Boton boton) {
        this.boton = boton;
        abierta = false;
    }

    public Boton getBoton() {
        return boton;
    }

    public void abrir() {
        abierta = true;
    }

    public void cerrar() {
        abierta = false;
    }

    public boolean isAbierta() {
        return abierta;
    }

}