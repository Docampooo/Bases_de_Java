package ejer1;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Raton raton = new Raton();
        
        raton.setVisible(true);
        raton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        raton.setLocationRelativeTo(null);
        raton.setSize(500, 500);
    }
}
