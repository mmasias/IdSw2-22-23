package docs.casos.codigo.dd.v1;
public class Hombre extends Persona {

	public void recibirPalmada(Recepcionista recepcionista) {
		System.out.println("---------- Soy un hombre lleno de vanidad");
		recepcionista.recibirPropina(3);
	}	
	
}
