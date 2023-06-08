package configuracionPjs;
import personajes.*;
import objetos.*;

public class CreadorPersonajes {

    public static Enemigo Enemigo(String nombre){
        Arma arma1Enemigo = new Arma("Mercadona", 5, 15, 100);
        Arma arma2Enemigo = new Arma("Beso de gato", 10, 15, 80);
        Arma arma3Enemigo = new Arma("TEO", 20, 10, 70);

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

        return new Enemigo(nombre, vida, armasEnemigo, spriteEnemigo);

    }

    public static Heroe Heroe(String nombre){
        Arma arma1Heroe = new Arma("Thousand truths", 7, 100, 100);
        Arma arma2Heroe = new Arma("Excalibur", 45, 15, 80);
        Arma arma3Heroe = new Arma("Hamburguesa", 25, 10, 90);
        Arma arma4Heroe = new Arma("Flora", 10, 5, 80, new EfectoAturdir());

        Arma[] armasHeroe = new Arma[]{arma1Heroe, arma2Heroe, arma3Heroe, arma4Heroe};

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

        return new Heroe(nombre, vida, armasHeroe, spriteHeroe);
    }
}
