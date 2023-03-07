package Personajes;

import Objetos.*;

public class Heroe extends Personaje{
    protected Pocion[] pociones;
    private String[] acciones = new String[]{"Atacar", "Defender"};

    public Heroe(String nombre, int vidaMaxima, Arma[] armas, String[][] sprite, Pocion[] pociones){
        super(nombre, vidaMaxima, armas, sprite);
    }

    public String[] getAcciones(){
        return acciones;
    }
}
