package Extras;

import Objetos.Arma;

public class Calculadora {

    public static int calcularDaño(Arma arma){
        double probAcertar = Math.random();
        double probDesgastar = Math.random();

        if (arma.getDurabilidad() > 0){
            if (probAcertar < arma.getProbAcertar()){
                return arma.getDaño();
            }

            if (probDesgastar < arma.getProbDesgaste()){
                arma.desgastar();
            }
        }

        return 0;
    }
}
