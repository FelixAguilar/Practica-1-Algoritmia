package Objects;

import Interfaces.Interfaz_Conceptos;

/**
 * Clase Bachiller. Contiene los atributos y metodos que identifican una clase
 * BBachiller, esta es hija de la clase Curso.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Bachiller extends Curso implements Interfaz_Conceptos {

    // Atributo.
    private String año;

    /**
     * Constructor.
     *
     * @param codigo
     * @param nombre
     * @param año
     */
    public Bachiller(int codigo, String nombre, String año) {
        super(codigo, nombre);
        this.año = año;
    }

    /**
     * Metodo para obterner el parametro año de curso.
     *
     * @return
     */
    public String getAño() {
        return año;
    }

    /**
     * Metodo para actualizar el parametro año de curso.
     *
     * @param año
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * Metodo que devuelve un string con los atributos de un curso. Incluye el
     * tipo de asignatura que es.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre()
                + ", Tipo: Bachiller, Año: " + año + ".\n";
    }
}
