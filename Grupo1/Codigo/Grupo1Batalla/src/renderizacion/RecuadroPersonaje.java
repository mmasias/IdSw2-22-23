package renderizacion;

import personajes.*;

public class RecuadroPersonaje {
    private final Personaje personaje;

    public RecuadroPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public void imprimir(){
        System.out.println("////////////////////////////////////////////////////////////");
        for(int i = 0; i < personaje.getSprite().length; i++){
                System.out.print(personaje.getSprite()[i]);
            System.out.println();
        }

        System.out.println("Nombre --> " + personaje.getNombre() + " | Vida --> " + personaje.getVidaActual());
        System.out.println("////////////////////////////////////////////////////////////");
        System.out.println();
    }

}
