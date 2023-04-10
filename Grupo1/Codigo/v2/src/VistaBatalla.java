import extras.RegistroDeCombate;
import personajes.*;
import objetos.*;
import renderizacion.RecuadroPersonaje;

import java.util.Scanner;

public class VistaBatalla {

    protected RecuadroPersonaje recuadro;
    protected Heroe heroe;

    private Scanner entrada;

    public VistaBatalla(Heroe heroe, Enemigo enemigo){
        this.heroe = heroe;
        recuadro = new RecuadroPersonaje(heroe, enemigo);
        entrada = new Scanner(System.in);
    }

    public void imprimirInterfaz(){
        System.out.println("---------------------------");
        recuadro.imprimir();
        System.out.println("---------------------------");
    }

    public void anunciarGanador(Personaje ganador){
        System.out.println(ganador.getNombre() + " ha sido el ganador!");
    }

    public int elegirAccion(){
        mostrarAcciones();
        return scanElegir(heroe.getAcciones().length);
    }

    public int elegirArma(){
        mostrarArmas();
        return scanElegir(heroe.getArmas().length);
    }

    public void esperarInteraccion(){
        Scanner a = new Scanner(System.in);
        a.nextLine();
    }
    private int scanElegir(int numMax){
        boolean elegidaOpcionCorrecta = false;
        int eleccion = 0;

        while (!elegidaOpcionCorrecta){

            eleccion = entrada.nextInt();

            if (eleccion > 0 & eleccion <= numMax){
                elegidaOpcionCorrecta = true;
            }
        }

        return eleccion;
    }

    private void mostrarAcciones(){
        for (String accion : heroe.getAcciones()) {
            System.out.print(accion + " || ");
        }
    }

    private void mostrarArmas(){
        for (Arma arma : heroe.getArmas()){
            System.out.println(arma.getNombre() + " // ");
        }
    }


}
