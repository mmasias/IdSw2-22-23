package settings;

import java.util.Scanner;

public class Settings {
    public static int NIVEL_SUPERIOR = 3;
    public static int NIVEL_INFERIOR = -3;
    public static int CAPACIDAD_MAXIMA_ASCENSOR = 6;
    public static int TOTAL_ASCENSORES = 3;
    public static int PLANTA_PRINCIPAL = 0;
    public static double PROBABILIDAD_LLEGADA_PERSONA = 0.5;

    public static void settingConstants(){
        setNivelInferior();
        setNivelSuperior();
        setCapacidadMaximaAscensor();
        setTotalAscensores();
        setPlantaPrincipal();
        setProbabilidadLlegadaPersona();
    }

    private static void setNivelInferior() {
        try {
            Scanner lector = new Scanner(System.in);
            System.out.printf("Ingrese el número del nivel inferior del edificio [0 ~ -10]: /[%d] - ", Settings.NIVEL_INFERIOR);
            String lectura = lector.nextLine();
            if(lectura.isEmpty()) return;
            int numero = Integer.parseInt(lectura);
            if(numero < -10) throw new Exception("El nivel inferior no puede ser menor a -10");
            if(numero > NIVEL_SUPERIOR) throw new Exception("El nivel inferior no puede ser mayor al nivel superior");
            if(numero > 0) throw new Exception("El nivel inferior no puede ser mayor o igual a 0");
            NIVEL_INFERIOR = numero;
            return;
        }  catch (NumberFormatException e) {
            System.out.println("==El valor introducido no es valido==");
        } catch (Exception e) {
            System.out.println("==" + e.getMessage() + "==");
        }
        setNivelInferior();
    }

    private static void setNivelSuperior() {
        try {
            Scanner lector = new Scanner(System.in);
            System.out.printf("Ingrese el número del nivel superior del edificio [1 ~ 10]: /[%d] - ", Settings.NIVEL_SUPERIOR);
            String lectura = lector.nextLine();
            if(lectura.isEmpty()) return;
            int numero = Integer.parseInt(lectura);
            if(numero > 10) throw new Exception("El nivel superior no puede ser mayor a 10");
            if(numero < NIVEL_INFERIOR) throw new Exception("El nivel superior no puede ser menor al nivel inferior");
            if(numero <= 0) throw new Exception("El nivel superior no puede ser menor o igual a 0");
            NIVEL_SUPERIOR = numero;
            return;
        } catch (NumberFormatException e){
            System.out.println("==El valor introducido no es valido==");
        } catch (Exception e) {
            System.out.println("==" + e.getMessage() + "==");
        }
        setNivelSuperior();
    }

    private static void setCapacidadMaximaAscensor() {
        try {
            Scanner lector = new Scanner(System.in);
            System.out.printf("Ingrese la capacidad máxima de los ascensores [1 ~ 10]: /[%d] - ", Settings.CAPACIDAD_MAXIMA_ASCENSOR);
            String lectura = lector.nextLine();
            if(lectura.isEmpty()) return;
            int numero = Integer.parseInt(lectura);
            if(numero > 10) throw new Exception("La capacidad máxima no puede ser mayor a 10");
            if(numero <= 0) throw new Exception("La capacidad máxima no puede ser menor o igual a 0");
            CAPACIDAD_MAXIMA_ASCENSOR = numero;
            return;
        }  catch (NumberFormatException e) {
            System.out.println("==El valor introducido no es valido==");
        } catch (Exception e) {
            System.out.println("==" + e.getMessage() + "==");
        }
        setCapacidadMaximaAscensor();
    }

    private static void setTotalAscensores() {
        try {
            Scanner lector = new Scanner(System.in);
            System.out.printf("Ingrese el número de ascensores [1 ~ 6]: /[%d] - ", Settings.TOTAL_ASCENSORES);
            String lectura = lector.nextLine();
            if(lectura.isEmpty()) return;
            int numero = Integer.parseInt(lectura);
            if(numero > 6) throw new Exception("El número de ascensores no puede ser mayor a 6");
            if(numero <= 0) throw new Exception("El número de ascensores no puede ser menor o igual a 0");
            TOTAL_ASCENSORES = numero;
            return;
        }  catch (NumberFormatException e) {
            System.out.println("==El valor introducido no es valido==");
        } catch (Exception e) {
            System.out.println("==" + e.getMessage() + "==");
        }
        setTotalAscensores();
    }

    private static void setPlantaPrincipal() {
        try {
            Scanner lector = new Scanner(System.in);
            System.out.printf("Ingrese el número de la planta principal [%d ~ %d]: /[%d] - ", Settings.NIVEL_INFERIOR, Settings.NIVEL_SUPERIOR, Settings.PLANTA_PRINCIPAL);
            String lectura = lector.nextLine();
            if(lectura.isEmpty()) return;
            int numero = Integer.parseInt(lectura);
            if(numero > NIVEL_SUPERIOR) throw new Exception("El número de la planta principal no puede ser mayor al nivel superior");
            if(numero < NIVEL_INFERIOR) throw new Exception("El número de la planta principal no puede ser menor al nivel inferior");
            PLANTA_PRINCIPAL = numero;
            return;
        } catch (NumberFormatException e) {
            System.out.println("==El valor introducido no es valido==");
        } catch (Exception e) {
            System.out.println("==" + e.getMessage() + "==");
        }
        setPlantaPrincipal();
    }

    private static void setProbabilidadLlegadaPersona() {
        try {
            Scanner lector = new Scanner(System.in);
            System.out.printf("Ingrese la probabilidad de llegada de personas [1 ~ 100]: /[%f] - ", Settings.PROBABILIDAD_LLEGADA_PERSONA*100);
            String lectura = lector.nextLine();
            if(lectura.isEmpty()) return;
            int numero = Integer.parseInt(lectura);
            if(numero >= 100) throw new Exception("La probabilidad de llegada de personas no puede ser mayor a 100");
            if(numero <= 0) throw new Exception("La probabilidad de llegada de personas no puede ser menor o igual a 0");
            double probabilidad = (double) numero / 100;
            PROBABILIDAD_LLEGADA_PERSONA = probabilidad;
            return;
        } catch (NumberFormatException e) {
            System.out.println("==El valor introducido no es valido==");
        } catch (Exception e) {
            System.out.println("==" + e.getMessage() + "==");
        }
        setProbabilidadLlegadaPersona();
    }
}
