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
import java.util.Scanner;

public final class Mundo {
    private final RenderizadorMundo renderizadorMundo;
    private final Scanner scanner;
    private int tiempoTranscurrido;
    public final Bloque[][] bloques;
    public final List<Entidad> entidades;
    public Personaje personaje;

    public Mundo(List<Entidad> entidades, Bloque[][] bloques, RenderizadorMundo renderizadorMundo) {
        this.entidades = entidades;
        this.bloques = bloques;
        this.scanner = new Scanner(System.in);
        this.renderizadorMundo = new RenderizadorMundo();
        this.personaje = this.getPersonaje(entidades);
    }

    public void iniciar() {
        while(true){
            leerInputUsuarioYAplicar();
            tick();
            renderizadorMundo.renderizar(this);
        }
    }

    private void leerInputUsuarioYAplicar() {
        switch (this.scanner.next()) {
            case "w" -> moverPersonaje(Direccion.ARRIBA);
            case "a" -> moverPersonaje(Direccion.IZQUIERDA);
            case "d" -> moverPersonaje(Direccion.DERECHA);
            case "s" -> moverPersonaje(Direccion.ABAJO);
            case "r" -> desmontarse();
            case "e" -> System.exit(1);
        }
    }

    public Personaje getPersonaje(List<Entidad> entidades) {
        for (Entidad entidad : entidades) {
            if(entidad instanceof Personaje personaje) {
                return personaje;
            }
        }

        return null;
    }

    public void insertarBloques(Bloque[][] bloquesInsertar) {
        for(int i = 0; i < bloquesInsertar.length; i++){
            for(int j = 0; j < bloquesInsertar[i].length; j++){
                this.bloques[i][j] = bloquesInsertar[i][j];
            }
        }
    }

    public void moverPersonaje(Direccion direccion) {
        this.personaje.mover(this, direccion.getVector());
    }

    public void desmontarse() {
        this.personaje.desmontarme();
    }

    public Bloque getBloque(Posicion posicion) {
        return this.bloques[posicion.y()][posicion.x()];
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
               posicion.y() + 1 > this.getLargo() ||
               posicion.x() + 1 > this.getAncho();
    }

    public void tick() {
        this.tiempoTranscurrido++;
        this.actualizarEntidades();
    }

    private void actualizarEntidades() {
        for(Entidad entidad : this.entidades){
            if(!(entidad instanceof SeMueveSolo seMueveSoloEntidad) || entidad.otraEntidadEstaMontada())
                continue;

            Vector vectorMovimientoSolo = seMueveSoloEntidad.getVectorMovimientoSolo(entidad);
            entidad.mover(this, vectorMovimientoSolo);
        }
    }

    public int getAncho() {
        return this.bloques[0].length;
    }

    public int getLargo() {
        return this.bloques.length;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }
}
