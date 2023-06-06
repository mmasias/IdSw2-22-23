package vista;

import extras.*;
import personajes.*;
import objetos.*;
import renderizacion.RecuadroPersonaje;

import java.util.List;
import java.util.Scanner;

public class VistaBatalla {

    protected RecuadroPersonaje recuadro;
    protected Heroe heroe = Combatientes.getHeroe();
    private final Scanner entrada;

    public VistaBatalla(){
        recuadro = new RecuadroPersonaje();
        entrada = new Scanner(System.in);
    }

    public void imprimirInterfaz(List<Personaje> combatientes){
        recuadro.imprimir(combatientes);
    }

    public void anunciarGanador(String ganador){
        System.out.println("Ha ganado " + ganador);
    }

    public Acciones elegirAccion(){
        mostrarAcciones();

        final int ATACAR = 1;
        final int DEFENDER = 2;
        final int CURARSE = 3;

        switch (scanElegir(heroe.getAcciones().length)){
            case ATACAR -> {
                return Acciones.ATACAR;
            }
            case DEFENDER -> {
                return Acciones.DEFENDER;
            }
            case CURARSE -> {
                return Acciones.CURARSE;
            }
            default -> {
                return null;
            }
        }
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
        System.out.print(" || ");
        int index = 1;
        for (String accion : heroe.getAcciones()) {
            System.out.print(accion +" ("+ (index++) + ") " + " || ");
        }
    }

    private void mostrarArmas(){
        int index = 1;
        for (Arma arma : heroe.getArmas()){
            System.out.println((index++) + " " + arma.getNombre() );
        }
    }

    public void imprimeAccionesDeTurnoActual(){
        System.out.println(RegistroDeCombate.getAccionesTurnoActual());
    }

    public void imprimeRecuentoDeBatalla(){
        System.out.println("\n####  RECUENTO DE BATALLA ####\n");
        for(String turno : RegistroDeCombate.getLog()){
            System.out.println(turno);
        }
    }


    public void eliminarDeBatalla(Personaje enemigo) {
        RegistroDeCombate.anadirLog(enemigo.getNombre() + " muerto: se elimina de la batalla");
    }

    public Personaje elegirEnemigo(List<Personaje> combatientes) {
        boolean enemigoBienElegido = false;
        int enemigoElegido=0;

        while(!enemigoBienElegido){

            System.out.println("¿A cuál enemigo quieres atacar?");

            enemigoElegido= scanElegir(combatientes.size()-1);

            if(combatientes.get(enemigoElegido) instanceof Enemigo){
                enemigoBienElegido = true;
            }
        }
        return combatientes.get(enemigoElegido);
    }
}
