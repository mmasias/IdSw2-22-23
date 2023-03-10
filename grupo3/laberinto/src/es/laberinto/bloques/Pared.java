package es.laberinto.bloques;

import es.laberinto.entides.Entidad;

import java.util.List;

public final class Pared extends Bloque {
    @Override
    public String tipo() {
        return "Pared";
    }

    @Override
    public double velocidad() {
        return 0;
    }

    @Override
    public List<Class<? extends Entidad>> soloTransitableCon() {
        return null;
    }
}
