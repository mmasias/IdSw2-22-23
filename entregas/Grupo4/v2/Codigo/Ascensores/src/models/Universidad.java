package models;

import settings.Settings;
import controllers.Movimiento;
import interfaces.IMovible;

import java.util.*;

public class Universidad implements IMovible {
    private ArrayList<Planta> plantas;
    private Map<Integer, Ascensor> ascensores;
    public Universidad() {
        plantas = new ArrayList<>();
        ascensores = new HashMap<>();
        this.crearPlantas();
    }
    public ArrayList<Planta> getPlantas() {
        return plantas;
    }
    public Map<Integer,Ascensor> getAscensores() {
        return ascensores;
    }

    private void crearPlantas() {
        for (int i = Settings.NIVEL_SUPERIOR; i >= Settings.NIVEL_INFERIOR; i--) {
            Planta nuevaPlanta = new Planta(i);
            configurarAscensores(plantas);
            plantas.add(nuevaPlanta);
        }
    }
    void configurarAscensores(ArrayList<Planta> plantas) {
        for (int i = 0; i < Settings.TOTAL_ASCENSORES; i++) {
            ascensores.put(i, new Ascensor(i,plantas));
        }
    }
    private boolean llegoUnaPersona() {
        if (Math.random() < Settings.PROBABILIDAD_LLEGADA_PERSONA) {
            return true;
        } else {
            return false;
        }
    }
    public void mover() {
        ArrayList<Ascensor> ascensores = new ArrayList<>(this.ascensores.values());
        for (Ascensor ascensor : ascensores) {
            Movimiento.mover(ascensor);
        }
        for (Planta planta : plantas) {
            if (planta.getNivel() == Settings.PLANTA_PRINCIPAL) {
                if (llegoUnaPersona())
                    planta.agregarPersona(new Persona());
            }
            Movimiento.mover(planta);
            planta.llamadaAscensorMasCercano(ascensores);
        }
    }
}
