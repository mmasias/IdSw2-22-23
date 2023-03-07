import Personajes.*;
import Objetos.*;
public class MainBatalla {

    public static void main (String[] args){
        //nueva batalla

        Arma armaDefault = new Arma("Pepineitor 1", 2, 5, 30, 30);
        Arma armaDefault2 = new Arma("Excalibur", 2, 5, 30, 30);
        Arma[] armas = new Arma[]{armaDefault, armaDefault2};

        String[][] spriteHeroe = new String[][]{{"|", "a", "|"}, {"|", "a", "|"}, {"|", "a", "|"}};
        String[][] spriteEnemigo = new String[][]{{"|", "b", "|"}, {"|", "b", "|"}, {"|", "b", "|"}};

        Heroe heroe = new Heroe("Jairo", 20,armas, spriteHeroe, null );
        Enemigo enemigo = new Enemigo("Tortajeitor", 20, armas, spriteEnemigo);


        Batalla batalla = new Batalla(heroe, enemigo);
        batalla.empezarBatalla();
    }
}
