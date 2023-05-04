import configuracionPjs.*;

public class MainBatalla {

    public static void main (String[] args){
        Batalla batalla;

        batalla = new Batalla(CreadorPersonajes.Heroe(), CreadorPersonajes.Enemigo());

        batalla.comenzarBatalla();
    }
}
