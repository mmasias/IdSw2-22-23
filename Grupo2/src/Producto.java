public class Producto {
    String nombre;
    float precio;

    Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public void setPrecio(float newPrecio){
        precio = newPrecio;
    }

    public float getPrecio(){
        return precio;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }

    public String getNombre(){
        return nombre;
    }

}
