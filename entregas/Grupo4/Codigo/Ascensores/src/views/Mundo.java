package views;

import constants.Constans;
import models.Ascensor;
import models.Planta;
import models.Tiempo;
import models.Universidad;

import java.util.ArrayList;

public class Mundo {

    public static void imprimirInterfaz(Tiempo tiempo) {
        //Imprimir cabecera
        String linea = "----------- Personas esperando  ";
        for (int i = 0; i < Constans.TOTAL_ASCENSORES; i++) {
            linea += "-------- ";
        }
        linea += "  Personas en la planta";
        System.out.println(linea);
        ArrayList<Planta> plantas = tiempo.getUniversidad().getPlantas();
        //Imprimir plantas
        for (Planta planta : plantas) {

            linea = "Planta "
                    + (planta.getNivel() < 0 ? planta.getNivel() : " " + planta.getNivel())
                    + "      _____"
                    + planta.getPersonasEsperandoAscensor().size()
                    + "_____     " ;

            ArrayList<Ascensor> ascensores = new ArrayList<>(tiempo.getUniversidad().getAscensores().values());
            for (Ascensor ascensor : ascensores) {
                if (ascensor.getPlantaActual().getNivel() == planta.getNivel()) {
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
            }
            linea+= "          ___" + planta.getPersonasEnPlanta().size() + "___";
            System.out.println(linea);
        }
        System.out.println("Tiempo: " + tiempo.getHoras() + ":" + tiempo.getMinutos() + ":" + tiempo.getSegundos() + "");
    }
}
