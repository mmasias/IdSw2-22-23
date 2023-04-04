package renderizacion;

import objetos.Arma;
import personajes.Heroe;

public class MenuAcciones {
    private final Heroe heroe;

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
