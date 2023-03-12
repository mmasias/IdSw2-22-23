import java.util.*;

class Planta {
    private int nivel;
    private Planta plantaSiguiente;
    private Planta plantaAnterior;
    private List<Puerta> Puertas;
    private Boton boton;

    public Planta(int nivel, Puerta[] puertas, Planta plantaSiguiente, Planta plantaAnterior) {
        this.nivel = nivel;
        Puertas = List.of(puertas);
        this.plantaSiguiente = plantaSiguiente;
        this.plantaAnterior = plantaAnterior;
        this.boton = new Boton(nivel);
    }

    public int getNivel() {
        return nivel;
    }

    public Boton getBoton() {
        return boton;
    }

    public List<Puerta> getPuertas() {
        return Puertas;
    }

    public void setPlantaSiguiente(Planta plantaSiguiente) {
        this.plantaSiguiente = plantaSiguiente;
    }

    public void setPlantaAnterior(Planta plantaAnterior) {
        this.plantaAnterior = plantaAnterior;
    }

    public Planta getPlantaSiguiente() {
        return plantaSiguiente;
    }

    public Planta getPlantaAnterior() {
        return plantaAnterior;
    }
}