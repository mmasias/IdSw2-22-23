package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.utils.Posicion;

public final class Caballo extends Entidad {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return true;
    }

    public static Caballo crear(Posicion posicion) {
        Caballo caballo = new Caballo();
        caballo.setPosicionActual(posicion);
        return caballo;
    }
}
