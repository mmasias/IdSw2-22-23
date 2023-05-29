# Inversión de control

Supongamos que cualquier objeto del mundo puede realizar una acción

```java
interface Accion {
    void realizar();
}
```

El gato y la aspiradora son dos objetos del mundo, por tanto implementan la interfaz

```java
class Gato implements Accion {
    @Override
    public void realizar() {
        System.out.println("El gato se está moviendo");
    }
}

class Aspiradora implements Accion {
    @Override
    public void realizar() {
        System.out.println("La aspiradora está limpiando");
    }
}
```

Por tanto, ya no son el gato y la aspiradora quienes dicen cuando hacer las cosas, sino que es el mundo el que se lo dice

```java
class Mundo {
    private List<Accion> acciones;

    public Mundo(List<Accion> acciones) {
        this.acciones = acciones;
    }

    public void ejecutarAcciones() {
        for (Accion accion : acciones) {
            accion.realizar();
        }
    }
}
```

Quedando, en la clase principal:

```java
public class Simulacion {
    public static void main(String[] args) {
        List<Accion> acciones = new ArrayList<>();
        acciones.add(new Gato());
        acciones.add(new Aspiradora());

        Mundo mundo = new Mundo(acciones);
        mundo.ejecutarAcciones();
    }
}
```

De tal modo que:

| | |
|-|-|
La creación y ejecución de las acciones se ha invertido y ahora está controlada por el Mundo.|En lugar de que el código de la aplicación controle el flujo de la lógica, el Mundo controla el flujo y el código de la aplicación simplemente responde a los eventos del Mundo.
