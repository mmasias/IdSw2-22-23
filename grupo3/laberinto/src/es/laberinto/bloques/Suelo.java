package es.laberinto.bloques;

import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;

import java.util.Collections;
import java.util.List;

public final class Suelo extends Bloque {
    @Override
    public double velocidad() {
        return 1;
    }

    @Override
    public boolean puedeTransitar(Class<? extends Entidad> entidad) {
        return true;
    }

    public static Suelo crear(){
        return new Suelo();
    }
}
