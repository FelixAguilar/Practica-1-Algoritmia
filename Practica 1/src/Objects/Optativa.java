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
public class Optativa extends Asignatura{
    // ATRIBUTOS
    private String perfil;
    
    // CONSTRUCTOR
    public Optativa(int codigo, String nombre, Lista_Estudiantes estudiantes, Asignatura siguiente, String perfil) {
        super(codigo, nombre, estudiantes, siguiente);
        this.perfil = perfil;
    }

    // MÉTODOS
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    @Override
    public String toString(){
        return "perfil: " + perfil + ".";
    }
    
}
