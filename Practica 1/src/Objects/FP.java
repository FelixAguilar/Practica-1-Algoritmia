package Objects;

import Interfaces.Interfaz_Conceptos;

/**
 * Clase FP. Contiene los atributos y metodos que identifican una clase FP, esta
 * es hija de la clase Curso.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class FP extends Curso implements Interfaz_Conceptos{
    
    // Atributo.
    private String especialidad;
    
    /**
     * Constructor.
     * 
     * @param codigo
     * @param nombre
     * @param especialidad 
     */
    public FP(int codigo, String nombre, String especialidad) {
        super(codigo, nombre);
        this.especialidad = especialidad;
    }

    /**
     * Metodo para obtener la especialidad del curso.
     * 
     * @return 
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Metodo para actualizar la especialidad del curso.
     * 
     * @param especialidad 
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Metodo que devuelve un string con los atributos de un curso. Incluye el 
     * tipo de asignatura que es.
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre() + 
                ", Tipo: FP, Especialidad: " + especialidad + ".";
    }
    
    
}
