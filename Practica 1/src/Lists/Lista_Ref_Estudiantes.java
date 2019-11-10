package Lists;

import Interfaces.Interfaz_Listas;
import References.Ref_Estudiante;

/**
 * Clase lista de ref_Estudiantes. Permite gestionar la lista añadiendo, eliminando 
 * o bien ordenado la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Ref_Estudiantes implements Interfaz_Listas<Ref_Estudiante> {
    
    // Atributo.
    private Ref_Estudiante ref_Estudiante;
    
    /**
     * Constructor de la clase.
     */
    public Lista_Ref_Estudiantes() {
        this.ref_Estudiante = null;
    }

    /**
     * Permite obtener el valor del primer campo de la lista.
     * 
     * @return 
     */
    public Ref_Estudiante getRef_Estudiante() {
        return ref_Estudiante;
    }
    
    /**
     * Permite asignar el primer elemento de la lista.
     * 
     * @param ref_Estudiante 
     */
    public void setRef_Estudiante(Ref_Estudiante ref_Estudiante) {
        this.ref_Estudiante = ref_Estudiante;
    } 

    /**
     * Permite añadir un elemento al final de la lista.
     * 
     * @param object 
     */
    @Override
    public void añadir(Ref_Estudiante object) {
        
        // Si la lista no esta vacia.
        if (this.ref_Estudiante != null){
            
            // Se recorre hasta llegar al final y se introduce el elemento alli.
            Ref_Estudiante ref_Estudiante = this.ref_Estudiante;
            while (ref_Estudiante.getSiguiente() != null){
                ref_Estudiante = ref_Estudiante.getSiguiente();
            }
            ref_Estudiante.setSiguiente(object);
        } else {
            
            // Si no se introduce en el this.ref_Estudiante sitio.
            this.ref_Estudiante = object;
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
        if (this.ref_Estudiante != null) {
            
            //Si el siguiente valor es nulo entonces elimina el this.ref_Estudiante elemento.
            if (this.ref_Estudiante.getSiguiente() == null) {
                this.ref_Estudiante = null;
            } else {
                
                // Si no se realiza un recorrido hasta el elemento index-1.
                int n = 0;
                Ref_Estudiante ref_Estudiante = this.ref_Estudiante;
                while (n < index - 2) {
                    ref_Estudiante = ref_Estudiante.getSiguiente();
                    n++;
                }
                
                // Se elimina el elemento index.
                ref_Estudiante.setSiguiente(ref_Estudiante.getSiguiente().getSiguiente());
            }
        }
    }

    /**
     * Ordena la lista alfabeticamente segun nombre de la ref_Estudiante.
     */
    @Override
    public void ordenarAlfabeticamente() {
        
    }
    
}
