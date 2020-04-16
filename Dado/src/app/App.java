package app;

public class App {
    public static void main(String[] args){
        Dado dado = new Dado();
        dado.setDefaultCloseOperation(Dado.EXIT_ON_CLOSE);
        dado.setSize(300,300);
        dado.setVisible(true);
    }
}