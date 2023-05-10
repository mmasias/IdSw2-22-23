# Inversión de dependencias

---

```java

public class Simulacion {

    public static void main(String[] args) {
        Mapa mapa = new Mapa();

        while (true){
            mapa.moverGato();
            mapa.moverAspiradora();
        }
    }
}

class Mapa {

    private Gato gato;
    private Aspiradora aspiradora;

    public Mapa() {
        this.gato = new Gato();
        this.aspiradora = new Aspiradora();
    }

    public void moverGato() {
        gato.mover();
    }

    public void moverAspiradora() {
        aspiradora.mover();
    }
}

class Gato {
    public void mover() {
        System.out.println("El gato se está moviendo");
    }
}

class Aspiradora {
    public void mover() {
        System.out.println("La aspiradora se está moviendo");
    }
}
```

---

```java

public class Simulacion {
    public static void main(String[] args) {

        ObjetoMovable gato = new Gato();
        ObjetoMovable aspiradora = new Aspiradora();

        Mapa mapa = new Mapa(gato, aspiradora);

        while (true){
            mapa.moverObjetoMovable1();
            mapa.moverObjetoMovable2();
        }
    }
}

class Mapa {
    
    private ObjetoMovable objetoMovable1;
    private ObjetoMovable objetoMovable2;

    public Mapa(ObjetoMovable objetoMovable1, ObjetoMovable objetoMovable2) {
        this.objetoMovable1 = objetoMovable1;
        this.objetoMovable2 = objetoMovable2;
    }

    public void moverObjetoMovable1() {
        objetoMovable1.mover();
    }

    public void moverObjetoMovable2() {
        objetoMovable2.mover();
    }
}

interface ObjetoMovable {
    void mover();
}

class Gato implements ObjetoMovable {
    @Override
    public void mover() {
        System.out.println("El gato se está moviendo");
    }
}

class Aspiradora implements ObjetoMovable {
    @Override
    public void mover() {
        System.out.println("La aspiradora se está moviendo");
    }
}

```

---
