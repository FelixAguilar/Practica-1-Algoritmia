package References;

import Objects.Estudiante;

/**
 * Clase referencia de estudiante. Contiene los atributos y metodos para hacer 
 * referencia a un estudiante.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Ref_Estudiante {
    
    // Atributos.
    private Estudiante estudiante;
    private Ref_Estudiante siguiente;
    
    /**
     * Constructor.
     * 
     * @param estudiante 
     */
    public Ref_Estudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
    
    /**
     * Metodo para obtener el estudiante al que hace referencia.
     * 
     * @return 
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Metodo para actualizar el estudiante al que hace referencia.
     * 
     * @param estudiante 
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Metodo para obtener la siguiente referencia de la lista.
     * 
     * @return 
     */
    public Ref_Estudiante getSiguiente() {
        return siguiente;
    }

    /**
     * Metodo para actualizar la siguiente referencia de la lista.
     * 
     * @param siguiente 
     */
    public void setSiguiente(Ref_Estudiante siguiente) {
        this.siguiente = siguiente;
    }
}
