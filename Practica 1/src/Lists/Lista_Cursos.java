package Lists;

import Interfaces.Interfaz_Listas;
import Objects.Curso;

/**
 * Clase lista de cursos. Permite gestionar la lista añadiendo, eliminando 
 * o bien ordenado la lista.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Cursos implements Interfaz_Listas<Curso> {
    
    // Atributo.
    private Curso curso;
    
    /**
     * Constructor de la clase.
     */
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
            Curso curso = this.curso;
            while (curso.getSiguiente() != null){
                curso = curso.getSiguiente();
            }
            curso.setSiguiente(object);
        } else {
            
            // Si no se introduce en el this.curso sitio.
            this.curso = object;
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
        if (this.curso != null) {
            
            //Si el siguiente valor es nulo entonces elimina el this.curso elemento.
            if (this.curso.getSiguiente() == null) {
                this.curso = null;
            } else {
                
                // Si no se realiza un recorrido hasta el elemento index-1.
                int n = 0;
                Curso curso = this.curso;
                while (n < index - 2) {
                    curso = curso.getSiguiente();
                    n++;
                }
                
                // Se elimina el elemento index.
                curso.setSiguiente(curso.getSiguiente().getSiguiente());
            }
        }
    }

    /**
     * Ordena la lista alfabeticamente segun nombre de la curso.
     */
    @Override
    public void ordenarAlfabeticamente() {
        
    }
    
}

