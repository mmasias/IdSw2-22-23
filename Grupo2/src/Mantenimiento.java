public class Mantenimiento {
    
    // La maquina envia el nombre y la cantidad del producto que existe en la maquina
    // Si la cantidad es menor o igual a 2 se setea la cantidad a 10 

    Mantenimiento(){}

    public void rellenarProducto(String nombre, int cantidad){
        if(cantidad <= 2){
            cantidad = 10;
        } else{
            System.out.println("No llenedado");
        }
    }
}
