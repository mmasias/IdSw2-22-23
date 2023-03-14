import Personajes.*;
import Renderizacion.*;
import java.util.Scanner;

public class Batalla {
    private final Heroe heroe;
    private final Enemigo enemigo;
    private int turno;

    private RecuadroPersonaje recuadroHeroe;
    private RecuadroPersonaje recuadroEnemigo;
    private MenuAcciones menuAcciones;

    public Batalla(Heroe heroe, Enemigo enemigo) {
        this.heroe = heroe;
        this.enemigo = enemigo;
    }

    public void empezarBatalla() {
        
        recuadroHeroe = new RecuadroPersonaje(heroe);
        recuadroEnemigo = new RecuadroPersonaje(enemigo);
        menuAcciones = new MenuAcciones(heroe);
        
        while (ambosPersonajesVivos()) {
            System.out.println("\n\n");
            System.out.println("----- SIGUIENTE TURNO -----");
            System.out.println("Turno " + turno);
            turnoHeroe();
            turnoEnemigo();
            turno++;
        }
    }

    private void turnoHeroe() {

        if (heroe.puedeActuar()) {
            elegirTurno();

            if (enemigo.estaMuerto()) {
                anunciarGanador(heroe);
            }

        } else {
            imprimirPersonajes();
            System.out.println("****************************");
            InOut.pausa();
            if (heroe.estaDesmayado() && heroe.esperandoAPocion()) {
                heroe.curarseDesmayado();
                heroe.avanzarTurnoDeCuracion();
                System.out.println("Heroe : Curarse desmayado + Turno curacion --> " + heroe.getTurnoCuracion());
            } else if (heroe.estaDesmayado()) {
                heroe.curarseDesmayado();
                System.out.println("Heroe : Curarse desmayado");
            } else {
                heroe.avanzarTurnoDeCuracion();
                System.out.println("Heroe : Avanzado turno curacion --> turno " + heroe.getTurnoCuracion());
            }
            heroe.comprobarSiSeDespierta();
        }
    }

    private boolean ambosPersonajesVivos() {
        return heroe.estaVivo() && enemigo.estaVivo();
    }

    private void elegirTurno() {
        System.out.println("----------------------------------------------------------");
        imprimirInterfazConAcciones();

        System.out.println("Elige accion: ");
        switch (InOut.pideValorEntero()) {
            case 1 -> {
                imprimirInterfazConArmas();
                elegirArma();
            }
            case 2 -> {
                heroe.defenderse();
                System.out.println("Heroe : Se defiende");
            }
            case 3 -> {
                heroe.iniciarEstadoDeCuracion();
                System.out.println("Heroe : Comienza curacion");
            }
            case 4 -> {
                System.out.println(" HAS PASAO TURNO CRACK ");
            }
            default -> {
                System.out.println("Elige turno correctamente");
                elegirTurno();
            }
        }

    }

    private void turnoEnemigo() {
        if (enemigo.estaVivo()) {

            if (enemigo.estaDesmayado()) {

                enemigo.curarseDesmayado();
                System.out.println("Enemigo : Curado desmayado");

                enemigo.comprobarSiSeDespierta();

            } else if (enemigo.pordDebajoDelUmbralDesmayo()) {

                enemigo.desmayar();
                System.out.println("Enemigo : Desmayado");

            } else {

                enemigo.equiparArmaAleatoria();

                int danoARealizar = enemigo.hacerDano();

                heroe.recibirDano(danoARealizar);

                System.out.println("Enemigo : Ha atacado con el arma --> " + enemigo.getArmaEquipada().getNombre());

                if (heroe.estaMuerto()) {
                    anunciarGanador(enemigo);
                }
            }
        }
    }

    private void elegirArma() {
        int armaAEquipar = scanInteraccion() - 1;

        if (armaAEquipar < 0 || armaAEquipar >= heroe.getArmas().length) {
            imprimirInterfazConArmas();
            System.out.println("------- ESCOGE UN ARMA CORRECTA ------------");
            elegirArma();
        } else {
            heroe.equiparArma(armaAEquipar);

            int danoARealizar = heroe.hacerDano();

            enemigo.recibirDano(danoARealizar);
            System.out.println("**************************");
            System.out.println("Heroe : Ha hecho " + danoARealizar + " de dano");
        }

    }

    private void esperarInteraccion() {
        Scanner entrada = new Scanner(System.in);
        entrada.nextLine();
    }

    private void anunciarGanador(Personaje ganador) {
        System.out.println("Ha ganado " + ganador.getNombre() + " !!");
    }

    private int scanInteraccion() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }

    private void imprimirPersonajes() {
        recuadroHeroe.imprimir();
        recuadroEnemigo.imprimir();
    }

    private void imprimirInterfazConAcciones() {
        imprimirPersonajes();
        menuAcciones.imprimirAcciones();
    }

    private void imprimirInterfazConArmas() {
        menuAcciones.imprimirArmas();
    }
}