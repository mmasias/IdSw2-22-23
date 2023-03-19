import java.util.ArrayList;
import java.util.List;

public class Gestor {
    String nombre;

    Gestor(String nombre) {
        this.nombre = nombre;
    }

    public List<Billete> crearListaDeBilletes(int cant1, int cant2, int cant3, int cant4, int cant5) {
        List<Billete> billetes = new ArrayList<Billete>();
        billetes.add(new Billete(20, cant1));
        billetes.add(new Billete(10, cant2));
        billetes.add(new Billete(5, cant3));
        billetes.add(new Billete(2, cant4));
        billetes.add(new Billete(1, cant5));
        return billetes;
    }

    public List<Moneda> crearListaDeMonedas(int cant1, int cant2, int cant3) {
        List<Moneda> monedas = new ArrayList<Moneda>();
        monedas.add(new Moneda(0.50, cant1));
        monedas.add(new Moneda(0.20, cant2));
        monedas.add(new Moneda(0.05, cant3));
        return monedas;
    }

    public List<Producto> crearListaDeProductos() {
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto("Galletas", 1.50, 10));
        productos.add(new Producto("Chocolates", 1.10, 10));
        productos.add(new Producto("Bebida", 1.05, 10));
        productos.add(new Producto("Bocadillo", 1.75, 10));
        return productos;
    }

    public void imprimirProductos(List<Maquina> maquinas) {
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

    public void imprimirNombreMaquinas(List<Maquina> maquinas) {
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
}
