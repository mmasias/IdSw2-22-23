package controllers;

import models.*;

public class Movimiento {
    public static void mover(Universidad universidad) {
        universidad.mover();
    }
    public static void mover(Persona persona) {
            persona.mover();
    }
    public static void mover(Planta planta){
        planta.mover();
    }
    public static void mover(Ascensor ascensor){
        ascensor.mover();
    }
}
