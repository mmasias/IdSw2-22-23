package es.laberinto;

import java.util.Scanner;

public final class JuegoLaberinto {
    private final RenderizadorMundo renderizadorMundo;
    private final Scanner scanner;
    private final Mundo mundo;

    public JuegoLaberinto(int tamano) {
        this.renderizadorMundo = new RenderizadorMundo();
        this.scanner = new Scanner(System.in);
        this.mundo = new Mundo(tamano);
    }

    public void iniciar() {
    }
}
