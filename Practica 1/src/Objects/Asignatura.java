/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Interfaces.interfaz_Conceptos;
import Lists.Lista_Ref_Estudiantes;

/**
 *
 * @author felix
 */
public class Asignatura implements interfaz_Conceptos{
    // ATRIBUTOS
    private int codigo;
    private String nombre;
    private Lista_Ref_Estudiantes estudiantes;
    private Asignatura siguiente;

    // CONSTRUCTOR
    public Asignatura(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = new Lista_Ref_Estudiantes();
        this.siguiente = null;
    }

    // MÉTODOS
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista_Ref_Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Lista_Ref_Estudiantes estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Asignatura getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Asignatura siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public String toString(){
        return "";
    }
    
}
