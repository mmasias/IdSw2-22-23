package docs.casos.codigo.dd.v2;
public abstract class Persona {

	public void saludar(){
		System.out.println("?????????? Soy una persona que saluda al entrar");
	}

	public abstract void aceptar(Recepcionista recepcionista);
	
	public void despedirse() {
		System.out.println("?????????? Soy una persona que se despide al salir");
	}

}
