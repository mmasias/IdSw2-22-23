package Objetos;

public class Arma {

    private String nombre;
    private int daño;
    private int durabilidad;
    private float probAcertar;
    private float probDesgaste;

    public Arma(String nombre, int daño, int durabilidad, float probAcertar, float probDesgaste) {
        this.nombre = nombre;
        this.daño = daño;
        this.durabilidad = durabilidad;
        this.probAcertar = probAcertar;
        this.probDesgaste = probDesgaste;
    }

    public String getNombre(){
        return nombre;
    }
}
