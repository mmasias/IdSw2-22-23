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

        imprimirInterfazConAcciones();
        siguienteTurno();
    }

    private void siguienteTurno(){
        // comprobar si los personajes siguen vivos en el bucle
            //si ambos siguen vivos:
                //heroe - comprobar si está desmayado
                    // esta desmayado - saltar las acciones
                    // no esta desmayado
                        // comprobar que pueda hacer algo (CD esperar a curarse)
                            // no puede hacer nada
                            // puede hacer cosas
                                // BUCLE - elegir accion

                                    //si elige atacar, mostrar armas
                                            // elige arma
                                                // calcular daño
                                                // quitar vida al enemigo
                                                // turnoEnemigo()

                                            // no elige arma -- > volver al inicio del bucle

                                    //si elige defenderse, defenderse

                                    //si elige curarse, curarse

                // turnoEnemigo()
                    // enemigo - comprobar si está desmayado
                        // esta desmayado
                        // no esta desmayado
                            // sacar arma aleatoria
                            // calcular daño y hacerselo al heroe

        // turno ++


        while(personajesSiguenVivos()){
            elegirTurno();
        }

        // cuando se sale del bucle es porque alguno ha ganado

        avisarDeGanador();
    }

    private boolean personajesSiguenVivos(){
        return heroe.getVidaActual() > 0 && enemigo.getVidaActual() > 0;
    }

    private void elegirTurno(){
        switch (scanInteraccion()){
            case 1:
                imprimirInterfazConArmas();
                elegirArma();
                break;

            case 2:
                //defenderse();
        }

    }

    private void elegirArma(){

    }

    private void avisarDeGanador(){
        if (heroe.getVidaActual() < 0 && enemigo.getVidaActual() < 0)
            System.out.println("EMPATE");

        else if (heroe.getVidaActual() < 0)
            System.out.println("Ha ganado el enemigo");

        else
            System.out.println("Ha ganado el héroe");
    }

    private int scanInteraccion(){
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    private void imprimirPersonajes(){
        recuadroHeroe.imprimir();
        recuadroEnemigo.imprimir();
    }

    private void imprimirInterfazConAcciones(){
        imprimirPersonajes();
        menuAcciones.imprimirAcciones();
    }

    private void imprimirInterfazConArmas(){
        imprimirPersonajes();
        menuAcciones.imprimirArmas();
    }
}
