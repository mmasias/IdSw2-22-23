package es.laberinto;

import es.laberinto.bloques.Bloque;
import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;
import es.laberinto.utils.Direccion;
import es.laberinto.utils.Posicion;

import java.util.List;

public final class Mundo {
    private static final Mundo instance = new Mundo();
    public static Mundo getInstance() {
        return instance;
    }

    private int tiempoTranscurrido;
    private Bloque[][] bloques;
    private List<Entidad> entidades;
    private Personaje personaje;

    public void moverPersonaje(Direccion direccion) {
        this.personaje.mover(this, direccion);
    }

    public Bloque getBloque(Posicion posicion) {
        return null;
    }

    public Entidad getEntidad(Posicion posicion) {
        return null;
    }

    public boolean posicionFueraDeLosLimites(Posicion posicion) {
        return false;
    }

    public void desmontarse() {
    }

    private void actualizarEntidades() {
    }
}
