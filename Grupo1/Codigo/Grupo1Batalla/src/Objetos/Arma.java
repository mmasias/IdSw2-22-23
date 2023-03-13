package Objetos;

public class Arma {

    private String nombre;
    private int dano;
    private int durabilidad;
    private double probAcertar;
    private double probDesgaste;

    public Arma(String nombre, int dano, int durabilidad, double probAcertar, double probDesgaste) {
        this.nombre = nombre;
        this.dano = dano;
        this.durabilidad = durabilidad;
        this.probAcertar = probAcertar;
        this.probDesgaste = probDesgaste;
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

    public double getProbDesgaste() {
        return probDesgaste;
    }

    public void desgastar(){
        durabilidad--;
    }

}
