package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.InvalidParameterException;

public class Colores extends JFrame implements ActionListener {
    private JLabel rojo;
    private JTextField compRojo;
    private JLabel verde;
    private JTextField compVerde;
    private JLabel azul;
    private JTextField compAzul;
    private JLabel etiqueta;
    private JButton boton;
    private int r=0;
    private int g=0;
    private int b=0;
    private JLabel direccion;
    private JTextField ruta;
    private JLabel imagen;


    public Colores(){
        super("Cambia de color");
        this.setLayout(new FlowLayout());

        rojo = new JLabel("R");
        add(rojo);
        compRojo = new JTextField(3);
        compRojo.setToolTipText("Componente rojo 0-255");
        add(compRojo);

        verde = new JLabel("G");
        add(verde);
        compVerde = new JTextField(3);
        compVerde.setToolTipText("Componente verde 0-255");
        add(compVerde);

        azul = new JLabel("B");
        add(azul);
        compAzul = new JTextField(3);
        compAzul.setToolTipText("Componente azul 0-255");
        compAzul.addActionListener(this);
        add(compAzul);

        etiqueta = new JLabel();
        add(etiqueta);

        boton = new JButton("Color");
        boton.setToolTipText("Click para cambiar el color de fondo. Presiona Ctrl y click para cambiar color de texto");
        boton.addActionListener(this);
        add(boton);

        direccion = new JLabel("Ruta imagen:");
        add(direccion);
        ruta = new JTextField(30);
        ruta.setToolTipText("Introduce una ruta");
        ruta.addActionListener(this);
        add(ruta);

        imagen = new JLabel();
        add(imagen);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) || e.getSource() == compAzul){
            if(parseo()){
                etiqueta.setText("");
                boton.setForeground(new Color(r,g,b));
            }
        }else if(e.getSource() == boton){
            if(parseo()){
                etiqueta.setText("");
                boton.setBackground(new Color(r,g,b));
            }
        }
        if(e.getSource() == ruta){
            imagen.setIcon(new ImageIcon(ruta.getText()));
        }

    }

    public boolean parseo(){
        try{
            this.r = Integer.parseInt(compRojo.getText());
            this.g = Integer.parseInt(compVerde.getText());
            this.b = Integer.parseInt(compAzul.getText());
            comprobacion(r,g,b);
        }catch(NumberFormatException o){
            etiqueta.setText("Error. Introduce números (0-255)");
            etiqueta.setForeground(new Color(255,0,0));
            return false;
        }catch(InvalidParameterException o){
            etiqueta.setText("Introduce números entre 0-255");
            etiqueta.setForeground(new Color(255,0,0));
            return false;
        }
        return true;
    }

    public void comprobacion(int r, int g, int b){
        if((r < 0 || r > 255) || (g<0 || g>255) || (b < 0 || b>255)){
            throw new InvalidParameterException("Parámetros inválidos");
        }
    }




}