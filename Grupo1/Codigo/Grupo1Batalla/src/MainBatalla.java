import Personajes.*;
import Objetos.*;


public class MainBatalla {

    public static void main (String[] args){
        Arma arma1Heroe = new Arma("Arma1", 7, 100, 50);
        Arma arma2Heroe = new Arma("Arma2", 15, 100, 25);
        Arma arma3Heroe = new Arma("Arma3", 25, 100, 12);

        Arma arma1Enemigo = new Arma("Arma1", 5, 100, 90);
        Arma arma2Enemigo = new Arma("Arma2", 10, 100, 60);
        Arma arma3Enemigo = new Arma("Arma3", 20, 100, 40);

        Arma[] armasHeroe = new Arma[]{arma1Heroe, arma2Heroe, arma3Heroe};
        Arma[] armasEnemigo = new Arma[]{arma1Enemigo, arma2Enemigo, arma3Enemigo};

        String[][] spriteHeroe = new String[][]{{"|", "a", "|"}};
        String[][] spriteEnemigo = new String[][]{{"|", "b", "|"}};


        Heroe heroe = new Heroe("Jairo", 150,armasHeroe, spriteHeroe, 30, 2);
        Enemigo enemigo = new Enemigo("Tortajeitor", 60, armasEnemigo, spriteEnemigo, 20, 2);

        // Si se quiere hacer la horda de enemigos
        String[][] spriteHorda = new String[][]{{"|", "b", "|"}};
        Enemigo hordaDeEnemigos = new Enemigo("Horda de Tortajeitors", 250, armasEnemigo, spriteHorda, 20, 2);

        Batalla batalla;

        // 20% de que salga horda al comenzar la batalla
        int probHorda = (int) (Math.random() * 100);
        if (probHorda < 20){
            batalla = new Batalla(heroe, hordaDeEnemigos);
        } else {
            batalla = new Batalla(heroe, enemigo);
        }

        batalla.empezarBatalla();
    }
}
