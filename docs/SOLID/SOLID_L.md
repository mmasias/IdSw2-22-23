# Sustitución de Liskov

Los objetos de una clase derivada deben poder reemplazar a los objetos de la clase base sin afectar la corrección del programa. En otras palabras, si una clase S hereda de una clase T, entonces un objeto de la clase T debe poder ser reemplazado por un objeto de la clase S sin alterar las propiedades deseables del programa.

<div align="center">

![](/images/liskovEIT.png.crdownload)

</div>

<div align="right">

Fuente: L.Fernández

</div>

**Se cumple cuando se redefine un método en una derivada reemplazando su precondición por una más débil y su postcondicion por una más fuerte**

— Barbara Liskov, Principio de Sustitución