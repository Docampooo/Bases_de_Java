package clicker;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Clicker principal = new Clicker();

        principal.setSize(500, 550);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
