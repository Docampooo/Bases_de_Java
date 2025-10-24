package ejer6;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Bombas extends JFrame implements ActionListener {

    String ruta;
    String[] imagenes;

    File f;

    ArrayList<JLabel> bombas;

    JLabel lblFondo;

    JLabel lblBomba;

    JButton btnPause;
    JButton btnRecords;

    JLabel lblProta;

    Timer temporizador;
    int contVeces = 0;
    int contSeg = 0;
    int contMin = 0;
    int contBomba = 0;
    int velocidad = 0;
    JLabel lblTiempo;

    int contPause;
    boolean pause;

    int puntuacion;

    public Bombas() {

        super("Esquivar las bombas!");
        this.setLayout(null);
        setSize(600, 750);

        f = new File("puntuacion.txt");

        ruta = "C:\\Users\\Usuario\\Desktop\\programación\\Ejercicios\\Tercer trimestre\\Tema 7 Swing Introducción a los GUI\\bol7_ejer9\\imagenes\\";
        imagenes = new String[] {
                ruta + "bomba.png", // 0
                ruta + "explosion.png",
                ruta + "flecha_derecha.jpg",
                ruta + "flecha_izquierda.jpg",
                ruta + "fondo.jpg",
                ruta + "guerrero.png",// 5
        };
        bombas = new ArrayList<>();

        lblFondo = new JLabel(new ImageIcon(imagenes[4]));
        lblFondo.setLocation(0, 0);
        lblFondo.setSize(600, 575);
        lblFondo.setOpaque(true);
        this.add(lblFondo);

        lblBomba = new JLabel(new ImageIcon(imagenes[0]));
        lblBomba.setSize(75, 75);
        lblBomba.setLocation(ColocarBomba(), 0);
        bombas.add(lblBomba);
        lblFondo.add(lblBomba);

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

        btnPause = new JButton("Pause");
        btnPause.setSize(100, 75);
        btnPause.setLocation(50, 600);
        btnPause.addActionListener(this);
        this.add(btnPause);

        contPause = 0;
        pause = false;

        puntuacion = 0;

        btnRecords = new JButton("Records");
        btnRecords.setSize(100, 75);
        btnRecords.setLocation(425, 600);
        btnRecords.addActionListener(this);
        this.add(btnRecords);

        this.addKeyListener(new KeyHandler());

        this.addMouseListener(new MouseHandler());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == temporizador) {

            contVeces++;

            for (int i = 0; i < bombas.size(); i++) {

                bombas.get(i).setLocation(bombas.get(i).getLocation().x,
                        bombas.get(i).getLocation().y + (20 + velocidad));

                if (lblProta.getBounds().intersects(bombas.get(i).getBounds())) {

                    lblProta.setIcon(new ImageIcon(imagenes[1]));

                    int eleccion = JOptionPane.showConfirmDialog(null, "Has explotado! quieres guardar la partida?", "Fin de la partida",JOptionPane.YES_NO_OPTION);
                    if(eleccion == JOptionPane.YES_OPTION){

                        Records records = new Records(this);
                        records.pack();
                        records.setVisible(true);
                        records.setLocationRelativeTo(null);

                    }else{
                        System.exit(0);

                    }
                }

                if (bombas.get(i).getLocation().y >= 550) {
                    bombas.get(i).setLocation(ColocarBomba(), 0);
                }
            }

            if(contVeces == 5){
                puntuacion = puntuacion + 100;

                if(puntuacion > 300){
                    lblTiempo.setForeground(Color.GREEN);
                }else{
                    lblTiempo.setForeground(null);
                }
            }

            if (contVeces == 10) {
                contSeg++;
                contVeces = 0;
            }

            if (contSeg % 5 == 0 && contVeces == 8 && velocidad < 25) {

                velocidad = velocidad + 2;

            }

            if ((contSeg == 5 || contSeg == 10 || contSeg == 20) && contVeces == 8) {
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

        if (e.getSource() == btnPause) {
            pause();
        }

        if(e.getSource() == btnRecords){
            pause();


        }
    }

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
                if (lblProta.getLocation().x < 25) {
                    lblProta.setLocation(0, lblProta.getLocation().y);
                } else {
                    lblProta.setLocation(lblProta.getLocation().x - 25, lblProta.getLocation().y);
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
                if (lblProta.getLocation().x > (525 - 25)) {
                    lblProta.setLocation(525, lblProta.getLocation().y);
                } else {
                    lblProta.setLocation(lblProta.getLocation().x + 25, lblProta.getLocation().y);
                }
            }
        }
    }

    public class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                if (lblProta.getLocation().x < 25) {
                    lblProta.setLocation(0, lblProta.getLocation().y);
                } else {
                    lblProta.setLocation(lblProta.getLocation().x - 25, lblProta.getLocation().y);
                }
            }

            if (e.getButton() == MouseEvent.BUTTON3) {
                if (lblProta.getLocation().x > (525 - 25)) {
                    lblProta.setLocation(525, lblProta.getLocation().y);
                } else {
                    lblProta.setLocation(lblProta.getLocation().x + 25, lblProta.getLocation().y);
                }
            }
        }
    }

    public int ColocarBomba() {

        int x = (int) (Math.random() * 525);
        return x;

    }

    public void pause() {
        contPause++;

        if (contPause % 2 == 0) {
            temporizador.start();
        } else {
            temporizador.stop();
        }
    }
}
