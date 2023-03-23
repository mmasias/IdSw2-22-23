package es.laberinto.bloques;

import es.laberinto.entides.Barca;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class Agua extends Bloque {
    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public boolean puedeTransitar(Class<? extends Entidad> entidad) {
        return entidad == Barca.class;
    }

    public static Agua crear() {
        return new Agua();
    }
}
