package app;

import javax.swing.*;

public class Principal {
    public static void main(String[] args)  {
        Calculadora casio = new Calculadora();
        casio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        casio.setSize(500,200);
        casio.setVisible(true);
    }
}