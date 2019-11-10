package Lists;

import Interfaces.Interfaz_Listas;
import Objects.Asignatura;

/**
 * Clase lista de asignaturas. Permite gestionar la lista añadiendo, eliminando 
 * o bien ordenado la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Asignaturas implements Interfaz_Listas<Asignatura> {
    
    // Atributo.
    private Asignatura asignatura;
    
    /**
     * Constructor de la clase.
     */
    public Lista_Asignaturas() {
        this.asignatura = null;
    }

    /**
     * Permite obtener el valor del primer campo de la lista.
     * 
     * @return 
     */
    public Asignatura getAsignatura() {
        return asignatura;
    }
    
    /**
     * Permite asignar el primer elemento de la lista.
     * 
     * @param asignatura 
     */
    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    } 

    /**
     * Permite añadir un elemento al final de la lista.
     * 
     * @param object 
     */
    @Override
    public void añadir(Asignatura object) {
        
        // Si la lista no esta vacia.
        if (this.asignatura != null){
            
            // Se recorre hasta llegar al final y se introduce el elemento alli.
            Asignatura asignatura = this.asignatura;
            while (asignatura.getSiguiente() != null){
                asignatura = asignatura.getSiguiente();
            }
            asignatura.setSiguiente(object);
        } else {
            
            // Si no se introduce en el this.asignatura sitio.
            this.asignatura = object;
        }
        object.setSiguiente(null);
    }

    /**
     * Elimina el elemento en la posicion "index" de la lista.
     * 
     * @param index 
     */
    @Override
    public void eliminar(int index) {
        
        // Si la lista esta vacia no realiza nada.
        if (this.asignatura != null) {
            
            //Si el siguiente valor es nulo entonces elimina el this.asignatura elemento.
            if (this.asignatura.getSiguiente() == null) {
                this.asignatura = null;
            } else {
                
                // Si no se realiza un recorrido hasta el elemento index-1.
                int n = 0;
                Asignatura asignatura = this.asignatura;
                while (n < index - 2) {
                    asignatura = asignatura.getSiguiente();
                    n++;
                }
                
                // Se elimina el elemento index.
                asignatura.setSiguiente(asignatura.getSiguiente().getSiguiente());
            }
        }
    }

    /**
     * Ordena la lista alfabeticamente segun nombre de la asignatura.
     */
    @Override
    public void ordenarAlfabeticamente() {
        
    }
    
}
