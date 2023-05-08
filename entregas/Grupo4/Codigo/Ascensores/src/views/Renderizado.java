package views;

public class Renderizado {
    public static void renderizar(models.Tiempo tiempo) {
        Cabecera.imprimir();
        Planta.imprimir(tiempo.getUniversidad());
        Tiempo.imprimir(tiempo);
    }
}
