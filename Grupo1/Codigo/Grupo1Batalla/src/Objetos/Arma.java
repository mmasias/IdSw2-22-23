package Objetos;

public class Arma {

    private String nombre;
    private int daño;
    private int durabilidad;
    private double probAcertar;
    private double probDesgaste;

    public Arma(String nombre, int daño, int durabilidad, double probAcertar, double probDesgaste) {
        this.nombre = nombre;
        this.daño = daño;
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

    public int getDaño() {
        return daño;
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
