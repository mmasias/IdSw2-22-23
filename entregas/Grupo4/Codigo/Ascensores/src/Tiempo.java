import java.util.Date;

class Tiempo {
    private Date tiempoFinal;
    private Date tiempoActual;

    public Tiempo() {
        tiempoActual = new Date();
        tiempoFinal = null;
    }

    public Tiempo(Date tiempoFinal) {
        this.tiempoFinal = tiempoFinal;
        tiempoActual = new Date();
    }

    public void avanzar() {
        tiempoActual.setTime(tiempoActual.getTime() + 1000);
    }

    public Date getTiempoActual() {
        return tiempoActual;
    }

    public Date getTiempoFinal() {
        return tiempoFinal;
    }

    public boolean isFinalizado() {
        return tiempoActual.after(tiempoFinal);
    }

}