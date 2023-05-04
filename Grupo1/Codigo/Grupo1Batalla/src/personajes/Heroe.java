package personajes;

import extras.RegistroDeCombate;
import objetos.*;

public class Heroe extends Personaje{
    private final String[] acciones = new String[]{"Atacar", "Defender", "Curarse"};
    private boolean defendiendo = false;
    private boolean esperandoACurarseConPocion = false;

    private int turnosParaCurarseConPocion;

    private final int armadura = 5;

    public Heroe(String nombre, int vidaMaxima, Arma[] armas, String[] sprite, int umbralDesmayo, int curaPorDesmayo){
        super(nombre, vidaMaxima, armas, sprite, umbralDesmayo, curaPorDesmayo);
    }

    public void defenderse(){
        double randomDefenderse = Math.random();

        if (randomDefenderse < 0.8){
            defendiendo = true;
            RegistroDeCombate.anadirLog(this.nombre + " : Se esta defendiendo");
        }
    }

    public void iniciarEstadoDeCuracion(){
        RegistroDeCombate.anadirLog(this.nombre + " : Comienza el estado de curacion");
        turnosParaCurarseConPocion = 3;
        esperandoACurarseConPocion = true;
    }

    public void avanzarTurnoDeCuracion(){
        turnosParaCurarseConPocion--;

        RegistroDeCombate.anadirLog(this.nombre + " : Avanza turno de curacion");


        if (turnosParaCurarseConPocion <= 0){
            curarse(vidaMaxima);
            esperandoACurarseConPocion = false;
        }
    }

    @Override
    public boolean puedeActuar(){
        return !desmayado && !esperandoACurarseConPocion;
    }

    @Override
    public void recibirDano(int danoARecibir){
        if (defendiendo){
            recibirDanoDefendiendose(danoARecibir);
            defendiendo = false;
            RegistroDeCombate.anadirLog(this.nombre + ": Ha dejado de defenderse");
        } else {
            vidaActual -= danoARecibir;
            RegistroDeCombate.anadirLog(this.nombre + ": Ha recibido " + danoARecibir + " puntos de dano");
        }

        if (vidaActual < umbralVidaDesmayo){
            desmayar();
        }
    }

    @Override
    public void avanzarTurnoSinActuar(){
        if (desmayado && esperandoACurarseConPocion){
            curarseDesmayado();
            avanzarTurnoDeCuracion();
        } else if (desmayado){
            curarseDesmayado();
        } else if (esperandoACurarseConPocion) {
            avanzarTurnoDeCuracion();
        }
    }

    private void recibirDanoDefendiendose(int danoARecibir){
        if (danoARecibir > armadura) {
            RegistroDeCombate.anadirLog(this.nombre + ": Se estaba defendiendo y recibio " + (danoARecibir - armadura) + " puntos de dano");
            vidaActual -= danoARecibir - armadura;
        } else {
            RegistroDeCombate.anadirLog(this.nombre + " : No ha recibido dano");
        }
    }

    public String[] getAcciones(){
        return acciones;
    }

}
