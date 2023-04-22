package models;

import structures.enums.EstadoAscensor;

import java.util.ArrayList;

public class Planta implements Comparable<Planta> {
    private int nivel;
    private ArrayList<Persona> personasEnPlanta;

    public Planta(int nivel) {
        this.nivel = nivel;
        this.personasEnPlanta = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        personasEnPlanta.add(persona);
    }
    public void eliminarPersona(Persona persona) {
        personasEnPlanta.remove(persona);
    }
    public void subirAAscensor(Ascensor ascensor) {
        for (Persona persona : getPersonasEsperandoAscensor()) {
            if (!ascensor.estaLleno()) {
                persona.entrarAscensor();
                ascensor.agregarPersona(persona);
                eliminarPersona(persona);
            }
        }
    }

    public void mover(){
        for (Persona persona : personasEnPlanta) {
            persona.mover();
        }
    }

    public void llamadaAscensorMasCercano(ArrayList<Ascensor> ascensores) {
        Ascensor ascensorMasCercano = null;
        if (getPersonasEsperandoAscensor().size() > 0) {
            for (Ascensor ascensor : ascensores) {
                if (ascensor.estaVacio()) {
                    if (ascensorMasCercano == null) {
                        ascensorMasCercano = ascensor;
                    } else {
                        if (Math.abs(ascensor.getPlantaActual().getNivel() - nivel) < Math.abs(ascensorMasCercano.getPlantaActual().getNivel() - nivel)) {
                            ascensorMasCercano = ascensor;
                        }
                    }
                }
            }
        }
        if (ascensorMasCercano != null) {
            ascensorMasCercano.llamar(this);
        }
    }
    public int getNivel() {
        return nivel;
    }
    public ArrayList<Persona> getPersonasEnPlanta() {
        return personasEnPlanta;
    }

    public ArrayList<Persona> getPersonasEsperandoAscensor() {
        ArrayList<Persona> personasEsperandoAscensor = new ArrayList<>();
        for (Persona persona : personasEnPlanta) {
            if (persona.estaEsperandoAscensor()) {
                personasEsperandoAscensor.add(persona);
            }
        }
        return personasEsperandoAscensor;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int compareTo(Planta o) {
        return nivel - o.getNivel();
    }

}