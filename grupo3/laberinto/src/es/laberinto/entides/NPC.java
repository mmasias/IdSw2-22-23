package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.Posicion;

public final class NPC extends Entidad implements SeMueveSolo {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return false;
    }

    @Override
    public Posicion mover(Mundo mundo) {
        return null;
    }
}
