package Objects;

import Interfaces.Interfaz_Conceptos;

/**
 * Clase Optativa. Contiene los atributos y metodos que identifican una 
 * clase Optativa, esta es hija de la clase Asignatura.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Optativa extends Asignatura implements Interfaz_Conceptos{
    
    // Atributo.
    private String perfil;
    
    /**
     * Constructor.
     * 
     * @param codigo
     * @param nombre
     * @param perfil 
     */
    public Optativa(int codigo, String nombre, String perfil) {
        super(codigo, nombre);
        this.perfil = perfil;
    }

    /**
     * Metodo para obtener el perfil de la asignatura.
     * 
     * @return 
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * Metodo para actualizar el perfil de la asignatura.
     * 
     * @param perfil 
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    /**
     * Metodo que devuelve un string con los atributos de una asignatura. 
     * Incluye el tipo de asignatura que es.
     * 
     * @return 
     */
    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre() + 
                ", Tipo: Optativa, Perfil: " + perfil + ".";
    }
    
}
