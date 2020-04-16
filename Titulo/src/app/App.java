package app;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
       Form ventana = new Form();
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.setSize(300, 300);
       ventana.setVisible(true);
    }
}