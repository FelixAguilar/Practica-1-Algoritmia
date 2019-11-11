/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author felix
 */
public class Obligatoria extends Asignatura{
    // ATRIBUTOS
    private int creditos;
    
    // CONSTRUCTOR
    public Obligatoria(int codigo, String nombre, int creditos) {
        super(codigo, nombre);
        this.creditos = creditos;
    }

    // MÉTODOS
    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre() + ", Tipo: Obligatoria, Creditos: " + creditos + ".\n";
    }
    
}
