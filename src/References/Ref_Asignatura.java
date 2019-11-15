package References;

import Objects.Asignatura;

/**
 * Clase referencia de asignatura. Contiene los metodos y atributos que definen
 * una referencia a una asignatura.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Ref_Asignatura {

    // Atributos.
    private Asignatura asignatura;
    private Ref_Asignatura siguiente;

    /**
     * Constructor.
     *
     * @param asignatura
     */
    public Ref_Asignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.siguiente = null;
    }

    /**
     * Metodo para obtener la asignatura a la que hace referencia.
     *
     * @return
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }

    /**
     * Metodo para actualizar la asignatura a la que hace referencia.
     *
     * @param asignatura
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /**
     * Metodo para obtener la siguiente referencia de la lista.
     *
     * @return
     */
    public Ref_Asignatura getSiguiente() {
        return siguiente;
    }

    /**
     * Metodo para actualizar la siguiente referencia de la lista.
     *
     * @param siguiente
     */
    public void setSiguiente(Ref_Asignatura siguiente) {
        this.siguiente = siguiente;
    }
}
