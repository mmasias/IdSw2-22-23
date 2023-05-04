# TO DO

# Segunda corrección

### Clase vida
- [ ] Crear clase vida, que tenga los atributos de vida actual, vida máxima, umbral de vida y cantidad de vida a curar desmayado

### Clase personaje
- [ ] Pasar en el constructor la clase vida en lugar de los 4 parámetros
- [ ] Controlador cuando se modifique la vida llamando a la clase Vida (?)

### Creador de personajes
- [ ] Modificar cómo se crean los personajes con la clase nueva de Vida

### Extras
- [ ] Revisar las clases y factorizarlas, reducir líneas y ponerlo más bonito


<hr>

# Primera corrección

## Diagramas

- [X] Diagrama de colaboracion
- [X] Actualizar diagramas

## Visual

#### Texto
- [X] Modificar todos los "daño" por "dano"

#### Renderización
- [X] La renderización sacarla en una clase a parte en lugar de la Batalla (tampoco en los recuadros), se podría hacer por ejemplo cuando el personaje realiza acciones -- <b>Manu está en ello</b>
- [x] Renombrar y cambiar lo que hace la clase MenuAcciones

## Modificar código
#### Clase batalla
- [ ] ~~En el constructor inicializar los <b><i>cuadros de los personajes</i></b>~~

- [X] Renombrar elegirTurno() a turnoHeroe() o similar y meter todas las acciones del heroe ahí
    - [ ] ~~turnoHeroe() llamaria a elegirAccion() o algo así para el héroe en lugar de "elegirTurno()"~~
- [X] De turnoEnemigo() quitar la parte de enemigo.desmayar(), ya que se hace anteriormente y esto se está repitiendo
- [X] Cuando el héroe no puede atacar, modificar el scanInteraccion() y el heroe.comprobarSiSeDespierta() para que no se repite

#### Clase personaje
- [X] El personaje tiene un metodo ataca(Personaje), con el que realiza los cálculos, logea de cuánto quiere atacar, y ataca, el personaje que se le pasa como argumento, recibe daño       
- [ ] ~~Crear método devolverCantidadArmas() ???~~
- [X] Renombrar el método para preguntar si el héroe está esperando a pocion (heroe.esperandoAPocion())
- [X] Renombrar heroe.curarseDesmayado() a un nombre más identificativo

#### Clases nuevas

- [X] Interacción usuario con la batalla
    - [X] Pedir enter cuando el personaje está desmayado o curando
    - [ ] ~~ScanInteracción para elegir armas/acciones, para poder reutilizar los métodos~~

- [X] Clase logger
    - [X] Contiene un mapa, clave entera (el turno), valor lista de String (cada registro del log)
    - [X] Método anadirLog(turno, registro) que guarda en la lista correspondiente a ese turno lo que ha hecho cada personaje (ej: Heroe ataca de 15, enemigo recibe 15...)
