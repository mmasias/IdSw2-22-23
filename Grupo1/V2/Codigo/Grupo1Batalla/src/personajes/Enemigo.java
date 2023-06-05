package personajes;

import controlador.Batalla;
import objetos.*;

import java.util.Random;

public class Enemigo extends Personaje {

    public Enemigo(String nombre, Vida vida, Arma[] armas, String[] sprite) {
        super(nombre, vida, armas, sprite);

    }

    public void equiparArmaAleatoria(){
        Random rand = new Random();

        armaEquipada = rand.nextInt(armas.length);

    }

    @Override
    public void actuar(Batalla batalla){
        batalla.turno(this);
    }

}