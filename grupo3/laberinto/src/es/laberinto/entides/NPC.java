package es.laberinto.entides;

import es.laberinto.Mundo;
import es.laberinto.utils.Direccion;
import es.laberinto.utils.Posicion;
import es.laberinto.utils.Vector;

import javax.swing.*;

public final class NPC extends Entidad implements SeMueveSolo {
    @Override
    public boolean puedeMontarseEnOtraEntidad() {
        return false;
    }

    @Override
    public boolean otraEntidadPuedeMontarse() {
        return false;
    }

    @Override
    public Vector getVectorMovimientoSolo(Entidad entidad) {
        return Direccion.aleatorio().getVector();
    }

    public static NPC crear(Posicion posicion) {
        NPC npc = new NPC();
        npc.setPosicion(posicion);
        return npc;
    }
}
