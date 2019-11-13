package Objects;

import Lists.Lista_Ref_Asignaturas;
import Interfaces.Interfaz_Conceptos;

/**
 * Clase estudiante. Contiene los atributos y metodos que definen a un 
 * estudiante.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno.
 */
public class Estudiante implements Interfaz_Conceptos{
    
    // Atributos.
    private int dni;
    private String nombre;
    private Estudiante siguiente;
    private Lista_Ref_Asignaturas ref_Asignaturas;

    /**
     * Constructor.
     * 
     * @param dni
     * @param nombre 
     */
    public Estudiante(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.siguiente = null;
        this.ref_Asignaturas = new Lista_Ref_Asignaturas();
    }

    /**
     * Metodo para obtener el DNI del estudiante.
     * 
     * @return 
     */
    public int getDni() {
        return dni;
    }

    /**
     * Metodo para actualizar el DNI del estudiante.
     * 
     * @param dni 
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * Metodo para obtener el nombre del estudiante.
     * 
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para actualizar el nombre del estudiante.
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el siguiente estudiante de la lista.
     * 
     * @return 
     */
    public Estudiante getSiguiente() {
        return siguiente;
    }

    /**
     * Metodo para actualizar el siguiente estudiante de la lista.
     * 
     * @param siguiente 
     */
    public void setSiguiente(Estudiante siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Metodo para obtener la lista de referencias de asignaturas.
     * 
     * @return 
     */
    public Lista_Ref_Asignaturas getRef_Asignaturas() {
        return ref_Asignaturas;
    }

    /**
     * Metodo para actualizar la lista de referencias de asignaturas.
     * 
     * @param ref_Asignaturas 
     */
    public void setRef_Asignaturas(Lista_Ref_Asignaturas ref_Asignaturas) {
        this.ref_Asignaturas = ref_Asignaturas;
    }
    
    /**
     * Devuelve un string con los atributos de un estudiante.
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "DNI: " + dni + ", nombre: " + nombre + ".";
    }
    
}
