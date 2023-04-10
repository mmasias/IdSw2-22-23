# TO DO

## Diagramas

- [ ] Diagrama de colaboracion

## Visual

#### Texto
- [X] Modificar todos los "daño" por "dano"

#### Renderización
- [ ] La renderización sacarla en una clase a parte en lugar de la Batalla (tampoco en los recuadros), se podría hacer por ejemplo cuando el personaje realiza acciones -- <b>Manu está en ello</b>
- [ ] Renombrar y cambiar lo que hace la clase MenuAcciones

## Modificar código
#### Clase batalla
- [ ] En el constructor inicializar los <b><i>cuadros de los personajes</i></b>

- [ ] Renombrar elegirTurno() a turnoHeroe() o similar y meter todas las acciones del heroe ahí
    - [ ] turnoHeroe() llamaria a elegirAccion() o algo así para el héroe en lugar de "elegirTurno()"
- [ ] De turnoEnemigo() quitar la parte de enemigo.desmayar(), ya que se hace anteriormente y esto se está repitiendo
- [ ] Cuando el héroe no puede atacar, modificar el scanInteraccion() y el heroe.comprobarSiSeDespierta() para que no se repite

#### Clase personaje
- [ ] El personaje tiene un metodo ataca(Personaje), con el que realiza los cálculos, logea de cuánto quiere atacar, y ataca, el personaje que se le pasa como argumento, recibe daño       
- [ ] Crear método devolverCantidadArmas() ???
- [ ] Renombrar el método para preguntar si el héroe está esperando a pocion (heroe.esperandoAPocion())
- [ ] Renombrar heroe.curarseDesmayado() a un nombre más identificativo

#### Clases nuevas

- [ ] Interacción usuario con la batalla
    - [ ] Pedir enter cuando el personaje está desmayado o curando
    - [ ] ScanInteracción para elegir armas/acciones, para poder reutilizar los métodos

- [ ] Clase logger
    - [ ] Contiene un mapa, clave entera (el turno), valor lista de String (cada registro del log)
    - [ ] Método anadirLog(turno, registro) que guarda en la lista correspondiente a ese turno lo que ha hecho cada personaje (ej: Heroe ataca de 15, enemigo recibe 15...)
