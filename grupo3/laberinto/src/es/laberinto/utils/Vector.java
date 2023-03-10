package es.laberinto.utils;

public record Vector(int x, int y) {
    public Vector aumentarSoloEnDireccion(Direccion direccion, int aumentar) {
        return new Vector(x + direccion.cambioX() * aumentar, y + direccion.cambioY() * aumentar);
    }

    public static Vector crear(int x, int y) {
        return new Vector(x, y);
    }
}
