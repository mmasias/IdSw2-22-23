package personajes;

import Extras.RegistroDeCombate;
import objetos.*;

public class Heroe extends Personaje{
    private final String[] acciones = new String[]{"Atacar", "Defender", "Curarse"};
    private boolean defendiendo = false;
    private boolean curando = false;

    private int turnosParaCurarseConPocion;

    private final int _ARMADURA = 5;

    public Heroe(String nombre, int vidaMaxima, Arma[] armas, String[] sprite, int umbralDesmayo, int curaPorDesmayo){
        super(nombre, vidaMaxima, armas, sprite, umbralDesmayo, curaPorDesmayo);
    }


    public boolean esperandoAPocion(){
        return turnosParaCurarseConPocion > 0;
    }

    public int getTurnoCuracion(){
        return turnosParaCurarseConPocion;
    }

    public void defenderse(){
        double randomDefenderse = Math.random();

        if (randomDefenderse < 0.8){
            defendiendo = true;
            RegistroDeCombate.anadirLog(this.nombre + " : Se está defendiendo");
        }
    }

    public void iniciarEstadoDeCuracion(){
        RegistroDeCombate.anadirLog(this.nombre + " : Comienza el estado de curación");
        turnosParaCurarseConPocion = 3;
        curando = true;
    }

    public void avanzarTurnoDeCuracion(){
        turnosParaCurarseConPocion--;

        RegistroDeCombate.anadirLog(this.nombre + " : Avanza turno de curación");


        if (turnosParaCurarseConPocion <= 0){
            vidaActual = vidaMaxima;
            desmayado = false;
            curando = false;
        }
    }

    @Override
    public boolean puedeActuar(){
        return !desmayado && !curando;
    }

    @Override
    public void recibirDano(int danoARecibir){
        if (defendiendo){
            recibirDanoDefendiendose(danoARecibir);
        } else {
            vidaActual -= danoARecibir;
        }

        if (vidaActual < umbralVidaDesmayo){
            desmayado = true;
        }

        defendiendo = false;
    }

    private void recibirDanoDefendiendose(int danoARecibir){
        if (danoARecibir > _ARMADURA) {
            System.out.println("Enemigo : Ha hecho " + (danoARecibir - _ARMADURA) + " de dano");
            vidaActual -= danoARecibir - _ARMADURA;
        }
    }

    public String[] getAcciones(){
        return acciones;
    }

}

//      _ _
//     /.-.`.
//    //o;o\ \
//    \\_-_/)/
//    _`) ( _\\
// .`) '-.-' ( `.
/// `/   .   \`. \
//\ \\___A___/_` /
// '-)|)=@=(|(-'`\
//   |/\   /\|  )/
//   /__\_/__\
//  '---' '---'
//   \ /   \ /
//   ( )   ( )
//   /_\   /_\
//  '---' '---'
//   \ /   \ /
//   /_\   /_\