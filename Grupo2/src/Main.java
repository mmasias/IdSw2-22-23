import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir = false;
        List<Maquina> maquinas = new ArrayList<Maquina>();

        do{
            String option = "";
            System.out.println("-----------------------------------------------------");
            System.out.println("[1] Agregar maquinas");
            System.out.println("[2] Comprar");
            System.out.println("[3] Salir");
            System.out.println("----------------   Elige una opcion: ");
            option = input.nextLine();

            if(option.equals("1"))
                maquinas = Maquina.menuMaquinas(input);
            else if(option.equals("2"))
                Compra.menu(maquinas);
            else if(option.equals("3")){
                System.out.println("Saliendo...");
                salir = true;
            }
        }while(!salir);
    }
}
