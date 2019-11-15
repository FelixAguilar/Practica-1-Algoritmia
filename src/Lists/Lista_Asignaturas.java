package Lists;

import Interfaces.Interfaz_Listas;
import Objects.Asignatura;

/**
 * Clase lista de asignaturas. Permite gestionar la lista añadiendo, eliminando
 * o bien modificando la lista.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Lista_Asignaturas implements Interfaz_Listas<Asignatura> {

    // Atributo.
    private Asignatura asignatura;

    // Constructor
    public Lista_Asignaturas() {
        this.asignatura = null;
    }

    /**
     * Permite obtener el valor del primer elemento de la lista.
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

        /* Comprueba que la lista no este vacia y que sea mayor el elemento 
           introducido por parametro que el primer elemento de la lista. */
        if (this.asignatura != null
                && object.getCodigo() > this.asignatura.getCodigo()) {

            /* Realiza un recorrido de los elementos de la lista hasta encontrar 
               un elemento mayor que el elemento introducir. */
            Asignatura aux = this.asignatura;
            while (aux.getSiguiente() != null
                    && object.getCodigo() > aux.getSiguiente().getCodigo()) {

                // Obtenemos el siguiente elemento de la lista.
                aux = aux.getSiguiente();
            }

            // Introduce el elemento en su posicion adecuada por el codigo.
            object.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(object);
        } else {

            // Introduce el elemento en el primer sitio de la lista.
            object.setSiguiente(this.asignatura);
            this.asignatura = object;
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
        if (this.asignatura != null) {

            /* Si el siguiente valor despues del primer elemento es nulo 
               entonces elimina el primer elemento de la lista. */
            if (this.asignatura.getSiguiente() == null) {
                this.asignatura = null;
            } else {

                /* Si el index es 0 entonces se elimina el primer elemento de la 
                   lista, si no se realiza un recorrido hasta encontrar el 
                   elemento anterior al elemento a eliminar. */
                if (index >= 1) {

                    // Recorre la lista en busca del elemento en la posicion index.
                    int n = 0;
                    Asignatura aux = this.asignatura;
                    while (n < index - 2) {
                        aux = aux.getSiguiente();
                        n++;
                    }

                    // Elimina el elemento en la posicion index.
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                } else {

                    // Elimina el elemento en la segunda posicion.
                    this.asignatura = this.asignatura.getSiguiente();
                }
            }
        }
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
        Asignatura aux;
        aux = this.asignatura;

        // Se realiza un recorrido hasta encontrar el campo Codigo identico.
        while (aux != null && aux.getCodigo() != index) {
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
    public int buscarIndex(Asignatura object) {

        // Creamos un puntero auxiliar que apunte al primer elemento.
        Asignatura aux = this.asignatura;
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
