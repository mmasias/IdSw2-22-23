# Inyección de dependencias, caso práctico

## Ejemplo 1

Supongamos que tenemos una clase **Calculadora** que realiza operaciones matemáticas y que depende de la clase **OperacionMatematica** para realizar sus cálculos.

```java
    public class Calculadora {

        private OperacionMatematica operacion;

        public Calculadora(OperacionMatematica operacion) {
            this.operacion = operacion;
        }

        public int calcular(int a, int b) {
            return operacion.operar(a, b);
        }
    }

    public class OperacionMatematica {
        public int operar(int a, int b) {
            return a + b;
        }
    }
```

En este ejemplo, la clase **Calculadora** tiene un campo operacion de tipo **OperacionMatematica**, que se utiliza para realizar los cálculos en el método **calcular()**. En lugar de crear una instancia de **OperacionMatematica** dentro de la clase **Calculadora**, se utiliza un constructor para pasar una instancia de **OperacionMatematica** como parámetro.

```java
OperacionMatematica op = new OperacionMatematica();
Calculadora calculadora = new Calculadora(op);
int resultado = calculadora.calcular(2, 3);
System.out.println(resultado);
```

En este ejemplo, se crea una instancia de **OperacionMatematica** y se pasa como parámetro al constructor de **Calculadora**. De esta forma, la clase **Calculadora** no tiene que preocuparse por la creación de una instancia de **OperacionMatematica** y se reduce el acoplamiento entre las dos clases.

## Ejemplo 2

Supongamos que en lugar de una sola clase **OperacionMatematica**, tenemos varias clases que implementan la interfaz ***IOperacionMatematica***. Cada clase realiza una operación matemática diferente, como suma, resta, multiplicación, etc.

```java
public interface IOperacionMatematica {

    int operar(int a, int b);
}

public class Suma implements IOperacionMatematica {

    public int operar(int a, int b) {
        return a + b;
    }
}

public class Resta implements IOperacionMatematica {

    public int operar(int a, int b) {
        return a - b;
    }
}

public class Multiplicacion implements IOperacionMatematica {

    public int operar(int a, int b) {
        return a * b;
    }
}
```

En este ejemplo, cada clase implementa el método **operar()** de la interfaz ***IOperacionMatematica***, y realiza una operación matemática diferente.

Para utilizar estas clases en nuestra clase Calculadora, podemos inyectar una instancia de ***IOperacionMatematica*** en el constructor de la clase **Calculadora**, y luego utilizarla en el método **calcular()**.

```java
public class Calculadora {

    private IOperacionMatematica operacion;

    public Calculadora(IOperacionMatematica operacion) {
        this.operacion = operacion;
    }

    public int calcular(int a, int b) {
        return operacion.operar(a, b);
    }
}
```

En este ejemplo, la clase **Calculadora** tiene un campo operacion de tipo ***IOperacionMatematica***, que se utiliza para realizar los cálculos en el método **calcular()**. En lugar de crear una instancia de una clase concreta dentro de la clase **Calculadora**, se utiliza una instancia de una clase que implementa la interfaz ***IOperacionMatematica***.

```java
IOperacionMatematica op = new Suma();
Calculadora calculadora = new Calculadora(op);
int resultado = calculadora.calcular(2, 3);
System.out.println(resultado);
```

En este ejemplo, se crea una instancia de **Suma** y se pasa como parámetro al constructor de **Calculadora**. De esta forma, la clase **Calculadora** no tiene que preocuparse por la creación de una instancia de una clase concreta, sino que se utiliza una instancia de una clase que implementa la interfaz ***IOperacionMatematica***. Esto permite una mayor flexibilidad y extensibilidad del software, ya que se pueden agregar nuevas clases que implementen ***IOperacionMatematica*** sin tener que modificar la clase **Calculadora**.
