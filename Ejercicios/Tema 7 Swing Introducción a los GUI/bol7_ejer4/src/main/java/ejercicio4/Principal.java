package ejercicio4;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        Formulario form = new Formulario();

        form.setVisible(true);
        form.setSize(500, 500);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
    }
}
