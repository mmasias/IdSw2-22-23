# Segregación de interfaces

Una clase no debe verse obligada a implementar interfaces que no utiliza

*==>  interfaces deben ser pequeñas y específicas*

```java
interface Movible {
    void mover();
}

interface Hablante {
    void hablar();
}

interface Cazador {
    void cazar();
}

class Gato implements Movible, Hablante, Cazador {
    // Implementación de los métodos de las interfaces
}

class Aspiradora implements Movible, Hablante {
    // Implementación de los métodos de las interfaces
}

class Mapa {
    // ...
}
```
