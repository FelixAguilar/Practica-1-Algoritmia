/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package References;

import Interfaces.interfaz_Conceptos;
import Objects.Asignatura;

/**
 *
 * @author felix
 */
public class Ref_Asignatura implements interfaz_Conceptos {
    // ATRIBUTOS
    private Asignatura asignatura;
    private Ref_Asignatura siguiente;

    // CONSTRUCTOR
    public Ref_Asignatura(Asignatura asignatura, Ref_Asignatura siguiente) {
        this.asignatura = asignatura;
        this.siguiente = siguiente;
    }

    // MÉTODOS
    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Ref_Asignatura getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Ref_Asignatura siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString(){
        return "asignatura: " + asignatura + ", siguiente: " + siguiente + ".";
    }
    
}
