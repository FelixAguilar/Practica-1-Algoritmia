package Lists;

import Interfaces.Interfaz_Listas;
import Objects.Curso;

/**
 * Clase lista de cursos. Permite gestionar la lista añadiendo, eliminando 
 * o bien modificando la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Cursos implements Interfaz_Listas<Curso> {
    
    // Atributo.
    private Curso curso;
    
    // Constructor.
    public Lista_Cursos() {
        this.curso = null;
    }

    /**
     * Permite obtener el valor del primer campo de la lista.
     * 
     * @return 
     */
    public Curso getCurso() {
        return curso;
    }
    
    /**
     * Permite asignar el primer elemento de la lista.
     * 
     * @param curso 
     */
    public void setCurso(Curso curso) {
        this.curso = curso;
    } 

    /**
     * Permite añadir un elemento al final de la lista.
     * 
     * @param object 
     */
    @Override
    public void añadir(Curso object) {
        
        // Si la lista no esta vacia.
        if (this.curso != null){
            
            // Se recorre hasta llegar al final y se introduce el elemento alli.
            Curso aux = this.curso;
            while (aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(object);
        } else {
            
            // Si no se introduce en el inicio de la lista.
            this.curso = object;
        }
        
        // Asegura que el elemento introducido al final apunta a null.
        object.setSiguiente(null);
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
        if (this.curso != null) {
            
            /* Si el siguiente valor despues del primer elemento es nulo 
               entonces elimina el primer elemento de la lista. */
            if (this.curso.getSiguiente() == null) {
                this.curso = null;
            } else {
                
                /* Si el index es 1 entonces se elimina el primer elemento de la 
                   lista, si no se realiza un recorrido hasta encontrar el 
                   elemento anterior al elemento a eliminar. */
                if (index >= 1){
                
                // Recorre la lista en busca del elemento en la posicion index.
                int n = 0;
                Curso aux = this.curso;
                while (n < index - 2) {
                    aux = aux.getSiguiente();
                    n++;
                }
                
                // Elimina el elemento en la posicion index.
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                }
                else{
                    
                    // Elimina el elemento en la segunda posicion.
                    this.curso = this.curso.getSiguiente();
                }
            }
        }
    }

    /**
     * Devuelve el objeto Curso en la posicion indicada por parametro. Si no
     * lo encuentra devuelve null.
     * 
     * @param index
     * @return 
     */
    @Override
    public Curso buscarObject(int index) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Curso aux;
        aux = this.curso;
        
        // Se realiza un recorrido hasta encontrar el campo Codigo identico.
        while(aux != null && aux.getCodigo()!= index){
            aux = aux.getSiguiente();
        }
        
        // Se devuelve el puntero.
        return aux;
    }
    
    /**
     * Devuelve el indice en la lista del elemento introducido por parametro. 
     * Si no lo encuentra devuelve -1.
     * 
     * @param object
     * @return 
     */
    @Override
    public int buscarIndex(Curso object) {
        
        // Creamos un puntero auxiliar que apunte al primer elemento.
        Curso aux = this.curso;
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

