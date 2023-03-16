package personajes;

import objetos.*;

import java.util.Random;

public class Enemigo extends Personaje {

    public Enemigo(String nombre, int vidaMaxima, Arma[] armas, String[][] sprite, int umbralDesmayo, int curaPorDesmayo) {
        super(nombre, vidaMaxima, armas, sprite, umbralDesmayo, curaPorDesmayo);

    }

    public void equiparArmaAleatoria(){
        Random rand = new Random();

        armaEquipada = rand.nextInt(armas.length);

    }
}
