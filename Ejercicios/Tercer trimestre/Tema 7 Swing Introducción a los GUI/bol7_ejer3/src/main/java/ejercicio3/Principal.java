package ejercicio3;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Colores colores = new Colores();

        colores.setVisible(true);
        colores.setSize(600, 400);
        colores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colores.setLocationRelativeTo(null);
    }
}
