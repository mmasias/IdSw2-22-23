package es.laberinto.entides;

import es.laberinto.Posicion;

public abstract class Entidad {
    private Posicion posicion;
    private double bufferMovimeinto;

    private Entidad entidadSobreLaQueEstoyMontado;
    private Entidad entidadMontadaSobreMi;

    public abstract boolean puedeMontarseEnOtraEntidad();
    public abstract boolean otraEntidadPuedeMontarse();
    public abstract double velocidadBase();
}
