/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Lists.Lista_Asignaturas;

/**
 *
 * @author felix
 */
public class FP extends Curso{
    // ATRIBUTOS
    private String especialidad;
    
    // CONSTRUCTOR
    public FP(int codigo, String nombre, Lista_Asignaturas asignaturas, Curso siguiente, String especialidad) {
        super(codigo, nombre, asignaturas, siguiente);
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
