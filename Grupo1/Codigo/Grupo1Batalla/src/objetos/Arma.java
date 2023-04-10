package objetos;

public class Arma {

    private String nombre;
    private int dano;
    private int durabilidad;
    private double probAcertar;

    public Arma(String nombre, int dano, int durabilidad, double probAcertar) {
        this.nombre = nombre;
        this.dano = dano;
        this.durabilidad = durabilidad;
        this.probAcertar = probAcertar;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDurabilidad(){
        return durabilidad;
    }

    public int getDano() {
        return dano;
    }

    public double getProbAcertar() {
        return probAcertar;
    }

    public void desgastar(){
        durabilidad--;
    }

}
