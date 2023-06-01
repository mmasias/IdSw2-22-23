package models;

import constants.Constans;
import structures.enums.EstadoAscensor;
import java.util.ArrayList;

public class Ascensor {

    private int idAscensor;
    private int nivel;
    private ArrayList<Planta> plantas;
    private ArrayList<Persona> personas;
    private EstadoAscensor estado;

    public Ascensor(int idAscensor, ArrayList<Planta> plantas) {
        this.idAscensor = idAscensor;
        this.plantas = plantas;
        this.nivel = Constans.PLANTA_PRINCIPAL;
        this.personas = new ArrayList<>();
        this.estado = EstadoAscensor.PARADO;
    }
    public Planta getPlantaActual() {
        for (Planta planta : plantas) {
            if (planta.getNivel() == nivel)
                return planta;
        }
        return null;
    }
    public int getPersonasEnAscensor() {
        return personas.size();
    }
    public boolean estaVacio() {
        return personas.size() == 0;
    }
    public boolean estaLleno() {
        return personas.size() == Constans.CAPACIDAD_MAXIMA_ASCENSOR;
    }
    public boolean estaSubiendo() {
        return estado == EstadoAscensor.SUBIENDO;
    }
    public boolean estaBajando() {
        return estado == EstadoAscensor.BAJANDO;
    }
    public boolean estaParado() {
        return estado == EstadoAscensor.PARADO;
    }

    public void agregarPersona(Persona persona) {
        if (personas.size() < Constans.CAPACIDAD_MAXIMA_ASCENSOR) {
            persona.entrarAscensor();
            personas.add(persona);
        } else {
            throw new RuntimeException("El ascensor esta lleno");
        }
    }

    private void bajarPersonas() {
        if (estaVacio())
            return;
        ArrayList<Persona> personasAEliminar = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getPlantaDestino().compareTo(getPlantaActual()) == 0) {
                persona.setPlantaActual(getPlantaActual());
                persona.getPlantaActual().agregarPersona(persona);
                persona.salirAscensor();
                personasAEliminar.add(persona);
                this.estado = EstadoAscensor.PARADO;
            }
        }
        personas.removeAll(personasAEliminar);
    }
    public void mover() {
        getPlantaActual().subirAAscensor(this);
        if (estaVacio()){
            return;
        }
        // La prioridad del movimiento está definida por la primera persona que entró al ascensor
        if (personas.get(0).getPlantaDestino().compareTo(getPlantaActual()) < 0) {
            if (estaParado()){
                estado = EstadoAscensor.BAJANDO;
            } else {
                bajar();
            }
        } else if (personas.get(0).getPlantaDestino().compareTo(getPlantaActual()) > 0) {
            if (estaParado()){
                estado = EstadoAscensor.SUBIENDO;
            } else {
                subir();
            }
        } else {
            estado = EstadoAscensor.PARADO;
            bajarPersonas();
        }
    }
    public void llamar(Planta planta) {
        if (planta.getNivel() == nivel)
            return;
        if (planta.getNivel() > nivel) {
            if (estaParado()){
                estado = EstadoAscensor.SUBIENDO;
            } else {
                subir();
            }
        } else {
            if (estaParado()){
                estado = EstadoAscensor.BAJANDO;
            } else {
                bajar();
            }
        }
    }
    public void subir() {
            if (getPlantaActual().getNivel() + 1 > Constans.NIVEL_SUPERIOR)
            throw new RuntimeException("No hay mas plantas");
        nivel++;
        bajarPersonas();
    }
    public void bajar() {
        if (getPlantaActual().getNivel()-1 < Constans.NIVEL_INFERIOR)
            throw new RuntimeException("No hay mas plantas");
        nivel--;
        bajarPersonas();
    }
}