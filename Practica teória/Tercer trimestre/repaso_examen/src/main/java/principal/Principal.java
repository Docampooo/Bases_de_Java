package principal;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Interfaz inter = new Interfaz();

        inter.setVisible(true);
        inter.setSize(500, 500);
        inter.setLocationRelativeTo(null);
        inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
