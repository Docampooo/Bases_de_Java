package ejer6;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Bombas bomba = new Bombas();

        bomba.setVisible(true);
        bomba.setLocationRelativeTo(null);
        bomba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
