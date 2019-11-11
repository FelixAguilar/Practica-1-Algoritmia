package Main;

import Lists.Lista_Cursos;
import Lists.Lista_Estudiantes;
import Objects.Asignatura;
import Objects.Bachiller;
import Objects.Curso;
import Objects.FP;
import Objects.Obligatoria;
import Objects.Optativa;
import References.Ref_Estudiante;

/**
 * Contiene todos los metodos a ejecutar desde la interfaz grafica.
 * 
 * @author Felix Aguilar Ferrer, Adrian Bennasar Polzin, Alvaro Bueno Lopez.
 */
public class Operations {
   
    //Lista de los cursos.
    public Lista_Cursos cursos = new Lista_Cursos();
    
    //Lista de los estudiantes.
    public Lista_Estudiantes estudiantes = new Lista_Estudiantes();
    
    //Dar de alta un curso, tambien dar de alta todas sus asignaturas de forma ordenada ascendiente de su identificador o nombre.
    public Curso nuevo_Curso(int codigo, String nombre, String tipo, String aux){
        
        Curso curso;
        
        if("FP".equals(tipo)){
            curso = new FP(codigo, nombre, aux);
        }else{
            curso = new Bachiller(codigo, nombre, aux);   
        }
        cursos.añadir(curso);
        
        return curso;
    }
    
    public int nueva_Asignatura(Curso curso, int codigo, String nombre, String tipo, String aux){
        
        Asignatura asignatura;
        
        if("Optativa".equals(tipo)){
            asignatura = new Optativa(codigo, nombre, aux);
        }else{
            asignatura = new Obligatoria(codigo, nombre, Integer.parseInt(aux));   
        }
        curso.getAsignaturas().añadir(asignatura);
        //curso.getAsignaturas().ordenarAlfabeticamente();
        
        return 0;
    }
    
    //Matricular un estudiante de una asignatura dada, los estudiantes tambien han de estar ordenados por nombre en la assignatura.
    
    
    //Dar de baja un curso, dando de baja tambien las asignaturas y la participacion de los estudiantes en esta.
    
    
    //Dar de baja una asignatura, dando de baja tambien la participacion de los estudiantes en la misma.
    
    //Dado un curso, listar todas sus asignaturas y los estudiantes matriculados en esta.
    public String mostrar_Curso(int codigo){
        Curso curso = cursos.buscar(codigo);
        String s = curso.toString();
        Asignatura asignatura = curso.getAsignaturas().getAsignatura();
        while(asignatura != null){
            s += asignatura.toString();
            Ref_Estudiante estudiante = asignatura.getEstudiantes().getRef_Estudiante();
            while (estudiante != null){
                s += estudiante.getEstudiante().toString();
                estudiante = estudiante.getSiguiente();
            }
            asignatura = asignatura.getSiguiente();
        }
        return s;
    }
    
    //Dada una asignatura, indicar a que curso pertenece con el tipo y su especialidad del curso juntamente con los estudiantes matriculados en la misma.

    
    //Dado un estudiante, indicar a que asignaturas con su informacion y a que curso pertenenen de cada asignatura.
    
}
