import java.util.List;

class Ascensor {

    private Planta plantaActual;
    private List<Boton> botones;

    private List<Puerta> puertas;

    public Ascensor(Planta plantaActual, Boton[] botones) {
        this.plantaActual = plantaActual;
        this.botones = List.of(botones);
        this.puertas = null;
    }

    public void agregarDestino(Planta plantaDestino) {
        int index = botones.indexOf(new Boton(plantaDestino.getNivel()));
        botones.get(index).presionar();
    }

    public void agregarPuertas(Puerta[] puertas) {
        this.puertas = List.of(puertas);
    }

    public void abrirPuerta(Boton boton) {
        puertas.get(puertas.indexOf(new Puerta(boton))).abrir();
    }

    public void cerrarPuerta(Boton boton) {
        puertas.get(puertas.indexOf(new Puerta(boton))).cerrar();
    }

    public Planta getPlantaActual() {
        return plantaActual;
    }

    public void mover(Boton botonPulsado) {

    }


}