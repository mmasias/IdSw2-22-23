package docs.casos.codigo.mvc.conMVC;
import java.util.Scanner;

class Vista {

    public void mostrarFahrenheit(double fahrenheit) {
      System.out.println("La temperatura en grados Fahrenheit es: " + fahrenheit);
    }
  
    public double obtenerCelsius() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Introduce la temperatura en grados Celsius: ");
      return scanner.nextDouble();
    }
  }