package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CajasTexto extends JFrame implements ActionListener {
    JLabel lbl1;
    JLabel lbl2;
    JTextField txt1;
    JTextField txt2;
    JTextField txt3;
    JTextField caja1;
    JTextField caja2;
    JPasswordField psw;

    public CajasTexto() {
        super("Cajas de edición de texto");
        this.setLayout(new FlowLayout());
        lbl1 = new JLabel("Introduzca su DNI");
        add(lbl1);

        txt1 = new JTextField(9);
        txt1.addActionListener(this);
        add(txt1);

        txt2 = new JTextField("Escriba aquí su nombre");
        txt2.addActionListener(this);
        add(txt2);

        caja1=new JTextField(3);
        caja1.addActionListener(this);
        add(caja1);

        caja2=new JTextField(3);
        caja2.addActionListener(this);
        add(caja2);


        txt3 = new JTextField("Información no editable", 23);
        txt3.select(0, 4);
        txt3.setEditable(false);
        txt3.addActionListener(this);
        add(txt3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == txt1){
            txt1.selectAll();
        }
        if(e.getSource()==caja2){
            int inicio=Integer.parseInt(caja1.getText());
            int posfinal=Integer.parseInt(caja2.getText());
            if(inicio<0 || posfinal > txt2.getText().length()){
                JOptionPane.showMessageDialog(null, "Te has pasao, error límites");
            }else{
                txt2.select(inicio, posfinal);
                JOptionPane.showMessageDialog(null, txt2.getSelectedText());
            }
        }
        JOptionPane.showMessageDialog(null, ((JTextField) e.getSource()).getSelectedText(), "Cajas de Texto",
                JOptionPane.INFORMATION_MESSAGE);
    }
}