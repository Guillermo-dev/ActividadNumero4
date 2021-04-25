package pootp4.ejercicio2;

import java.util.LinkedList;
import java.util.Queue;

public class ColaDeTrabajo {

    private String nombre;
    private boolean estado;

    private Queue<Trabajo> trabajos = new LinkedList<Trabajo>();

    public ColaDeTrabajo(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void encolar(Trabajo trabajo) {
        trabajos.add(trabajo);
    }

    public Trabajo sacar() throws NoListaException, SinTrabajoEnColaException {
        if (!estado) {
            throw new NoListaException(this.nombre, this.trabajos.size());
        } else if (this.trabajos.isEmpty()) {
            throw new SinTrabajoEnColaException(this.nombre);
        } else {
            return trabajos.poll();
        }
    }

}
