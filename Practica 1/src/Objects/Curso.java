/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Interfaces.interfaz_Conceptos;
import Lists.Lista_Asignaturas;

/**
 *
 * @author felix
 */
public class Curso implements interfaz_Conceptos{
    // ATRIBUTOS
    private int codigo;
    private String nombre;
    private Lista_Asignaturas asignaturas;
    private Curso siguiente;

    // CONSTRUCTOR
    public Curso(int codigo, String nombre, Lista_Asignaturas asignaturas, Curso siguiente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
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

    public Lista_Asignaturas getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Lista_Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }

    public Curso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Curso siguiente) {
        this.siguiente = siguiente;
    }
    
     @Override
    public String toString(){
        return "código: " + codigo + ", nombre: " + nombre + ", asignaturas: " + asignaturas
        + ", siguiente: " + siguiente + ".";
    }
    
}
