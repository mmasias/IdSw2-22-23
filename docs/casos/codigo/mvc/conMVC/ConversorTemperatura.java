package docs.casos.codigo.mvc.conMVC;

public class ConversorTemperatura {

    public static void main(String[] args) {
        
      Modelo modelo = new Modelo();
      Vista vista = new Vista();
      Controlador controlador = new Controlador(modelo, vista);
      controlador.iniciar();
    }
  }