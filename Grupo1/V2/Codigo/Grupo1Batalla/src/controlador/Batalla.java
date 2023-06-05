package controlador;

import extras.RegistroDeCombate;
import personajes.*;
import vista.*;

import java.util.List;

public class Batalla {
    protected VistaBatalla vista;
    protected Heroe heroe = Combatientes.getHeroe();
    protected List<Enemigo> enemigos = Combatientes.getEnemigos();

    public Batalla(){
        vista = new VistaBatalla();
    }

    public void comenzarBatalla(){

        while (Combatientes.ambosBandosConVida()){
            System.out.println("Vida heroe - " + heroe.getVidaActual());
            for (var a : enemigos){
                System.out.print("Enemigo - " + a.getVidaActual() + "  ");
            }
            System.out.println("///////");

            for (var personaje : Combatientes.getCombatientes()){

                vista.imprimirInterfaz();

                personaje.actuar(this);

                vista.imprimeAccionesDeTurnoActual();
                RegistroDeCombate.pasarTurno();

            }

        }
        vista.imprimeRecuentoDeBatalla();

        if (heroe.estaVivo()){
            vista.anunciarGanador("el heroe");
        } else {
            vista.anunciarGanador("los enemigos");
        }
    }

    private void jugadorEligeAccion(){
        switch(vista.elegirAccion()){
            case ATACAR -> {
                heroe.equiparArma(vista.elegirArma() - 1);
                heroe.atacar(Combatientes.elegirPrimerEnemigoVivo());
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
        if (enemigo.puedeActuar()){
            enemigoActua(enemigo);
        } else {
            enemigo.avanzarTurnoSinActuar();
        }
    }
}
