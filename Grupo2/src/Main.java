import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        System.out.println("============================");
        cantidadDeProductos(productos);
        System.out.println("============================");
        
        /* Billete billete01 = new Billete(100);
        Billete billete02 = new Billete(50);
        Billete billete03 = new Billete(20);
        Moneda moneda01 = new Moneda(2);
        Moneda moneda02 = new Moneda(1);
        Moneda moneda03 = new Moneda(0.50);

        System.out.println("Billete 01: "+ billete01.valor);
        System.out.println("Billete 02: "+ billete02.valor);
        System.out.println("Billete 03: "+ billete03.valor);
        System.out.println("Moneda 01: "+ moneda01.valor);
        System.out.println("Billete 01: "+ moneda02.valor);
        System.out.println("Billete 01: "+ moneda03.valor);
        */
    }


    public void cantidadDeProductos(List<Producto> productos) {
        int salir = 0;
        do {
            System.out.println("Quieres agregar productos? [Si=1 | No= 0] ");
            salir = sc.nextInt();
            System.out.println("Nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.println("Precio del producto: ");
            double precio = sc.nextDouble();

            productos.add(new Producto(nombre, precio));

        } while (salir == 0);
    }
}
