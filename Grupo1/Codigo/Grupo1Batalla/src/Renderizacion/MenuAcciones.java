package Renderizacion;

import Objetos.Arma;
import Personajes.Heroe;

public class MenuAcciones {
    private final Heroe heroe;
    private Arma[] armas;
    private String[] acciones; // las acciones las podemos crear desde aqui

    public MenuAcciones(Heroe heroe){
        this.heroe = heroe;
    }

    public void imprimirAcciones(){
        for (String accion : heroe.getAcciones()) {
            System.out.print(accion + " || ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public void imprimirArmas(){
        for (Arma arma : heroe.getArmas()) {
            System.out.print(arma.getNombre() + " ; ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }
}
