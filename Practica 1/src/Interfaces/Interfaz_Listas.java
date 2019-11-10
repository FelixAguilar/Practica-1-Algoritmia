package Interfaces;

/**
 * Interfaz para los metodos de gestion de las listas.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez
 */
public interface Interfaz_Listas <T> {
    public void añadir (T object);
    public void eliminar (int index);
    public void ordenarAlfabeticamente();
}
