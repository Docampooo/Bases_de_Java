package ejercicio1;

import javax.swing.JFrame;

public class Principal {

    public static void main(String[] args) {

        Dado frame = new Dado();

        frame.setSize(400, 400);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
    }
}
