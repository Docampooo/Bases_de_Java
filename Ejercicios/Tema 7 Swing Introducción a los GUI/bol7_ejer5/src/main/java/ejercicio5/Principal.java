package ejercicio5;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Tragaperras tragaperras = new Tragaperras();

        tragaperras.setSize(550, 500);
        tragaperras.setLocationRelativeTo(null);
        tragaperras.setVisible(true);
        tragaperras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
