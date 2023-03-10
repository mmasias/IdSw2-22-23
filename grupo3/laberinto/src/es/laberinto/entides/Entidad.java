package es.laberinto.entides;

import es.laberinto.utils.Direccion;
import es.laberinto.Mundo;
import es.laberinto.utils.Posicion;
import es.laberinto.bloques.Bloque;
import es.laberinto.utils.Vector;

public abstract class Entidad {
    private Posicion posicionActual;

    private double bufferMovimeintoAnteriorTurno;
    private Posicion posicionDondeQuiereMoverseAnteriorTurno;

    private Entidad entidadSobreLaQueEstoyMontado;
    private Entidad entidadMontadaSobreMi;

    public abstract boolean puedeMontarseEnOtraEntidad();
    public abstract boolean otraEntidadPuedeMontarse();

    public Posicion getPosicionActual() {
        return posicionActual;
    }

    public Entidad getEntidadMontadaSobreMi() {
        return entidadMontadaSobreMi;
    }

    public Entidad getEntidadSobreLaQueEstoyMontado() {
        return entidadSobreLaQueEstoyMontado;
    }

    public boolean estaMontadoSobreEntidad() {
        return this.entidadSobreLaQueEstoyMontado != null;
    }

    public boolean otraEntidadEstaMontadaSobreMi() {
        return this.entidadMontadaSobreMi != null;
    }

    public void mover(Mundo mundo, Direccion direccion) {
        Vector vectorDireccion = direccion.getVector();
        Posicion nuevaPosicion = this.posicionActual.nuevaPosicionAPartirDe(vectorDireccion);

        if(!mePuedoMoverA(mundo, nuevaPosicion))
            return;

        double velocidadSiguienteBloque = mundo.getBloque(nuevaPosicion).velocidad();
        if(velocidadSiguienteBloque >= 1){
            nuevaPosicion = posicionActual.nuevaPosicionAPartirDe(direccion.aumentarEn(velocidadSiguienteBloque));

            if(!mePuedoMoverA(mundo, nuevaPosicion)) return;

            this.posicionActual = nuevaPosicion;
            this.bufferMovimeintoAnteriorTurno = 0;
            return;
        }

        if(!this.posicionActual.mismaPosicion(this.posicionDondeQuiereMoverseAnteriorTurno)) {
            this.posicionDondeQuiereMoverseAnteriorTurno = null;
            this.bufferMovimeintoAnteriorTurno = 0;
        }

        this.bufferMovimeintoAnteriorTurno += velocidadSiguienteBloque;
        this.posicionDondeQuiereMoverseAnteriorTurno = nuevaPosicion;

        if(this.bufferMovimeintoAnteriorTurno >= 1){
            this.posicionActual = nuevaPosicion;
            this.posicionDondeQuiereMoverseAnteriorTurno = null;
            this.bufferMovimeintoAnteriorTurno = 0;
        }
    }

    private boolean mePuedoMoverA(Mundo mundo, Posicion posicion) {
        if(mundo.posicionFueraDeLosLimites(posicion) || otraEntidadEstaMontadaSobreMi())
            return false;

        Bloque siguienteBloque = mundo.getBloque(posicion);
        if(!siguienteBloque.puedeTranspasar(this))
            return false;

        Entidad entidadEnElBloqueDireccion = mundo.getEntidad(posicion);
        if(hayEntidadYNoSePuedeMontar(entidadEnElBloqueDireccion))
            return false;

        return true;
    }

    private boolean hayEntidadYNoSePuedeMontar(Entidad entidad) {
        return entidad != null && (
                        !entidad.otraEntidadPuedeMontarse() ||
                        entidad.otraEntidadEstaMontadaSobreMi() ||
                        entidad.estaMontadoSobreEntidad());
    }
}
