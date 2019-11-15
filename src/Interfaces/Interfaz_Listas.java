package Interfaces;

/**
 * Interfaz para los metodos de gestion de las listas.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez.
 * @param <Object>
 */
public interface Interfaz_Listas<Object> {

    /**
     * Metodo utilizado para añadir un elemento en la lista.
     *
     * @param object
     */
    public void añadir(Object object);

    /**
     * Metodo utilizado para eliminar un elemento de la lista.
     *
     * @param index
     */
    public void eliminar(int index);

    /**
     * Metodo utilizado para buscar un elemento en la lista dado su indice.
     *
     * @param index
     * @return
     */
    public Object buscarObject(int index);

    /**
     * Metodo utilizado para buscar en que posicion se encuentra un elemento.
     *
     * @param object
     * @return
     */
    public int buscarIndex(Object object);
}
