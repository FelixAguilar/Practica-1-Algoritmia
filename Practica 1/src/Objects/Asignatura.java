package Objects;

import Interfaces.interfaz_Conceptos;
import Lists.Lista_Ref_Estudiantes;

/**
 * Clase Asignatura. contiene los atributos y metodos que identifican una 
 * asignatura.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Asignatura implements interfaz_Conceptos{
    
    // Atributos.
    private int codigo;
    private String nombre;
    private Lista_Ref_Estudiantes ref_Estudiantes;
    private Asignatura siguiente;

    // Constructor.
    public Asignatura(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ref_Estudiantes = new Lista_Ref_Estudiantes();
        this.siguiente = null;
    }

    /**
     * Metodo para obtener el codigo.
     * 
     * @return 
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo para actualizar el codigo.
     * 
     * @param codigo 
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo para obtener el nombre.
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para actualizar el nombre.
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la lista de referencias de estudiantes.
     * 
     * @return 
     */
    public Lista_Ref_Estudiantes getRef_Estudiantes() {
        return ref_Estudiantes;
    }

    /**
     * Metodo para actualizar la lista de referencias de estudiantes.
     * 
     * @param estudiantes 
     */
    public void setRef_Estudiantes(Lista_Ref_Estudiantes estudiantes) {
        this.ref_Estudiantes = estudiantes;
    }

    /**
     * Metodo para obtener la siguiente asignatura en la lista.
     * 
     * @return 
     */
    public Asignatura getSiguiente() {
        return siguiente;
    }

    /**
     * Metodo para actualizar la siguiente asignatura en la lista.
     * 
     * @param siguiente 
     */
    public void setSiguiente(Asignatura siguiente) {
        this.siguiente = siguiente;
    }
    
    /**
     * Metodo para imprimir el contenido de una asignatura.
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "Codigo: " + this.codigo + " Nombre: " + this.nombre + ".";
    }
    
}
