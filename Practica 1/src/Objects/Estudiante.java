/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Interfaces.interfaz_Conceptos;
import Lists.Lista_Ref_Asignaturas;

/**
 *
 * @author felix
 */
public class Estudiante implements interfaz_Conceptos{
    // ATRIBUTOS
    private int dni;
    private String nombre;
    private Estudiante siguiente;
    private Lista_Ref_Asignaturas ref_Asignaturas;

    // CONSTRUCTOR
    public Estudiante(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.siguiente = null;
        this.ref_Asignaturas = new Lista_Ref_Asignaturas();
    }

    // MÉTODOS
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Estudiante siguiente) {
        this.siguiente = siguiente;
    }

    public Lista_Ref_Asignaturas getRef_Asignaturas() {
        return ref_Asignaturas;
    }

    public void setRef_Asignaturas(Lista_Ref_Asignaturas ref_Asignaturas) {
        this.ref_Asignaturas = ref_Asignaturas;
    }
    
    @Override
    public String toString(){
        return "DNI: " + dni + ", nombre: " + nombre + ".";
    }
    
}
