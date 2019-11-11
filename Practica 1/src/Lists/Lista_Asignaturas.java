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
        
        //Preparacion de variables
        Lista_Asignaturas lista_aux = new Lista_Asignaturas();
        Asignatura max = this.asignatura;
        Asignatura aux = this.asignatura;
        
        // Comenzamos la ordenacion de maximo al minimo.
        while(max != null){ 
            while (aux != null) {
                int c = max.getNombre().compareTo(aux.getNombre());
                if (c >= 0) {
                    aux = aux.getSiguiente();
                } else {
                    max = aux;
                    aux = aux.getSiguiente();
                }
            }
            lista_aux.añadir(max);
            this.eliminar(buscar_Posicion(max));
            aux = this.asignatura;
            max = this.asignatura;
        }
        this.asignatura = lista_aux.getAsignatura();
    }
    
    private int buscar_Posicion(Asignatura asignatura){
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Asignatura aux = this.asignatura;
        int i = 0;

        // Se realiza un recorrido hasta encontrar el campo info identico.
        while(aux != asignatura && aux != null){
            aux = aux.getSiguiente();
            i++;
        }
        
        // Se devuelve el puntero.
        return i;
    }
    
    public Asignatura buscar(int codigo){
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Asignatura elemento;
        elemento = this.asignatura;
        
        // Se realiza un recorrido hasta encontrar el campo info identico.
        while(elemento.getCodigo()!= codigo){
            elemento = elemento.getSiguiente();
        }
        
        // Se devuelve el puntero.
        return elemento;
    }
}
