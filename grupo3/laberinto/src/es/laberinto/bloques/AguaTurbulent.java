package es.laberinto.bloques;

import es.laberinto.entides.Barca;
import es.laberinto.entides.Entidad;

import java.util.List;

public final class AguaTurbulent extends Bloque {
    @Override
    public String tipo() {
        return "AguasTurbulentas";
    }

    @Override
    public double velocidad() {
        return 2;
    }

    @Override
    public List<Class<? extends Entidad>> transitableCon() {
        return List.of(Barca.class);
    }
}
