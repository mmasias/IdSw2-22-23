package es.laberinto.entides;

import es.laberinto.utils.Direccion;
import es.laberinto.Mundo;
import es.laberinto.utils.Posicion;
import es.laberinto.bloques.Bloque;
import es.laberinto.utils.Vector;
import lombok.Getter;

public abstract class Entidad {
    @Getter private final Mundo mundo;
    @Getter private Posicion posicionActual;
    @Getter private Entidad entidadSobreLaQueEstoyMontado;
    @Getter private Entidad entidadMontadaSobreMi;

    private double bufferMovimeintoAnteriorTurno;
    private Posicion posicionDondeQuiereMoverseAnteriorTurno;

    public abstract boolean puedeMontarseEnOtraEntidad();
    public abstract boolean otraEntidadPuedeMontarse();

    public Entidad(Mundo mundo) {
        this.mundo = mundo;
    }

    public boolean estaMontadoSobreEntidad() {
        return this.entidadSobreLaQueEstoyMontado != null;
    }

    public boolean otraEntidadEstaMontada() {
        return this.entidadMontadaSobreMi != null;
    }

    public void desmontarme() {
        if(this.entidadSobreLaQueEstoyMontado != null){
            this.entidadSobreLaQueEstoyMontado.entidadMontadaSobreMi = null;
            this.entidadSobreLaQueEstoyMontado = null;
        }
    }

    public void montarme(Entidad entidadAMontarme) {
        entidadAMontarme.entidadMontadaSobreMi = this;
        this.entidadSobreLaQueEstoyMontado = entidadAMontarme;
    }

    public void mover(Vector vectorDireccion) {
        Posicion nuevaPosicion = this.posicionActual.nuevaPosicionAPartirDe(vectorDireccion);

        if(!mePuedoMoverALaPosicion(nuevaPosicion))
            return;

        double velocidadSiguienteBloque = mundo.getBloque(nuevaPosicion).velocidad();
        if(velocidadSiguienteBloque >= 1){
            nuevaPosicion = posicionActual.nuevaPosicionAPartirDe(vectorDireccion.aumentarEn(velocidadSiguienteBloque));

            if(!mePuedoMoverALaPosicion(nuevaPosicion)) return;

            actualizarPosicion(nuevaPosicion);

            return;
        }

        if(!this.posicionActual.mismaPosicion(this.posicionDondeQuiereMoverseAnteriorTurno)) {
            this.bufferMovimeintoAnteriorTurno = 0;
        }

        this.bufferMovimeintoAnteriorTurno += velocidadSiguienteBloque;
        this.posicionDondeQuiereMoverseAnteriorTurno = nuevaPosicion;

        if(this.bufferMovimeintoAnteriorTurno >= 1){
            actualizarPosicion(nuevaPosicion);
        }
    }

    private void actualizarPosicion(Posicion nuevaPosicion) {
        this.posicionActual = nuevaPosicion;
        this.posicionDondeQuiereMoverseAnteriorTurno = null;
        this.bufferMovimeintoAnteriorTurno = 0;

        Entidad entidadEnLaNuevaPosicion = mundo.getEntidad(nuevaPosicion);
        if(entidadEnLaNuevaPosicion != null && entidadEnLaNuevaPosicion.mePuedoMontar()){
            montarme(entidadEnLaNuevaPosicion);
        }
    }

    private boolean mePuedoMoverALaPosicion(Posicion posicion) {
        if(mundo.posicionFueraDeLosLimites(posicion) || otraEntidadEstaMontada())
            return false;

        Bloque siguienteBloque = mundo.getBloque(posicion);
        if(!siguienteBloque.puedeTransitar(this))
            return false;

        Entidad entidadEnElBloqueDireccion = mundo.getEntidad(posicion);

        return !hayEntidadYNoSePuedeMontar(entidadEnElBloqueDireccion);
    }

    private boolean hayEntidadYNoSePuedeMontar(Entidad entidad) {
        return entidad != null && (
                        !entidad.otraEntidadPuedeMontarse() ||
                        entidad.otraEntidadEstaMontada() ||
                        entidad.estaMontadoSobreEntidad());
    }

    private boolean mePuedoMontar() {
        return this.otraEntidadPuedeMontarse() && !otraEntidadEstaMontada();
    }
}
