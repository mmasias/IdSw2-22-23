package es.laberinto;

import es.laberinto.bloques.*;
import es.laberinto.utils.Posicion;

public final class RenderizadorMundo {
    public void renderizar(Mundo mundo) {
        int posicionX = mundo.personaje.getPosicionActual().x();
        int posicionY = mundo.personaje.getPosicionActual().y();
        boolean necesitasBloque = true;
        for(int i = 0; i<mundo.bloques.length; i++){
            for(int j = 0; j< mundo.bloques[0].length;j++){
                necesitasBloque = true;
                if(posicionX == j && posicionY == i) {
                    System.out.print("/0/");
                    necesitasBloque = false;
                }
                for(int k = 0; k< mundo.entidades.size();k++){
                    if(mundo.entidades.get(k).getPosicionActual().x() == i && mundo.entidades.get(k).getPosicionActual().y() == j){
                        System.out.print("EEE");
                        necesitasBloque = false;
                    }
                }
                if(necesitasBloque){
                    if (mundo.bloques[i][j]instanceof Agua)	{System.out.print("~~~");}
                    else if (mundo.bloques[i][j]instanceof AguaTurbulenta)	{System.out.print("888");}
                    else if (mundo.bloques[i][j]instanceof Arena)	{System.out.print("...");}
                    else if (mundo.bloques[i][j]instanceof CespedBajo)	{System.out.print(".:.");}
                    else if (mundo.bloques[i][j]instanceof CespedMedio)	{System.out.print(":::");}
                    else if (mundo.bloques[i][j]instanceof CespedAlto)	{System.out.print("///");}
                    else if (mundo.bloques[i][j]instanceof Montana)	{System.out.print("^^^");}
                    else if (mundo.bloques[i][j]instanceof Pared)	{System.out.print("[ ]");}
                    else if (mundo.bloques[i][j]instanceof Suelo)	{System.out.print("___");}
                }
            }
            System.out.println();
        }
    }
}
