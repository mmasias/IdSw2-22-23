package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.entides.Entidad;

public final class Personaje extends Entidad {
    public Personaje(Mundo mundo) {
        super(mundo);
    }

    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return true;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return false;
    }
}
