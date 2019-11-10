package Lists;

import Interfaces.Interfaz_Listas;
import Objects.Estudiante;

/**
 * Clase lista de estudiantes. Permite gestionar la lista añadiendo, eliminando 
 * o bien ordenado la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Estudiantes implements Interfaz_Listas<Estudiante> {
    
    // Atributo.
    private Estudiante estudiante;
    
    /**
     * Constructor de la clase.
     */
    public Lista_Estudiantes() {
        this.estudiante = null;
    }

    /**
     * Permite obtener el valor del primer campo de la lista.
     * 
     * @return 
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }
    
    /**
     * Permite asignar el primer elemento de la lista.
     * 
     * @param estudiante 
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    } 

    /**
     * Permite añadir un elemento al final de la lista.
     * 
     * @param object 
     */
    @Override
    public void añadir(Estudiante object) {
        
        // Si la lista no esta vacia.
        if (this.estudiante != null){
            
            // Se recorre hasta llegar al final y se introduce el elemento alli.
            Estudiante estudiante = this.estudiante;
            while (estudiante.getSiguiente() != null){
                estudiante = estudiante.getSiguiente();
            }
            estudiante.setSiguiente(object);
        } else {
            
            // Si no se introduce en el this.estudiante sitio.
            this.estudiante = object;
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
        if (this.estudiante != null) {
            
            //Si el siguiente valor es nulo entonces elimina el this.estudiante elemento.
            if (this.estudiante.getSiguiente() == null) {
                this.estudiante = null;
            } else {
                
                // Si no se realiza un recorrido hasta el elemento index-1.
                int n = 0;
                Estudiante estudiante = this.estudiante;
                while (n < index - 2) {
                    estudiante = estudiante.getSiguiente();
                    n++;
                }
                
                // Se elimina el elemento index.
                estudiante.setSiguiente(estudiante.getSiguiente().getSiguiente());
            }
        }
    }

    /**
     * Ordena la lista alfabeticamente segun nombre de la estudiante.
     */
    @Override
    public void ordenarAlfabeticamente() {
        
    }
    
}
