<a name="_t95g2r9w3fb8"></a>**Métrica y Estadísticas del Código**

<a name="_mwdq52gf5lk1"></a>[**Clases**	](#_p3rp51s9dhyw)

 - [Ascensor	](#_1blnnqguessc)

 - [Persona	](#_lkb4n9ia769d)

 - [Planta	](#_g45xnic55y42)

 - [Tiempo	](#_sc481op9kl4r)

 - [Universidad	](#_59p00g9awiow)

 - [Mundo	](#_n26xmjn1ea27)

[**Enums**	](#_fn6iygiwhbv4)

 - [EstadoAscensor	](#_6jjjb6qtotd4)

<a name="_urwumnrfi10u"></a>
# <a name="_p3rp51s9dhyw"></a>Clases
## <a name="_1blnnqguessc"></a>Ascensor
- **Cantidad de líneas totales**: 56
- **Complejidad ciclomática por cada método:**
  - **getPlantaActual():** 1
  - **getPersonasEnAscensor():** 1
  - **estaVacio():** 1
  - **estaLleno():** 1
  - **estaSubiendo():** 1
  - **estaBajando():** 1
  - **estaParado():** 1
  - **agregarPersona(Persona):** 1
  - **bajarPersonas():** 2
  - **mover():** 5
  - **llamar(Planta):** 4
  - **subir():** 2
  - **bajar():** 2
- **Líneas de código por método:**
  - **getPlantaActual():** 7
  - **getPersonasEnAscensor():** 2
  - **estaVacio():** 2
  - **estaLleno():** 2
  - **estaSubiendo():** 2
  - **estaBajando():** 2
  - **estaParado():** 2
  - **agregarPersona(Persona):** 8
  - **bajarPersonas():** 12
  - **mover():** 20
  - **llamar(Planta):** 12
  - **subir():** 6
  - **bajar():** 6
- **Número de métodos:** 13
- **Variables de instancia:** 
  - idAscensor 
  - nivel 
  - plantas
  - personas 
  - estado
- **Encapsulación:** No está completamente encapsulado ya que algunas variables de instancia son accesibles directamente desde fuera de la clase, sin usar métodos de acceso.
## <a name="_lhfg46x2afl2"></a>
## <a name="_lkb4n9ia769d"></a>Persona
- **Cantidad de líneas totales: 31 líneas de código.**
- **Complejidad ciclomática por cada método:**
  - **elegirPlantaDestino():** 3
  - **mover():** 3
  - El resto tiene complejidad ciclomática 1
- **Líneas de código por método:**
  - **Persona():** 11 líneas de código
  - **elegirTiempoEnDestino():** 3 líneas de código
  - **elegirPlantaDestino():** 14 líneas de código
  - **mover():** 12 líneas de código
  - El resto tiene 2 líneas de código.
- **Número de métodos:** 8 métodos
- **Variables de instancia:** 5 variables de instancia
  - plantaActual
  - plantaDestino
  - tiempoEnDestino
  - esperandoAscensor
  - dentroAscensor
- **Encapsulación:** La clase tiene un nivel de encapsulación moderado, ya que todas las variables de instancia son privadas y tienen métodos getter y setter públicos para acceder a ellas. Sin embargo, los métodos mover(), esperarAscensor(), entrarAscensor() y salirAscensor() son públicos y modifican el estado interno de la clase, lo que podría afectar la consistencia de la misma si no se usan adecuadamente.
## <a name="_g45xnic55y42"></a>Planta
- **Cantidad de líneas totales:** 42
- **Complejidad ciclomática por cada método:**
  - **agregarPersona():** 1
  - **eliminarPersona():** 1
  - **subirAAscensor():** 2
  - **mover():** 1
  - **llamadaAscensorMasCercano():** 3
  - **getPersonasEsperandoAscensor():** 2
  - **compareTo():** 1
- **Líneas de código por método:**
  - **agregarPersona():** 2
  - **eliminarPersona():** 2
  - **subirAAscensor():** 6
  - **mover():** 3
  - **llamadaAscensorMasCercano():** 13
  - **getPersonasEsperandoAscensor():** 8
  - **compareTo():** 4
- **Número de métodos:** 8
- **Variables de instancia:**
  - nivel: int
  - personasEnPlanta: ArrayList<Persona>
- **Encapsulación:** Los atributos nivel y personasEnPlanta son privados y se acceden mediante getters y setters. Los métodos que modifican el estado de la instancia (agregarPersona, eliminarPersona, subirAAscensor, mover, llamadaAscensorMasCercano) son públicos.

## <a name="_yxzeo7m9oc66"></a>
## <a name="_sc481op9kl4r"></a>Tiempo
- **Cantidad de líneas totales:** 37
- **Complejidad ciclomática por cada método:**
  - **incrementar():** 1
  - **disminuir():** 1
  - **empezar():** 2
  - **main():** 1
- **Líneas de código por método:**
  - **incrementar():** 10
  - **disminuir():** 10
  - **empezar():** 14
  - **main():** 4
  - **Número de métodos:** 4
- **Variables de instancia:**
  - horas (int)
  - minutos (int)
  - segundos (int)
  - universidad (Universidad)
- **Encapsulación:**

Las variables de instancia están definidas como privadas y tienen sus correspondientes métodos getter. No hay métodos setter, lo que implica que las variables no pueden ser modificadas desde fuera de la clase.
## <a name="_9m61xyun6xb"></a>
## <a name="_59p00g9awiow"></a>Universidad
- **Cantidad de líneas totales: 31**
- **Complejidad ciclomática por cada método:**
  - **crearPlantas():** 2
  - **configurarAscensores(ArrayList<Planta> plantas):** 2
  - **mover():** 4
  - **llegoUnaPersona():** 1
- **Líneas de código por método:**
  - **crearPlantas():** 5
  - **configurarAscensores(ArrayList<Planta> plantas):** 4
  - **mover():** 13
  - **llegoUnaPersona():** 3
  - **Número de métodos:** 4
- **Variables de instancia:**
  - plantas (ArrayList)
  - ascensores (Map)
- **Encapsulación:**

Los campos plantas y ascensores son privados y tienen métodos getter públicos para acceder a ellos. Los métodos mover(), configurarAscensores() y crearPlantas() son todos marcados como package-private.
## <a name="_vzptq1xi2mks"></a>
## <a name="_n26xmjn1ea27"></a>Mundo
- **Cantidad de líneas totales:** 32
- **Complejidad ciclomática por cada método:**
  - **imprimirInterfaz:** 3
- **Líneas de código por método:**
  - **imprimirInterfaz:** 30
- **Número de métodos:** 1

# <a name="_ro1n9mtmn2rw"></a>
# <a name="_fn6iygiwhbv4"></a>Enum
## <a name="_6jjjb6qtotd4"></a>EstadoAscensor
- **Cantidad de líneas totales:** 4
