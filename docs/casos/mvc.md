# Modelo Vista Controlador

## Sin MVC

```java
import java.util.Scanner;

public class ConversorTemperatura {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Introduce la temperatura en grados Celsius: ");
    double celsius = scanner.nextDouble();

    double fahrenheit = (celsius * 9 / 5) + 32;

    System.out.println("La temperatura en grados Fahrenheit es: " + fahrenheit);
  }
}
```

## Con MVC

```java
public class ConversorTemperatura {

  public static void main(String[] args) {
    Modelo modelo = new Modelo();
    Vista vista = new Vista();
    Controlador controlador = new Controlador(modelo, vista);
    controlador.iniciar();
  }
}

class Modelo {
  public double convertirCelsiusAFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
  }
}

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

```

## Extensión

```java
class Modelo {
  public double convertirCelsiusAFahrenheit(double celsius) {
    return (celsius * 9 / 5) + 32;
  }

  public double convertirFahrenheitACelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
  }
}

class Vista {
  public String obtenerTipoTemperatura() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("¿Qué tipo de temperatura quieres convertir (C/F)? ");
    return scanner.next();
  }

  public void mostrarTemperatura(double temperatura, String tipo) {
    if (tipo.equals("C")) {
      System.out.println("La temperatura en grados Celsius es: " + temperatura);
    } else {
      System.out.println("La temperatura en grados Fahrenheit es: " + temperatura);
    }
  }

  public double obtenerTemperatura() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Introduce la temperatura: ");
    return scanner.nextDouble();
  }
}
```