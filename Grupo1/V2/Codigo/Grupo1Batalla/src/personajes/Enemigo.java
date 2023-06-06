package personajes;

import controlador.Batalla;
import objetos.*;

import java.util.List;
import java.util.Random;

public class Enemigo extends Personaje {

    private boolean aturdido = true;

    public Enemigo(String nombre, Vida vida, Arma[] armas, String[] sprite) {
        super(nombre, vida, armas, sprite);
    }

    public void equiparArmaAleatoria(){
        Random rand = new Random();

        armaEquipada = rand.nextInt(armas.length);
    }

    public Personaje elegirPersonajeAAtacar(List<Personaje> combatientes){
        if(aturdido){
            Random random = new Random();
            return combatientes.get(random.nextInt(combatientes.size()));
        }
        return combatientes.get(0);
    }

    @Override
    public void actuar(Batalla batalla){
        batalla.turno(this);
    }

}