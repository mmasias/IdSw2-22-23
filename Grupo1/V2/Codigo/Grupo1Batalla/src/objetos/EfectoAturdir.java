package objetos;

import personajes.Personaje;

public class EfectoAturdir implements EfectoSecundario{
    @Override
    public void Aplicar(Personaje personaje) {
        personaje.aturdir();
    }
}
