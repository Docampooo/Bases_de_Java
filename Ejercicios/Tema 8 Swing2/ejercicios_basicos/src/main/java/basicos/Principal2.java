package basicos;

import javax.swing.JFrame;

public class Principal2 {
    
    public static void main(String[] args) {
        
        Etiquetas etiquetas = new Etiquetas();

        etiquetas.setSize(720, 500);
        etiquetas.setVisible(true);
        etiquetas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        etiquetas.setLocationRelativeTo(null);
    }
}
