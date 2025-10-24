package ejer1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class Raton extends JFrame{
    
    JButton btn1, btn2;
    JLabel lblTeclas;

    public Raton(){
        
        super("Control de Ratón");
        setLayout(new FlowLayout());

        btn1 = new JButton("Izquierdo");
        btn1.addMouseListener(new MouseHandler());
        btn1.setBackground(Color.BLUE);
        btn1.addMouseMotionListener(new MouseHandler());
        btn1.addKeyListener(new KeyHandler());
        this.add(btn1);
        
        btn2 = new JButton("Derecho");
        btn2.addMouseListener(new MouseHandler());
        btn2.setBackground(Color.BLUE);
        btn2.addMouseMotionListener(new MouseHandler());
        btn2.addKeyListener(new KeyHandler());
        this.add(btn2);

        lblTeclas = new JLabel("Teclas");
        lblTeclas.setPreferredSize(getPreferredSize());
        this.add(lblTeclas);

        this.getContentPane().addMouseListener(new MouseHandler());
        this.getContentPane().addMouseMotionListener(new MouseHandler());

        this.setFocusable(true);
        this.addKeyListener(new KeyHandler());
    }

    public class MouseHandler extends MouseAdapter{

        @Override
        public void mouseMoved(MouseEvent e) {
            if(e.getSource().getClass() == JButton.class){
                JButton btn = (JButton)e.getSource();
                setTitle(String.format("Control de Ratón - (X:%d, Y:%d)", e.getX() + btn.getX(), e.getY()+ btn.getY()));//Listo lo de las coordenadas
            }else{
                setTitle(String.format("Control de Ratón - (X:%d, Y:%d)", e.getX(), e.getY()));

            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setTitle("Control de Ratón");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                btn1.setBackground(Color.RED);
            }

            if(e.getButton() == MouseEvent.BUTTON3){
                btn2.setBackground(Color.RED);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1){
                btn1.setBackground(Color.BLUE);
            }

            if(e.getButton() == MouseEvent.BUTTON3){
                btn2.setBackground(Color.BLUE);
            }
        }
    }

    public class KeyHandler extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            
            lblTeclas.setText(String.format("Tecla:%d, Caracter:%c", e.getKeyCode(), e.getKeyChar()));

            if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C){

                Secundario secun = new Secundario(new Raton());

                secun.pack();
                secun.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                secun.setVisible(true);
            }
        }
    }
}