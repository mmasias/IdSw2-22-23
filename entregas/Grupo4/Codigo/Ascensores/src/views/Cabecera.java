package views;

import constants.Constans;

public class Cabecera {
    public static void imprimir() {
        String linea = "----------- Personas esperando  ";
        for (int i = 0; i < Constans.TOTAL_ASCENSORES; i++) {
            linea += "-------- ";
        }
        linea += "  Personas en la planta";
        System.out.println(linea);
    }
}
