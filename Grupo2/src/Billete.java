import java.util.ArrayList;
import java.util.List;

public class Billete extends Dinero {
    Billete(double valor, int cantidad) {
        super(valor, cantidad);
    }

    public static List<Billete> crearListaDeBilletes(int cant1, int cant2, int cant3, int cant4, int cant5) {
        List<Billete> billetes = new ArrayList<Billete>();
        billetes.add(new Billete(20, cant1));
        billetes.add(new Billete(10, cant2));
        billetes.add(new Billete(5, cant3));
        billetes.add(new Billete(2, cant4));
        billetes.add(new Billete(1, cant5));
        return billetes;
    }
}
