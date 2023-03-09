package es.laberinto.bloques;

import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;

import java.util.List;

public final class CespedBajo extends Bloque {
    @Override
    public String tipo() {
        return "cespedBajo";
    }

    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public List<Class<? extends Entidad>> transitableCon() {
        return List.of(Personaje.class);
    }
}
