package Personajes;

import Objetos.*;

public abstract class Personaje {
    protected String nombre;
    protected String[][] sprite;
    protected int vidaActual;


    protected int vidaMaxima;
    protected Arma[] armas;
    protected int armaEquipada;
    protected Desmayo desmayo;


    public Personaje(String nombre, int vidaMaxima, Arma[] armas, String[][] sprite) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.armas = armas;
        this.sprite = sprite;

        vidaActual = vidaMaxima;
    }

    public void recibirDaño(int daño) {
        vidaActual -= daño;
    }

    public void desmayar(){

    }

    public int getVidaActual(){
        return vidaActual;
    }

    public Arma[] getArmas(){
        return armas;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public int getArmaEquipada(){
        return armaEquipada;
    }

    public String[][] getSprite(){
        return sprite;
    }

    public String getNombre(){
        return nombre;
    }
}