package renderizacion;

import extras.RegistroDeCombate;
import personajes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RecuadroPersonaje {
    //private final List<Personaje> combatientes = Combatientes.getCombatientes();
    private List<Personaje> combatientes;

    private String[] unirSprites() {

        int alturaMaxima = combatientes.stream()
                .map(personaje -> personaje.getSprite().length)
                .max(Integer::compare)
                .get();

        String[][] sprites = combatientes.stream()
                .map(personaje -> llenarHuecos(personaje.getSprite(), alturaMaxima))
                .toArray(String[][]::new);

        String[] recuadroDeBatalla = new String[alturaMaxima];

        for (int altura = 0; altura < alturaMaxima; altura++) {
            StringBuilder newLine = new StringBuilder();
            for (int sprite = 0; sprite < sprites.length; sprite++) {
                newLine.append(sprites[sprite][altura]);
            }
            recuadroDeBatalla[altura] = String.valueOf(newLine);
        }

        return recuadroDeBatalla;
    }

    private String[] llenarHuecos(String[] sprite, int alturaMaxima) {
        if (sprite.length == alturaMaxima) return sprite;

        int ancho = sprite[0].length();
        int hueco = alturaMaxima - sprite.length;

        List<String> list = new ArrayList<>(Arrays.stream(sprite).toList());

        for (int i = 0; i < hueco; i++) {
            list.add(0, String.join("", Collections.nCopies(ancho, " ")));
        }
        return list.toArray(new String[0]);
    }

    public void imprimir(List<Personaje> combatientes) {

        this.combatientes = combatientes;

        int largo = combatientes.stream()
                .map(personaje -> personaje.getSprite()[0].length())
                .reduce(0, Integer::sum);
        ArrayList<String> recuadro = prepararRecuadro(largo);
        for (String line : recuadro) {
            System.out.println(line);

        }
    }

    private ArrayList<String> prepararRecuadro(int largo) {
        ArrayList<String> recuadro = new ArrayList<>();

        String borde = String.join("", Collections.nCopies(largo, "+"));

        List<String> vidasYNombres = combatientes.stream()
                .map(personaje -> String.format("%s :  ", personaje.getNombre()) +
                        String.join(""
                                , Collections
                                        .nCopies((personaje.getVidaActual() / 10) + 1, "❤"))
                ).toList();

        recuadro.add(borde);

        recuadro.add("Turno " + RegistroDeCombate.turnoActual());
        recuadro.addAll(vidasYNombres);
        recuadro.addAll(Arrays.asList(unirSprites()));

        recuadro.add(borde);

        return recuadro;
    }

}
