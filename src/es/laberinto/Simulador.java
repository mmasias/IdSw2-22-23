package es.laberinto;

import es.laberinto.controlador.Mundo;
import es.laberinto.modelo.Posicion;
import es.laberinto.modelo.bloques.*;
import es.laberinto.modelo.entides.*;
import es.laberinto.vista.RenderizadorMundo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Simulador {
    private static final Posicion POSICION_INICIAL_PERSONAJE = Posicion.crear(3, 3);
    public static void simular(int numeroBarcas, int numeroAlfombras, int numeroCaballos, int numeroNPCs){

        Mundo mundo = new Mundo(
                crearListaEntidades(crearPosiciones(numeroBarcas), crearPosiciones(numeroAlfombras), crearPosiciones(numeroCaballos), crearPosiciones(numeroNPCs)),
                Personaje.crear(POSICION_INICIAL_PERSONAJE),
                crearArrayaBloques(),
                new RenderizadorMundo()
        );

        mundo.iniciar();
    }
    private static List<Posicion> crearPosiciones(int numeroEntidades) {
        List<Posicion> lista = new ArrayList<>();
        for(int i = 0; i<numeroEntidades;i++){
            Random random = new Random();
            int coordenadaX = random.nextInt(20) + 1;
            int coordenadaY = random.nextInt(18) + 1;
            Posicion POSICION_INICIAL_BARCA = Posicion.crear(coordenadaX, coordenadaY);
            lista.add(POSICION_INICIAL_BARCA);
        }
        return lista;
    }
    private static List<Entidad> crearListaEntidades(List<Posicion> posicionesBarcas, List<Posicion> posicionesAlfombras, List<Posicion> posicionesCaballos, List<Posicion> posicionesNPCs) {
        List<Entidad> lista = new ArrayList<>();
        for (Posicion posicionesBarca : posicionesBarcas) {
            lista.add(Barca.crear(posicionesBarca));
        }
        for (Posicion posicionesAlfombra : posicionesAlfombras) {
            lista.add(Alfombra.crear(posicionesAlfombra));
        }
        for (Posicion posicionesCaballo : posicionesCaballos) {
            lista.add(Caballo.crear(posicionesCaballo));
        }
        for (Posicion posicionesNPC : posicionesNPCs) {
            lista.add(NPC.crear(posicionesNPC));
        }
        return lista;
    }

    private static Bloque[][] crearArrayaBloques() {
        Bloque[][] bloques = new Bloque[MAPA_BLOQUES_ID.length][MAPA_BLOQUES_ID[0].length];

        for (int i = 0; i < MAPA_BLOQUES_ID.length; i++) {
            for (int j = 0; j < MAPA_BLOQUES_ID[i].length; j++) {
                bloques[i][j] = BLOQUES_BY_ID.get(MAPA_BLOQUES_ID[i][j]);
            }
        }

        return bloques;
    }

    private static final Map<Integer, Bloque> BLOQUES_BY_ID = Map.of(
            0, Suelo.crear(),
            1, Pared.crear(),
            2, AguaTurbulenta.crear(),
            3, Montana.crear(),
            4, CespedMedio.crear(),
            5, Agua.crear(),
            6, Arena.crear(),
            7, CespedAlto.crear(),
            8, CespedBajo.crear()
    );

    private static final int[][] MAPA_BLOQUES_ID = new int[][]{
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,8,8,8,0,0,0,0,0,0,0,8,8,8,0,0,3,3,3,3,3,3,3,1},
            {1,8,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,3,3,3,3,3,1},
            {1,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,5,3,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,5,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8,5,1},
            {1,5,5,5,5,5,0,0,0,5,5,5,5,5,0,0,0,0,0,0,0,0,5,1},
            {1,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,8,1},
            {1,5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,1},
            {1,5,0,1,1,1,0,0,0,1,1,1,0,5,8,8,8,8,8,8,8,8,5,1},
            {1,5,0,1,1,1,1,2,1,1,1,1,0,5,8,6,6,6,6,6,6,5,5,1},
            {1,5,0,0,1,0,0,0,0,0,1,0,0,5,6,6,6,6,6,5,5,5,5,1},
            {1,5,0,0,1,0,0,0,0,0,1,0,0,5,6,6,6,2,5,5,5,8,8,1},
            {1,5,0,0,1,0,0,0,0,0,1,0,0,5,6,6,5,2,5,6,6,6,8,1},
            {1,5,0,1,1,0,1,1,1,0,1,1,0,5,6,5,5,6,6,6,8,8,8,1},
            {1,5,0,1,1,0,0,0,0,0,1,1,0,5,5,5,6,6,6,6,6,8,1,1},
            {1,5,0,0,0,0,0,0,0,0,0,0,0,5,4,4,6,6,6,8,8,8,1,1},
            {1,5,5,5,5,5,5,5,5,5,5,5,5,5,4,4,6,6,8,8,8,8,1,1},
            {1,7,7,4,4,4,4,4,4,4,4,4,4,4,4,4,6,6,8,8,8,8,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
    };
}
