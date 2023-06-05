package personajes;

import configuracionPjs.CreadorPersonajes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Combatientes {

    private static Heroe heroe = CreadorPersonajes.Heroe("Fernando Alonso");

    private static List<Enemigo> enemigos = new LinkedList<>(){{
        add(CreadorPersonajes.Enemigo("Hamilton"));
        add(CreadorPersonajes.Enemigo("Tortix"));
    }};

    public static Heroe getHeroe(){
        return heroe;
    }

    public static List<Enemigo> getEnemigos(){
        return enemigos;
    }

    public static List<Personaje> getCombatientes(){
        List<Personaje> listaCompleta = new ArrayList<>();
        listaCompleta.add(heroe);
        listaCompleta.addAll(enemigos);

        return listaCompleta;
    }

    public static boolean ambosBandosConVida(){
        return heroe.estaVivo() && hayEnemigosVivos();
    }

    private static boolean hayEnemigosVivos(){
        return enemigos.stream().anyMatch(Personaje::estaVivo);
    }

    public static Enemigo elegirPrimerEnemigoVivo(){
        return enemigos.stream().filter(Personaje::estaVivo).toList().get(0);

    }
}
