package Lists;

import Interfaces.Interfaz_Listas;
import References.Ref_Asignatura;

/**
 * Clase lista de ref_Asignaturas. Permite gestionar la lista añadiendo, 
 * eliminando o bien buscando en la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Ref_Asignaturas implements Interfaz_Listas<Ref_Asignatura> {
    
    // Atributo.
    private Ref_Asignatura ref_Asignatura;
    
    // Constructor.
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
     * Permite añadir un elemento a la lista de forma ordenada por el codigo de 
     * la asignatura.
     * 
     * @param object 
     */
    @Override
    public void añadir(Ref_Asignatura object) {
        
        /* Comprueba que la lista no este vacia y que sea mayor el elemento 
           introducido por parametro que el primer elemento de la lista. */
        if (this.ref_Asignatura != null && 
                object.getAsignatura().getCodigo()> 
                        this.ref_Asignatura.getAsignatura().getCodigo()){
            
            /* Realiza un recorrido de los elementos de la lista hasta encontrar 
               un elemento mayor que el elemento introducir. */
            Ref_Asignatura aux = this.ref_Asignatura;
            while(aux.getSiguiente() != null && 
                    object.getAsignatura().getCodigo() > 
                        aux.getSiguiente().getAsignatura().getCodigo()){
                
                // Obtenemos el siguiente elemento de la lista.
                aux = aux.getSiguiente();
            }
            
            // Introduce el elemento en su posicion adecuada por el codigo.
            object.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(object);
        } else {
            
            // Introduce el elemento en el primer sitio de la lista.
            object.setSiguiente(this.ref_Asignatura);
            this.ref_Asignatura = object;
        } 
    }

    /**
     * Elimina el elemento de la lista en la posicion indicada por index 
     * introducido por parametro.
     * 
     * @param index 
     */
    @Override
    public void eliminar(int index) {
        
        // Si la lista esta vacia no realiza nada.
        if (this.ref_Asignatura != null) {
            
            /* Si el siguiente valor despues del primer elemento es nulo 
               entonces elimina el primer elemento de la lista. */
            if (this.ref_Asignatura.getSiguiente() == null) {
                this.ref_Asignatura = null;
            } else {
                
                /* Si el index es 1 entonces se elimina el primer elemento de la 
                   lista, si no se realiza un recorrido hasta encontrar el 
                   elemento anterior al elemento a eliminar. */
                if (index >= 1){
                
                // Recorre la lista en busca del elemento en la posicion index.
                int n = 0;
                Ref_Asignatura aux = this.ref_Asignatura;
                while (n < index - 2) {
                    aux = aux.getSiguiente();
                    n++;
                }
                
                // Elimina el elemento en la posicion index.
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
                else{
                    
                    // Elimina el elemento en la segunda posicion.
                    this.ref_Asignatura = this.ref_Asignatura.getSiguiente();
                }
            }
        }
    }

    /**
     * Devuelve el objeto Ref_Asignatura en la posicion indicada por parametro. 
     * Si no lo encuentra devuelve null.
     * 
     * @param index
     * @return 
     */
    @Override
    public Ref_Asignatura buscarObject(int index) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Ref_Asignatura elemento;
        elemento = this.ref_Asignatura;
        
        // Se realiza un recorrido hasta encontrar el campo info identico.
        while(elemento != null && elemento.getAsignatura().getCodigo()!= index){
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
    public int buscarIndex(Ref_Asignatura object) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Ref_Asignatura aux = this.ref_Asignatura;
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
