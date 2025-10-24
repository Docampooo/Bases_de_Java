package ejer4;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Acciones ac = new Acciones();

        ac.setSize(500, 500);
        ac.setVisible(true);
        ac.setLocationRelativeTo(null);
        ac.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
    }
}
