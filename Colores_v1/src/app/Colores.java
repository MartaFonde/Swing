package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Colores extends JFrame implements ActionListener {
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    
    public Colores(){
        super("Colores");
        this.setLayout(new FlowLayout());

        boton1=new JButton("Amarillo");
        boton1.setForeground(new Color(255,255,000));
        boton1.setFont(new Font("Arial",Font.ITALIC, 16));
        this.add(boton1);
        boton1.addActionListener(this);

        boton2=new JButton("Azul");
        boton2.setForeground(new Color(037,109,123));
        boton2.setFont(new Font("Arial",Font.ITALIC, 16));
        this.add(boton2);
        boton2.addActionListener(this);

        boton3=new JButton("Aleatorio");
        boton3.setFont(new Font("Arial",Font.ITALIC, 16));
        this.add(boton3);
        boton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==boton1){
           this.getContentPane().setBackground(Color.yellow);
       }else if(e.getSource()==boton2){
           this.getContentPane().setBackground(Color.blue);
       }else{
           int x=(int)(Math.random()*600+0);
           int y=(int)(Math.random()*400+0);
           this.setLocation(x,y);
       }

    }
    
}