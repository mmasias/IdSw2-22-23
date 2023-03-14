import java.util.Scanner;

public class World {
    private User user;
    private static int rows = 20; // número de filas
    private static int columns = 20;
    private static char[][] map;// número de columnas

    World()
    {
        user = new User();
        // crear matriz para el mapa
        map = new char[rows][columns];
        // llenar el mapa con caracteres
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = '.'; // caracter por defecto
            }
        }
        user.setxPosition(0);
        user.setyPosition(0);
        // posición inicial del usuario
        map[user.getxPosition()][user.getyPosition()] = user.getUserIcon();
    }

    public void printWorld()
    {
        // imprimir el mapa actualizado
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println(); // nueva línea para la siguiente fila
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            // obtener la dirección del usuario
            System.out.print("Dirección (WASD): ");
            String direccion = scanner.nextLine();

            // actualizar la posición del usuario
            switch (direccion) {
                case "w":
                    if (user.getxPosition() > 0) {
                        int xPosition = user.getxPosition();
                        xPosition--;
                        map[user.getxPosition()][user.getyPosition()] = '.'; // quitar el usuario del mapa
                        user.setxPosition(xPosition);
                        map[user.getxPosition()][user.getyPosition()] = '@'; // agregar el usuario en la nueva posición
                    }
                    break;
                case "a":
                    if (user.getyPosition() > 0) {
                        int yPosition = user.getyPosition();
                        yPosition--;
                        map[user.getxPosition()][user.getyPosition()] = '.'; // quitar el usuario del mapa
                        user.setyPosition(yPosition);
                        map[user.getxPosition()][user.getyPosition()] = '@'; // agregar el usuario en la nueva posición
                    }
                    break;
                case "s":
                    if (user.getxPosition() < rows - 1) {
                        int xPosition = user.getxPosition();
                        xPosition++;
                        map[user.getxPosition()][user.getyPosition()] = '.'; // quitar el usuario del mapa
                        user.setxPosition(xPosition);
                        map[user.getxPosition()][user.getyPosition()] = '@'; // agregar el usuario en la nueva posición
                    }
                    break;
                case "d":
                    if (user.getyPosition() < columns - 1) {
                        int yPosition = user.getyPosition();
                        yPosition++;
                        map[user.getxPosition()][user.getyPosition()] = '.'; // quitar el usuario del mapa
                        user.setyPosition(yPosition);
                        map[user.getxPosition()][user.getyPosition()] = '@'; // agregar el usuario en la nueva posición
                    }
                    break;
                default:
                    System.out.println("Dirección inválida.");
                    break;
            }

            // imprimir el mapa actualizado
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println(); // nueva línea para la siguiente fila
            }
        }
    }
}
