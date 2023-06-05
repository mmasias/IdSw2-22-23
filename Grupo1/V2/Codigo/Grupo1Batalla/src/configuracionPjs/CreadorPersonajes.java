package configuracionPjs;
import personajes.*;
import objetos.*;

public class CreadorPersonajes {

    public static Enemigo Enemigo(String nombre){
        Arma arma1Enemigo = new Arma("Mercadona", 5, 15, 90);
        Arma arma2Enemigo = new Arma("Beso de gato", 10, 15, 60);
        Arma arma3Enemigo = new Arma("TEO", 20, 10, 40);

        Arma[] armasEnemigo = new Arma[]{arma1Enemigo, arma2Enemigo, arma3Enemigo};

        String[] spriteEnemigo = new String[]{
                "              .-.              ",
                "             (o.o)             ",
                "              |=|              ",
                "             __|__             ",
                "           //.=|=.\\\\           ",
                "          // .=|=. \\\\          ",
                "          \\\\ .=|=. //          ",
                "           \\\\(_=_)//           ",
                "            (:| |:)            ",
                "             || ||             ",
                "             () ()             ",
                "             || ||             ",
                "             || ||             ",
                "            ==' '==            "
        };

        Vida vida = new Vida(60, 20,2);
        Enemigo enemigo = new Enemigo(nombre, vida, armasEnemigo, spriteEnemigo);

        return enemigo;

    }

    public static Heroe Heroe(String nombre){
        Arma arma1Heroe = new Arma("Thousand truths", 7, 100, 50);
        Arma arma2Heroe = new Arma("Excalibur", 15, 15, 25);
        Arma arma3Heroe = new Arma("Hamburguesa", 25, 10, 12);

        Arma[] armasHeroe = new Arma[]{arma1Heroe, arma2Heroe, arma3Heroe};

        String[] spriteHeroe = new String[]{
                "             _ _              ",
                "            /.-.`.            ",
                "           //o;o\\ \\           ",
                "           \\\\_-_/)/           ",
                "           _`) ( _\\\\          ",
                "        .`) '-.-' ( `.        ",
                "       / `/   .   \\`. \\       ",
                "       \\ \\\\___A___/_` /       ",
                "        '-)|)=@=(|(-'`\\       ",
                "          |/\\   /\\|  )/       ",
                "          /__\\_/__\\           ",
                "         '---' '---'          ",
                "          \\ /   \\ /           ",
                "          ( )   ( )           ",
                "          /_\\   /_\\           ",
                "         '---' '---'          ",
                "          \\ /   \\ /           ",
                "          /_\\   /_\\           "

        };


        Vida vida = new Vida(150, 30, 2);
        Heroe heroe = new Heroe(nombre, vida, armasHeroe, spriteHeroe);

        return heroe;
    }
}
