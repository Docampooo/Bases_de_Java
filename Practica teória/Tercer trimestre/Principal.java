import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal{
    
    public static void main(String[] args) {
        
        // Eventos2 frame = new Eventos2();
        // CajasTexto frame = new CajasTexto();
        Menu frame = new Menu();

        frame.setSize(700, 700);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}
