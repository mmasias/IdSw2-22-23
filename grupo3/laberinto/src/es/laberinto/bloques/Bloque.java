package es.laberinto.bloques;

import es.laberinto.utils.Posicion;
import es.laberinto.entides.Entidad;

import java.util.List;

public abstract class Bloque {
    private Posicion posicion;

    public abstract String tipo();
    public abstract double velocidad();

    public abstract boolean todasLasEntidadesPuedenPasar();
    public abstract List<Class<? extends Entidad>> soloTransitableCon();

    //TODO Puede que esto vaya en Mundo
    public boolean puedeTranspasar(Entidad entidad) {
        return this.todasLasEntidadesPuedenPasar()
                || soloTransitableCon().stream().anyMatch(it -> it.equals(entidad.getClass()))
                || soloTransitableCon().stream().anyMatch(it -> it.equals(entidad.getEntidadSobreLaQueEstoyMontado().getClass()));
    }
}
