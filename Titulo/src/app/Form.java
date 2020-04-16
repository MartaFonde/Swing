package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form extends JFrame implements ActionListener, ItemListener {
    private JTextField texto;
    private JButton boton;
    private JLabel etiqueta;
    private JCheckBox check;
    private JCheckBox check2;
    
    /**
     * Inicializa todas las propiedades y las añade al formulario
     */
    public Form(){
        super("TEXTO");
        this.setLayout(new FlowLayout());
        
        etiqueta=new JLabel("Introduce texto");
        this.add(etiqueta);

        texto=new JTextField(20);
        texto.addActionListener(this);
        this.add(texto);

        boton=new JButton("Aceptar");
        boton.addActionListener(this);
        this.add(boton);

        check = new JCheckBox("Dar la vuelta");
        add(check);

        check2 = new JCheckBox("Pulsa para deshabilitar");
        check2.addItemListener(this);
        add(check2);

    }

    /**
     * Pregunta si el usuario desea poner el texto introducido como título del formulario 
     * y si contesta que sí, cambia dicho título. Si está marcado el check de "dar la vuelta"
     * coloca el título en orden inverso
     * @param e evento 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int respuesta=JOptionPane.showConfirmDialog(this, "\""+texto.getText()+"\"" , "¿Desea poner el texto en el título?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch(respuesta){
            case JOptionPane.YES_OPTION:
            if(check.isSelected()){
                String fraseInversa=inverso(texto.getText());
                this.setTitle(fraseInversa);
            }else{
                this.setTitle(texto.getText());
            }
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "Pos nas");
        }
        
    }

   
   /**
    * Invierte el orden de una cadena
    * @param frase cadena
    * @return cadena inversa
    */ 
    public String inverso(String frase){
        String invertido="";
        for(int i=frase.length()-1; i>=0; i--){
            invertido+=frase.charAt(i);
        }
        return invertido;
        
    }

    /**
     * Si el check está marcado, deshabilita el cuadro de texto.
     * Si no está marcado lo habilita.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(check2.isSelected()){
            this.texto.setEnabled(false);
        }else{
            this.texto.setEnabled(true);
        }

    }

}