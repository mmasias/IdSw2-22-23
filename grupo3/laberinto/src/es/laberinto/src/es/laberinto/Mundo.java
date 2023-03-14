package es.laberinto;

import es.laberinto.bloques.Bloque;
import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;
import es.laberinto.entides.SeMueveSolo;
import es.laberinto.utils.Direccion;
import es.laberinto.utils.Posicion;
import es.laberinto.utils.Vector;

import java.util.LinkedList;
import java.util.List;

public final class Mundo {
    private int tiempoTranscurrido;
    public final Bloque[][] bloques;
    public final List<Entidad> entidades;
    public final Personaje personaje;

    public Mundo(int ancho, int largo, int xPersonaje, int yPersonaje) {
        this.bloques = new Bloque[ancho][largo];
        this.entidades = new LinkedList<>();

        this.personaje = new Personaje(this);
        this.personaje.setPosicionActual(new Posicion(xPersonaje, yPersonaje));
    }

    public void insertarEntidades(List<Entidad> entidades) {
        this.entidades.addAll(entidades);
    }

    public void insertarBloques(Bloque[][] bloquesInsertar) {
        for(int i = 0; i < bloquesInsertar.length; i++){
            for(int j = 0; j < bloquesInsertar.length; j++){
                this.bloques[i][j] = bloquesInsertar[i][j];
            }
        }
    }

    public void moverPersonaje(Direccion direccion) {
        this.personaje.mover(direccion.getVector());
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
        this.tiempoTranscurrido++;
        this.actualizarEntidades();
    }

    private void actualizarEntidades() {
        for(Entidad entidad : this.entidades){
            if(!(entidad instanceof SeMueveSolo seMueveSoloEntidad)
                    || entidad.otraEntidadEstaMontada())
                continue;

            Vector vectorMovimientoSolo = seMueveSoloEntidad.getVectorMovimientoSolo(entidad);
            entidad.mover(vectorMovimientoSolo);
        }
    }

    public int getAncho() {
        return this.bloques[0].length;
    }

    public int getLargo() {
        return this.bloques.length;
    }
}
