package docs.casos.codigo.dd.v2;
public class Mujer extends Persona {

	public void escucharHalago() {
		System.out.println("++++++++++ Soy una mujer ruborizada");
	}

	public void escucharPiropo() {
		System.out.println("++++++++++ Soy una mujer más ruborizada");
	}	
	
	@Override
	public void aceptar(Recepcionista recepcionista) {
		recepcionista.visitar(this);
	}

}
