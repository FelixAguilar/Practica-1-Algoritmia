/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author felix
 */
public class FP extends Curso{
    // ATRIBUTOS
    private String especialidad;
    
    // CONSTRUCTOR
    public FP(int codigo, String nombre, String especialidad) {
        super(codigo, nombre);
        this.especialidad = especialidad;
    }

    // MÉTODOS
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString(){
        return "especialidad: " + especialidad + ".";
    }
    
    
}
