package juego;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Gatos gatos = new Gatos();

        gatos.setSize(510, 700);
        gatos.setVisible(true);
        gatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gatos.setLocationRelativeTo(null);
    }
}
