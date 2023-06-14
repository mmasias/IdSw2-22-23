# Principio de responsabilidad única (SRP)

Una clase debe tener una sola responsabilidad, y por tanto, una única razón para cambiar.

¿A qué hace referencia el término "cambiar" en el SRP?

*Cambiar* se refiere a la modificación o actualización del código de una clase debido a cambios en los requisitos del negocio, corrección de errores o adición de nuevas funcionalidades.

- Clase con más de una responsabilidad >> hace más de una cosa. 
  - Si hace más de una cosa >> es posible que deba cambiar en más de una ocasión.
    - Cambia mucho >> aumenta la complejidad y el riesgo de errores.

||
|-|
Cada clase debe tener una única responsabilidad bien definida y limitada
Cualquier cambio necesario en esa responsabilidad solo debería requerir cambios en la propia clase, sin afectar a otras partes del sistema.

De esta manera, se pueden mantener las clases de forma independiente y se reduce el acoplamiento entre ellas, lo que facilita el mantenimiento, la reutilización y la evolución del sistema.

## Ejemplos

- [Ejemplo con empleado y salario](SOLID_S_ejemplosEmpleadoSalario.md)
- [Ejemplo con una biblioteca](SOLID_S_ejemploBibliotecaPrestamo.md)