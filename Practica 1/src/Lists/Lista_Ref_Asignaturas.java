package Lists;

import Interfaces.Interfaz_Listas;
import References.Ref_Asignatura;

/**
 * Clase lista de ref_Asignaturas. Permite gestionar la lista añadiendo, eliminando 
 * o bien ordenado la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Ref_Asignaturas implements Interfaz_Listas<Ref_Asignatura> {
    
    // Atributo.
    private Ref_Asignatura ref_Asignatura;
    
    /**
     * Constructor de la clase.
     */
    public Lista_Ref_Asignaturas() {
        this.ref_Asignatura = null;
    }

    /**
     * Permite obtener el valor del primer campo de la lista.
     * 
     * @return 
     */
    public Ref_Asignatura getRef_Asignatura() {
        return ref_Asignatura;
    }
    
    /**
     * Permite asignar el primer elemento de la lista.
     * 
     * @param ref_Asignatura 
     */
    public void setRef_Asignatura(Ref_Asignatura ref_Asignatura) {
        this.ref_Asignatura = ref_Asignatura;
    } 

    /**
     * Permite añadir un elemento al final de la lista.
     * 
     * @param object 
     */
    @Override
    public void añadir(Ref_Asignatura object) {
        
        // Si la lista no esta vacia.
        if (this.ref_Asignatura != null){
            
            // Se recorre hasta llegar al final y se introduce el elemento alli.
            Ref_Asignatura ref_Asignatura = this.ref_Asignatura;
            while (ref_Asignatura.getSiguiente() != null){
                ref_Asignatura = ref_Asignatura.getSiguiente();
            }
            ref_Asignatura.setSiguiente(object);
        } else {
            
            // Si no se introduce en el this.ref_Asignatura sitio.
            this.ref_Asignatura = object;
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
        if (this.ref_Asignatura != null) {
            
            //Si el siguiente valor es nulo entonces elimina el this.ref_Asignatura elemento.
            if (this.ref_Asignatura.getSiguiente() == null) {
                this.ref_Asignatura = null;
            } else {
                
                // Si no se realiza un recorrido hasta el elemento index-1.
                int n = 0;
                Ref_Asignatura ref_Asignatura = this.ref_Asignatura;
                while (n < index - 2) {
                    ref_Asignatura = ref_Asignatura.getSiguiente();
                    n++;
                }
                
                // Se elimina el elemento index.
                ref_Asignatura.setSiguiente(ref_Asignatura.getSiguiente().getSiguiente());
            }
        }
    }

    /**
     * Ordena la lista alfabeticamente segun nombre de la ref_Asignatura.
     */
    @Override
    public void ordenarAlfabeticamente() {
        
    }
    
}
