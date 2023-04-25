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

        while (true){

            vista.imprimirInterfaz();

            if (heroe.puedeActuar()){
                turnoHeroe();

                if (!enemigo.estaVivo()){
                    vista.anunciarGanador(heroe);
                    break;
                }

            } else {
                heroe.avanzarTurnoSinActuar();

                vista.esperarInteraccion();
            }

            if (enemigo.puedeActuar()){
                turnoEnemigo();

                if (!heroe.estaVivo()){
                    vista.anunciarGanador(enemigo);
                    break;
                }

            } else {
                enemigo.avanzarTurnoSinActuar();
            }
            RegistroDeCombate.sacarAccionesTurnoACtual();

            RegistroDeCombate.pasarTurno();

        }

        System.out.println("-----");
        RegistroDeCombate.sacarAccionesTotal();
    }


    private void turnoHeroe(){
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

    private void turnoEnemigo(){
        enemigo.equiparArmaAleatoria();
        enemigo.atacar(heroe);
    }
}
