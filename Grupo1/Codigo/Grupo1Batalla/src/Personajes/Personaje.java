package Personajes;

import Objetos.*;

public abstract class Personaje {
    protected String nombre;
    protected String[][] sprite;
    protected int vidaActual;
    protected int vidaMaxima;
    protected Arma[] armas;
    protected int armaEquipada;
    protected boolean desmayado;


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

    public boolean estaDesmayado(){
        return desmayado;
    }

    public int hacerDano(){
        double probAcertar = Math.random();
        double probDesgastar = Math.random();
        Arma arma = armas[armaEquipada];

        if (arma.getDurabilidad() > 0){
            if (probAcertar < arma.getProbAcertar()){
                arma.desgastar();
                return arma.getDaño();
            }
        }

        return 0;
    }

    public void equiparArma(int armaAEquipar){
        armaEquipada = armaAEquipar;
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

    public void curarse(int vidaACurar){
        if ((vidaActual + vidaACurar ) > vidaMaxima)
            vidaActual = vidaMaxima;

        else
            vidaActual += vidaACurar;
    }

    public void despertar(){
        desmayado = false;
    }
}