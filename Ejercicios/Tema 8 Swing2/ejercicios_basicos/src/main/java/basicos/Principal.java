package basicos;

import javax.swing.JFrame;

public class Principal {
    
    public static void main(String[] args) {
        
        V1 v1 = new V1();

        v1.setSize(700, 500);
        v1.setVisible(true);
        v1.setLocationRelativeTo(null);
        v1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
}
