package es.laberinto.bloques;

import es.laberinto.entides.Alfombra;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class Montana extends Bloque {
    @Override
    public String tipo() {
        return "BloqueMontana";
    }

    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public List<Class<? extends Entidad>> soloTransitableCon() {
        return List.of(Alfombra.class);
    }
}
