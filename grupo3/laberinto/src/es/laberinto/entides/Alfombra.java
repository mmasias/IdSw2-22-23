package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.utils.Posicion;

public final class Alfombra extends Entidad {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return true;
    }

    public static Alfombra crear(Posicion posicion) {
        Alfombra alfombra = new Alfombra();
        alfombra.setPosicion(posicion);

        return alfombra;
    }
}
