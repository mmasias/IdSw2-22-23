package Renderizacion;

import Personajes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecuadroPersonaje {
    private final Personaje personaje;

    public RecuadroPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public void imprimir(){

        ArrayList<String> recuadro = new ArrayList<>();

        int largo = personaje.getSprite()[0].length();
        String borde = String.join("", Collections.nCopies(largo, "/"));
        String vida = String.join("", Collections.nCopies(personaje.getVidaActual()/10, "❤️"));

        //Borde
        recuadro.add(borde);
        //Vida y Nombre
        recuadro.add(vida);
        recuadro.add(personaje.getNombre());
        //Personaje
        recuadro.addAll(Arrays.asList(personaje.getSprite()));
        //Borde
        recuadro.add(borde);

        for (String line: recuadro) {
            System.out.println(line);

        }
    }

}
