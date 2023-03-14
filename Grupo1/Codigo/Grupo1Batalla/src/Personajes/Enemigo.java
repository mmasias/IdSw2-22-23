package Personajes;

import Objetos.*;

import java.util.Random;

public class Enemigo extends Personaje {

    public Enemigo(String nombre, int vidaMaxima, Arma[] armas, String[] sprite, int umbralDesmayo, int curaPorDesmayo) {
        super(nombre, vidaMaxima, armas, sprite, umbralDesmayo, curaPorDesmayo);

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


