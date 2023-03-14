import java.util.Random;

class Persona {
    private Planta plantaActual;
    private Planta plantaDestino;
    private Tiempo estanciaEnDestino;
    private boolean esperandoAscensor;
    private boolean dentroAscensor;

    public Persona(Planta plantaActual) {
        this.plantaActual = plantaActual;
        this.plantaDestino = elegirPlantaDestino();
        estanciaEnDestino = elegirEstanciaEnDestino();
        esperandoAscensor = false;
        dentroAscensor = false;
    }

    private Tiempo elegirEstanciaEnDestino(){
        Random random = new Random();
        int tiempo = random.nextInt(Constans.ESTANCIA_MAXIMA - 0 + 1) + 0;
        return new Tiempo(tiempo);
    }

    private Planta elegirPlantaDestino() {
        int a = Constans.NIVEL_INFERIOR;
        int b = Constans.NIVEL_SUPERIOR;
        Random random = new Random();
        int nivel = random.nextInt(b - a + 1) + a;
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

    public boolean estaDentroAscensor() {
        return dentroAscensor;
    }

    public void esperarAscensor() {
        esperandoAscensor = true;
    }
    public void entrarAscensor() {
        esperandoAscensor = false;
        dentroAscensor = true;
    }

    public void salirAscensor() {
        dentroAscensor = false;
    }

    public void incrementarTiempo() {
        estanciaEnDestino.incrementar();
    }
    public boolean tieneQueIrse() {
        return estanciaEnDestino.haPasado();
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