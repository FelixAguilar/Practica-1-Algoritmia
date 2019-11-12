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

        // Se comprueba que no este vacia la lista o que sea mayor que el primer elemento.
        if (this.estudiante != null && object.getNombre().compareTo(this.estudiante.getNombre()) <= 0){
            
            // Se realiza un recorrido de los elementos de la lista hasta encontrar 
            // un elemento mayor que el que se quiere introducir.
            Estudiante estudiante = this.estudiante;
            while(estudiante.getSiguiente() != null && object.getNombre().compareTo(estudiante.getNombre()) <= 0){
                estudiante = estudiante.getSiguiente();
            }
            
            // Se introduce el elemento en su posicion.
            object.setSiguiente(estudiante.getSiguiente());
            estudiante.setSiguiente(object);
        } else {
            
            // Se introduce el elemento en el primer sitio de la lista.
            object.setSiguiente(this.estudiante);
            this.estudiante = object;
        } 
        
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
     * Devuelve el objeto Estudiante en la posicion indicada por parametro. Si no
     * lo encuentra devuelve null.
     * 
     * @param index
     * @return 
     */
    @Override
    public Estudiante buscarObject(int index) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Estudiante elemento;
        elemento = this.estudiante;
        
        // Se realiza un recorrido hasta encontrar el campo info identico.
        while(elemento != null && elemento.getDni()!= index){
            elemento = elemento.getSiguiente();
        }
        
        // Se devuelve el puntero.
        return elemento;
    }
    
    /**
     * Devuelve el indice en la lista del elemento introducido por parametro. 
     * Si no lo encuentra devuelve -1.
     * 
     * @param object
     * @return 
     */
    @Override
    public int buscarIndex(Estudiante object) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Estudiante aux = this.estudiante;
        int i = 0;

        // Se realiza un recorrido hasta encontrar el elemento introducido.
        while(aux != object && aux != null){
            aux = aux.getSiguiente();
            i++;
        }
        
        //Si no lo ha encontrado entonces devuelve -1.
        if(aux == null){
            i = -1;
        }
        
        // Se devuelve el indice.
        return i;
    }
    
}
