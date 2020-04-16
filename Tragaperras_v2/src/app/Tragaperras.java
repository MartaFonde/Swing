package app;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tragaperras extends JFrame implements ActionListener {
    private JLabel n1;
    private JLabel n2;
    private JLabel n3;
    private JLabel explicacion;
    private JButton boton;
    private JLabel resultado;
    private JLabel credito;
    private JLabel tiempo;
    private Timer cronometro;
    private int seg = 0;
    private int min = 0;
    private int hora = 0;
    private double suma = 10;
    private Timer parpadeo;
    Imagenes imagenes;
    int num1;
    int num2;
    int num3;
    private int repetir;

    public Tragaperras() {
        super("Superminitragaperras");
        this.setLayout(null);

        n1 = new JLabel();
        n1.setSize(200, 200);
        n1.setLocation(34, 28);
        add(n1);

        n2 = new JLabel();
        n2.setSize(200, 200);
        n2.setLocation(306, 28);
        add(n2);

        n3 = new JLabel();
        n3.setSize(200, 200);
        n3.setLocation(561, 28);
        add(n3);

        explicacion = new JLabel("<html><body>Apuesta: 1$<br>Doble: +1,5$<br>Pleno: +5$</body></html>");
        explicacion.setSize(explicacion.getPreferredSize());
        explicacion.setLocation(33, 260);
        add(explicacion);

        boton = new JButton("Juega");
        boton.setSize(100, 40);
        boton.setLocation(330, 250);
        boton.addActionListener(this);
        add(boton);

        resultado = new JLabel();
        resultado.setSize(200, 50);
        resultado.setLocation(580, 250);
        add(resultado);

        imagenes = new Imagenes();

        credito = new JLabel("Crédito: "+suma);
        credito.setSize(120, 40);
        credito.setLocation(560, 300);
        add(credito);

        parpadeo = new Timer(500, new ActionListener() {
            int seg = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                seg++;
                if (seg % 2 == 0) {
                    resultado.setForeground(new Color(0, 255, 0));
                } else {
                    resultado.setForeground(new Color(0, 0, 255));
                }
            }
        });

        tiempo = new JLabel();
        tiempo.setSize(50, 30);
        tiempo.setLocation(340, 300);
        add(tiempo);

        cronometro = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tiempoJuego = String.format("%d:%02d:%02d", hora, min, seg);
                tiempo.setText(tiempoJuego);
                seg++;
                if (seg == 60) {
                    min++;
                    seg = 0;
                }
                if (min == 60) {
                    hora++;
                    min = 0;
                }
            }
        });
        cronometro.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        suma -= 1;
        iconos();
        if (num1 == num2 && num2 == num3) {
            resultado.setText("PREMIO +5$");
            suma += 5;
            credito.setText("Crédito = " + String.valueOf(suma));
            parpadeo.start();

        } else if (num1 == num2 && num1 != num3 || num1 == num3 && num1 != num2 || num2 == num3 && num2 != num1) {
            resultado.setText("PREMIO +1.5$");
            suma += 1.5;
            credito.setText("Crédito = " + String.valueOf(suma));
            parpadeo.start();

        } else {
            resultado.setText("PIERDES -1$");
            resultado.setForeground(new Color(255, 0, 0));
            credito.setText("Crédito = " + String.valueOf(suma));
            parpadeo.stop();
        }

        if (suma < 1) {
            repetir = JOptionPane.showConfirmDialog(this, "Ya no puedes volver a apostar\n¿Quieres volver a jugar?", "Crédito insuficiente",
                    JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
            switch (repetir) {
            case JOptionPane.YES_OPTION:
                suma = 10;
                credito.setText("Crédito = " + String.valueOf(suma));
                resultado.setText("");
                seg = 0;
                min = 0;
                hora = 0;
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
            }
        }
    }

    public void iconos() {
        num1 = (int) (Math.random() * 5 + 0);
        n1.setIcon(imagenes.imag.get(num1));
        num2 = (int) (Math.random() * 5 + 0);
        n2.setIcon(imagenes.imag.get(num2));
        num3 = (int) (Math.random() * 5 + 0);
        n3.setIcon(imagenes.imag.get(num3));
    }

}