package es.laberinto.bloques;

import es.laberinto.entides.Alfombra;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class Montana extends Bloque {
    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public boolean puedeTransitar(Class<? extends Entidad> entidad) {
        return entidad == Alfombra.class;
    }

    public static Montana crear() {
        return new Montana();
    }
}
