package models;

import constants.Constans;
import structures.enums.EstadoAscensor;

import java.util.ArrayList;

public class Planta implements Comparable<Planta> {
    private int nivel;
    private ArrayList<Persona> personasEnPlanta;
    private SalaEspera salaEspera;
    public Planta(int nivel) {
        this.nivel = nivel;
        this.personasEnPlanta = new ArrayList<>();
        this.salaEspera = new SalaEspera();
    }
    public void agregarPersona(Persona persona) {
        personasEnPlanta.add(persona);
        if (persona.getPlantaDestino().getNivel() != Constans.PLANTA_PRINCIPAL)
            salaEspera.agregarPersona(persona);
    }
    public void eliminarPersona(Persona persona) {
        personasEnPlanta.remove(persona);
    }
    public void subirAAscensor(Ascensor ascensor) {
        ArrayList<Persona> personasAEliminar = new ArrayList<>();
        for (Persona persona : salaEspera.getPersonas()) {
            if (!ascensor.estaLleno()) {
                persona.entrarAscensor();
                ascensor.agregarPersona(persona);
                eliminarPersona(persona);
                personasAEliminar.add(persona);
            }
        }
        for (Persona persona : personasAEliminar) {
            salaEspera.eliminarPersona(persona);
        }
    }
    public void mover(){
        for (Persona persona : personasEnPlanta) {
            persona.mover();
        }
    }
    public void llamadaAscensorMasCercano(ArrayList<Ascensor> ascensores) {
        Ascensor ascensorMasCercano = null;
        if (salaEspera.count() > 0) {
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
    public SalaEspera getSalaEspera() {
        return salaEspera;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    @Override
    public int compareTo(Planta o) {
        return nivel - o.getNivel();
    }
}