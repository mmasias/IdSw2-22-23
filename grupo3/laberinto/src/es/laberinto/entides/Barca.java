package es.laberinto.entides;

import es.laberinto.Mundo;

public final class Barca extends Entidad {
    public Barca(Mundo mundo) {
        super(mundo);
    }

    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return true;
    }
}
