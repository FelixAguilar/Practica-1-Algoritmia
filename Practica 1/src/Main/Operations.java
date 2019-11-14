package Main;

import Lists.Lista_Cursos;
import Lists.Lista_Estudiantes;
import Objects.Asignatura;
import Objects.Bachiller;
import Objects.Curso;
import Objects.Estudiante;
import Objects.FP;
import Objects.Obligatoria;
import Objects.Optativa;
import References.Ref_Asignatura;
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

    /**
     * Dar de alta un curso. Permite dar de alta un curso con los parametros
     * introducidos, donde aux es una variable que puede representar varios
     * tipos de datos especificos para cada hijo de curso, siendo FP o Bachiller
     * posibles cursos.
     *
     * @param codigo
     * @param nombre
     * @param tipo
     * @param aux
     * @return
     */
    public Curso nuevo_Curso(int codigo, String nombre, String tipo, String aux) {

        // Crea un puntero nuevo.
        Curso curso = null;

        // Comprueba que no exista ya un curso con ese codigo.
        if (cursos.buscarObject(codigo) == null) {

            // Si no existe, entonces se crea un nuevo curso segun el tipo.
            if ("FP".equals(tipo)) {
                curso = new FP(codigo, nombre, aux);
            } else {
                curso = new Bachiller(codigo, nombre, aux);
            }

            // Añade a la lista de cursos.
            cursos.añadir(curso);
        }

        // Devuelve null si ha habido algun problema, sino el puntero nuevo.
        return curso;
    }

    /**
     * Añade una asignatura a un curso especificado por parametro. Esta puede
     * ser de dos tipos. Por ello, hay una variable aux que se ajusta
     * dependiendo de si se ha introducido de un tipo o del otro.
     *
     * @param nuevo_curso
     * @param codigo
     * @param nombre
     * @param tipo
     * @param aux
     * @return
     */
    public Asignatura nueva_Asignatura(Curso nuevo_curso, int codigo, String nombre, String tipo, String aux) {

        // Crea un nuevo puntero asignatura.
        Asignatura asignatura = null;

        // Obtiene el primer curso y pone a false el booleano.
        Curso curso = cursos.getCurso();
        boolean encontrado = false;

        // Recorre los cursos para buscar una asignatura con el mismo codigo.
        while (curso != null && encontrado == false) {
            if (curso.getAsignaturas().buscarObject(codigo) != null) {
                encontrado = true;
            } else {
                curso = curso.getSiguiente();
            }
        }

        // Si no existe una asignatura con ese codigo, crea la nueva asignatura.
        if (encontrado == false) {
            if ("Optativa".equals(tipo)) {
                asignatura = new Optativa(codigo, nombre, aux);
            } else {
                asignatura = new Obligatoria(codigo, nombre, Integer.parseInt(aux));
            }

            // Añade la asignatura al nuevo curso.
            nuevo_curso.getAsignaturas().añadir(asignatura);
        }

        // Devuelve null si ha habido algun problema, sino el puntero nuevo.
        return asignatura;
    }

    /**
     * Matricula un estudiante de una asignatura dada. si no existe el
     * estudiante se crea. los estudiantes se ordenaran por orden alfabetico.
     *
     * @param codigo_curso
     * @param codigo_asignatura
     * @param dni
     * @param nombre
     * @return
     */
    public Asignatura matricular_Estudiante(int codigo_curso, int codigo_asignatura, int dni, String nombre) {

        //Busca la asignatura, si existe, entonces matricula.
        Asignatura asignatura = cursos.buscarObject(codigo_curso).getAsignaturas().buscarObject(codigo_asignatura);
        if (asignatura != null) {

            // Busca si hay un estudiante ya con el dni, sino lo crea.
            Estudiante estudiante = estudiantes.buscarObject(dni);
            if (estudiante == null) {
                estudiante = new Estudiante(dni, nombre);
                estudiantes.añadir(estudiante);
            }

            // Se añade la referencia de estudiante a la asignatura.
            Ref_Estudiante refE = new Ref_Estudiante(estudiante);
            asignatura.getRef_Estudiantes().añadir(refE);

            // Se añade la referencia de asignatura al estudiante.
            Ref_Asignatura refA = new Ref_Asignatura(asignatura);
            estudiante.getRef_Asignaturas().añadir(refA);
        }
        
        // Devuelve null si ha habido un problema, sino el punero de asignatura.
        return asignatura;
    }

    /**
     * Elimina un curso y todo lo relacionado con el.
     *
     * @param codigo
     * @return
     */
    public Curso eliminar_Curso(int codigo) {

        // Comprueba que el curso exista.
        Curso curso = cursos.buscarObject(codigo);
        if (curso != null) {

            // Mientras haya asignaturas, estas se eliminan con los estudiantes.
            while (curso.getAsignaturas().getAsignatura() != null) {
                eliminar_Asignatura(curso.getAsignaturas().getAsignatura().getCodigo());
            }

            // Elimina el curso.
            cursos.eliminar(cursos.buscarIndex(curso));
        }

        // Devuelve el puntero del curso eliminado o null si no existia.
        return curso;
    }

    /**
     * Elimina una asignatura y todo lo relacionado con ella. Si un estudiante
     * no esta matriculado en ninguna asignatura se elimina.
     *
     * @param codigo
     * @return
     */
    public Asignatura eliminar_Asignatura(int codigo) {

        // Obtiene el primer curso y realiza la primera busqueda de asignatura.
        Curso curso = cursos.getCurso();
        Asignatura asignatura = curso.getAsignaturas().buscarObject(codigo);

        // Recorrido de busqueda de la asignatura.
        while (curso != null && asignatura == null) {
            curso = curso.getSiguiente();
            if (curso != null) {
                asignatura = curso.getAsignaturas().buscarObject(codigo);
            }
        }

        // Si existe la asignatura y el curso entonces se elimina.
        if (asignatura != null && curso != null) {

            // Obtiene el primer estudiante.
            Estudiante estudiante = estudiantes.getEstudiante();

            // Se elimina los estudiantes matriculados en la asignatura.
            Ref_Estudiante ref_estudiante = asignatura.getRef_Estudiantes().getRef_Estudiante();
            while (ref_estudiante != null) {

                // Si la referencia es igual al primer estudiante.
                if (ref_estudiante.getEstudiante() == estudiante) {

                    // Siguiente referencia.
                    ref_estudiante = ref_estudiante.getSiguiente();

                    // Se busca la referencia de asignatura.
                    Ref_Asignatura ref_asignatura = estudiante.getRef_Asignaturas().getRef_Asignatura();
                    while (ref_asignatura.getAsignatura() != asignatura) {
                        ref_asignatura = ref_asignatura.getSiguiente();
                    }

                    // Se elimina la referencia de asignatura del estudiante.
                    estudiante.getRef_Asignaturas().eliminar(estudiante.getRef_Asignaturas().buscarIndex(ref_asignatura));

                    // Si no exisiten mas matriculas se elimina el estudiante.
                    if (estudiante.getRef_Asignaturas().getRef_Asignatura() == null) {
                        estudiantes.eliminar(estudiantes.buscarIndex(estudiante));
                    }

                }
                estudiante = estudiante.getSiguiente();

            }

            // Eliminamos la asignatura.
            curso.getAsignaturas().eliminar(curso.getAsignaturas().buscarIndex(asignatura));
        }
        
        // Si hubo un problema devueleve null, sino el puntero de la asignatura.
        return asignatura;
    }

    /**
     * Muestra el Curso y todas sus asignaturas con los estudiantes matriculados
     * en cada una de ellas.
     *
     * @param codigo
     * @return
     */
    public String mostrar_Curso(int codigo) {

        // Busca el curso con el codigo introducido.
        Curso curso = cursos.buscarObject(codigo);
        String s = "";

        if (curso != null) {

            // Imprime el curso.
            s = "Curso: " + curso.toString() + "\n";

            // Imprime las asignaturas.
            Asignatura asignatura = curso.getAsignaturas().getAsignatura();
            while (asignatura != null) {
                s += "- Asignatura: " + asignatura.toString() + "\n";

                // Imprime los estudiantes.
                Ref_Estudiante estudiante = asignatura.getRef_Estudiantes().getRef_Estudiante();
                while (estudiante != null) {
                    s += "-- Estudiante: " + estudiante.getEstudiante().toString() + "\n";
                    estudiante = estudiante.getSiguiente();
                }
                asignatura = asignatura.getSiguiente();
            }
        }
        
        // Devuelve "" si hubo un problema.
        return s;
    }

    /**
     * Dado el codigo de una asignatura busca esta por los cursos y muestra los
     * estudiantes matriculados en esta junto con el curso.
     *
     * @param codigo
     * @return
     */
    public String mostrar_Asignatura(int codigo) {

        //Obtenemos el primer curso.
        Curso curso = cursos.getCurso();
        String s = "";
        if (curso != null) {

            // Se busca la asignatura con ese codigo.
            Asignatura asignatura = curso.getAsignaturas().buscarObject(codigo);
            while (curso != null && asignatura == null) {
                curso = curso.getSiguiente();
                if (curso != null) {
                    asignatura = curso.getAsignaturas().buscarObject(codigo);
                }
            }

            // Si encuentra la asignatura entonces imprime el contenido de esta.
            if (asignatura != null) {
                s = "Asignatura: " + asignatura.toString() + "\n";
                s += "- Curso: " + curso.toString() + "\n";
                Ref_Estudiante estudiante = asignatura.getRef_Estudiantes().getRef_Estudiante();
                while (estudiante != null) {
                    s += "-- Estudiante: " + estudiante.getEstudiante().toString() + "\n";
                    estudiante = estudiante.getSiguiente();
                }
            }
        }
        
        // Devuelve "" si hubo un problema.
        return s;
    }

    /**
     * Dado un estudiante muestra las asignaturas a las que esta matriculado y a
     * que curso pertenece cada asignatura.
     *
     * @param dni
     * @return
     */
    public String mostrar_Estudiante(int dni) {
        String s = "";

        // Se obtiene el estudiante si existe se imprime.
        Estudiante estudiante = estudiantes.buscarObject(dni);
        if (estudiante != null) {

            // Imprime el estudiante.
            s = "Estudiante: " + estudiante.toString() + "\n";

            // Se imprime todas las asignaturas con sus cursos.
            Ref_Asignatura ref_asignatura = estudiante.getRef_Asignaturas().getRef_Asignatura();
            while (ref_asignatura != null) {

                // Obtiene la asignatura de la referencia y se busca el curso.
                Asignatura asignatura = ref_asignatura.getAsignatura();
                Curso curso = cursos.getCurso();
                boolean encontrado = false;
                while (curso != null && encontrado == false) {
                    if (curso.getAsignaturas().buscarIndex(asignatura) != -1) {
                        encontrado = true;
                    } else {
                        curso = curso.getSiguiente();
                    }
                }

                // Imprime la asignatura y el curso.
                s += "- Asignatura: " + asignatura.toString() + "\n";
                s += "-- Curso: " + curso.toString() + "\n";

                ref_asignatura = ref_asignatura.getSiguiente();
            }
        }
        
        // Devuelve "" si hubo un problema.
        return s;
    }
}
