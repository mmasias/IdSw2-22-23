package renderizacion;

import personajes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecuadroPersonaje {
    private final Personaje personaje;
    private final Personaje personaje2;

    public RecuadroPersonaje(Personaje personaje1, Personaje personaje2) {
        this.personaje = personaje1;
        this.personaje2 = personaje2;
    }


    private String[] unirSprites() {

        // Determinar la longitud del nuevo array
        int alturaMaxima = Math.max(personaje.getSprite().length, personaje2.getSprite().length);

        //Fill gaps
        String[] sprite1 = llenarHuecos(personaje.getSprite(), alturaMaxima);
        String[] sprite2 = llenarHuecos(personaje2.getSprite(), alturaMaxima);

        // Cree un nuevo array para contener los elementos de los dos arrays anteriores
        String[] newArray = new String[alturaMaxima];

        // Concatene los elementos de los dos arrays en una cadena separados por un espacio, y agregue la cadena resultante al nuevo array
        for (int i = 0; i < alturaMaxima; i++) {
            newArray[i] = sprite1[i] + " " + sprite2[i] ;
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

        int largo = personaje.getSprite()[0].length() + personaje2.getSprite()[0].length();

        ArrayList<String> recuadro = new ArrayList<>();

        String borde = String.join("", Collections.nCopies(largo, "+"));

        String vidaPersonaje1 = String.join("", Collections.nCopies(personaje.getVidaActual() / 10, "❤️"));
        String vidaPersonaje2 = String.join("", Collections.nCopies(personaje2.getVidaActual() / 10, "❤️"));

        String espacioVidas = String.join("",
                Collections.nCopies(borde.length() - vidaPersonaje2.length() - vidaPersonaje1.length(), " "));
        String espacioNombres = String.join("",
                Collections.nCopies(borde.length() - personaje.getNombre().length() - personaje2.getNombre().length() , " "));

        //Borde
        recuadro.add(borde);
        //Vida y Nombre
        recuadro.add(vidaPersonaje1 + espacioVidas + vidaPersonaje2);
        recuadro.add(personaje.getNombre() + espacioNombres + personaje2.getNombre());
        //Personaje
        recuadro.addAll(Arrays.asList(unirSprites()));
        //Borde
        recuadro.add(borde);

        for (String line : recuadro) {
            System.out.println(line);

        }
    }

}
