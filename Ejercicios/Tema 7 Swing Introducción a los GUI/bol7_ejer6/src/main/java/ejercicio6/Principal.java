package ejercicio6;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Mates mates = new Mates();

        mates.setVisible(true);
        mates.setSize(500, 500);
        mates.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mates.setLocationRelativeTo(null);
    }
}
