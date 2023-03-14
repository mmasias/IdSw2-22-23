package Personajes;

import Objetos.*;

public abstract class Personaje {
    protected String nombre;
    protected String[] sprite;
    protected int vidaActual;
    protected int vidaMaxima;
    protected Arma[] armas;
    protected int armaEquipada;
    protected boolean desmayado;

    protected final int _UMBRAL_VIDA_DESMAYO; //hace falta llamarles asi???? revisar
    protected final int _VIDA_CURAR_DESMAYO;


    public Personaje(String nombre, int vidaMaxima, Arma[] armas, String[] sprite, int umbralDesmayo, int curaPorDesmayo) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.armas = armas;
        this.sprite = sprite;
        _UMBRAL_VIDA_DESMAYO = umbralDesmayo;
        _VIDA_CURAR_DESMAYO = curaPorDesmayo;

        vidaActual = vidaMaxima;
    }

    public void recibirDano(int dano) {
        vidaActual -= dano;
        if (vidaActual < _UMBRAL_VIDA_DESMAYO){
            desmayado = true;
        }
    }
    public int hacerDano(){
        int probAcertar = (int) (Math.random() * 100);
        //double probDesgastar = Math.random();
        Arma arma = armas[armaEquipada];

        // de momento, despues de atacar correctamente se desgasta
        if (arma.getDurabilidad() > 0){
            if (probAcertar < arma.getProbAcertar()){
                arma.desgastar();
                return arma.getDano();
            }
        }

        return 0;
    }
    public boolean puedeActuar(){
        return !desmayado;
    }
    public void curarseDesmayado(){
        curarse(_VIDA_CURAR_DESMAYO);
    }
    public void curarse(int vidaACurar){
        if ((vidaActual + vidaACurar ) > vidaMaxima){
            vidaActual = vidaMaxima;
        } else {
            vidaActual += vidaACurar;
        }
    }
    public void despertar(){
        desmayado = false;
    }
    public void comprobarSiSeDespierta(){
        if (!this.pordDebajoDelUmbralDesmayo() && desmayado){
            despertar();
            System.out.println("Heroe : Despertado");
        }
    }
    public boolean estaVivo(){
        return vidaActual > 0;
    }
    public boolean estaMuerto(){
        return vidaActual <= 0;
    }
    public boolean pordDebajoDelUmbralDesmayo(){
        return vidaActual < _UMBRAL_VIDA_DESMAYO;
    }
    public void desmayar(){
        desmayado = true;
    }
    public boolean estaDesmayado(){
        return desmayado;
    }
    public int getVidaActual(){
        return vidaActual;
    }
    public Arma getArmaEquipada(){
        return armas[armaEquipada];
    }
    public void equiparArma(int armaAEquipar){
        armaEquipada = armaAEquipar;
    }
    public Arma[] getArmas(){
        return armas;
    }
    public String[] getSprite(){
        return sprite;
    }
    public String getNombre(){
        return nombre;
    }
}