package configuracionPjs;
import personajes.*;
import objetos.*;

public class CreadorPersonajes {

    public static Enemigo Enemigo(){
        Arma arma1Enemigo = new Arma("Mercadona", 5, 100, 90);
        Arma arma2Enemigo = new Arma("Beso de gato", 10, 100, 60);
        Arma arma3Enemigo = new Arma("TEO", 20, 100, 40);

        Arma[] armasEnemigo = new Arma[]{arma1Enemigo, arma2Enemigo, arma3Enemigo};

        String[] spriteEnemigo = new String[]{
                "              .-.              ",
                "             (o.o)             ",
                "              |=|              ",
                "             __|__             ",
                "           //.=|=.\\\\         ",
                "          // .=|=. \\\\        ",
                "          \\\\ .=|=. //        ",
                "           \\\\(_=_)//         ",
                "            (:| |:)            ",
                "             || ||             ",
                "             () ()             ",
                "             || ||             ",
                "             || ||             ",
                "            ==' '==            "
        };

        Enemigo enemigo = new Enemigo("Tortajeitor", 60, armasEnemigo, spriteEnemigo, 20, 2);

        return enemigo;

    }

    public static Heroe Heroe(){
        Arma arma1Heroe = new Arma("Pepinardo", 7, 100, 50);
        Arma arma2Heroe = new Arma("Excalibur", 15, 100, 25);
        Arma arma3Heroe = new Arma("Hamburguesa", 25, 100, 12);

        Arma[] armasHeroe = new Arma[]{arma1Heroe, arma2Heroe, arma3Heroe};

        String[] spriteHeroe = new String[]{
                "             _ _              ",
                "            /.-.`.            ",
                "           //o;o\\ \\         ",
                "           \\\\_-_/)/         ",
                "           _`) ( _\\\\        ",
                "        .`) '-.-' ( `.        ",
                "       / `/   .   \\`. \\     ",
                "       \\ \\\\___A___/_` /    ",
                "        '-)|)=@=(|(-'`\\      ",
                "          |/\\   /\\|  )/     ",
                "          /__\\_/__\\         ",
                "         '---' '---'          ",
                "          \\ /   \\ /         ",
                "          ( )   ( )           ",
                "          /_\\   /_\\         ",
                "         '---' '---'          ",
                "          \\ /   \\ /         ",
                "          /_\\   /_\\         "

        };

        Heroe heroe = new Heroe("Heroe", 150,armasHeroe, spriteHeroe, 30, 2);

        return heroe;
    }
}
