package es.laberinto.bloques;

import es.laberinto.utils.Posicion;
import es.laberinto.entides.Entidad;

import java.util.List;

public abstract class Bloque {
    public abstract double velocidad();

    public abstract boolean puedeTransitar(Class<? extends Entidad> entidad);
}
