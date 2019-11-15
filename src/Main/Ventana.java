package Main;

import Objects.Asignatura;
import Objects.Curso;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Interfaz grafica de la solucion. Desde aqui se llama a los metodos del
 * archivo Operaciones.
 *
 * @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez.
 */
public class Ventana extends JFrame {

    Operaciones o = new Operaciones();

    // Constantes del menú.
    private final String TITULO = "Practica 1";
    private final String NUEVOCURSO = "Añadir curso";
    private final String MATRICULAESTUDIANTE = "Matricular un estudiante";
    private final String ELIMINARCURSO = "Dar de baja un curso";
    private final String ELIMINARASIGNATURA = "Dar de baja una asignatura";
    private final String MOSTRARCURSO = "Mostrar el contenido de un curso";
    private final String MOSTRARASIGNATURA = "Mostrar el contenido de una asignatura";
    private final String MOSTRARESTUDIANTE = "Mostrar el contenido de un estudiante";
    private final String SALIR = "Salir";
    private final String ERRORVACIO = "ERROR: Todos los campos son obligatorios";

    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }

    public Ventana() {
        this.setTitle(TITULO);
        this.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.initContents();
        this.pack();
    }

    private void initContents() {
        JPanel menu = (JPanel) getContentPane();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1><strong><i>" + TITULO + "</i></strong></h1><hr></html>"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel butones = new JPanel(new GridBagLayout());

        // Boton de crear curso.
        JButton botonNuevoCurso = new JButton();
        botonNuevoCurso.setText(NUEVOCURSO);
        butones.add(botonNuevoCurso, gbc);

        // Boton de matricular un estudiante.
        JButton botonMatriculaEstudiante = new JButton();
        botonMatriculaEstudiante.setText(MATRICULAESTUDIANTE);
        butones.add(botonMatriculaEstudiante, gbc);

        // Boton de eliminar un curso.
        JButton botonEliminarCurso = new JButton();
        botonEliminarCurso.setText(ELIMINARCURSO);
        butones.add(botonEliminarCurso, gbc);

        // Boton de eliminar una asignatura.
        JButton botonEliminarAsignatura = new JButton();
        botonEliminarAsignatura.setText(ELIMINARASIGNATURA);
        butones.add(botonEliminarAsignatura, gbc);

        // Boton de mostrar curso.
        JButton botonMostrarCurso = new JButton();
        botonMostrarCurso.setText(MOSTRARCURSO);
        butones.add(botonMostrarCurso, gbc);

        // Boton de mostrar asignatura.
        JButton botonMostrarAsignatura = new JButton();
        botonMostrarAsignatura.setText(MOSTRARASIGNATURA);
        butones.add(botonMostrarAsignatura, gbc);

        // Boton de mostrar estudiante.
        JButton botonMostrarEstudiante = new JButton();
        botonMostrarEstudiante.setText(MOSTRARESTUDIANTE);
        butones.add(botonMostrarEstudiante, gbc);

        // Boton de salir.
        JButton botonSalir = new JButton();
        botonSalir.setText(SALIR);
        butones.add(botonSalir, gbc);

        gbc.weighty = 1;
        menu.add(butones, gbc);

        // Escuchadores de eventos.
        botonNuevoCurso.addActionListener((java.awt.event.ActionEvent e) -> {
            nuevoCurso();
        });

        botonMatriculaEstudiante.addActionListener((java.awt.event.ActionEvent e) -> {
            matriculaEstudiante();
        });

        botonEliminarCurso.addActionListener((java.awt.event.ActionEvent e) -> {
            eliminarCurso();
        });

        botonEliminarAsignatura.addActionListener((java.awt.event.ActionEvent e) -> {
            eliminarAsignatura();
        });

        botonMostrarCurso.addActionListener((java.awt.event.ActionEvent e) -> {
            mostrarCurso();
        });

        botonMostrarAsignatura.addActionListener((java.awt.event.ActionEvent e) -> {
            mostrarAsignatura();
        });

        botonMostrarEstudiante.addActionListener((java.awt.event.ActionEvent e) -> {
            mostrarEstudiante();
        });

        botonSalir.addActionListener((java.awt.event.ActionEvent e) -> {
            System.exit(0);
        });
    }

    // Ventana para añadir un nuevo curso
    private void nuevoCurso() {

        JFrame frame = nuevaVentana(NUEVOCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));

        // Campo de texto para el código asociado al curso.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Campo de texto para el nombre asociado al curso.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea2.add(infoNombre);
        linea2.add(nombre);

        // Select para el tipo de curso.
        JLabel infotipoCurso = new JLabel("Tipo:");
        JComboBox tipoCurso = new JComboBox();
        tipoCurso.addItem("FP");
        tipoCurso.addItem("Bachiller");
        linea3.add(infotipoCurso);
        linea3.add(tipoCurso);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("") && !nombre.getText().equals("")) {
                if (tipoCurso.getSelectedItem() == "FP") {
                    ventanaFP(Integer.parseInt(codigo.getText()), nombre.getText(), tipoCurso.getSelectedItem().toString());
                } else if (tipoCurso.getSelectedItem() == "Bachiller") {
                    ventanaBachiller(Integer.parseInt(codigo.getText()), nombre.getText(), tipoCurso.getSelectedItem().toString());
                }
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para matricular un estudiante
    private void matriculaEstudiante() {

        JFrame frame = nuevaVentana(MATRICULAESTUDIANTE);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));
        JPanel linea5 = new JPanel();
        linea5.setLayout(new BoxLayout(linea5, BoxLayout.X_AXIS));

        // Campo de texto para el DNI asociado al estudiante.
        JLabel infoCodigo = new JLabel("DNI:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Campo de texto para el nombre del estudiante.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea2.add(infoNombre);
        linea2.add(nombre);

        // Campo de texto para el código asociado a la asignatura de la que se quiere matricular.
        JLabel infoAsignatura = new JLabel("Asignatura:");
        JTextField asignatura = new JTextField();
        linea3.add(infoAsignatura);
        linea3.add(asignatura);

        // Campo de texto para el código asociado al curso.
        JLabel infoCurso = new JLabel("Curso:");
        JTextField curso = new JTextField();
        linea4.add(infoCurso);
        linea4.add(curso);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea5.add(botonAceptar);
        linea5.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        entrada.add(linea5, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("") && !nombre.getText().equals("") && !asignatura.getText().equals("")
                    && !curso.getText().equals("")) {

                Asignatura asig = o.matricular_Estudiante(Integer.parseInt(curso.getText()), Integer.parseInt(asignatura.getText()),
                        Integer.parseInt(codigo.getText()), nombre.getText());
                if (asig == null) {
                    Popup(frame, "ERROR: Ha habido un error al matricular el estudiante");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para crear un curso de FP
    private void ventanaFP(int codigo, String nombre, String tipo) {

        JFrame frame = nuevaVentana(NUEVOCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));

        // Select para el tipo de FP.
        JLabel infoTipoFP = new JLabel("Tipo:");
        JComboBox tipoFP = new JComboBox();
        tipoFP.addItem("Informática");
        tipoFP.addItem("Mecánica");
        tipoFP.addItem("Electrónica");
        linea3.add(infoTipoFP);
        linea3.add(tipoFP);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            Curso curso = o.nuevo_Curso(codigo, nombre, tipo, tipoFP.getSelectedItem().toString());
            if (curso != null) {
                añadirAsignatura(curso);
            } else {
                Popup(frame, "ERROR: Ya existe un curso con este código");
            }
            frame.dispose();
        });

    }

    // Ventana para crear un curso de Bachiller 
    private void ventanaBachiller(int codigo, String nombre, String tipo) {

        JFrame frame = nuevaVentana(NUEVOCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));

        // Select para el curso de bachillerato.
        JLabel infoTipoBachiller = new JLabel("Tipo:");
        JComboBox tipoBachiller = new JComboBox();
        tipoBachiller.addItem("Primero");
        tipoBachiller.addItem("Segundo");
        linea3.add(infoTipoBachiller);
        linea3.add(tipoBachiller);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            Curso curso = o.nuevo_Curso(codigo, nombre, tipo, tipoBachiller.getSelectedItem().toString());
            if (curso != null) {
                añadirAsignatura(curso);
            } else {
                Popup(frame, "ERROR: Ya existe un curso con este código");
            }
            frame.dispose();
        });

    }

    // Ventana para añadir una nueva asignatura a un curso
    private void añadirAsignatura(Curso curso) {

        JFrame frame = nuevaVentana(NUEVOCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));

        // Campo de texto para el código asociado a la asignatura.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Campo de texto para el nombre de la asignatura.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea2.add(infoNombre);
        linea2.add(nombre);

        // Select para el tipo de asignatura.
        JLabel infoTipoAsignatura = new JLabel("Tipo:");
        JComboBox tipoAsignatura = new JComboBox();
        tipoAsignatura.addItem("Obligatoria");
        tipoAsignatura.addItem("Optativa");
        linea3.add(infoTipoAsignatura);
        linea3.add(tipoAsignatura);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("") && !nombre.getText().equals("")) {
                if (tipoAsignatura.getSelectedItem() == "Obligatoria") {
                    ventanaCreditos(curso, Integer.parseInt(codigo.getText()), nombre.getText(),
                            tipoAsignatura.getSelectedItem().toString());
                } else if (tipoAsignatura.getSelectedItem() == "Optativa") {
                    ventanaPerfil(curso, Integer.parseInt(codigo.getText()), nombre.getText(),
                            tipoAsignatura.getSelectedItem().toString());
                }
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para asignar los creditos de una asignatura obligatoria
    private void ventanaCreditos(Curso curso, int codigo, String nombre, String tipo) {

        JFrame frame = nuevaVentana(NUEVOCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));

        // Campo de texto para el número de créditos de una asignatura obligatoria.
        JLabel infoCreditos = new JLabel("Créditos:");
        JTextField creditos = new JTextField();
        linea1.add(infoCreditos);
        linea1.add(creditos);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!creditos.getText().equals("")) {
                Asignatura asignatura = o.nueva_Asignatura(curso, codigo, nombre, tipo, creditos.getText());
                if (asignatura == null) {
                    Popup(frame, "ERROR: Ya existe una asignatura con este código");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para añadir el perfil de una asignatura optativa
    private void ventanaPerfil(Curso curso, int codigo, String nombre, String tipo) {

        JFrame frame = nuevaVentana(NUEVOCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        JPanel linea4 = new JPanel();
        linea4.setLayout(new BoxLayout(linea4, BoxLayout.X_AXIS));

        // Campo de texto para el tipo de asignatura optativa.
        JLabel infoTipoOptativa = new JLabel("Tipo:");
        JComboBox tipoOptativa = new JComboBox();
        tipoOptativa.addItem("Teórica");
        tipoOptativa.addItem("Práctica");
        linea3.add(infoTipoOptativa);
        linea3.add(tipoOptativa);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            Asignatura asignatura = o.nueva_Asignatura(curso, codigo, nombre, tipo, tipoOptativa.getSelectedItem().toString());
            if (asignatura == null) {
                Popup(frame, "ERROR: Ya existe una asignatura con este código");
            }
            frame.dispose();
        });

    }

    // Ventana para mostrar un curso dado
    private void mostrarCurso() {

        JFrame frame = nuevaVentana(MOSTRARCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));

        // Campo de texto para el código asociado al curso.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("")) {
                String res;
                res = o.mostrar_Curso(Integer.parseInt(codigo.getText()));
                if (!res.equals("")) {
                    Popup(frame, o.mostrar_Curso(Integer.parseInt(codigo.getText())));
                } else {
                    Popup(frame, "ERROR: No existe ningún curso con este código");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para mostrar una asignatura dada
    private void mostrarAsignatura() {

        JFrame frame = nuevaVentana(MOSTRARASIGNATURA);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));

        // Campo de texto para el código de la asignatura.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("")) {
                String res;
                res = o.mostrar_Asignatura(Integer.parseInt(codigo.getText()));
                if (!res.equals("")) {
                    Popup(frame, o.mostrar_Asignatura(Integer.parseInt(codigo.getText())));
                } else {
                    Popup(frame, "ERROR: No existe ninguna asignatura con este código");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para mostrar un estudiante dado
    private void mostrarEstudiante() {

        JFrame frame = nuevaVentana(MOSTRARESTUDIANTE);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));

        // Campo de texto para el DNI asociado al estudiante.
        JLabel infoDni = new JLabel("DNI:");
        JTextField dni = new JTextField();
        linea1.add(infoDni);
        linea1.add(dni);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!dni.getText().equals("")) {
                String res;
                res = o.mostrar_Estudiante(Integer.parseInt(dni.getText()));
                if (!res.equals("")) {
                    Popup(frame, o.mostrar_Estudiante(Integer.parseInt(dni.getText())));
                } else {
                    Popup(frame, "ERROR: No existe ningun estudiante con este DNI");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });

    }

    // Ventana para eliminar un curso dado
    private String eliminarCurso() {

        JFrame frame = nuevaVentana(ELIMINARCURSO);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));

        // Campo de texto para el código asociado al curso.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("")) {
                Curso curso = o.eliminar_Curso(Integer.parseInt(codigo.getText()));
                if (curso == null) {
                    Popup(frame, "ERROR: No existe ningun curso con este código");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });
        return null;

    }

    // Ventana para eliminar una asignatura dada
    private String eliminarAsignatura() {

        JFrame frame = nuevaVentana(ELIMINARASIGNATURA);

        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());

        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));

        // Campo de texto para el código de la asignatura.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);

        // Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));

        // Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);

        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();

        // Escuchadores de eventos.
        botonAceptar.addActionListener((java.awt.event.ActionEvent e) -> {
            if (!codigo.getText().equals("")) {
                Asignatura asignatura = o.eliminar_Asignatura(Integer.parseInt(codigo.getText()));
                if (asignatura == null) {
                    Popup(frame, "ERROR: No existe ninguna asignatura con este código");
                }
                frame.dispose();
            } else {
                Popup(frame, ERRORVACIO);
            }
        });
        return null;

    }

    // PopUp para mostrar mensajes
    public void Popup(JFrame f, String mensaje) {
        JOptionPane.showMessageDialog(f, mensaje);
    }

    // Botón estándar para volver atrás
    private JButton botonRetroceder(JFrame frame) {

        //Boton de cancelar operacion.
        JButton boton = new JButton();
        boton.setText("Cancelar");

        //Escuchadores de eventos.
        boton.addActionListener((java.awt.event.ActionEvent e) -> {
            frame.dispose();
        });

        return boton;
    }

    // Instrucciones iniciales para mostrar una ventana
    private JFrame nuevaVentana(String titulo) {
        JFrame frame = new JFrame();
        frame.setTitle(titulo);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }
}
