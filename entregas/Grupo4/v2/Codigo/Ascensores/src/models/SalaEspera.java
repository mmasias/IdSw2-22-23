package models;

import java.util.ArrayList;

public class SalaEspera {
    private ArrayList<Persona> personas;

    public SalaEspera(){
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona){
        personas.add(persona);
    }

    public void eliminarPersona(Persona persona){
        personas.remove(persona);
    }

    public ArrayList<Persona> getPersonas(){
        return personas;
    }

    public int count(){
        return personas.size();
    }
}
