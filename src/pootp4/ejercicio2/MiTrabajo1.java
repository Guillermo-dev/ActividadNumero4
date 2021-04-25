package pootp4.ejercicio2;

public class MiTrabajo1 implements Trabajo {

    private String nombre;
    private String Descripcion;

    public MiTrabajo1(String nombre, String Descripcion) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }
}
