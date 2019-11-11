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
public class Optativa extends Asignatura{
    // ATRIBUTOS
    private String perfil;
    
    // CONSTRUCTOR
    public Optativa(int codigo, String nombre, String perfil) {
        super(codigo, nombre);
        this.perfil = perfil;
    }

    // MÉTODOS
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + this.getCodigo() + ", Nombre:" + this.getNombre() + ", Tipo: Optativa, Perfil: " + perfil + ".\n";
    }
    
}
