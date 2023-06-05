package controllers;

import interfaces.IMovible;

public class Movimiento {
    public static void mover(IMovible objetoMovible) {
        objetoMovible.mover();
    }
}
