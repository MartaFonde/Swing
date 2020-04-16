package app;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Imagenes
 */
public class Imagenes {
    ArrayList<ImageIcon> imag = new ArrayList<ImageIcon>();

    public Imagenes(){
        imag.add(new ImageIcon(getClass().getResource("/images/arendt.jpeg")));
        imag.add(new ImageIcon(getClass().getResource("/images/degouges.jpg")));
        imag.add(new ImageIcon(getClass().getResource("/images/hegel.jpg")));
        imag.add(new ImageIcon(getClass().getResource("/images/kierkegaard.jpg")));
        imag.add(new ImageIcon(getClass().getResource("/images/Mill.jpg")));
        imag.add(new ImageIcon(getClass().getResource("/images/sartre.jpg")));

    }
}