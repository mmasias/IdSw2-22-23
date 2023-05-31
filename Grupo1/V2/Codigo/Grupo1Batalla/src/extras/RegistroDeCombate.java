package extras;

import java.util.TreeMap;

public class RegistroDeCombate {
    private static TreeMap<Integer, String> log = new TreeMap<>();
    private static int turnoActual = 1;


    public static void anadirLog(String accionActual){
        if (log.containsKey(turnoActual)) {
            String accionAnterior = log.get(turnoActual);
            String sobreEscrito = accionAnterior + "\n" +  accionActual;
            log.put(turnoActual, sobreEscrito);
        } else {
            log.put(turnoActual, accionActual);
        }
    }



    public static java.util.Collection<String> getLog(){
        return log.values();
    }


    public static String getAccionesTurnoActual(){
        return log.get(turnoActual);
    }


    public static void pasarTurno(){
        turnoActual++;
    }

    public static int turnoActual(){
        return turnoActual;
    }
}
