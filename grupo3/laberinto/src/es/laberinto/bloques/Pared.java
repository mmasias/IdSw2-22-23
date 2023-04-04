package es.laberinto.bloques;

import es.laberinto.entides.Entidad;

import java.util.Collections;
import java.util.List;

public final class Pared extends Bloque {
    @Override
    public double velocidad() {
        return 0;
    }

    @Override
    public boolean puedeTransitar(Entidad entidad) {
        return false;
    }

    public static Pared crear() {
        return new Pared();
    }
}
