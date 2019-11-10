/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Lists.Lista_Estudiantes;

/**
 *
 * @author felix
 */
public class Obligatoria extends Asignatura{
    // ATRIBUTOS
    private int creditos;
    
    // CONSTRUCTOR
    public Obligatoria(int codigo, String nombre, Lista_Estudiantes estudiantes, Asignatura siguiente, int creditos) {
        super(codigo, nombre, estudiantes, siguiente);
        this.creditos = creditos;
    }

    // MÉTODOS
    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    @Override
    public String toString(){
        return "créditos: " + creditos + ".";
    }
    
}
