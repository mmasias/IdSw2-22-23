package es.laberinto.utils;

public enum Direccion {
    ARRIBA(Vector.crear(0, 1)),
    ABAJO(Vector.crear(0, -1)),
    IZQUIERDA(Vector.crear(-1, 0)),
    DERECHA(Vector.crear(1, 0));

    private final Vector vector;

    Direccion(Vector vector) {
        this.vector = vector;
    }

    public Vector getVector() {
        return new Vector(this.vector.x(), this.vector.y());
    }

    public Vector aumentarEn(double aumentar) {
        return new Vector((int) (cambioX() * aumentar), (int) (cambioY() * aumentar));
    }

    public int cambioX() {
        return this.vector.x();
    }

    public int cambioY() {
        return this.vector.y();
    }
}
