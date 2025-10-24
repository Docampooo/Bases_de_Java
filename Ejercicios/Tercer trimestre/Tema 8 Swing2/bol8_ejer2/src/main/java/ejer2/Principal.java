package ejer2;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Movil movil = new Movil();

        movil.setSize(425, 750);
        movil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        movil.setVisible(true);
        movil.setLocationRelativeTo(null);
    }
}
