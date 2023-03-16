package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.entides.Entidad;
import es.laberinto.utils.Posicion;

public final class Personaje extends Entidad {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return true;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return false;
    }

    public static Personaje crear(Posicion posicion) {
        Personaje personaje = new Personaje();
        personaje.setPosicionActual(posicion);

        return personaje;
    }
}
