package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.InvalidParameterException;

public class Dado extends JFrame implements ActionListener {
    private JLabel etiqueta;
    private JLabel etiqueta2;
    private JButton boton;
    private JTextField campo;
    private int numero;
    private int max=6;

    public Dado(){
        super("El dado mágico");
        this.setLayout(new FlowLayout());
        //this.setLayout(null);

        boton=new JButton("Pulsa aquí");
        // boton.setLocation(50, 50);
        // boton.setSize(boton.getPreferredSize());
        this.add(boton);
        boton.addActionListener(this);

        etiqueta2 = new JLabel("Introduce un número");
        this.add(etiqueta2);

        campo=new JTextField(3);
        this.add(campo);
        campo.addActionListener(this);

        etiqueta=new JLabel();
        // etiqueta.setLocation(0,0);
        // etiqueta.setSize(120,50);
        this.add(etiqueta);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.numero=Integer.parseInt(campo.getText());
        if(numero>=1 && numero<=6){
            int n=(int)(Math.random()*numero+1);
            this.etiqueta.setText("El dado dice: "+Integer.toString(n));
        }else{
            JOptionPane.showMessageDialog(null, "Dato inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}