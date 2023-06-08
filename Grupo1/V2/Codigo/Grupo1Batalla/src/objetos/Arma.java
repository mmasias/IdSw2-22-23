package objetos;

public class Arma {

    private String nombre;
    private int dano;
    private int durabilidad;
    private double probAcertar;
    private EfectoSecundario efectoSecundario = null;


    public Arma(String nombre, int dano, int durabilidad, double probAcertar) {
        this.nombre = nombre;
        this.dano = dano;
        this.durabilidad = durabilidad;
        this.probAcertar = probAcertar;
    }
    public Arma(String nombre, int dano, int durabilidad, double probAcertar, EfectoSecundario efectoSecundario) {
        this.nombre = nombre;
        this.dano = dano;
        this.durabilidad = durabilidad;
        this.probAcertar = probAcertar;
        this.efectoSecundario = efectoSecundario;
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

    public EfectoSecundario getEfectoSecundario(){
        return efectoSecundario;
    }

}
