package controlador;

import extras.RegistroDeCombate;
import personajes.*;
import vista.*;

import java.util.List;

public class Batalla {
    protected VistaBatalla vista;
    protected Heroe heroe = Combatientes.getHeroe();
    protected List<Personaje> combatientes = Combatientes.getCombatientesVivos();

    public Batalla(){
        vista = new VistaBatalla();
    }

    private int contador = 0;

    public void comenzarBatalla(){

        while (Combatientes.ambosBandosConVida()){

            System.out.println("Turno- " +RegistroDeCombate.turnoActual());
            for (var a : combatientes){
                System.out.print( a.getNombre() + " - " + a.getVidaActual() + "  ");
            }
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

            vista.imprimirInterfaz(combatientes);

            if(contador>=combatientes.size()) contador=0;

            combatientes.get(contador).actuar(this);

            vista.imprimeAccionesDeTurnoActual();

            vista.esperarInteraccion();
            RegistroDeCombate.pasarTurno();

            actualizarCombatientes();

            contador++;
        }

        if (heroe.estaVivo()){
            vista.anunciarGanador("el heroe!!!!!");
        } else {
            vista.anunciarGanador("los enemigos!!!!!!");
        }

        vista.imprimeRecuentoDeBatalla();
    }

    private void jugadorEligeAccion(){
        switch(vista.elegirAccion()){
            case ATACAR -> {
                heroe.equiparArma(vista.elegirArma() - 1);
                Personaje enemigo = vista.elegirEnemigo(Combatientes.obtenerEnemigosVivos());
                heroe.atacar(enemigo);
            }
            case DEFENDER -> {
                heroe.defenderse();
            }
            case CURARSE -> {
                heroe.iniciarEstadoDeCuracion();
            }
        }
    }

    private void enemigoActua(Enemigo enemigoActual){
        enemigoActual.equiparArmaAleatoria();
        enemigoActual.atacar(heroe);
    }

    public void turno(Heroe heroe) {
        if (heroe.puedeActuar()) {
            jugadorEligeAccion();
        } else {
            heroe.avanzarTurnoSinActuar();
            vista.esperarInteraccion();
        }
    }

    public void turno(Enemigo enemigo){

        heroe.comprobarSiCurar();

        if (enemigo.puedeActuar()){
            enemigoActua(enemigo);
        } else {
            enemigo.avanzarTurnoSinActuar();
        }
    }

    private void actualizarCombatientes() {

        combatientes = Combatientes.getCombatientesVivos();
    }
}
