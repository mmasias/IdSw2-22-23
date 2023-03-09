package es.laberinto.bloques;

import es.laberinto.entides.Caballo;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class CespedAlto extends Bloque {
    @Override
    public String tipo() {
        return "CespedAlto";
    }

    @Override
    public double velocidad() {
        return 2;
    }

    @Override
    public List<Class<? extends Entidad>> transitableCon() {
        return List.of(Caballo.class);
    }
}
