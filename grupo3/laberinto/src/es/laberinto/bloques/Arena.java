package es.laberinto.bloques;

import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;

import java.util.List;

public final class Arena extends Bloque{
    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public boolean puedeTransitar(Class<? extends Entidad> entidad) {
        return entidad == Personaje.class;
    }

    public static Arena crear() {
        return new Arena();
    }
}
