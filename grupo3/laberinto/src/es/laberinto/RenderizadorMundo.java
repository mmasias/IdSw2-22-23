package es.laberinto;

import es.laberinto.bloques.*;
import es.laberinto.utils.Posicion;

public final class RenderizadorMundo {
    public void renderizar(Mundo mundo) {
        System.out.flush();

        int posicionXPersonaje = mundo.personaje.getPosicionActual().x();
        int posicionYPersonaje = mundo.personaje.getPosicionActual().y();

        for(int i = 0; i<mundo.bloques.length; i++){
            for(int j = 0; j < mundo.bloques[0].length; j++){
                if(posicionYPersonaje == i && posicionXPersonaje == j){
                    System.out.print("/0/");
                }
                else if (mundo.bloques[i][j]instanceof Agua)	{System.out.print("~~~");}
                else if (mundo.bloques[i][j]instanceof AguaTurbulenta)	{System.out.print("888");}
                else if (mundo.bloques[i][j]instanceof Arena)	{System.out.print("...");}
                else if (mundo.bloques[i][j]instanceof CespedBajo)	{System.out.print(".:.");}
                else if (mundo.bloques[i][j]instanceof CespedMedio)	{System.out.print(":::");}
                else if (mundo.bloques[i][j]instanceof CespedAlto)	{System.out.print("///");}
                else if (mundo.bloques[i][j]instanceof Montana)	{System.out.print("^^^");}
                else if (mundo.bloques[i][j]instanceof Pared)	{System.out.print("[ ]");}
                else if (mundo.bloques[i][j]instanceof Suelo)	{System.out.print("___");}
            }
            System.out.println();
        }
    }
}
