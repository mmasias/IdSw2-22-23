package es.laberinto.bloques;

import es.laberinto.entides.Entidad;

import java.util.List;

public final class Pared extends Bloque {
    @Override
    public double velocidad() {
        return 0;
    }

    @Override
    public boolean todasLasEntidadesPuedenTransitar() {
        return false;
    }

    @Override
    public List<Class<? extends Entidad>> soloTransitableCon() {
        return null;
    }
}
