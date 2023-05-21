package cap.aplication.wimk;

import java.util.List;

public class Receta {
    private String nombre;
    private String descripcion;
    private List<String> ingredientes;

    public Receta() {
        // Constructor vacío requerido para Firebase
    }

    public Receta(String nombre, String descripcion, List<String> ingredientes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
