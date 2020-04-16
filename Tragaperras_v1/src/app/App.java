package app;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        Tragaperras tragaperras = new Tragaperras();
        tragaperras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tragaperras.setSize(600,300);
        tragaperras.setVisible(true);
    }
}