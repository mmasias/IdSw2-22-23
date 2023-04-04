package es.laberinto.bloques;

import es.laberinto.entides.Barca;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class AguaTurbulenta extends Bloque {
    @Override
    public double velocidad() {
        return 2;
    }

    @Override
    public boolean puedeTransitar(Entidad entidad) {
        return entidad.getClass() == Barca.class;
    }

    public static AguaTurbulenta crear() {
        return new AguaTurbulenta();
    }
}
