import models.Tiempo;
import settings.Settings;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if (askUser()) Settings.settingConstants();
        new Tiempo().empezar();
    }

    private static boolean askUser(){
        String respuesta = "";
        Scanner lector = new Scanner(System.in);
        while (!respuesta.toLowerCase().equals("s") && !respuesta.toLowerCase().equals("n")) {
            System.out.println("¿Desea cambiar las constantes? (s/n)");
            respuesta = lector.nextLine();
        }
        return respuesta.toLowerCase().equals("s");
    }
}
