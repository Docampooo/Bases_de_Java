package ejer3;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Operaciones op = new Operaciones();

        op.setSize(700, 700);
        op.setLocationRelativeTo(null);
        op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        op.setVisible(true);

    }
}
