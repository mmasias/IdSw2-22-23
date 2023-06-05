package views;

import controllers.Consola;
import models.*;

import java.util.ArrayList;

public class Renderizado {

    public static void renderizar(Tiempo tiempo) {
        Universidad universidad = tiempo.getUniversidad();
        ArrayList<Planta> plantas = new ArrayList<>(universidad.getPlantas());
        ArrayList<Ascensor> ascensores = new ArrayList<>(universidad.getAscensores().values());

        Consola.imprimir();
        for (Planta planta : plantas) {
            SalaEspera salaEspera = planta.getSalaEspera();
            Consola.imprimir(planta);
            Consola.imprimir(salaEspera);
            for (Ascensor ascensor : ascensores) {
                Consola.imprimir(ascensor, planta.getNivel());
            }
            Consola.imprimir(planta.getPersonasEnPlanta().size());
        }
        Consola.imprimir(tiempo);
    }
}
