package controllers;

import settings.Settings;
import models.*;

public class Consola {
    public static void imprimir(){
        String linea = "----------- Personas esperando  ";
        for (int i = 0; i < Settings.TOTAL_ASCENSORES; i++) {
            linea += "-------- ";
        }
        linea += "  Personas en la planta";
        System.out.println(linea);
    }
    public static void imprimir(Planta planta) {
        System.out.print("Planta " + (planta.getNivel() < 0 ? planta.getNivel() : " " + planta.getNivel()));
    }
    public static void imprimir(SalaEspera salaEspera){
        System.out.print("      _____" + salaEspera.count() + "_____     ");
    }
    public static void imprimir(Ascensor ascensor, int nivel) {
        String linea = "";
        if (ascensor.getPlantaActual().getNivel() == nivel) {
            if (ascensor.estaParado()){
                linea += "   [-" + ascensor.getPersonasEnAscensor() + "-] ";
            } else if (ascensor.estaSubiendo()){
                linea += "   [^" + ascensor.getPersonasEnAscensor() + "^] ";
            } else if (ascensor.estaBajando()){
                linea += "   [v" + ascensor.getPersonasEnAscensor() + "v] ";
            }
        } else {
            linea += "   |  |  ";
        }
        System.out.print(linea);
    }
    public static void imprimir(int numero) {
        System.out.println("          ___" + numero + "___");
    }
    public static void imprimir(Tiempo tiempo) {
        System.out.println("Tiempo: " + tiempo.getHoras() + ":" + tiempo.getMinutos() + ":" + tiempo.getSegundos() + "");
    }
    public static void imprimir(String texto){
        System.out.println(texto);
    }




}
