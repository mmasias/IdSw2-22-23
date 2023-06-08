package personajes;

import configuracionPjs.CreadorPersonajes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Combatientes {

    private static Heroe heroe = CreadorPersonajes.Heroe("Fernando Alonso");

    private static List<Enemigo> enemigos = new LinkedList<>(){{
        add(CreadorPersonajes.Enemigo("Hamilton"));
        add(CreadorPersonajes.Enemigo("Ocon"));
    }};

    public static Heroe getHeroe(){
        return heroe;
    }

    public static List<Personaje> getCombatientesVivos(){
        List<Personaje> listaCompleta = new ArrayList<>();
        listaCompleta.add(heroe);
        listaCompleta.addAll(obtenerEnemigosVivos());

        return listaCompleta;
    }

    public static boolean ambosBandosConVida(){
        return heroe.estaVivo() && hayEnemigosVivos();
    }

    private static boolean hayEnemigosVivos(){
        return enemigos.stream().anyMatch(Personaje::estaVivo);
    }

    public static List<Enemigo> obtenerEnemigosVivos() {
        return enemigos.stream().filter(Personaje::estaVivo).toList();
    }

    public static Personaje getPersonajeVivoRandom(){

        Random random = new Random();
        int enemigoRandom = random.nextInt(getCombatientesVivos().size());

        return getCombatientesVivos().get(enemigoRandom);
    }

}
