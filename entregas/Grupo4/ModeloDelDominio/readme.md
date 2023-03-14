# Modelo Del Dominio

## Glosario


| Clase               | Descripción                                                                              |
| ------------------- | -----------------------------------------------------------------------------------------|
| Persona             |  Individuo que puede estar en una planta de la universidad o en un ascensor.             |
| Tiempo              |  Intervalo en el que las personas están en una planta                                    |
| Planta              |  Niveles del edificio de la universidad donde se pueden encontrar personas y ascensores. |                                      
| Ascensor            |  Equipo que transporta a las personas entre diferentes plantas de la universidad.        |
| Universidad         |  Institución académica que cuenta con plantas, ascensores y personas.                    |


<hr>

## Diagramas

<details>
  <summary>Modelo del dominio</summary>
  
|         Modelo del dominio         
| :-: 
| ![](images/modeloDelDominio.png)
| [Código](modeloDelDominio.puml) 

</details>

<details>
  <summary>Diagrama de estados</summary>

    


  <div align="center">

| Estado                | Descripción                                                        |
| --------------------- | ------------------------------------------------------------------ |
| Ascensor Parado       |  El ascensor donde no se esta moviendo.                            |
| Ascensor Subiendo     |  EL ascensor donde se esta moviendo hacia una planta superior.     |
| Ascensor Bajando      |  El ascensor donde se esta moviendo hacia una planta inferior.     |                                      
| Persona EnAscensor    |  La persona se encuentra dentro del ascensor.                      |
| Persona EnPlanta      |  La persona se encuentra en una planta de la universidad.          |

</div>
  
| Diagrama de estados
| :-: 
| ![](images/diagramaDeEstados.png)
| [Código](diagramaDeEstados.puml) 


</details>

<details>
  <summary>Diagrama de clases</summary>
  
| Diagrama de clases
| :-: 
| ![](images/diagramaDeClases.png)
| [Código](diagramaDeClases.puml) 


</details>