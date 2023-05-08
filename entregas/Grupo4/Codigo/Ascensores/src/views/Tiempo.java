package views;

public class Tiempo {
    public static void imprimir(models.Tiempo tiempo){
         System.out.println("Tiempo: " + tiempo.getHoras() + ":" + tiempo.getMinutos() + ":" + tiempo.getSegundos() + "");
    }
}
