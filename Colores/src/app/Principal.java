package app;

import javax.swing.JFrame;

public class Principal {
    public static void main(String[] args) {
        Colores frame = new Colores();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,300);
        frame.setVisible(true);
    }
}