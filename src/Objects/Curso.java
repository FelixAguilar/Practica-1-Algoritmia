package Objects;

import Lists.Lista_Asignaturas;
import Interfaces.Interfaz_Conceptos;

/**
 * Clase Curso. Contiene los atributos y metodos que identifican un curso.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Curso implements Interfaz_Conceptos {

    // Atributos.
    private int codigo;
    private String nombre;
    private Lista_Asignaturas asignaturas;
    private Curso siguiente;

    /**
     * Constructor.
     *
     * @param codigo
     * @param nombre
     */
    public Curso(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.asignaturas = new Lista_Asignaturas();
        this.siguiente = null;
    }

    /**
     * Metodo para obtener el codigo del curso.
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo para actualiar el codigo del curso.
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo para obtener el nombre del curso.
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para actualizar el nombre del curso.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la lista de asignaturas.
     *
     * @return
     */
    public Lista_Asignaturas getAsignaturas() {
        return asignaturas;
    }

    /**
     * Metodo para actualizar la lista de asignaturas.
     *
     * @param asignaturas
     */
    public void setAsignaturas(Lista_Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }

    /**
     * Metodo para obtener el siguiente curso de la lista.
     *
     * @return
     */
    public Curso getSiguiente() {
        return siguiente;
    }

    /**
     * Metodo para actualizar el siguiente curso de la lista.
     *
     * @param siguiente
     */
    public void setSiguiente(Curso siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Metodo que devuelve un string con los atributos de un curso.
     *
     * @return
     */
    @Override
    public String toString() {
        return "código: " + codigo + ", nombre: " + nombre + ".";
    }

}
