package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.utils.Posicion;

public final class Barca extends Entidad {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return true;
    }

    public static Barca crear(Posicion posicion) {
        Barca barca = new Barca();
        barca.setPosicionActual(posicion);

        return barca;
    }
}
