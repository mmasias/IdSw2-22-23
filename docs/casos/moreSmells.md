# Más smells codes

> Basado en una clasificación de Mika Mäntylä, Universidad de Helsinki

Conviene también darle un vistazo a los [antipatrones](https://es.wikipedia.org/wiki/Antipatr%C3%B3n_de_dise%C3%B1o) 

## The bloaters

*"Los infladores"*, que agrupa ‘aromas’ que indican el crecimiento excesivo de algún aspecto que hacen incontrolable el código.

|Smell|Code|Detalle
-|-|-
Long method|Método extenso|Precisa de su reducción para ser más legible y mantenible.
Large class |Clase larga|Con síntomas y consecuencias muy similares al caso anterior.
Primitive obsession |Obsesión por tipos primitivos|Cuyo síntoma es la utilización de tipos primitivos para almacenar datos de entidades pequeñas, por ejemplo, usar un long para guardar un número de teléfono.
Long parameter list |Lista de parámetros larga|Incrementan la complejidad de un método de forma considerable.
Dataclumps |Grupos de datos|O uso de un conjunto de variables o propiedades de tipos primitivos en lugar de crear una clase apropiada para almacenar los datos, lo que a su vez provoca el incremento de parámetros en métodos y clases.

## The Object-Orientation Abusers

*Maltratadores de la orientación a objetos*, que aglutina code smells que indican que no se está aprovechando la potencia de este paradigma

|Smell|Code|Detalle
-|-|-
Switch statements |Sentencias Switch|Que podrían indicar una falta de utilización de mecanismos de herencia.
Temporary field |Campo temporal|Que se salta el principio de encapsulamiento y ocultación de variables haciendo que éstas pertenezcan a la clase cuando su ámbito debería ser exclusivamente el método que las usa.
Refused bequest |Rechazo del legado|Cuando una subclase ‘rechaza’ métodos o propiedades heredadas, atentando directamente contra uno de los principales pilares de la OOP.
Alternative Classes with Different Interfaces |Clases alternativas con distintos interfaces|Indica la ausencia de interfaces comunes entre clases similares.

## The change preventers

*Los impedidores de cambios*

|Smell|Code|Detalle|Posible causa
-|-|-|-
Divergent Change|Cambio divergente|Hace que sean implementadas dentro de la misma clase funcionalidades sin ninguna relación entre ellas, lo que sugiere extraerlas a una nueva clase.|CTRL+C & CTRL+V indiscriminado
Shotgun surgery |Cirujía de escopeta|Cuando un cambio en una clase implica modificar varias clases relacionadas.|Una única responsabilidad ha sido dividida en un gran número de clases.
Parallel Inheritance Hierarchies|Jerarquías de herencia paralelas|Paralelismo que aparece cuando cada vez que se crea una instancia de una clase es necesario crear una instancia de otra clase, evitable uniendo ambas en una única clase final.|Una evolución inadecuada de la jerarquía de herencias

## The Dispensables

*Los prescindibles*, pistas aportadas por porciones de código innecesarias que podrían y deberían ser eliminadas:

|Smell|Code|Detalle
-|-|-
Lazy class|Clase holgazana|Clase sin apenas responsabilidades que hay que dotar de sentido, o bien eliminar.
Data class|Clase de datos|Clase que sólo se utiliza para almacenar datos, pero no dispone de métodos asociados a éstos.
Duplicate code|Código duplicado|Presencia de código duplicado que dificulta enormemente el mantenimiento.
Dead code|Código muerto|Aparición de código que no se utiliza, probablemente procedente de versiones anteriores, prototipos o pruebas.
Speculative generality|Generalización especulativa|Ocurre cuando un código intenta solucionar problemas más allá de sus necesidades actuales.

## The couplers

*Los emparejadores*, son code smells que alertan sobre problemas de acoplamiento componentes, a veces excesivo y otras demasiado escaso.

|Smell|Code|Detalle
-|-|-
Features envy|Envidia de características|Aparece cuando existe un método de una clase que utiliza extensivamente métodos de otra clase y podría sugerir la necesidad de moverlo a ésta.
Inappropriate intimacy|Intimidad inapropiada|Cuando dos clases de conocen demasiado y usan con demasiada confianza, y a veces de forma inapropiada, sus miembros
Message Chains|Cadenas de mensajes|Código que realiza una cadena de llamadas a métodos de clases distintas utilizando como parámetros el retorno de las llamadas anteriores, como A.getB().getC().getD().getTheNeededData(), que dejan entrever un acoplamiento excesivo de la primera clase con la última.
Middle man|Intermediario|Cuestiona la necesidad de tener clases cuyo único objetivo es actuar de intermediaria entre otras dos clases.

