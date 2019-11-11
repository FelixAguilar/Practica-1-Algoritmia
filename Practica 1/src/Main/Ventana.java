package Main;

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
 *
 * @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez.
 */
public class Ventana extends JFrame {
    
    Operations o = new Operations();
    
    //Constantes del menú.
    private final String TITULO = "Practica 1";
    private final String NUEVOCURSO = "Añadir curso";
    private final String MATRICULAESTUDIANTE = "Matricular un estudiante";
    private final String ELIMINARCURSO = "Dar de baja un curso";
    private final String ELIMINARASIGNATURA = "Dar de baja una asignatura";
    private final String MOSTRARCURSO = "Mostrar el contenido de un curso";
    private final String MOSTRARASIGNATURA = "Mostrar el contenido de una asignatura";
    private final String MOSTRARESTUDIANTE = "Mostrar el contenido de un estudiante";
    private final String SALIR = "Salir";
    
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
    
    private void initContents(){
        JPanel menu = (JPanel) getContentPane();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1><strong><i>"+ TITULO +"</i></strong></h1><hr></html>"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel butones = new JPanel(new GridBagLayout());

        //Boton de crear curso.
        JButton botonNuevoCurso = new JButton();
        botonNuevoCurso.setText(NUEVOCURSO);
        butones.add(botonNuevoCurso, gbc);

        //Boton de buscar por cuenta.
        JButton botonEliminar = new JButton();
        botonEliminar.setText(MATRICULAESTUDIANTE);
        butones.add(botonEliminar, gbc);

        //Boton de buscar por usuario.
        JButton botonEliminarK = new JButton();
        botonEliminarK.setText(ELIMINARCURSO);
        butones.add(botonEliminarK, gbc);

        //Boton de ingresar dinero a cuenta.
        JButton botonCrearO = new JButton();
        botonCrearO.setText(ELIMINARASIGNATURA);
        butones.add(botonCrearO, gbc);

        //Boton de extraer dinero de cuenta.
        JButton botonMostrar = new JButton();
        botonMostrar.setText(MOSTRARCURSO);
        butones.add(botonMostrar, gbc);
        
        //Boton de extraer dinero de cuenta.
        JButton botonMostrard = new JButton();
        botonMostrard.setText(MOSTRARASIGNATURA);
        butones.add(botonMostrard, gbc);
        
        //Boton de extraer dinero de cuenta.
        JButton botonMostrardd = new JButton();
        botonMostrardd.setText(MOSTRARESTUDIANTE);
        butones.add(botonMostrardd, gbc);

        //Boton de salir.
        JButton botonSalir= new JButton();
        botonSalir.setText(SALIR);
        butones.add(botonSalir, gbc);

        gbc.weighty = 1;
        menu.add(butones, gbc);
        
        //Escuchadores de eventos.
        botonNuevoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                nuevoCurso();
            }
        });
        
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {

            }
        });
        
        botonEliminarK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
            }
        });
        
        botonCrearO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
               
            }
        });
        
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                mostrarCurso();
            }
        });
        
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.exit(0);
            }
        });
    }    
    
    private void nuevoCurso(){
        
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
        JPanel linea5 = new JPanel();
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea2.add(infoNombre);
        linea2.add(nombre);
        
        //Select para el tipo de curso.
        JLabel infotipoCurso = new JLabel("Tipo:");
        JComboBox tipoCurso = new JComboBox();
        tipoCurso.addItem("FP");
        tipoCurso.addItem("Bachiller");
        linea3.add(infotipoCurso);
        linea3.add(tipoCurso);
        
        //Botones.

        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        
        linea4.add(botonRetroceder(frame));
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               
                if(tipoCurso.getSelectedItem() == "FP"){
                    ventanaFP(Integer.parseInt(codigo.getText()),nombre.getText(),tipoCurso.getSelectedItem().toString());
                }else if(tipoCurso.getSelectedItem() == "Bachiller"){
                    ventanaBachiller(Integer.parseInt(codigo.getText()),nombre.getText(),tipoCurso.getSelectedItem().toString());
                }
                
            }
        }); 
        

    }
    
    private void ventanaFP(int codigo, String nombre, String tipo){
        
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
        JPanel linea5 = new JPanel();
       
        //Select para el tipo de curso.
        JLabel infoTipoFP = new JLabel("Tipo:");
        JComboBox tipoFP = new JComboBox();
        tipoFP.addItem("Informática");
        tipoFP.addItem("Mecánica");
        tipoFP.addItem("Electrónica");
        linea3.add(infoTipoFP);
        linea3.add(tipoFP);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               Curso curso = o.nuevo_Curso(codigo, nombre, tipo, tipoFP.getSelectedItem().toString());
               añadirAsignatura(curso); 
               frame.dispose();
               // nuevoCurso2();
            }
        });   
             
    }
     
    private void ventanaBachiller(int codigo, String nombre, String tipo){
        
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
        JPanel linea5 = new JPanel();
       
        //Select para el tipo de curso.
        JLabel infoTipoBachiller = new JLabel("Tipo:");
        JComboBox tipoBachiller = new JComboBox();
        tipoBachiller.addItem("Primero");
        tipoBachiller.addItem("Segundo");
        linea3.add(infoTipoBachiller);
        linea3.add(tipoBachiller);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               Curso curso = o.nuevo_Curso(codigo, nombre, tipo, tipoBachiller.getSelectedItem().toString());
               añadirAsignatura(curso);                                                                  
               frame.dispose();
              // nuevoCurso2();
            }
        });   
        
        
    }
    
    private void añadirAsignatura(Curso curso){
        
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
        JPanel linea5 = new JPanel();
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea2.add(infoNombre);
        linea2.add(nombre);
        
        //Select para el tipo de curso.
        JLabel infoTipoAsignatura = new JLabel("Tipo:");
        JComboBox tipoAsignatura = new JComboBox();
        tipoAsignatura.addItem("Obligatoria");
        tipoAsignatura.addItem("Optativa");
        linea3.add(infoTipoAsignatura);
        linea3.add(tipoAsignatura);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                if(tipoAsignatura.getSelectedItem() == "Obligatoria"){
                    ventanaCreditos(curso, Integer.parseInt(codigo.getText()), nombre.getText(), tipoAsignatura.getSelectedItem().toString());
                }else if(tipoAsignatura.getSelectedItem() == "Optativa"){
                    ventanaPerfil(curso, Integer.parseInt(codigo.getText()), nombre.getText(), tipoAsignatura.getSelectedItem().toString());
                }
              
            }
        });   
       
        
    }
    
    private void ventanaCreditos(Curso curso, int codigo, String nombre, String tipo){
        
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
        JPanel linea5 = new JPanel();
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCreditos = new JLabel("Créditos:");
        JTextField creditos = new JTextField();
        linea1.add(infoCreditos);
        linea1.add(creditos);
      
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               o.nueva_Asignatura(curso, codigo, nombre, tipo, creditos.getText());
               frame.dispose();
               //nuevoCurso2();
            }
        });   
      
        
    }
     
    private void ventanaPerfil(Curso curso, int codigo, String nombre, String tipo){
        
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
        JPanel linea5 = new JPanel();
        
        JLabel infoTipoOptativa = new JLabel("Tipo:");
        JComboBox tipoOptativa = new JComboBox();
        tipoOptativa .addItem("Teórica");
        tipoOptativa .addItem("Práctica");
        linea3.add(infoTipoOptativa);
        linea3.add(tipoOptativa);
      
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               o.nueva_Asignatura(curso, codigo, nombre, tipo, tipoOptativa.getSelectedItem().toString());
               frame.dispose();
               //nuevoCurso2();
            }
        });   
        
        
    }
    
    private void mostrarCurso(){
        
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
        
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
 
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
               o.mostrar_Curso(Integer.parseInt(codigo.getText()));
               Popup(frame,o.mostrar_Curso(Integer.parseInt(codigo.getText())));
               frame.dispose();
              
            }
        });   
       
        
    }
    /*
    private String nuevoCurso2(){
        
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
        JPanel linea5 = new JPanel();
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCodigo = new JLabel("Codigo:");
        JTextField codigo = new JTextField();
        linea1.add(infoCodigo);
        linea1.add(codigo);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea2.add(infoNombre);
        linea2.add(nombre);
        
        //Select para el tipo de curso.
        JLabel infoTipoAsignatura = new JLabel("Tipo:");
        JComboBox tipoAsignatura = new JComboBox();
        tipoAsignatura.addItem("Obligatoria");
        tipoAsignatura.addItem("Optativa");
        linea3.add(infoTipoAsignatura);
        linea3.add(tipoAsignatura);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea4.add(botonAceptar);
        linea4.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        entrada.add(linea4, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
               frame.dispose();
               nuevoCurso2();
            }
        });   
        return null;
        
    }
   */
    
    public void Popup(JFrame f, String mensaje){
        JOptionPane.showMessageDialog(f, mensaje);
    }
    
    private JButton botonRetroceder(JFrame frame){
        
        //Boton de cancelar operacion.
        JButton boton = new JButton();
        boton.setText("Cancelar");
        
        //Escuchadores de eventos.
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        }); 
        
        return boton;
    }
    
    private JFrame nuevaVentana(String titulo){
        JFrame frame = new JFrame();
        frame.setTitle(titulo);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    
}