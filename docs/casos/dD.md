# Escenario

Debido a un reparto de responsabilidades justificado, existe la necesidad de que un cliente de una jerarquía de clases **gestione específicamente según la clase derivada concreta de un parámetro polimórfico**.

## Aproximación I

- De forma directa con operadores y funciones del lenguaje, ***instanceOf***
- Indirectamente con métodos explícitos, ***get<Tipo>()***
- Abriendo distintas ramas de sentencias alternativas para tratar cada tipo de clase derivada.

||
|:-:|
|![](/images/dd-00-00.svg)
|![](/images/dd-00-01.svg)

- 👎Se ve obligado a **preguntar** por el tipo de objeto (supuestamente polimórfico)
- 👎Incurre en cambios divergentes, implementanndo una nueva rama en **cada clase cliente** que hay que localizar por toda la aplicación
- 👎Rompe el principio Open/Close con **cambios en el interior de los métodos** del cliente

## Aproximación II

- El cliente envia un mensaje aceptar al objeto polimórfico auto-pasándose como parámetro (this)
- Cada clase derivada devuelve un mensaje visitar al propio cliente auto-pasándose como parámetro (this)
- El cliente atiende por separado con métodos visitar para cada tipo de clase derivada con el comportamiento particular para cada uno

||
|:-:|
|![](/images/dd-01-00.svg)|No hace falta preguntar el tipo de objeto
|![](/images/dd-01-01.svg)|No rompe el principio Open/Close

- 👍No pregunta por el tipo de objeto polimórfico
- 👍No incurre en cambios divergentes para atender con una nueva rama en cada clase cliente
- 👍No rompe el principio Open/Close con cambios en el interior de los métodos del cliente
- 👎Intimidad inapropiada con ciclos entre todas las clases cliente con todas las clases de la jerarquía
- 👎Alto acoplamiento, según tienden a crecer los clientes porque todas las clases de la jerarquía conocen a todas las clases de clientes

## Aproximación III

- La jerarquía de clases no conoce directamente a los clientes sino que **conoce únicamente a una interfaz** que debe cumplir todo cliente que visita la jerarquía: *visitador genérico*.
- La nueva clase derivada debe redefinir el método aceptar para no ser abstracta enviando un mensaje visitar auto-pasandose por parámetro
- Los cambios están guiados por el compilador porque cada clase cliente debe definir un nuevo método visitar para la nueva clase derivada

||
|:-:|
|![](/images/dd-02-00.svg)

- 👍No pregunta por el tipo de objeto polimórfico
- 👍No incurre en cambios divergentes para atender con una nueva rama en cada clase cliente
- 👍No rompe el principio Open/Close con cambios en el interior de los métodos del cliente
- 👍Hay una "leve" intimidad inapropiada con ciclos dentro del mismo paquete entre todas las clases de la jerarquía con la interfaz de los clientes, que no requiere pruebas ni comprensión porque no aporta código de implementación
- 👍Mantiene un bajo acoplamiento según tienden a crecer los clientes porque no todas las clases de la jerarquía conocen a todas las clases de clientes, solo conocen a la interfaz de todos los clientes