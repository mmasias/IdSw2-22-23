package controlador;

import personajes.*;
import extras.*;
import vista.*;

public class Batalla {
    protected VistaBatalla vista;

    public Batalla(){
        vista = new VistaBatalla();
    }

    public void comenzarBatalla(){

        while (Combatientes.ambosBandosConVida()){

            for (var personaje : Combatientes.getCombatientes()){

                vista.imprimirInterfaz();

                personaje.actuar(this);

            }

            /*turnoHeroe();

            if (personajeHaMuerto(enemigo)){
                vista.anunciarGanador(heroe);
                ambosPersonajesVivos = false;
            } else {
                turnoEnemigo();
            }

            if (personajeHaMuerto(heroe)){
                vista.anunciarGanador(enemigo);
                ambosPersonajesVivos = false;
            }


            vista.imprimeAccionesDeTurnoActual();
            RegistroDeCombate.pasarTurno();*/

        }
        vista.imprimeRecuentoDeBatalla();
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

    private void enemigoActua(){
        enemigo.equiparArmaAleatoria();
        enemigo.atacar(heroe);
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
            enemigoActua();
        } else {
            enemigo.avanzarTurnoSinActuar();
        }
    }
}
