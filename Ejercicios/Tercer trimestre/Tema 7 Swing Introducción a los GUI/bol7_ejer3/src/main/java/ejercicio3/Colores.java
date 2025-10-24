package ejercicio3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Colores extends JFrame implements ActionListener {

    private JButton btn1;
    private JButton btn2;
    private JButton btn3;

    public Colores() {
        super("Botones coloridos");
        this.setLayout(null);

        btn1 = new JButton();
        btn1.setText("Amarillo");
        btn1.setBackground(new Color(255, 255, 0));
        btn1.setSize(100, 100);
        btn1.setLocation(200, 100);
        btn1.addActionListener(this);
        this.add(btn1);

        btn2 = new JButton();
        btn2.setText("Azul");
        btn2.setBackground(new Color(0, 0, 255));
        btn2.setSize(100, 100);
        btn2.setLocation(300, 100);
        btn2.addActionListener(this);
        this.add(btn2);

        btn3 = new JButton();
        btn3.setText("Aleatorio");
        btn3.setSize(100, 100);
        btn3.setLocation(400, 100);
        btn3.addActionListener(this);

        int[] colores = new int[3];
        for (int i = 0; i < 3; i++) {
            colores[i] = (int) (Math.random() * 255);
        }

        btn3.setBackground(new Color(colores[0], colores[1], colores[2]));
        this.add(btn3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int x;
        int y;

        if (e.getSource() == btn1) {
            this.getContentPane().setBackground(btn1.getBackground());
        }

        if (e.getSource() == btn2) {
            this.getContentPane().setBackground(btn2.getBackground());
        }

        if (e.getSource() == btn3) {

            if ((e.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {

                int[] colores = new int[3];
                for (int i = 0; i < 3; i++) {
                    colores[i] = (int) (Math.random() * 255);
                }

                btn3.setBackground(new Color(colores[0], colores[1], colores[2]));
                this.getContentPane().setBackground(btn3.getBackground());

                btn3.setLocation((int) (Math.random() * this.getX()), (int) (Math.random() * this.getY()));
            } else {

                int[] colores = new int[3];
                for (int i = 0; i < 3; i++) {
                    colores[i] = (int) (Math.random() * 255);
                }

                btn3.setBackground(new Color(colores[0], colores[1], colores[2]));

                this.getContentPane().setBackground(btn3.getBackground());

                x = (int) (Math.random() * 600);
                y = (int) (Math.random() * 400);
                this.setLocation(x, y);

            }

        }

    }
}
