package ejercicio9;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Bombas extends JFrame implements ActionListener, KeyListener{

    public int ColocarBomba() {

        int x = (int) (Math.random() * 525);
        return x;

    }

    String ruta;
    String[] imagenes;

    ArrayList<JLabel> bombas;

    JLabel lblFondo;

    JLabel lblBomba;

    JButton btnIzquierda;
    JButton btnDerecha;

    JLabel lblProta;

    Timer temporizador;
    int contVeces = 0;
    int contSeg = 0;
    int contMin = 0;
    int contBomba = 0;
    int velocidad = 0;
    JLabel lblTiempo;

    public Bombas() {

        super("Esquivar las bombas!");
        this.setLayout(null);
        setSize(600, 750);

        ruta = "C:\\Users\\Usuario\\Desktop\\programación\\Ejercicios\\Tercer trimestre\\Tema 7 Swing Introducción a los GUI\\bol7_ejer9\\imagenes\\";
        imagenes = new String[]{
            ruta + "bomba.png",//0
            ruta + "explosion.png",
            ruta + "flecha_derecha.jpg",
            ruta + "flecha_izquierda.jpg",
            ruta + "fondo.jpg",
            ruta + "guerrero.png",//5
        };
        bombas = new ArrayList<>();

        lblFondo = new JLabel(new ImageIcon(imagenes[4]));
        lblFondo.setLocation(0,0);
        lblFondo.setSize(600,575);
        lblFondo.setOpaque(true);
        this.add(lblFondo);

        lblBomba = new JLabel(new ImageIcon(imagenes[0]));
        lblBomba.setSize(75, 75);
        lblBomba.setLocation(ColocarBomba(), 0);
        bombas.add(lblBomba);
        lblFondo.add(lblBomba);

        // btnIzquierda = new JButton(new ImageIcon(
        //         "C:\\Users\\Usuario\\Desktop\\programación\\Ejercicios\\Tercer trimestre\\Tema 7 Swing Introducción a los GUI\\bol7_ejer9\\imagenes\\flecha_izquierda.jpg"));
        // btnIzquierda.setSize(75, 75);
        // btnIzquierda.setLocation(200, 600);
        // btnIzquierda.addActionListener(this);
        // this.add(btnIzquierda);

        // btnDerecha = new JButton(new ImageIcon(
        //         "C:\\Users\\Usuario\\Desktop\\programación\\Ejercicios\\Tercer trimestre\\Tema 7 Swing Introducción a los GUI\\bol7_ejer9\\imagenes\\flecha_derecha.jpg"));
        // btnDerecha.setSize(75, 75);
        // btnDerecha.setLocation(300, 600);
        // btnDerecha.addActionListener(this);
        // this.add(btnDerecha);

        lblProta = new JLabel(new ImageIcon(imagenes[5]));
        lblProta.setSize(75, 75);
        lblProta.setLocation(200, 425);
        lblFondo.add(lblProta);

        temporizador = new Timer(100, this);
        temporizador.start();

        lblTiempo = new JLabel();
        lblTiempo.setSize(175, 50);
        lblTiempo.setLocation(200, 675);
        lblTiempo.setFont(new Font("Arial", ABORT, 20));
        lblTiempo.setForeground(new Color(0, 0, 200));
        lblTiempo.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblTiempo);

        addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == temporizador) {

            contVeces++;

            for(int i = 0; i < bombas.size(); i++){

                bombas.get(i).setLocation( bombas.get(i).getLocation().x, bombas.get(i).getLocation().y + (20 + velocidad));

                if(lblProta.getBounds().intersects(bombas.get(i).getBounds())){
    
                    lblProta.setIcon(new ImageIcon(imagenes[1]));
                    JOptionPane.showConfirmDialog(null, "Has explotado!", "Fin de la partida", JOptionPane.CLOSED_OPTION);
                    System.exit(0);
                }

                if (bombas.get(i).getLocation().y >= 550) {
                    bombas.get(i).setLocation(ColocarBomba(), 0);
                }
            }

            if (contVeces == 10) {
                contSeg++;
                contVeces = 0;
            }

            if (contSeg % 5 == 0 && contVeces==8 && velocidad < 25) {

                velocidad = velocidad + 2;

            }

            if ((contSeg == 5 || contSeg == 10 ||contSeg == 20) && contVeces == 8) {
                contBomba++;

                JLabel lbl = new JLabel(new ImageIcon(imagenes[0]));
                lbl.setSize(75, 75);
                lbl.setLocation(ColocarBomba(), 0);
                bombas.add(lbl);
                lblFondo.add(lbl);
            }

            if (contSeg == 60) {
                contMin++;
                contSeg = 0;
            }

            lblTiempo.setText(String.format("%02d:%02d", contMin, contSeg));
        }

        // if (e.getSource() == btnDerecha) {

        //     if (lblProta.getLocation().x > (525 - 25)) {
        //         lblProta.setLocation(525, lblProta.getLocation().y);
        //     } else {
        //         lblProta.setLocation(lblProta.getLocation().x + 25, lblProta.getLocation().y);
        //     }
        // }

        // if (e.getSource() == btnIzquierda) {

        //     if (lblProta.getLocation().x < 25) {
        //         lblProta.setLocation(0, lblProta.getLocation().y);
        //     } else {
        //         lblProta.setLocation(lblProta.getLocation().x - 25, lblProta.getLocation().y);
        //     }
        // }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            if (lblProta.getLocation().x < 25) {
                lblProta.setLocation(0, lblProta.getLocation().y);
            } else {
                lblProta.setLocation(lblProta.getLocation().x - 25, lblProta.getLocation().y);
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            if (lblProta.getLocation().x > (525 - 25)) {
                lblProta.setLocation(525, lblProta.getLocation().y);
            } else {
                lblProta.setLocation(lblProta.getLocation().x + 25, lblProta.getLocation().y);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
