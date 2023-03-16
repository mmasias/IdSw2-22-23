import java.util.ArrayList;
import java.util.List;
public class Moneda extends Dinero {
    Moneda(double valor, int cantidad) {
        super(valor, cantidad);
    }

    public static List<Moneda> crearListaDeMonedas(int cant1, int cant2, int cant3) {
        List<Moneda> monedas = new ArrayList<Moneda>();
        monedas.add(new Moneda(0.50, cant1));
        monedas.add(new Moneda(0.20, cant2));
        monedas.add(new Moneda(0.05, cant3));
        return monedas;
    }
}
