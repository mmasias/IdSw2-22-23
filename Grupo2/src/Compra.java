import java.util.List;

public class Compra {
    String descripcion;
    String fechaDeCompra;

    Compra(String descripcion, String fechaDeCompra) {
        this.descripcion = descripcion;
        this.fechaDeCompra = fechaDeCompra;
    }

    void realizarCompra(double coste, double pago) {

    }

    public static void menu(List<Maquina> maquinas) {
        try {
            System.out.println("#################################################################");
            System.out.println();
            System.out.println("#################################################################");
            if (maquinas.isEmpty())
                System.out.println("No hay registros ");
            maquinas.forEach(maquina -> {
                System.out.println("--------------------------- " + maquina.nombre + " --------------------------");
                maquina.productos.forEach(producto -> {
                    System.out.printf("%12s %4s %6s", producto.nombre, " $: ", producto.precio);
                });
                System.out.println();
            });
            System.out.println("_________________________________________________________________");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
