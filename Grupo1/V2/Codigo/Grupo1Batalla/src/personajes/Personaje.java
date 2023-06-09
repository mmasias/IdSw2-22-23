package personajes;

import objetos.*;
import extras.*;
import controlador.*;

public abstract class Personaje {
    protected String nombre;
    protected String[] sprite;
    protected Arma[] armas;
    protected Vida vida;

    public abstract void actuar(Batalla batalla);

    protected int armaEquipada;
    protected boolean desmayado;
    protected boolean aturdido;

    private int turnosParaQuitarAturdimiento;

    public Personaje(String nombre, Vida vida, Arma[] armas, String[] sprite) {
        this.nombre = nombre;
        this.sprite = sprite;
        this.armas = armas;
        this.vida = vida;

    }

    public void recibirDano(int dano) {
        vida.restarVida(dano);

        RegistroDeCombate.anadirLog(this.nombre + ": Ha recibido " + dano + " puntos de dano");

        comprobarEstado();
    }

    private void recibirEfectoSecundario(EfectoSecundario efectoSecundario) {

        if (efectoSecundario != null) {
            efectoSecundario.Aplicar(this);
        }
    }

    protected void comprobarEstado() {
        if (vida.getVidaActual() <= 0) {
            RegistroDeCombate.anadirLog(this.nombre + " : Ha muerto");
        } else if (vida.getVidaActual() < vida.getUmbralDesmayo() && !desmayado) {
            desmayar();
        }
    }


    public void atacar(Personaje personajeAAtacar) {
        int probAcertar = (int) (Math.random() * 100);
        Arma arma = armas[armaEquipada];

        personajeAAtacar = comprobarEstadoAlAtacar(personajeAAtacar);

        if ((probAcertar < arma.getProbAcertar()) && (arma.getDurabilidad() > 0)) {
            RegistroDeCombate.anadirLog(this.nombre + " : Ha acertado con el arma " + arma.getNombre());

            int danoARealizar = arma.getDano();
            personajeAAtacar.recibirDano(danoARealizar);

            personajeAAtacar.recibirEfectoSecundario(arma.getEfectoSecundario());

            arma.desgastar();
            RegistroDeCombate.anadirLog(this.nombre + " : El arma " + arma.getNombre() + " se ha desgastado, ahora le quedan " + arma.getDurabilidad() + " puntos de durabilidad");
        } else {
            RegistroDeCombate.anadirLog(this.nombre + " : Ha fallado con el arma " + arma.getNombre());
        }

    }

    private Personaje comprobarEstadoAlAtacar(Personaje personajeAAtacar) {
        if (aturdido) {
            RegistroDeCombate.anadirLog(getNombre() + " : Esta aturdido");
            personajeAAtacar = Combatientes.getPersonajeVivoRandom();
            avanzarTurnoAturdimiento();
        }

        return personajeAAtacar;
    }

    public boolean puedeActuar() {
        return !desmayado;
    }

    public void avanzarTurnoSinActuar() {
        curarseDesmayado();
    }

    public void curarseDesmayado() {

        if (vida.debajoDelUmbral()) {
            RegistroDeCombate.anadirLog(this.nombre + " : Esta desmayado");

            vida.curarDesmayado();
            RegistroDeCombate.anadirLog(this.nombre + " : Se ha curado " + vida.getVidaARecuperarDesmayado());

        }

        comprobarSiSeDespierta();
    }

    private void comprobarSiSeDespierta() {

        if (!vida.debajoDelUmbral()) {
            despertar();
        }
    }

    private void despertar() {

        desmayado = false;
        RegistroDeCombate.anadirLog(this.nombre + " : Se ha despertado");
    }

    public boolean estaVivo() {
        return vida.mayorQueCero();
    }

    public void desmayar() {
        desmayado = true;
        RegistroDeCombate.anadirLog(this.nombre + ": Se ha desmayado");
    }

    public int getVidaActual() {
        return vida.getVidaActual();
    }

    public void equiparArma(int armaAEquipar) {
        armaEquipada = armaAEquipar;
    }

    public Arma[] getArmas() {
        return armas;
    }

    public String[] getSprite() {
        return sprite;
    }

    public String getNombre() {
        return nombre;
    }

    public void aturdir() {

        turnosParaQuitarAturdimiento = 3;
        aturdido = true;
        RegistroDeCombate.anadirLog(getNombre() + " : Ha sido aturdido ");
    }

    public void avanzarTurnoAturdimiento() {
        turnosParaQuitarAturdimiento--;

        if (turnosParaQuitarAturdimiento <= 0) {
            RegistroDeCombate.anadirLog(getNombre() + " : Último turno de aturdimiento");
            aturdido = false;
        }

    }
}