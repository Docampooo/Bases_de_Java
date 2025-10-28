package ejer10;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        ListaVideojuegos juegos = new ListaVideojuegos();

        juegos.setVisible(true);
        juegos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        juegos.setLocationRelativeTo(null);
        juegos.setSize(700, 700);
    }
}
