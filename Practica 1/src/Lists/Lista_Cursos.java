/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

import Objects.Curso;

/**
 *
 * @author felix
 */
public class Lista_Cursos {
    
    // Atributos.
    private Curso curso;

    public Lista_Cursos(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    } 
}
