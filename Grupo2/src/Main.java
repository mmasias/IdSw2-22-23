import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("gestorDeMaquinas");

        List<Billete> billetesMaquina001 = gestor.crearListaDeBilletes(3,1,2,5,10);
        List<Moneda> monedasMaquina001 = gestor.crearListaDeMonedas(10, 20, 10);

        List<Billete> billetesMaquina002 = gestor.crearListaDeBilletes(3, 2, 3, 7, 15);
        List<Moneda> monedasMaquina002 = gestor.crearListaDeMonedas(25, 30, 20);

        List<Billete> billetesMaquina003 = gestor.crearListaDeBilletes(3, 1, 3, 5, 12);
        List<Moneda> monedasMaquina003 = gestor.crearListaDeMonedas(30, 10, 15);

        List<Producto> productos = gestor.crearListaDeProductos();

        List<Maquina> maquinas = new ArrayList<Maquina>();
        maquinas.add(new Maquina("Maquina 1", billetesMaquina001, monedasMaquina001, productos));
        maquinas.add(new Maquina("Maquina 2", billetesMaquina002, monedasMaquina002, productos));
        maquinas.add(new Maquina("Maquina 3", billetesMaquina003, monedasMaquina003, productos));

        gestor.imprimirProductos(maquinas);
        Maquina.menuCompra();
    }

}
