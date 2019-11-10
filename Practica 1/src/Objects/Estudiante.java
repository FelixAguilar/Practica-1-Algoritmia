/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Interfaces.interfaz_Conceptos;

/**
 *
 * @author felix
 */
public class Estudiante implements interfaz_Conceptos{
    // ATRIBUTOS
    private int dni;
    private String nombre;
    private Estudiante siguiente;

    // CONSTRUCTOR
    public Estudiante(int dni, String nombre, Estudiante siguiente) {
        this.dni = dni;
        this.nombre = nombre;
        this.siguiente = siguiente;
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
    
    @Override
    public String toString(){
        return "DNI: " + dni + ", nombre: " + nombre + ", siguiente: " + siguiente + ".";
    }
    
}
