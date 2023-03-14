class Planta implements Comparable<Planta> {
    private int nivel;
    private Planta plantaSiguiente;
    private Planta plantaAnterior;

    public Planta(int nivel, Planta plantaSiguiente, Planta plantaAnterior) {
        this.nivel = nivel;
        this.plantaSiguiente = plantaSiguiente;
        this.plantaAnterior = plantaAnterior;
    }

    public int getNivel() {
        return nivel;
    }

    public void setPlantaSiguiente(Planta plantaSiguiente) {
        this.plantaSiguiente = plantaSiguiente;
    }

    public Planta getPlantaSiguiente() {
        return plantaSiguiente;
    }

    public Planta getPlantaAnterior() {
        return plantaAnterior;
    }

    @Override
    public int compareTo(Planta o) {
        return nivel - o.getNivel();
    }
}