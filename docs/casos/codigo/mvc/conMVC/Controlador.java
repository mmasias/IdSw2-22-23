package docs.casos.codigo.mvc.conMVC;

class Controlador {
    
    private Modelo modelo;
    private Vista vista;
  
    public Controlador(Modelo modelo, Vista vista) {
      this.modelo = modelo;
      this.vista = vista;
    }
  
    public void iniciar() {
      double celsius = vista.obtenerCelsius();
      double fahrenheit = modelo.convertirCelsiusAFahrenheit(celsius);
      vista.mostrarFahrenheit(fahrenheit);
    }
  }