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
public class Ballicher extends Curso{
    // ATRIBUTOS
    private String año;

    // CONSTRUCTOR
    public Ballicher(String año, int codigo, String nombre, Lista_Asignaturas asignaturas, Curso siguiente) {
        super(codigo, nombre, asignaturas, siguiente);
        this.año = año;
    }

    // MÉTODOS
    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    @Override
    public String toString(){
        return "año: " + año + ".";
    }
}
