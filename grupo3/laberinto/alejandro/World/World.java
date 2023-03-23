package World;
import java.util.Map;
import java.util.Scanner;

import Block.Block;
import Block.Pared;
import Block.Suelo;
import Position.Position;
import User.User;

import java.lang.Math;
public class World {
    private static final int[][] INTMAP = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    private User user;
    private static int rows = INTMAP.length ; // número de filas
    private static int columns = INTMAP[0].length; // número de columnas
    private static Block[][] map; 
    private static final Map<Integer, Block> BLOCKMAPPER = Map.of(
            0, new Suelo(),
            1, new Pared()
            //2, AguaTurbulenta.crear(),
            //3, Montana.crear(),
            //4, CespedMedio.crear(),
            //5, Agua.crear(),
            //6, Arena.crear(),
            //7, CespedAlto.crear(),
            //8, CespedBajo.crear()*/
    );
    public World()
    {
        user = new User();
        // crear matriz para el mapa
        map = new Block[rows][columns];
        // llenar el mapa con caracteres
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = BLOCKMAPPER.get(INTMAP[i][j]);
            }
        }
    }

    public static Block[][] getMap() {
        return map;
    }
    
    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    public static Block getBlock(Position position) {
        return map[(int) Math.floor(position.getX())][(int) Math.floor(position.getY())];
    }

    public void printWorld(Scanner scanner)
    {
        // imprimir el mapa actualizado
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(user.getPosition().getY() == j && user.getPosition().getX() == i)
                System.out.print(user.getSprite());
                else
                System.out.print(map[i][j].getSprite());
            }
            System.out.println(); // nueva línea para la siguiente fila
        }

        System.out.print("Dirección (WASD): ");
        String direccion = scanner.nextLine();

        // actualizar la posición del usuario
        user.move(direccion);
    }
}
