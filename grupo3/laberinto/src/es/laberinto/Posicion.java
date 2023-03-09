package es.laberinto;

public record Posicion(int x, int y) {
    public Posicion nuevaPosicionAPartirDe(Direccion direccion) {
        return new Posicion(x + direccion.cambioX, y + direccion.cambioY);
    }
}
