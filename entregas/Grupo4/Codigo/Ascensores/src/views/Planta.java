package views;

import models.Universidad;

import java.util.ArrayList;

public class Planta {
    public static void imprimir(Universidad universidad) {
        ArrayList<models.Planta> plantas = universidad.getPlantas();
        for (models.Planta planta : plantas) {
            System.out.print("Planta "
                    + (planta.getNivel() < 0 ? planta.getNivel() : " " + planta.getNivel())
                    + "      _____"
                    + planta.getPersonasEsperandoAscensor().size()
                    + "_____     ");
            Ascensor.imprimir(universidad.getAscensores().values(), planta.getNivel());
            System.out.println("          ___" + planta.getPersonasEnPlanta().size() + "___");
        }
    }
}
