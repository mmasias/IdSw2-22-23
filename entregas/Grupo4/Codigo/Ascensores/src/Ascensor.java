import structures.enums.Estado;

import java.util.ArrayList;
import java.util.List;

class Ascensor {

    private Planta plantaActual;
    private List<Persona> personas;
    private Estado estado;

    public Ascensor(Planta plantaActual) {
        this.plantaActual = plantaActual;
        personas = new ArrayList<>();
        estado = Estado.PARADO;
    }

    public Planta getPlantaActual() {
        return plantaActual;
    }

    public int getPersonasEnAscensor() {
        return personas.size();
    }

    public void agregarPersona(Persona persona) {
        if (personas.size() < Constans.CAPACIDAD_MAXIMA_ASCENSOR) {
            personas.add(persona);
        } else {
            throw new RuntimeException("El ascensor esta lleno");
        }
    }

    public void eliminarPersona(Persona persona) {
        if (personas.size() == 0)
            throw new RuntimeException("El ascensor esta vacio");
        if (!personas.contains(persona))
            throw new RuntimeException("La persona no esta en el ascensor");
        personas.remove(persona);
        persona.salirAscensor();
    }

    public void subir() {
        if (plantaActual.getPlantaSiguiente() == null)
            throw new RuntimeException("No hay mas plantas");
        plantaActual = plantaActual.getPlantaSiguiente();
        this.estado = Estado.SUBIENDO;
        if (estaVacio())
            return;


        List<Persona> personasAEliminar = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getPlantaDestino().compareTo(plantaActual) == 0) {
                personasAEliminar.add(persona);
                persona.setPlantaActual(plantaActual);
                this.estado = Estado.PARADO;
            }
        }
        for (Persona persona : personasAEliminar) {
            eliminarPersona(persona);
        }
    }

    public void bajar() {
        if (plantaActual.getPlantaAnterior() == null)
            throw new RuntimeException("No hay mas plantas");
        plantaActual = plantaActual.getPlantaAnterior();
        this.estado = Estado.BAJANDO;
        if (personas.size() == 0)
            return;


        List<Persona> personasAEliminar = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getPlantaDestino().compareTo(plantaActual) == 0) {
                persona.setPlantaActual(plantaActual);
                personasAEliminar.add(persona);
                this.estado = Estado.PARADO;
            }
        }
        for (Persona persona : personasAEliminar) {
            eliminarPersona(persona);
        }
    }

    public boolean estaVacio() {
        return personas.size() == 0;
    }

    public boolean estaLleno() {
        return personas.size() == Constans.CAPACIDAD_MAXIMA_ASCENSOR;
    }

    public boolean estaSubiendo() {
        return estado == Estado.SUBIENDO;
    }

    public boolean estaBajando() {
        return estado == Estado.BAJANDO;
    }

    public boolean estaParado() {
        return estado == Estado.PARADO;
    }

    public void mover() {
        if (personas.size() == 0)
            return;

        // La prioridad del movimiento está definida por la primera persona que entró al ascensor
        if (personas.get(0).getPlantaDestino().compareTo(plantaActual) < 0) {
            if (estaParado()){
                estado = Estado.BAJANDO;
            } else {
                bajar();
            }
        } else if (personas.get(0).getPlantaDestino().compareTo(plantaActual) > 0) {
            if (estaParado()){
                estado = Estado.SUBIENDO;
            } else {
                subir();
            }
        } else {
            estado = Estado.PARADO;
        }
    }
}