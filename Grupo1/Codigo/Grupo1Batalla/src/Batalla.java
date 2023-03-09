import Personajes.*;
import Renderizacion.MenuAcciones;
import Renderizacion.RecuadroPersonaje;

import java.util.Random;
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
        siguienteTurno();
    }

    private void siguienteTurno(){
        System.out.println("----");
        if (heroe.getVidaActual() > 0){
            if (heroePuedeActuar()){
                elegirTurno();

                if (enemigo.getVidaActual() <= 0){
                    anunciarGanador(heroe);
                }

            } else {

                if (heroe.estaDesmayado() && heroe.esperandoAPocion()){
                    heroe.curarse(2);
                    heroe.avanzarTurnoDeCuracion();

                    if (heroe.getVidaActual() >= 30){
                        heroe.despertar();
                    }

                } else if (heroe.estaDesmayado()){
                    heroe.curarse(2);

                    if (heroe.getVidaActual() >= 30){
                        heroe.despertar();
                    }

                } else {
                    heroe.avanzarTurnoDeCuracion();
                }

            }

            turnoEnemigo();
            turno++;

            System.out.println("-------------NEXT TURN-------------" + turno);
            siguienteTurno();

        } else {
            anunciarGanador(enemigo);
        }
    }
    private void turnoEnemigo(){
        if (enemigo.getVidaActual() < 30) {
            enemigo.desmayar();
        }

        if (enemigo.estaDesmayado()){
            enemigo.curarse(2);

            if (enemigo.getVidaActual() >= 30){
                enemigo.despertar();
            }
        } else {
            Random rand = new Random();
            //int armaAEquipar = rand.nextInt(enemigo.getArmas().length) + 1;

            enemigo.equiparArma(0);

            int dañoARealizar = enemigo.hacerDano();

            if (heroe.estaDefendiendo()){
                heroe.recibirDaño(dañoARealizar - 5);
            } else {
                heroe.recibirDaño(dañoARealizar);
                System.out.println("Vampiro ha atacado de" + dañoARealizar);

                if (heroe.getVidaActual() < 30 )
                    heroe.desmayar();
            }

        }
    }
    private void anunciarGanador(Personaje ganador){
        System.out.println("Ha ganado " + ganador.getNombre() + " !!");
    }
    private void elegirTurno(){
        System.out.println("----------------------------------------------------------");
        imprimirInterfazConAcciones();

        switch (scanInteraccion()){
            case 1:
                imprimirInterfazConArmas();
                elegirArma();
                break;

            case 2:
                heroe.defenderse();
                break;

            case 3:
                heroe.iniciarEstadoDeCuracion();
                break;

            default:
                elegirTurno();
        }

    }

    private boolean heroePuedeActuar(){
        return (heroe.estaDesmayado() || heroe.esperandoAPocion()) ? false : true;
    }

    private void elegirArma(){
        int armaAEquipar = scanInteraccion() - 1;

        if (armaAEquipar < 0 || armaAEquipar > heroe.getArmas().length){
            System.out.println("-------------------");
            imprimirInterfazConArmas();
            elegirArma();
        }
        else {
            heroe.equiparArma(armaAEquipar);
            int dañoARealizar = heroe.hacerDano();

            enemigo.recibirDaño(dañoARealizar); // ?? igual sacarlo
            System.out.println("Heroe ataca de "+ dañoARealizar);
        }


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