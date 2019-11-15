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

    // Constructor.
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
     * Permite añadir un elemento a la lista de forma ordenada por el Nombre del
     * estudiante.
     *
     * @param object
     */
    @Override
    public void añadir(Estudiante object) {

        /* Comprueba que la lista no este vacia y que sea mayor el elemento 
           introducido por parametro que el primer elemento de la lista. */
        if (this.estudiante != null
                && object.getNombre().compareTo(this.estudiante.getNombre()) >= 0) {

            /* Realiza un recorrido de los elementos de la lista hasta encontrar 
               un elemento mayor que el elemento introducir. */
            Estudiante aux = this.estudiante;
            while (aux.getSiguiente() != null
                    && object.getNombre().compareTo(aux.getSiguiente().getNombre()) >= 0) {

                // Obtenemos el siguiente elemento de la lista.
                aux = aux.getSiguiente();
            }

            // Introduce el elemento en su posicion adecuada por el nombre.
            object.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(object);
        } else {

            // Introduce el elemento en el primer sitio de la lista.
            object.setSiguiente(this.estudiante);
            this.estudiante = object;
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
        if (this.estudiante != null) {

            /* Si el siguiente valor despues del primer elemento es nulo 
               entonces elimina el primer elemento de la lista. */
            if (this.estudiante.getSiguiente() == null) {
                this.estudiante = null;
            } else {

                /* Si el index es 0 entonces se elimina el primer elemento de la 
                   lista, si no se realiza un recorrido hasta encontrar el 
                   elemento anterior al elemento a eliminar. */
                if (index >= 1) {

                    // Recorre la lista en busca del elemento en la posicion index.
                    int n = 0;
                    Estudiante aux = this.estudiante;
                    while (n < index - 2) {
                        aux = aux.getSiguiente();
                        n++;
                    }

                    // Elimina el elemento en la posicion index.
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                } else {

                    // Elimina el elemento en la segunda posicion.
                    this.estudiante = this.estudiante.getSiguiente();
                }
            }
        }
    }

    /**
     * Devuelve el objeto Estudiante en la posicion indicada por parametro. Si
     * no lo encuentra devuelve null.
     *
     * @param index
     * @return
     */
    @Override
    public Estudiante buscarObject(int index) {

        // Creamos un puntero auxiliar que apunte al primer elemento.
        Estudiante aux;
        aux = this.estudiante;

        // Se realiza un recorrido hasta encontrar el campo info identico.
        while (aux != null && aux.getDni() != index) {
            aux = aux.getSiguiente();
        }

        // Se devuelve el puntero.
        return aux;
    }

    /**
     * Devuelve el indice en la lista del elemento introducido por parametro. Si
     * no lo encuentra devuelve -1.
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
        while (aux != object && aux != null) {
            aux = aux.getSiguiente();
            i++;
        }

        //Si no lo ha encontrado entonces devuelve -1.
        if (aux == null) {
            i = -1;
        }

        // Se devuelve el indice.
        return i;
    }

}
