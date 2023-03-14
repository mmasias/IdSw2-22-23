import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Billete> billetesMaquina001 = Billete.crearListaDeBilletes(3,1,2,5,10);
        List<Moneda> monedasMaquina001 = Moneda.crearListaDeMonedas(10, 20, 10);

        List<Billete> billetesMaquina002 = Billete.crearListaDeBilletes(3, 2, 3, 7, 15);
        List<Moneda> monedasMaquina002 = Moneda.crearListaDeMonedas(25, 30, 20);

        List<Billete> billetesMaquina003 = Billete.crearListaDeBilletes(3, 1, 3, 5, 12);
        List<Moneda> monedasMaquina003 = Moneda.crearListaDeMonedas(30, 10, 15);

        List<Producto> productos = Producto.crearListaDeProductos();

        List<Maquina> maquinas = new ArrayList<Maquina>();
        maquinas.add(new Maquina("Maquina 1", billetesMaquina001, monedasMaquina001, productos));
        maquinas.add(new Maquina("Maquina 2", billetesMaquina002, monedasMaquina002, productos));
        maquinas.add(new Maquina("Maquina 3", billetesMaquina003, monedasMaquina003, productos));

        menu(maquinas);
    }

    public static void menu(List<Maquina> maquinas) {
        try {
            System.out.println("____________________________________________________________________________________");  
            imprimirNombreMaquinas(maquinas);
            for (int i = 0; i < maquinas.get(0).productos.size(); i++) {
                System.out.print("|");
                System.out.printf("%26s|",maquinas.get(0).productos.get(i).nombre + " $: " + maquinas.get(0).productos.get(i).precio);
                for (int j = 1; j < maquinas.size(); j++) {
                    System.out.printf("%26s |",maquinas.get(j).productos.get(i).nombre + " $: " + maquinas.get(j).productos.get(i).precio);
                }
                System.out.println();
            }
            System.out.println("____________________________________________________________________________________"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirNombreMaquinas(List<Maquina> maquinas) {
        maquinas.forEach(maquina -> {
            int width = 28;
            int padding = (width - maquina.nombre.length()) / 2;
            System.out.print(String.format("%" + padding + "s%s%" + padding + "s", "", maquina.nombre, ""));
        });
        System.out.print("\n|__________________________|");
        for(int j=0;j<maquinas.size() -1;j++)
        {
            System.out.print("___________________________|");            
        }
        System.out.println();
    }

    public static void showMenu() {
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
                System.out.println();
            else if(option.equals("2"))
                System.out.println();
            else if(option.equals("3")){
                System.out.println("Saliendo...");
                salir = true;
            }
        }while(!salir);
    }
}
