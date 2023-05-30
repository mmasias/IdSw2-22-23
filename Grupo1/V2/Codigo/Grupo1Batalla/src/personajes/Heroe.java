package personajes;

import extras.RegistroDeCombate;
import objetos.*;

public class Heroe extends Personaje{
    private final String[] acciones = new String[]{"Atacar", "Defender", "Curarse"};
    private boolean defendiendo = false;
    private boolean esperandoACurarseConPocion = false;

    private int turnosParaCurarseConPocion;

    private final int armadura = 5;

    public Heroe(String nombre, Vida vida, Arma[] armas, String[] sprite){
        super(nombre, vida, armas, sprite);
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
            vida.curarPorCompleto();
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
            vida.restarVida(danoARecibir);
            RegistroDeCombate.anadirLog(this.nombre + ": Ha recibido " + danoARecibir + " puntos de dano");
        }

        comprobarEstado();

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
            int danoARecibirDefendiendose = danoARecibir - armadura;
            vida.restarVida(danoARecibirDefendiendose);
            RegistroDeCombate.anadirLog(this.nombre + ": Se estaba defendiendo y recibio " + (danoARecibirDefendiendose) + " puntos de dano");
        } else {
            RegistroDeCombate.anadirLog(this.nombre + " : No ha recibido dano");
        }
    }

    public String[] getAcciones(){
        return acciones;
    }

}
