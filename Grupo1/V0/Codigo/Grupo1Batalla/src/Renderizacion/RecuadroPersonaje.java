package Renderizacion;

public class RecuadroPersonaje {
    private String[][] sprite;
    private int vida;
    private String nombre;

    public RecuadroPersonaje(String[][] sprite, int vida, String nombre){
        this.sprite = sprite;
        this.vida = vida;
        this.nombre = nombre;
    }

    public void imprimir(){
        for(int i = 0; i < sprite.length; i++){
            for (int j = 0 ; j < sprite[i].length; j++){
                System.out.print(sprite[i][j]);
            }
            System.out.println();
        }

        System.out.println("Nombre -->" + nombre + " _ " + vida);
        System.out.println();
    }

}
