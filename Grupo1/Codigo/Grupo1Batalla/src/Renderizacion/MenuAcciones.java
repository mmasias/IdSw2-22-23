package Renderizacion;

import Objetos.Arma;

public class MenuAcciones {
    private Arma[] armas;
    private String[] acciones; // las acciones las podemos crear desde aqui

    public MenuAcciones(Arma[] armas, String[] acciones){
        this.armas = armas;
        this.acciones = acciones;
    }

    public void imprimirAcciones(){
        for (int i = 0 ; i < acciones.length; i++){
            System.out.print(acciones[i] + " _ _ ");
        }
        System.out.println();
    }

    public void imprimirArmas(){
        for (int i = 0 ; i < armas.length; i++){
            System.out.print(armas[i].getNombre() + " _ _ ");
        }
        System.out.println();
    }
}
