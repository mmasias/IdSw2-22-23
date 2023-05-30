import personajes.*;
import extras.*;

public class Batalla {
    protected VistaBatalla vista;
    protected Heroe heroe;
    protected Enemigo enemigo;


    public Batalla(Heroe heroe, Enemigo enemigo){
        vista = new VistaBatalla(heroe, enemigo);
        this.heroe = heroe;
        this.enemigo = enemigo;
    }

    public void comenzarBatalla(){

        boolean ambosPersonajesVivos = true;

        while (ambosPersonajesVivos){

            vista.imprimirInterfaz();

            turnoHeroe();

            if (personajeHaMuerto(enemigo)){
                vista.anunciarGanador(heroe);
                break;
            } else {
                turnoEnemigo();
            }

            if (personajeHaMuerto(heroe)){
                vista.anunciarGanador(enemigo);
                ambosPersonajesVivos = false;
            }

            vista.imprimeAccionesDeTurnoActual();

            RegistroDeCombate.pasarTurno();

        }

        RegistroDeCombate.sacarAccionesTotal();
    }

    private boolean personajeHaMuerto(Personaje posiblePerdedor){
        return posiblePerdedor.estaVivo();
    }

    private void turnoHeroe(){
        if (heroe.puedeActuar()){
            jugadorEligeAccion();
        } else {
            heroe.avanzarTurnoSinActuar();
            vista.esperarInteraccion();
        }
    }


    private void jugadorEligeAccion(){
        switch(vista.elegirAccion()){
            case ATACAR -> {
                heroe.equiparArma(vista.elegirArma() - 1);
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

    private void enemigoActua(){
        enemigo.equiparArmaAleatoria();
        enemigo.atacar(heroe);
    }

    private void turnoEnemigo(){
        if (enemigo.puedeActuar()){
            enemigoActua();
        } else {
            enemigo.avanzarTurnoSinActuar();
        }
    }

}
