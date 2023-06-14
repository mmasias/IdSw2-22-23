package models;

import settings.Settings;
import interfaces.IMovible;

import java.util.Random;

public class Persona implements IMovible {
    private Planta plantaActual;
    private Planta plantaDestino;
    private Tiempo tiempoEnDestino;
    private boolean esperandoAscensor;
    private boolean dentroAscensor;

    public Persona() {
        this.plantaActual = new Planta(Settings.PLANTA_PRINCIPAL);
        this.plantaDestino = elegirPlantaDestino();
        this.tiempoEnDestino = elegirTiempoEnDestino();
        this.esperandoAscensor = true;
        this.dentroAscensor = false;
    }

    private Tiempo elegirTiempoEnDestino(){
        return new Tiempo(0 , 0, new Random().nextInt(59));
    }

    private Planta elegirPlantaDestino() {
        Random random = new Random();
        int nivelDestino = random.nextInt(Settings.NIVEL_SUPERIOR - Settings.NIVEL_INFERIOR + 1) + Settings.NIVEL_INFERIOR;
        if (nivelDestino == plantaActual.getNivel()) {
            return elegirPlantaDestino();
        } else {
            Planta current = plantaActual;
            while (nivelDestino > current.getNivel() && current.getNivel() + 1 <= Settings.NIVEL_SUPERIOR ) {
                current.setNivel(current.getNivel() + 1);
            }
            while (nivelDestino < current.getNivel() && current.getNivel() - 1 >= Settings.NIVEL_INFERIOR) {
                current.setNivel(current.getNivel() - 1);
            }
            return current;
        }
    }

    public void mover() {
        if (tiempoEnDestino.getSegundos() == 0 && tiempoEnDestino.getMinutos() == 0 && tiempoEnDestino.getHoras() == 0) {
            esperarAscensor();
            setPlantaDestino(new Planta(Settings.PLANTA_PRINCIPAL));
        } else if (!estaDentroAscensor() && !estaEsperandoAscensor()) {
            tiempoEnDestino.disminuir();
        }
    }


    public Planta getPlantaActual() {
        return plantaActual;
    }
    public Planta getPlantaDestino() {
        return plantaDestino;
    }
    public boolean estaEsperandoAscensor() {
        return esperandoAscensor;
    }
    public boolean estaDentroAscensor() {
        return dentroAscensor;
    }
    public void setPlantaActual(Planta plantaActual) {
        this.plantaActual = plantaActual;
    }
    public void setPlantaDestino(Planta plantaDestino) {
        this.plantaDestino = plantaDestino;
    }
    public void esperarAscensor() {
        this.esperandoAscensor = true;
    }
    public void entrarAscensor() {
        this.esperandoAscensor = false;
        this.dentroAscensor = true;
    }
    public void salirAscensor() {
        this.dentroAscensor = false;
    }
}