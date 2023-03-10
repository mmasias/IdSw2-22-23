package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.utils.Posicion;

public final class NPC extends Entidad {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return false;
    }
}
