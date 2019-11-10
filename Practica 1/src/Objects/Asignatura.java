/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Interfaces.interfaz_Conceptos;
import Lists.Lista_Estudiantes;

/**
 *
 * @author felix
 */
public class Asignatura implements interfaz_Conceptos{
    // ATRIBUTOS
    private int codigo;
    private String nombre;
    private Lista_Estudiantes estudiantes;
    private Asignatura siguiente;

    // CONSTRUCTOR
    public Asignatura(int codigo, String nombre, Lista_Estudiantes estudiantes, Asignatura siguiente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        this.siguiente = siguiente;
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

    public Lista_Estudiantes getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Lista_Estudiantes estudiantes) {
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
        return "código: " + codigo + ", nombre: " + nombre + ", estudiantes: " + estudiantes
        + ", siguiente: " + siguiente + ".";
    }
    
}
