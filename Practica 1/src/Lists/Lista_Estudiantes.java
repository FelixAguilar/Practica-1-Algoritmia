/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lists;

import Objects.Estudiante;

/**
 *
 * @author felix
 */
public class Lista_Estudiantes {
    
    // Atributos.
    private Estudiante estudiante;

    public Lista_Estudiantes(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    } 
}
