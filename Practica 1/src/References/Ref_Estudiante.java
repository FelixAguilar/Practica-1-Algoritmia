/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package References;

import Interfaces.interfaz_Conceptos;
import Objects.Estudiante;

/**
 *
 * @author felix
 */
public class Ref_Estudiante implements interfaz_Conceptos{
    // ATRIBUTOS
    private Estudiante estudiante;
    private Ref_Estudiante siguiente;
    
    // CONSTRUCTOR
    public Ref_Estudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
    
    // MÉTODOS
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Ref_Estudiante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Ref_Estudiante siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString(){
        return "estudiante: " + estudiante + ", siguiente: " + siguiente + ".";
    }
}
