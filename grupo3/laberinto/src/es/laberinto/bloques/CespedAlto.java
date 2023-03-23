package es.laberinto.bloques;

import es.laberinto.entides.Caballo;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class CespedAlto extends Bloque {
    @Override
    public double velocidad() {
        return 2;
    }

    @Override
    public boolean puedeTransitar(Class<? extends Entidad> entidad) {
        return entidad == Caballo.class;
    }

    public static CespedAlto crear() {
        return new CespedAlto();
    }
}
