package Personajes;

import Objetos.*;

public class Heroe extends Personaje{
    private String[] acciones = new String[]{"Atacar", "Defender", "Curarse"};
    private boolean defendiendo = false;

    private int turnosParaCurarseConPocion;

    public Heroe(String nombre, int vidaMaxima, Arma[] armas, String[][] sprite){
        super(nombre, vidaMaxima, armas, sprite);
    }

    public String[] getAcciones(){
        return acciones;
    }

    public boolean esperandoAPocion(){
        return turnosParaCurarseConPocion > 0;
    }

    public boolean estaDefendiendo(){
        return defendiendo;
    }

    public void defenderse(){
        double randomDefenderse = Math.random();

        if (randomDefenderse < 0.8){
            defendiendo = true;
        }
    }

    public void iniciarEstadoDeCuracion(){
        turnosParaCurarseConPocion = 3;
    }

    public void avanzarTurnoDeCuracion(){
        if (turnosParaCurarseConPocion <= 0){
            vidaActual = vidaMaxima;
            desmayado = false;
        } else {
            turnosParaCurarseConPocion--;
        }
    }

    public int getTurnoDeCuracion(){
        return turnosParaCurarseConPocion;
    }
}
