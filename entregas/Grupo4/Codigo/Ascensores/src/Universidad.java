import java.util.ArrayList;
import java.util.List;

class Universidad {
    private List<Planta> plantas;
    private List<Ascensor> ascensores;
    private List<Persona> personas;

    public Universidad() {
        plantas = new ArrayList<>();
        ascensores = new ArrayList<>();
        personas = new ArrayList<>();

        //Crear boton por planta
        Boton[] botonesPlanta = {new Boton(-3), new Boton(-2), new Boton(-1), new Boton(0), new Boton(1), new Boton(2), new Boton(3)};
        //Crear puertas
        //Ascensor1
        Puerta[] puertasAscensor1 = {new Puerta(botonesPlanta[0]), new Puerta(botonesPlanta[1]), new Puerta(botonesPlanta[2]), new Puerta(botonesPlanta[3]), new Puerta(botonesPlanta[4]), new Puerta(botonesPlanta[5]), new Puerta(botonesPlanta[6])};
        //Ascensor2
        Puerta[] puertasAscensor2 = {new Puerta(botonesPlanta[0]), new Puerta(botonesPlanta[1]), new Puerta(botonesPlanta[2]), new Puerta(botonesPlanta[3]), new Puerta(botonesPlanta[4]), new Puerta(botonesPlanta[5]), new Puerta(botonesPlanta[6])};
        //Ascensor3
        Puerta[] puertasAscensor3 = {new Puerta(botonesPlanta[0]), new Puerta(botonesPlanta[1]), new Puerta(botonesPlanta[2]), new Puerta(botonesPlanta[3]), new Puerta(botonesPlanta[4]), new Puerta(botonesPlanta[5]), new Puerta(botonesPlanta[6])};


        // Crear plantas y agregarlas a la universidad
        Planta plantam3 = new Planta(-3, new Puerta[]{puertasAscensor1[0], puertasAscensor2[0], puertasAscensor3[0]}, null, null);
        Planta plantam2 = new Planta(-2, new Puerta[]{puertasAscensor1[1], puertasAscensor2[1], puertasAscensor3[1]}, null, plantam3);
        Planta plantam1 = new Planta(-1, new Puerta[]{puertasAscensor1[2], puertasAscensor2[2], puertasAscensor3[2]}, null, plantam2);
        Planta planta0 = new Planta(0, new Puerta[]{puertasAscensor1[3], puertasAscensor2[3], puertasAscensor3[3]}, null, plantam1);
        Planta planta1 = new Planta(1, new Puerta[]{puertasAscensor1[4], puertasAscensor2[4], puertasAscensor3[4]}, null, planta0);
        Planta planta2 = new Planta(2, new Puerta[]{puertasAscensor1[5], puertasAscensor2[5], puertasAscensor3[5]}, null, planta1);
        Planta planta3 = new Planta(3, new Puerta[]{puertasAscensor1[6], puertasAscensor2[6], puertasAscensor3[6]}, null, planta2);
        plantam3.setPlantaSiguiente(plantam2);
        plantam2.setPlantaSiguiente(plantam1);
        plantam1.setPlantaSiguiente(planta0);
        planta0.setPlantaSiguiente(planta1);
        planta1.setPlantaSiguiente(planta2);
        planta2.setPlantaSiguiente(planta3);
        plantas.add(plantam3);
        plantas.add(plantam2);
        plantas.add(plantam1);
        plantas.add(planta0);
        plantas.add(planta1);
        plantas.add(planta2);
        plantas.add(planta3);

        //Crear Botones del Ascensor
        Boton[] botonesAscensores = {new Boton(-3), new Boton(-2), new Boton(-1), new Boton(0), new Boton(1), new Boton(2), new Boton(3)};

        // Crear ascensores y agregarlos a la universidad
        Ascensor ascensor1 = new Ascensor(plantas.get(0), botonesAscensores);
        Ascensor ascensor2 = new Ascensor(plantas.get(0), botonesAscensores);
        Ascensor ascensor3 = new Ascensor(plantas.get(0), botonesAscensores);
        ascensores.add(ascensor1);
        ascensores.add(ascensor2);
        ascensores.add(ascensor3);
        ascensor1.agregarPuertas(puertasAscensor1);
        ascensor2.agregarPuertas(puertasAscensor2);
        ascensor3.agregarPuertas(puertasAscensor3);
    }

    public Universidad(Ascensor[] ascensores, Planta[] plantas) {
        this.plantas = List.of(plantas);
        this.ascensores = List.of(ascensores);
        personas = new ArrayList<>();
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public List<Ascensor> getAscensores() {
        return ascensores;
    }

    public List<Planta> getPlantas() {
        return plantas;
    }

    public void removerPersona(Persona persona) {
        personas.remove(persona);
    }

    boolean llegoUnaPersona() {
        if (Math.random() < .5) {
            return true;
        } else {
            return false;
        }
    }

    int contarPersonasEsperandoAscensorPorPlanta( Planta planta) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getPlantaActual() == planta) {
                contador++;
            }
        }
        return contador;
    }



    int contarPersonasEnPlanta(Planta planta) {
        int contador = 0;
        for (Persona persona : personas) {
            if (persona.getPlantaActual() == planta) {
                contador++;
            }
        }
        return contador;
    }


    public void empezar() {
        do{
            if (llegoUnaPersona()) {
                Persona persona = new Persona(plantas.get(3));
                agregarPersona(persona);
                persona.esperarAscensor(); // validar si hay ascensores libres y en la planta 0
            }
            System.out.println("---------- Personas esperando ---------- ---------- ---------- Personas en la planta");
            for (Planta planta : plantas) {
                System.out.println("Planta " + planta.getNivel() + "    _____" + contarPersonasEsperandoAscensorPorPlanta(planta) + "_____" + "       |    |      |    |      |    |      ____" + contarPersonasEnPlanta(planta) + "___");
            }
        }
        while (true);
    }

    public static void main(String[] args) {
        new Universidad().empezar();
    }

}
