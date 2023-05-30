package personajes;

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

}


//____   Turned invader               Normal invader
//         /___/\_                                __
//        _\   \/_/\__                          _|  |_
//      __\       \/_/\                       _|      |_
//      \   __    __ \ \                     |  _    _  |
//     __\  \_\   \_\ \ \   __               | |_|  |_| |
//    /_/\\   __   __  \ \_/_/\           _  |  _    _  |  _
//    \_\/_\__\/\__\/\__\/_\_\/          |_|_|_| |__| |_|_|_|
//       \_\/_/\       /_\_\/              |_|_        _|_|
//          \_\/       \_\/                  |_|      |_|


