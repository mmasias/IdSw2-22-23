import java.util.Scanner;

import World.World;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        World world = new World();
        while (true) {
            world.printWorld(scanner);
        }
    }
}