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
public class Bachiller extends Curso{
    // ATRIBUTOS
    private String año;

    // CONSTRUCTOR
    public Bachiller(int codigo, String nombre, String año) {
        super(codigo, nombre);
        this.año = año;
    }

    // MÉTODOS
    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre() + ", Tipo: Bachiller, Año: " + año + ".\n";
    }
}
