package ejercicio7;

import java.awt.Color;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Colores color = new Colores();

        color.setSize(600, 500);
        color.setVisible(true);
        color.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        color.setLocationRelativeTo(null);
    }
}
