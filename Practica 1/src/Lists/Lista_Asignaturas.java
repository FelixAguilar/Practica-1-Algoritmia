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
     * Permite añadir un elemento a la lista de forma ordenada por el codigo de 
     * la asignatura.
     * 
     * @param object 
     */
    @Override
    public void añadir(Asignatura object) {
        
        // Se comprueba que no este vacia la lista o que sea mayor que el primer elemento.
        if (this.asignatura != null && object.getCodigo()> this.asignatura.getCodigo()){
            
            // Se realiza un recorrido de los elementos de la lista hasta encontrar 
            // un elemento mayor que el que se quiere introducir.
            Asignatura A = this.asignatura;
            while(A.getSiguiente() != null && object.getCodigo() > A.getSiguiente().getCodigo()){
                A = A.getSiguiente();
            }
            
            // Se introduce el elemento en su posicion.
            object.setSiguiente(A.getSiguiente());
            A.setSiguiente(object);
        } else {
            
            // Se introduce el elemento en el primer sitio de la lista.
            object.setSiguiente(this.asignatura);
            this.asignatura = object;
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
    public void ordenarAlfabeticamente() {
        
        //Preparacion de variables
        Lista_Asignaturas lista_aux = new Lista_Asignaturas();
        Asignatura min = this.asignatura;
        Asignatura aux = this.asignatura;
        
        // Comenzamos la ordenacion de maximo al minimo.
        while(min != null){ 
            while (aux != null) {
                int c = min.getNombre().compareTo(aux.getNombre());
                if (c >= 0) {
                    aux = aux.getSiguiente();
                } else {
                    min = aux;
                    aux = aux.getSiguiente();
                }
            }
            lista_aux.añadir(min);
            this.eliminar(buscarIndex(min));
            aux = this.asignatura;
            min = this.asignatura;
        }
        this.asignatura = lista_aux.getAsignatura();
    }

    /**
     * Devuelve el objeto Asignatura con el codigo indicado por parametro. Si no
     * lo encuentra devuelve null.
     * 
     * @param index
     * @return 
     */
    @Override
    public Asignatura buscarObject(int index) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Asignatura elemento;
        elemento = this.asignatura;
        
        // Se realiza un recorrido hasta encontrar el campo info identico.
        while(elemento != null && elemento.getCodigo()!= index){
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
    public int buscarIndex(Asignatura object) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Asignatura aux = this.asignatura;
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
