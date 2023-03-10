package es.laberinto.utils;

public record Posicion(int x, int y) {
    public Posicion nuevaPosicionAPartirDe(Vector vector) {
        return new Posicion(x + vector.x(), y + vector.y());
    }

    public boolean mismaPosicion(Posicion posicion) {
        return posicion != null && posicion.x == this.x && posicion.y == this.y;
    }
}
