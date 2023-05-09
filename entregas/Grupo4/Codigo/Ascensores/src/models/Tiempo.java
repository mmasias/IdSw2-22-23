package models;

import controllers.Movimiento;
import views.Renderizado;

import java.util.Scanner;

public class Tiempo {
    private int horas;
    private int minutos;
    private int segundos;
    private Universidad universidad;

    public Tiempo() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Tiempo (int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void incrementar() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
        }
        if (minutos == 60) {
            minutos = 0;
            horas++;
        }
    }

    public void disminuir() {
        segundos--;
        if (segundos == -1) {
            segundos = 59;
            minutos--;
        }
        if (minutos == -1) {
            minutos = 59;
            horas--;
        }
    }

    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    private void empezar(){
        universidad = new Universidad();
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        do {
            universidad.mover();
            Renderizado.renderizar(this);
            incrementar();
            entrada = scanner.nextLine();
        } while (entrada.toLowerCase().compareTo("s") != 0);
    }

    public static void main(String[] args) {
        new Tiempo().empezar();
    }

}