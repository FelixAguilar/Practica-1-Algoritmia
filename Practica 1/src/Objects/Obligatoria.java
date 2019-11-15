package Objects;

import Interfaces.Interfaz_Conceptos;

/**
 * Clase Obligatoria. Contiene los atributos y metodos que identifican una clase
 * Obligatoria, esta es hija de la clase Asignatura.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Obligatoria extends Asignatura implements Interfaz_Conceptos {

    // Atributo.
    private int creditos;

    /**
     * Constructor.
     *
     * @param codigo
     * @param nombre
     * @param creditos
     */
    public Obligatoria(int codigo, String nombre, int creditos) {
        super(codigo, nombre);
        this.creditos = creditos;
    }

    /**
     * Metodo para obtener los creditos de la Asignatura.
     *
     * @return
     */
    public int getCreditos() {
        return creditos;
    }

    /**
     * Metodo para actualalizar los creditos de la asigntura.
     *
     * @param creditos
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /**
     * Metodo que devuelve un string con los atributos de una asignatura.
     * Incluye el tipo de asignatura que es.
     *
     * @return
     */
    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre()
                + ", Tipo: Obligatoria, Creditos: " + creditos + ".";
    }

}
