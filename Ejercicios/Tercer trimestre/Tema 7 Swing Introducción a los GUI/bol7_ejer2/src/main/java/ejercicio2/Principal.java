package ejercicio2;

import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {

        Texto texto = new Texto();

        texto.setSize(600, 400);
        texto.setVisible(true);
        texto.setLocationRelativeTo(null);
        texto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
