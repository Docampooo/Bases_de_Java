import javax.swing.*;

public class PruebaGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cositas de swing");

        JLabel label = new JLabel("Una aplicación sencilla");
        label.setToolTipText("Esto es un componente JLabel");

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 200);

        frame.setVisible(true);
    }

}
