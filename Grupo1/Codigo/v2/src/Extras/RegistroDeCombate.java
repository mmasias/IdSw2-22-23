package Extras;

import java.util.TreeMap;

public class RegistroDeCombate {
    private static TreeMap<Integer, String> log;
    private static int turnoActual;


    public static void anadirLog(String accionActual){
        if (log.containsKey(turnoActual)) {
            String accionAnterior = log.get(turnoActual);
            String sobreEscrito = accionAnterior + accionActual;
            log.put(turnoActual, sobreEscrito);
        } else {
            log.put(turnoActual, accionActual);
        }
    }

    public static void sacarAccionesTotal(){
        for(String turno : log.values()){
            System.out.println(turno);
        }
    }

    public static void sacarAccionesTurnoACtual(){
        if (log.containsKey(turnoActual)){
            System.out.println(log.get(turnoActual));
        }
    }

    public static void sacarAccionesTurnoElegir(Integer turno){
        if (log.containsKey(turno)){
            System.out.println(log.get(turno));
        }
    }

    public static void pasarTurno(){
        turnoActual++;
    }
}
