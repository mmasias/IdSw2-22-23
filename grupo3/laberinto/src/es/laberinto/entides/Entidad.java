package es.laberinto.entides;

import es.laberinto.Direccion;
import es.laberinto.Mundo;
import es.laberinto.Posicion;
import es.laberinto.bloques.Bloque;

public abstract class Entidad {
    private Posicion posicion;
    private double bufferMovimeinto;

    private Entidad entidadSobreLaQueEstoyMontado;
    private Entidad entidadMontadaSobreMi;

    public abstract boolean puedeMontarseEnOtraEntidad();
    public abstract boolean otraEntidadPuedeMontarse();
    public abstract double velocidadBase();
    public Posicion getPosicion() {
        return posicion;
    }

    public boolean estaMontadoSobreEntidad() {
        return this.entidadSobreLaQueEstoyMontado != null;
    }

    public void mover(Mundo mundo, Direccion direccion) {
        Posicion nuevaPosicion = personaje.getPosicion().nuevaPosicionAPartirDe(direccion);
        boolean esLaNuevaposicionValido = esValido(nuevaPosicion, personaje);

        if(!esLaNuevaposicionValido){
            return;
        }

        Bloque bloqueNuevaPosicion = getBloque(nuevaPosicion);

    }
}
