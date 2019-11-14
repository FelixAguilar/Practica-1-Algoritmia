package Lists;

import Interfaces.Interfaz_Listas;
import References.Ref_Estudiante;

/**
 * Clase lista de ref_Estudiantes. Permite gestionar la lista añadiendo, 
 * eliminando o bien buscando en la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Ref_Estudiantes implements Interfaz_Listas<Ref_Estudiante> {
    
    // Atributo.
    private Ref_Estudiante ref_Estudiante;
    
    // Constructor de la clase.
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
     * Permite añadir un elemento a la lista de forma ordenada por el Nombre del
     * estudiante.
     * 
     * @param object 
     */
    @Override
    public void añadir(Ref_Estudiante object) {

        /* Comprueba que la lista no este vacia y que sea mayor el elemento 
           introducido por parametro que el primer elemento de la lista. */
        if (this.ref_Estudiante != null && 
                object.getEstudiante().getNombre().compareTo(
                        this.ref_Estudiante.getEstudiante().getNombre()) >= 0){
            
            /* Realiza un recorrido de los elementos de la lista hasta encontrar 
               un elemento mayor que el elemento introducir. */
            Ref_Estudiante aux = this.ref_Estudiante;
            while(aux.getSiguiente() != null && 
                    object.getEstudiante().getNombre().compareTo(
                            aux.getSiguiente().getEstudiante().getNombre()) >= 0){
                
                // Obtenemos el siguiente elemento de la lista.
                aux = aux.getSiguiente();
            }
            
            // Introduce el elemento en su posicion adecuada por el nombre.
            object.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(object);
        } else {
            
            // Introduce el elemento en el primer sitio de la lista.
            object.setSiguiente(this.ref_Estudiante);
            this.ref_Estudiante = object;
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
        if (this.ref_Estudiante != null) {
            
            /* Si el siguiente valor despues del primer elemento es nulo 
               entonces elimina el primer elemento de la lista. */
            if (this.ref_Estudiante.getSiguiente() == null) {
                this.ref_Estudiante = null;
            } else {
                
                /* Si el index es 1 entonces se elimina el primer elemento de la 
                   lista, si no se realiza un recorrido hasta encontrar el 
                   elemento anterior al elemento a eliminar. */
                if (index >= 1){
                
                // Recorre la lista en busca del elemento en la posicion index.
                int n = 0;
                Ref_Estudiante aux = this.ref_Estudiante;
                while (n < index - 2) {
                    aux = aux.getSiguiente();
                    n++;
                }
                
                // Elimina el elemento en la posicion index.
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
                else{
                    
                    // Elimina el elemento en la segunda posicion.
                    this.ref_Estudiante = this.ref_Estudiante.getSiguiente();
                }
            }
        }
    }

    /**
     * Devuelve el objeto Ref_Estudiante en la posicion indicada por parametro. 
     * Si no lo encuentra devuelve null.
     * 
     * @param index
     * @return 
     */
    @Override
    public Ref_Estudiante buscarObject(int index) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Ref_Estudiante elemento;
        elemento = this.ref_Estudiante;
        
        // Se realiza un recorrido hasta encontrar el campo info identico.
        while(elemento != null && elemento.getEstudiante().getDni()!= index){
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
    public int buscarIndex(Ref_Estudiante object) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Ref_Estudiante aux = this.ref_Estudiante;
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
