package personajes;

import Extras.RegistroDeCombate;
import objetos.*;

public abstract class Personaje {
    protected String nombre;
    protected String[] sprite;
    protected int vidaActual;
    protected int vidaMaxima;
    protected Arma[] armas;
    protected int armaEquipada;
    protected boolean desmayado;

    protected final int umbralVidaDesmayo;
    protected final int vidaCurarDesmayo;


    public Personaje(String nombre, int vidaMaxima, Arma[] armas, String[] sprite, int umbralDesmayo, int curaPorDesmayo) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.armas = armas;
        this.sprite = sprite;
        this.umbralVidaDesmayo = umbralDesmayo;
        this.vidaCurarDesmayo = curaPorDesmayo;

        vidaActual = vidaMaxima;
    }

    public void recibirDano(int dano) {
        vidaActual -= dano;

        RegistroDeCombate.anadirLog(this.nombre + ": Ha recibido " + dano + " puntos de daño");

        if (vidaActual < umbralVidaDesmayo){
            desmayado = true;
            RegistroDeCombate.anadirLog(this.nombre + " : Se ha desmayado");
        }
    }

    public void atacarAPersonaje(Personaje personajeAAtacar){
        int probAcertar = (int) (Math.random() * 100);
        Arma arma = armas[armaEquipada];

        if ((probAcertar < arma.getProbAcertar()) && (arma.getDurabilidad() > 0)){
            RegistroDeCombate.anadirLog(this.nombre + " : Ha acertado con el arma " + arma.getNombre());

            int danoARealizar = arma.getDano();
            personajeAAtacar.recibirDano(danoARealizar);

            arma.desgastar();
            RegistroDeCombate.anadirLog(this.nombre + " : El arma " + arma.getNombre() + " se ha desgastado, ahora le quedan " + arma.getDurabilidad() + " puntos de durabilidad");
        }

    }

    public boolean puedeActuar(){
        return !desmayado;
    }
    public void curarseDesmayado(){
        RegistroDeCombate.anadirLog(this.nombre + " : Está desmayado");
        curarse(vidaCurarDesmayo);
    }
    public void curarse(int vidaACurar){
        if ((vidaActual + vidaACurar ) > vidaMaxima){
            vidaActual = vidaMaxima;
            RegistroDeCombate.anadirLog(this.nombre + " : Se ha curado por completo");
        } else {
            vidaActual += vidaACurar;
            RegistroDeCombate.anadirLog(this.nombre + " : Se ha curado " + vidaACurar + " puntos de vida, ahora tiene " + this.vidaActual);
        }
    }
    public void despertar(){
        desmayado = false;
        RegistroDeCombate.anadirLog(this.nombre + " : Se ha despertado");
    }
    public void comprobarSiSeDespierta(){
        if (!this.porDebajoDelUmbralDeDesmayo() && desmayado){
            despertar();
            System.out.println("Heroe : Despertado");
        }
    }
    public boolean estaVivo(){
        return vidaActual > 0;
    }

    public boolean porDebajoDelUmbralDeDesmayo(){
        return vidaActual < umbralVidaDesmayo;
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