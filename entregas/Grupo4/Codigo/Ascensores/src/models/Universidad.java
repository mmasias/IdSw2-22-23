package models;

import constants.Constans;

import java.util.*;

public class Universidad {
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
        for (int i = Constans.NIVEL_SUPERIOR; i >= Constans.NIVEL_INFERIOR; i--) {
            Planta nuevaPlanta = new Planta(i);
            configurarAscensores(plantas);
            plantas.add(nuevaPlanta);
        }
    }

    void configurarAscensores(ArrayList<Planta> plantas) {
        for (int i = 0; i < Constans.TOTAL_ASCENSORES; i++) {
            ascensores.put(i, new Ascensor(i,plantas));
        }
    }

    private boolean llegoUnaPersona() {
        if (Math.random() < .5) {
            return true;
        } else {
            return false;
        }
    }

    public void mover() {
        ArrayList<Ascensor> ascensores = new ArrayList<>(this.ascensores.values());
        for (Ascensor ascensor : ascensores) {
            ascensor.mover();
        }
        for (Planta planta : plantas) {
            if (planta.getNivel() == Constans.PLANTA_PRINCIPAL) {
                if (llegoUnaPersona())
                    planta.agregarPersona(new Persona());
            }
            planta.mover();
            planta.llamadaAscensorMasCercano(ascensores);
        }
    }
}
