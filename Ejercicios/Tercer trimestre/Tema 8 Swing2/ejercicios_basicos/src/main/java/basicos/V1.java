package basicos;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class V1 extends JFrame {

    JButton btn;

    public V1() {

        super("prueba Video1");
        this.setLayout(null);

        btn = new JButton("Pulsame!");
        btn.setSize(100, 40);
        btn.setLocation(275, 150);
        btn.addMouseListener(new MouseHandler());
        btn.addKeyListener(new KeyHandler());
        this.add(btn);
        
        this.addWindowListener(new WindowHandler());
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {

            int x = (int) (Math.random() * 600);
            int y = (int) (Math.random() * 400);

            btn.setLocation(x, y);
        }

    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_A) {

                int x = (int) (Math.random() * 600);
                int y = (int) (Math.random() * 400);

                btn.setLocation(x, y);
            }
        }
    }

    private class WindowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            
            int eleccion = 0;

            eleccion = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres cerrar el programa?", "Cierre de programa", JOptionPane.YES_NO_OPTION);

            switch (eleccion) {
                case JOptionPane.YES_OPTION:
                    
                    System.exit(0);
                    break;

                case JOptionPane.NO_OPTION:
                    
                    JOptionPane.showMessageDialog(null, "No se ha cerrado la aplicacion", "Cierre programa cancelado", JOptionPane.INFORMATION_MESSAGE);
                    break;
            
                default:
                    break;
            }
        }
    }
}
