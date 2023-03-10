package es.laberinto.bloques;

import es.laberinto.entides.Barca;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class Agua extends Bloque {
    @Override
    public String tipo() {
        return "Agua";
    }

    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public List<Class<? extends Entidad>> soloTransitableCon() {
        return List.of(Barca.class);
    }
}
