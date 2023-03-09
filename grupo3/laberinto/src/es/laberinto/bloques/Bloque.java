package es.laberinto.bloques;

import es.laberinto.Posicion;
import es.laberinto.entides.Entidad;

import java.util.List;

public abstract class Bloque {
    private Posicion posicion;

    public abstract String tipo();
    public abstract double velocidad();
    public abstract List<Class<? extends Entidad>> transitableCon();
}
