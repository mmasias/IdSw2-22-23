import Personajes.*;
import Renderizacion.MenuAcciones;
import Renderizacion.RecuadroPersonaje;

import java.util.Scanner;

public class Batalla {
    private Heroe heroe;
    private Enemigo enemigo;
    private int turno;


    private boolean continuar;

    private RecuadroPersonaje recuadroHeroe;
    private RecuadroPersonaje recuadroEnemigo;
    private MenuAcciones menuAcciones;


    public Batalla(Heroe heroe, Enemigo enemigo){
        this.heroe = heroe;
        this.enemigo = enemigo;

        continuar = true;
    }

    public void empezarBatalla(){
        recuadroHeroe = new RecuadroPersonaje(heroe.getSprite(), heroe.getVidaActual(), heroe.getNombre());
        recuadroEnemigo = new RecuadroPersonaje(enemigo.getSprite(), enemigo.getVidaActual(), enemigo.getNombre());

        menuAcciones = new MenuAcciones(heroe.getArmas(), heroe.getAcciones());

        imprimirInterfazAcciones();
        iterar();
    }

    private void iterar(){
        while(continuar){
            elegirTurno();
        }
    }

    private void elegirTurno(){
        switch (scanInteraccion()){
            case 1:
                imprimirInterfazArmas();
                elegirArma();
                break;

            case 2:
                //defenderse();
        }

    }

    private void elegirArma(){

    }

    private int scanInteraccion(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    private void imprimirPersonajes(){
        recuadroHeroe.imprimir();
        recuadroEnemigo.imprimir();
    }

    private void imprimirInterfazAcciones(){
        imprimirPersonajes();
        menuAcciones.imprimirAcciones();
    }

    private void imprimirInterfazArmas(){
        imprimirPersonajes();
        menuAcciones.imprimirArmas();
    }
}
