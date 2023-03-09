package es.laberinto;

public enum Direccion {
    ARRIBA(0, 1),
    ABAJO(0, -1),
    IZQUIERDA(-1, 0),
    DERECHA(1, 0);

    public final int cambioX;
    public final int cambioY;

    Direccion(int cambioX, int cambioY) {
        this.cambioX = cambioX;
        this.cambioY = cambioY;
    }
}
