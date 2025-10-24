package ejercicio5;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Loteria lote = new Loteria();

        lote.setVisible(true);
        lote.setLocationRelativeTo(null);
        lote.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lote.setSize(700, 500);
    }
}
