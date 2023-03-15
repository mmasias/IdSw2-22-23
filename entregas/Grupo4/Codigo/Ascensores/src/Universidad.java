import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Universidad {
    private List<Planta> plantas;
    private List<Ascensor> ascensores;
    private List<Persona> personas;

    public Universidad() {
        plantas = new ArrayList<>();
        ascensores = new ArrayList<>();
        personas = new ArrayList<>();

        establecerConfigInicial();
    }

    private void establecerConfigInicial() {
        ArrayList<Ascensor> listaDeAscensores = new ArrayList<>();
        ArrayList<Planta> listaDePlantas = new ArrayList<>();

        // Crear plantas
        Planta plantaAnterior = null;

        for (int i = Constans.NIVEL_INFERIOR; i <= Constans.NIVEL_SUPERIOR; i++) {
            Planta planta = new Planta(i, null, plantaAnterior);
            plantaAnterior = planta;
            listaDePlantas.add(planta);
        }
        for (int i = 0; i < listaDePlantas.size() - 1; i++) {
            listaDePlantas.get(i).setPlantaSiguiente(listaDePlantas.get(i + 1));
        }
        plantas = listaDePlantas;

        // Crear ascensores
        Planta planta0 = getPlanta0();
        for (int i = 0; i < Constans.TOTAL_ASCENSORES; i++) {
            Ascensor ascensor = new Ascensor(planta0);
            listaDeAscensores.add(ascensor);
        }
        ascensores = listaDeAscensores;
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void removerPersona(Persona persona) {
        personas.remove(persona);
    }

    private boolean llegoUnaPersona() {
        if (Math.random() < Constans.PROBABILIDAD_PERSONA_LLEGA) {
            return true;
        } else {
            return false;
        }
    }

    private Planta getPlanta0() {
        for (int i = 0; i < plantas.size(); i++) {
            if (plantas.get(i).getNivel() == 0) {
                return plantas.get(i);
            }
        }
        throw new RuntimeException("No se encontró la planta 0");
    }

    private List<Persona> getPersonasEsperandoAscensorPorPlanta(Planta planta) {
        List<Persona> personasEsperandoAscensor = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.estaEsperandoAscensor() && persona.getPlantaActual().compareTo(planta) == 0) {
                personasEsperandoAscensor.add(persona);
            }
        }
        return personasEsperandoAscensor;
    }

    private List<Persona> getPersonasEnPlanta(Planta planta) {
        List<Persona> personasEnPlanta = new ArrayList<>();
        for (Persona persona : personas) {
            if (persona.getPlantaActual().compareTo(planta) == 0 && !persona.estaDentroAscensor()) {
                personasEnPlanta.add(persona);
            }
        }
        return personasEnPlanta;
    }


    private void empezar() {
        Scanner scanner = new Scanner(System.in);
        String entrada = "";
        do{
            llamarAscensorLibreMasCercano();
            personaTieneQueIrse();
            for (Ascensor ascensor : ascensores) {
                ascensor.mover();
                List<Persona> personasEsperandoAscensor = getPersonasEsperandoAscensorPorPlanta(ascensor.getPlantaActual());
                for (Persona persona : personasEsperandoAscensor) {
                    if (!ascensor.estaLleno()) {
                        ascensor.agregarPersona(persona);
                        persona.entrarAscensor();
                    }
                }
            }
            if (llegoUnaPersona()) {
                Persona persona = new Persona(getPlanta0());
                agregarPersona(persona);
                persona.esperarAscensor();
            }
            imprimirInterfaz();

            entrada = scanner.nextLine();
        }
        while (entrada.compareTo("s") != 0);
    }

    private void personaTieneQueIrse(){
        for(Planta planta : plantas){
            if (planta.getNivel() == 0) continue;
            List<Persona> personasEnPlanta = getPersonasEnPlanta(planta);
            for(Persona persona : personasEnPlanta){
                if (persona.tieneQueIrse() && persona.getPlantaActual().compareTo(getPlanta0()) != 0){
                    persona.esperarAscensor();
                    persona.setPlantaDestino(getPlanta0());
                } else {
                    persona.incrementarTiempo();
                }
            }
        }
        List<Persona> personasEnPlanta0 = getPersonasEnPlanta(getPlanta0());
        for(Persona persona : personasEnPlanta0){
            if (persona.tieneQueIrse()){
                removerPersona(persona);
            }
        }
    }
    private void llamarAscensorLibreMasCercano(){
        Ascensor ascensorMasCercano = null;
        for (Planta planta : plantas) {
            if (getPersonasEsperandoAscensorPorPlanta(planta).size() > 0) {
                for (Ascensor ascensor : ascensores) {
                    if (ascensor.estaVacio()) {
                        if (ascensorMasCercano == null) {
                            ascensorMasCercano = ascensor;
                        } else {
                            int distanciaAscensorMasCercano = Math.abs(ascensorMasCercano.getPlantaActual().compareTo(planta));
                            if (Math.abs(ascensor.getPlantaActual().compareTo(planta)) < distanciaAscensorMasCercano) {
                                ascensorMasCercano = ascensor;
                            }
                        }
                    }
                }
                if (ascensorMasCercano != null) {
                    if (ascensorMasCercano.getPlantaActual().compareTo(planta) > 0) {
                        ascensorMasCercano.bajar();
                        break;
                    } else if (ascensorMasCercano.getPlantaActual().compareTo(planta) < 0) {
                        ascensorMasCercano.subir();
                        break;
                    }
                }
            }
        }
    }

    private void imprimirInterfaz(){
        //Imprimir cabecera
        String linea = "----------- Personas esperando  ";
        for (int i = 0; i < ascensores.size(); i++) {
            linea += "-------- ";
        }
        linea += "  Personas en la planta";
        System.out.println(linea);
        //Imprimir plantas
        for (int i = plantas.size() - 1; i >= 0; i--) {

            linea = "Planta "
                    + (plantas.get(i).getNivel() < 0 ? plantas.get(i).getNivel() : " " + plantas.get(i).getNivel())
                    + "      _____"
                    + getPersonasEsperandoAscensorPorPlanta(plantas.get(i)).size()
                    + "_____     " ;

            for (Ascensor ascensor : ascensores) {
                if (ascensor.getPlantaActual().compareTo(plantas.get(i)) == 0){
                    if (ascensor.estaParado()){
                        linea += "   [-" + ascensor.getPersonasEnAscensor() + "-] ";
                    } else if (ascensor.estaSubiendo()){
                        linea += "   [^" + ascensor.getPersonasEnAscensor() + "^] ";
                    } else if (ascensor.estaBajando()){
                        linea += "   [v" + ascensor.getPersonasEnAscensor() + "v] ";
                    }
                } else {
                    linea += "   |  |  ";
                }
            }
            linea+= "          ___" + getPersonasEnPlanta(plantas.get(i)).size() + "___";
            System.out.println(linea);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Universidad().empezar();
    }

}
