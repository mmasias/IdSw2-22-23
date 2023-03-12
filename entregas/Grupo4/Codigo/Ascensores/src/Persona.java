class Persona {
    private Planta plantaActual;
    private Planta plantaDestino;

    private boolean esperandoAscensor;

    public Persona(Planta plantaActual) {

        this.plantaActual = plantaActual;
        this.plantaDestino = elegirPlantaDestino();
        esperandoAscensor = false;
    }

    Planta elegirPlantaDestino() {
        int nivel = (int) (Math.random() * 10);
        if (nivel == plantaActual.getNivel()) {
            return elegirPlantaDestino();
        } else {
            Planta current = plantaActual;
            while (nivel > current.getNivel() && current.getPlantaSiguiente() != null) {
                current = current.getPlantaSiguiente();
            }
            while (nivel < current.getNivel() && current.getPlantaAnterior() != null) {
                current = current.getPlantaAnterior();
            }
            return current;
        }
    }


    public Planta getPlantaActual() {
        return plantaActual;
    }

    public boolean estaEsperandoAscensor() {
        return esperandoAscensor;
    }

    public void esperarAscensor() {
        esperandoAscensor = true;
    }

    public void subir() {
        esperandoAscensor = false;
        plantaActual = plantaActual.getPlantaSiguiente();
    }

    public void bajar() {
        esperandoAscensor = false;
        plantaActual = plantaActual.getPlantaAnterior();
    }

    public boolean llegoADestino() {
        return plantaActual == plantaDestino;
    }

    public void estaEnAscensor() {
        esperandoAscensor = false;
    }

    public Planta getPlantaDestino() {
        return plantaDestino;
    }

    public void setPlantaActual(Planta plantaActual) {
        this.plantaActual = plantaActual;
    }

    public void setPlantaDestino(Planta plantaDestino) {
        this.plantaDestino = plantaDestino;
    }
}