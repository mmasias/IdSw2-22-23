package es.laberinto;

import es.laberinto.bloques.Bloque;
import es.laberinto.entides.Entidad;
import es.laberinto.entides.Personaje;

import java.util.List;

public final class Mundo {
    private int tiempoTranscurrido;
    private Bloque[][] bloques;
    private List<Entidad> entidades;
    private Personaje personaje;

    public void moverPersonaje(Direccion direccion) {
        keyboardlistener(){
            onevent(keydown:uparr){
                ejecutasrturno()
                personaje.mover(x,y)
            }
        }
        personaje.mover(bloqueNuevaPosicion);
    }

    private Bloque getBloque(Posicion posicion) {
        return null;
    }

    public boolean esValido(Posicion posicion, Entidad entidad) {
        return false;
    }

    public void desmontarse() {
    }

    private void actualizarEntidades() {
    }
}
