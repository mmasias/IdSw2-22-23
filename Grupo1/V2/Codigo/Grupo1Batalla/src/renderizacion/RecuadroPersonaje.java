package renderizacion;

import extras.RegistroDeCombate;
import personajes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecuadroPersonaje {
    private final Personaje heroe;
    private final Personaje enemigo;

    public RecuadroPersonaje(Personaje heroe, Personaje enemigo) {
        this.heroe = heroe;
        this.enemigo = enemigo;
    }


    private String[] unirSprites() {

        // Determinar la longitud del nuevo array
        int alturaMaxima = Math.max(heroe.getSprite().length, enemigo.getSprite().length);

        //Fill gaps
        String[] sprite1 = llenarHuecos(heroe.getSprite(), alturaMaxima);
        String[] sprite2 = llenarHuecos(enemigo.getSprite(), alturaMaxima);

        // Cree un nuevo array para contener los elementos de los dos arrays anteriores
        String[] newArray = new String[alturaMaxima];

        // Concatene los elementos de los dos arrays en una cadena separados por un espacio, y agregue la cadena resultante al nuevo array
        for (int i = 0; i < alturaMaxima; i++) {
            newArray[i] = sprite1[i] + " " + sprite2[i];
        }

        // Retorne el nuevo array con las columnas concatenadas
        return newArray;

    }

    private String[] llenarHuecos(String[] sprite, int alturaMaxima) {
        if (sprite.length == alturaMaxima) return sprite;

        int ancho = sprite[0].length();
        int hueco = alturaMaxima - sprite.length;

        List<String> list = new ArrayList<>(Arrays.stream(sprite).toList());
        for (int i = 0; i < hueco; i++) {
            list.add(0, String.join("", Collections.nCopies(ancho, "")));
        }

        return list.toArray(new String[0]);
    }

    public void imprimir() {

        int largo = heroe.getSprite()[0].length() + enemigo.getSprite()[0].length();
        ArrayList<String> recuadro = prepararRecuadro(largo);
        for (String line : recuadro) {
            System.out.println(line);

        }
    }

    private ArrayList<String> prepararRecuadro(int largo) {
        ArrayList<String> recuadro = new ArrayList<>();

        String borde = String.join("", Collections.nCopies(largo, "+"));

        String vidaPersonaje1 = String.join("", Collections.nCopies((heroe.getVidaActual() / 10) + 1, "❤"));
        String vidaPersonaje2 = String.join("", Collections.nCopies((enemigo.getVidaActual() / 10) + 1, "❤"));

        String espacioVidas = calcularEspacioVidas(borde, vidaPersonaje1, vidaPersonaje2);
        String espacioNombres = calcularEspacioNombres(borde);

        //Borde
        recuadro.add(borde);
        //Turno
        recuadro.add("Turno " + RegistroDeCombate.turnoActual());
        //Vida y Nombre
        recuadro.add(vidaPersonaje1 + espacioVidas + vidaPersonaje2);
        recuadro.add(heroe.getNombre() + espacioNombres + enemigo.getNombre());
        recuadro.add(heroe.getVidaActual() + String.join("",
                Collections.nCopies(borde.length() - 6, " ")) + enemigo.getVidaActual());
        //Personaje
        recuadro.addAll(Arrays.asList(unirSprites()));
        //Borde
        recuadro.add(borde);
        return recuadro;
    }

    private String calcularEspacioNombres(String borde) {
        return String.join("",
                Collections.nCopies(borde.length() - (heroe.getNombre().length() + enemigo.getNombre().length()), " "));
    }

    private static String calcularEspacioVidas(String borde, String vidaPersonaje1, String vidaPersonaje2) {
        return String.join("",
                Collections.nCopies(borde.length() - ((int) Math.round((vidaPersonaje1.length() + vidaPersonaje2.length()) * 1.5)), " "));
    }

}
