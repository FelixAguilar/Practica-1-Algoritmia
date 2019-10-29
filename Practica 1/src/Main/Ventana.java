package Main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
    
    //Constantes del menú.
    private final String TITULO = "Actividad 3";
    private final String CREAR = "Crear nodo";
    private final String ELIMINAR = "Eliminar nodo";
    private final String ELIMINARK = "Eliminar k-esimo nodo";
    private final String CREARO = "Añadir nodo ordenado";
    private final String MOSTRAR = "Mostrar lista";
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

        //Boton de crear cuenta.
        JButton botonCrear = new JButton();
        botonCrear.setText(CREAR);
        butones.add(botonCrear, gbc);

        //Boton de buscar por cuenta.
        JButton botonEliminar = new JButton();
        botonEliminar.setText(ELIMINAR);
        butones.add(botonEliminar, gbc);

        //Boton de buscar por usuario.
        JButton botonEliminarK = new JButton();
        botonEliminarK.setText(ELIMINARK);
        butones.add(botonEliminarK, gbc);

        //Boton de ingresar dinero a cuenta.
        JButton botonCrearO = new JButton();
        botonCrearO.setText(CREARO);
        butones.add(botonCrearO, gbc);

        //Boton de extraer dinero de cuenta.
        JButton botonMostrar = new JButton();
        botonMostrar.setText(MOSTRAR);
        butones.add(botonMostrar, gbc);

        //Boton de salir.
        JButton botonSalir= new JButton();
        botonSalir.setText(SALIR);
        butones.add(botonSalir, gbc);

        gbc.weighty = 1;
        menu.add(butones, gbc);
        
        //Escuchadores de eventos.
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                CrearVentana();
            }
        });
        
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                EliminarVentana();
            }
        });
        
        botonEliminarK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                EliminarKVentana();
            }
        });
        
        botonCrearO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                CrearOVentana();
            }
        });
        
        botonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {

            }
        });
        
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.exit(0);
            }
        });
    }    
    
    private void CrearVentana(){
        
        JFrame frame = nuevaVentana(CREAR);
        
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
        JLabel infoInfo = new JLabel("Info:");
        JTextField info = new JTextField();
        linea1.add(infoInfo);
        linea1.add(info);
        
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

            }
        });     
    }
    
    private void EliminarVentana(){
        
        JFrame frame = nuevaVentana(ELIMINAR);
        
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
        JLabel infoInfo = new JLabel("Info:");
        JTextField info = new JTextField();
        linea1.add(infoInfo);
        linea1.add(info);
        
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

            }
        });     
    }
    
    private void EliminarKVentana(){
        
        JFrame frame = nuevaVentana(ELIMINARK);
        
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
        JLabel infoPuntero = new JLabel("Puntero:");
        JTextField puntero = new JTextField();
        linea1.add(infoPuntero);
        linea1.add(puntero);
        
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

            }
        });     
    }
    
    private void CrearOVentana(){
        
        JFrame frame = nuevaVentana(CREARO);
        
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
        JLabel infoInfo = new JLabel("Info:");
        JTextField info = new JTextField();
        linea1.add(infoInfo);
        linea1.add(info);
        
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

            }
        });     
    }
    
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