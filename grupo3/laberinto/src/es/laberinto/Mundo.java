package es.laberinto;

import es.laberinto.bloques.Bloque;
import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;
import es.laberinto.utils.Direccion;
import es.laberinto.utils.Posicion;
import lombok.Getter;

import java.util.List;

public final class Mundo {
    private int tiempoTranscurrido;
    private Bloque[][] bloques;
    private List<Entidad> entidades;
    private Personaje personaje;

    public void moverPersonaje(Direccion direccion) {
        this.personaje.mover(this, direccion);
    }

    public void desmontarse() {
        this.personaje.desmontarme();
    }

    public Bloque getBloque(Posicion posicion) {
        return this.bloques[posicion.x()][posicion.y()];
    }

    public Entidad getEntidad(Posicion posicion) {
        return this.entidades.stream()
                .filter(it -> it.getPosicionActual().mismaPosicion(posicion))
                .findFirst()
                .orElse(null);
    }

    public boolean posicionFueraDeLosLimites(Posicion posicion) {
        return posicion.x() < 0 ||
               posicion.y() < 0 ||
               posicion.x() + 1 > this.getLargo() ||
               posicion.y() + 1 > this.getAncho();
    }

    public void tick() {

    }

    private int getAncho() {
        return this.bloques[0].length;
    }

    private int getLargo() {
        return this.bloques.length;
    }
}
