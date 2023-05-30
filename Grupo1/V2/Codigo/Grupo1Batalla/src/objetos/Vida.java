package objetos;

public class Vida {
    protected int vidaActual;
    protected int vidaMaxima;
    protected final int umbralVidaParaDesmayarse;
    protected final int vidaARecuperarDesmayado;

    public Vida(int vidaMaxima, int umbralVidaParaDesmayarse, int vidaARecuperarDesmayado){
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;

        this.umbralVidaParaDesmayarse = umbralVidaParaDesmayarse;
        this.vidaARecuperarDesmayado = vidaARecuperarDesmayado;
    }

    public void restarVida(int vidaARestar) {
        this.vidaActual -= vidaARestar;
    }

    public void curarDesmayado(){
        this.vidaActual += vidaARecuperarDesmayado;
    }

    public void curarPorCompleto(){
        this.vidaActual = vidaMaxima;
    }

    public int getUmbralDesmayo() {
        return umbralVidaParaDesmayarse;
    }

    public int getVidaARecuperarDesmayado() {
        return vidaARecuperarDesmayado;
    }

    public int getVidaActual(){
        return vidaActual;
    }

    public boolean mayorQueCero(){
        return vidaActual > 0;
    }

    public boolean debajoDelUmbral(){
        return vidaActual < umbralVidaParaDesmayarse;
    }



}
