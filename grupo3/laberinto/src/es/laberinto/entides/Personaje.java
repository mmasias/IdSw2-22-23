package es.laberinto.entides;

import es.laberinto.entides.Entidad;

public final class Personaje extends Entidad {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return true;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return false;
    }
}
