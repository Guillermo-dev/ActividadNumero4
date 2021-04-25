package pootp4.ejercicio2;

public class NoListaException extends Exception {

    private String nombre;
    private long cantidadTrabajos;

    public NoListaException(String nom, long s) {
        nombre = nom;
        cantidadTrabajos = s;
    }

    @Override
    public String getMessage() {
        return "La Cola de Trabajo: " + nombre + " no está disponible.\nCantidad de trabajos a procesar: " + cantidadTrabajos;
    }
}
