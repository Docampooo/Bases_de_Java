package ejercicio8;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Tragaperras tragaperras = new Tragaperras();

        tragaperras.setVisible(true);
        tragaperras.setLocationRelativeTo(null);
        tragaperras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tragaperras.setSize(1000, 800);
    }
}
