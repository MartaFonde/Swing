package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tragaperras extends JFrame implements ActionListener{
    private JTextField n1;
    private JTextField n2;
    private JTextField n3;
    private JButton boton;
    private JLabel etiqueta;
    private JLabel etiqueta2;
    private JLabel tiempo;
    private Timer cronometro;
    private int seg;
    private int min;
    private int hora;
    private int suma=1000;


    public Tragaperras() {
        super("Welcome to LAS VEGAS");
        this.setLayout(new FlowLayout());

        n1 = new JTextField(3);
        add(n1);

        n2 = new JTextField(3);
        add(n2);
        
        n3 = new JTextField(3);
        add(n3);

        boton = new JButton("Juega");
        boton.addActionListener(this);
        add(boton);

        etiqueta = new JLabel();
        add(etiqueta);

        etiqueta2 = new JLabel();
        etiqueta2.setForeground(new Color(0,255,0));
        add(etiqueta2);
 
        tiempo = new JLabel();
        add(tiempo);

        seg=0;
        min=0;
        hora=0;
        cronometro = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String tiempoJuego = String.format("%d:%02d:%02d", hora, min, seg);
                tiempo.setText(tiempoJuego);
                seg++;
                if(seg == 60){
                    min++;
                    seg=0;
                }
                if(min == 60){
                    hora++;
                    min=0;
                }
            }

        });
        cronometro.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1 = (int)(Math.random()*6+1);
        int num2 = (int)(Math.random()*6+1);
        int num3 = (int)(Math.random()*6+1);

        n1.setText(String.valueOf(num1));
        n1.setEditable(false);
        n2.setText(String.valueOf(num2));
        n2.setEditable(false);
        n3.setText(String.valueOf(num3));
        n3.setEditable(false);
        
        if(num1 == num2 && num2 == num3){  
            etiqueta.setText("PREMIO!! 500$");
            suma+=500;
            etiqueta2.setText("Bolsillo = "+String.valueOf(suma));
        }else{
            etiqueta.setText("PERDICHES (-100$)");
            suma-=100;
            etiqueta2.setText("Bolsillo = "+String.valueOf(suma));
        }
        if(suma<0){
            etiqueta2.setForeground(new Color(255,0,0));
        }else{
            etiqueta2.setForeground(new Color(0,255,0));
        }

        //if(n1.getText() == n2.getText() && n2.getText() == n3.getText()){
            //NON FUNCIONA
        
    }
    
}