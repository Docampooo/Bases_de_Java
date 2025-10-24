package juego;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//El juego se basa en un sencillo juego de memoria donde los jugadores controlan cada uno a un gato que puede moverse por el tablero y girar las cartas ocultas que contienen una imagen, funciona por turnos, un jugador no puede girar 3 cartas seguidas a menos que encuentre la pareja y pueda seguir jugando, es el clasico juego de memory.

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javazoom.jl.player.Player;

public class Gatos extends JFrame implements ActionListener {

    // imagenes finales
    String rutaGatos = "C:\\Users\\Usuario\\Desktop\\programación\\juego_gatos\\imagenes\\final\\gato";
    String[] gatos = new String[8];
    String[] nombreGatos = new String[] {
            "Cafe",
            "Sick",
            "Manchitas",
            "Ilgner",
            "Niobe",
            "Gaturri",
            "Oreo",
            "Peluso"
    };

    String rutaDados = "C:\\Users\\Usuario\\Desktop\\programación\\juego_gatos\\imagenes\\final\\dado";
    String[] dados = new String[6];

    String rutaCartasJuego = "C:\\Users\\Usuario\\Desktop\\programación\\juego_gatos\\imagenes\\final\\";
    String[] cartasJuego = new String[8];

    String rutaBotones = "C:\\Users\\Usuario\\Desktop\\programación\\juego_gatos\\imagenes\\final\\boton";
    String[] botones = new String[9];

    // recursos usados
    String rutaOtros = "C:\\Users\\Usuario\\Desktop\\programación\\juego_gatos\\imagenes\\recursos\\";
    String[] otros = new String[] {
            rutaOtros + "fondoInicial.jpg", // 0
            rutaOtros + "gatoDeftones.jpg",
            rutaOtros + "gatoSigilismo.png",
            rutaOtros + "overlay0.png",
            rutaOtros + "overlay1.png",
            rutaOtros + "fondoJuego.jpg", // 5
            rutaCartasJuego + "cartaMorada.jpg"
    };

    boolean sonido = true;
    String rutaSonidos = "C:\\Users\\Usuario\\Desktop\\programación\\juego_gatos\\audios\\";
    String[] audios = new String[] {
            rutaSonidos + "acierto.mp3",
            rutaSonidos + "fallo.mp3",
            rutaSonidos + "comenzar_partida.mp3",
            rutaSonidos + "final_partida.mp3",
            rutaSonidos + "seleccion.mp3",
            rutaSonidos + "cambio.mp3"
    };

    JLabel lblTitulo;
    JLabel lblFondo;
    JLabel lblEleccion;
    JLabel lblOverlay;

    JTextField txtNombre;
    JTextField txtJ1;
    JTextField txtJ2;

    JButton btnJugar;
    JButton btnSonidoOn;
    JButton btnSonidoOff;
    JButton btnIzq;
    JButton btnDer;
    JButton btnRecords;

    int j = 0;
    int inidiceJ1 = 0;
    int inidiceJ2 = 0;

    boolean j1 = false;
    boolean j2 = false;

    public Gatos() {

        super("Jueguito");
        this.setLayout(null);

        for (int i = 0; i < gatos.length; i++) {
            gatos[i] = rutaGatos + i + ".png";
        }

        for (int i = 0; i < dados.length; i++) {
            dados[i] = rutaDados + i + ".png";
        }

        for (int i = 0; i < botones.length; i++) {
            botones[i] = rutaBotones + i + ".png";
        }

        cartasJuego[0] = rutaCartasJuego + "rec_master.jpg"; // 0
        cartasJuego[1] = rutaCartasJuego + "rec_familia.jpg";
        cartasJuego[2] = rutaCartasJuego + "rec_pov.jpg";
        cartasJuego[3] = rutaCartasJuego + "rec_yeah.jpg";
        cartasJuego[4] = rutaCartasJuego + "rec_rojos.jpg";
        cartasJuego[5] = rutaCartasJuego + "rec_maligna.jpg"; // 5
        cartasJuego[6] = rutaCartasJuego + "rec_adri.jpg";
        cartasJuego[7] = rutaCartasJuego + "rec_nico.jpg"; // 7

        lblFondo = new JLabel(new ImageIcon(otros[0]));
        lblFondo.setSize(510, 700);
        lblFondo.setLocation(0, 0);
        lblFondo.setOpaque(true);
        add(lblFondo);

        btnJugar = new JButton(new ImageIcon(botones[6]));
        btnJugar.setSize(178, 78);// ajustar bien
        btnJugar.setLocation(160, 20);
        btnJugar.addActionListener(this);
        btnJugar.setOpaque(true);
        lblFondo.add(btnJugar);

        txtNombre = new JTextField("Selecciona un Gato!");
        txtNombre.setHorizontalAlignment(JLabel.CENTER);
        txtNombre.setForeground(Color.WHITE);
        txtNombre.setBackground(Color.BLACK);
        txtNombre.setFont(new Font("Cambria Math", ABORT, 30));
        txtNombre.setSize(300, 50);
        txtNombre.setEditable(false);
        txtNombre.setLocation(100, 120);
        lblFondo.add(txtNombre);

        lblOverlay = new JLabel(new ImageIcon(otros[3]));
        lblOverlay.setSize(300, 334);
        lblOverlay.setLocation(85, 180);
        lblFondo.add(lblOverlay);

        lblEleccion = new JLabel(new ImageIcon(gatos[0]));
        lblEleccion.setSize(210, 210);
        lblEleccion.setLocation(60, 60);
        lblOverlay.add(lblEleccion);

        btnIzq = new JButton(new ImageIcon(botones[8]));
        btnIzq.setSize(105, 77);// ajustar bien
        btnIzq.setLocation(15, 300);
        btnIzq.addActionListener(this);
        btnIzq.setOpaque(true);
        btnIzq.setFocusable(false);
        lblFondo.add(btnIzq);

        btnDer = new JButton(new ImageIcon(botones[4]));
        btnDer.setSize(105, 77);// ajustar bien
        btnDer.setLocation(375, 300);
        btnDer.addActionListener(this);
        btnDer.setOpaque(true);
        btnDer.setFocusable(false);
        lblFondo.add(btnDer);

        txtJ1 = new JTextField("J1:");
        txtJ1.setSize(200, 50);
        txtJ1.setHorizontalAlignment(JTextField.CENTER);
        txtJ1.setForeground(Color.WHITE);
        txtJ1.setBackground(Color.BLACK);
        txtJ1.setFont(new Font("Cambria Math", ABORT, 30));
        txtJ1.setLocation(15, 525);
        txtJ1.setEditable(false);
        lblFondo.add(txtJ1);

        txtJ2 = new JTextField("J2:");
        txtJ2.setSize(200, 50);
        txtJ2.setForeground(Color.WHITE);
        txtJ2.setBackground(Color.BLACK);
        txtJ2.setHorizontalAlignment(JTextField.CENTER);
        txtJ2.setFont(new Font("Cambria Math", ABORT, 30));
        txtJ2.setLocation(15, 600);
        txtJ2.setEditable(false);
        lblFondo.add(txtJ2);

        btnSonidoOn = new JButton(new ImageIcon(botones[0]));
        btnSonidoOn.setSize(105, 77);// ajustar bien
        btnSonidoOn.setLocation(250, 550);
        btnSonidoOn.addActionListener(this);
        btnSonidoOn.setOpaque(true);
        lblFondo.add(btnSonidoOn);

        btnSonidoOff = new JButton(new ImageIcon(botones[7]));
        btnSonidoOff.setSize(105, 77);// ajustar bien
        btnSonidoOff.setLocation(370, 550);
        btnSonidoOff.addActionListener(this);
        btnSonidoOff.setOpaque(true);
        lblFondo.add(btnSonidoOff);

        for (Component c : getContentPane().getComponents()) {
            c.addKeyListener(new KeyHandler());
        }
        for (Component d : lblFondo.getComponents()) {
            d.addKeyListener(new KeyHandler());

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIzq) {
            reproducirAudio(audios[5]);
            txtNombre.setForeground(Color.WHITE);
            j = 0;
            String aux = lblEleccion.getIcon().toString();
            for (int i = 0; i < gatos.length; i++) {
                if (gatos[i].equals(aux)) {
                    if (i == 0) {
                        j = gatos.length - 1;
                    } else {
                        j = i - 1;
                    }
                }
            }
            txtNombre.setText(nombreGatos[j]);
            lblEleccion.setIcon(new ImageIcon(gatos[j]));
            if (!j1) {
                inidiceJ1 = j;
            } else {
                inidiceJ2 = j;
            }
        }

        if (e.getSource() == btnDer) {
            reproducirAudio(audios[5]);
            txtNombre.setForeground(Color.WHITE);
            j = 0;
            String aux = lblEleccion.getIcon().toString();
            for (int i = 0; i < gatos.length; i++) {
                if (gatos[i].equals(aux) && i < gatos.length - 1) {
                    j = i + 1;
                }

                if (i == gatos.length) {
                    j = 0;
                }
            }
            txtNombre.setText(nombreGatos[j]);
            lblEleccion.setIcon(new ImageIcon(gatos[j]));
            if (!j1) {
                inidiceJ1 = j;
            } else {
                inidiceJ2 = j;
            }
        }

        if (e.getSource() == btnJugar) {
            if (!j1 || !j2) {
                txtNombre.setText("Selecciona un gato!");
                txtNombre.setForeground(new Color(74, 61, 64));
            } else {
                reproducirAudio(audios[2]);
                Juego j = new Juego(this);
                j.setSize(565, 850);
                j.setLocationRelativeTo(null);
                j.setVisible(true);
                j.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        }

        if(e.getSource() == btnSonidoOn){
            sonido = true;
        }

        if(e.getSource() == btnSonidoOff){
            sonido = false;
        }
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                reproducirAudio(audios[4]);

                txtNombre.setForeground(Color.WHITE);
                if (!j1) {
                    txtJ1.setText(String.format("%s %s", txtJ1.getText(), nombreGatos[inidiceJ1]));
                    txtJ1.setBackground(new Color(74, 61, 64));
                    j1 = true;
                } else if (!j2) {
                    txtJ2.setText(String.format("%s %s", txtJ2.getText(), nombreGatos[inidiceJ2]));
                    txtJ2.setBackground(new Color(74, 61, 64));
                    j2 = true;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                btnDer.doClick();
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                btnIzq.doClick();
            }
        }
    }

    public void reproducirAudio(String ruta) {

        if (sonido) {
            new Thread(() -> {
                try (FileInputStream fis = new FileInputStream(ruta)) {
                    Player player = new Player(fis);
                    player.play();
                } catch (Exception e) {
                    System.err.println("Error al reproducir: " + ruta);
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
