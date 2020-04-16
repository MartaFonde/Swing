package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculadora extends JFrame implements ActionListener{
    private JTextField n1;
    private double num1;
    private JTextField n2;
    private double num2;
    private JLabel resultado;
    private JButton suma;
    private JButton division;
    private JButton raiz;
    private DecimalFormat df = new DecimalFormat("#.000");

    public Calculadora(){
        super("CASIO fx-82MS ou case");
        this.setLayout(new FlowLayout());

        n1=new JTextField(5);
        add(n1);

        n2 = new JTextField(5);
        add(n2);

        resultado=new JLabel();
        add(resultado);

        suma= new JButton("+");
        suma.addActionListener(this);
        add(suma);

        division = new JButton("/");
        division.addActionListener(this);
        add(division);

        raiz = new JButton("√");
        raiz.addActionListener(this);
        add(raiz);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            num1=Double.parseDouble(n1.getText());
            
            if(e.getSource()==suma){
                num2=Double.parseDouble(n2.getText());
                resultado.setText(" = "+(num1+num2));
                resultado.setForeground(new Color(0,0,0));
    
            } else if(e.getSource() == division){
                try{
                    num2=Double.parseDouble(n2.getText());
                    resultado.setText(" = "+opDivision(num1, num2));
                    resultado.setForeground(new Color(0,0,0));

                } catch(ArithmeticException o){
                    resultado.setText("Non se pode dividir entre 0");
                    resultado.setForeground(new Color(255,0,0));
                }

            } else {
                try{
                    resultado.setText(" = "+ raizCuadradada(num1));
                    resultado.setForeground(new Color(0,0,0));

                } catch(ArithmeticException o){
                    resultado.setText("Non existe raíz cadrada para reais negativos");
                    resultado.setForeground(new Color(255,0,0));
                }
            }

        }catch(NumberFormatException o){
            resultado.setText("MMM... Non introduciches números");
            resultado.setForeground(new Color(255,0,0));
        }
        
    }

    public String opDivision(double n1, double n2){
        if(n2 != 0){
            return df.format(n1/n2);
        } else {
            throw new ArithmeticException("Non se pode dividir entre 0");
        }
    }

    public String raizCuadradada(double n1){
        if(n1 >= 0){
            return df.format(Math.sqrt(n1));
        }else{
            throw new ArithmeticException("Non existe raíz cuadrada para reais negativos");
        }
    }

}