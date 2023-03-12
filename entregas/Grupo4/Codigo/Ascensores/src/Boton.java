class Boton {
    private int nivel;
    private boolean presionado;

    public Boton(int nivel) {
        this.nivel = nivel;
        presionado = false;
    }

    public int getNivel() {
        return nivel;
    }

    public void presionar() {
        presionado = true;
    }

    public void soltar() {
        presionado = false;
    }

    public boolean estaPresionado() {
        return presionado;
    }
}