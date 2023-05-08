package views;

import java.util.ArrayList;
import java.util.Collection;

public class Ascensor {
    public static void imprimir(Collection<models.Ascensor> ascensores, int nivel) {
        String linea = "";
        ArrayList<models.Ascensor> arrayAscensores = new ArrayList<>(ascensores);
        for (models.Ascensor ascensor : arrayAscensores) {
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
        }
        System.out.print(linea);
    }
}
