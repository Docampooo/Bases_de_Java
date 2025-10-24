package juego;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

import javax.sound.sampled.*;
import java.io.File;

public class Juego extends JDialog implements ActionListener {

    Gatos g;

    ArrayList<JLabel> cartas = new ArrayList<>();
    int[] imagenCartas = new int[16];
    boolean[] veces = new boolean[16];

    int[] contAsignarImagenes = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] contElegirImagenes = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };

    JLabel lblJuego;
    JLabel lblJ1;
    JLabel lblJ2;

    JTextField txtPuntosJ1;
    JTextField txtPuntosJ2;

    int contPuntosJ1 = 0;
    int contPuntosJ2 = 0;

    Timer tmr;
    int contTmr = 0;
    int contSeg = 0;
    int contMin = 0;
    JLabel lblTiempo;

    int contOJo = 0;
    int contObillo = 0;
    int contCampana = 0;
    int contPez = 0;
    int contFlor = 0;
    int contRaton = 0;
    int contGato = 0;

    int contJ1 = 0;
    boolean turnoJ1 = true;

    int contJ2 = 0;
    boolean turnoJ2 = false;

    JLabel primeraCarta = null;
    JLabel segundaCarta = null;
    boolean puedeElegir = true;

    public Juego(Gatos g) {

        super(g, true);
        this.setLayout(null);

        this.g = (Gatos) this.getOwner();

        ImageIcon fondoGato = new ImageIcon(g.otros[4]);
        Image imgFondo = fondoGato.getImage().getScaledInstance(560, 850, 210);
        lblJuego = new JLabel(new ImageIcon(imgFondo));
        lblJuego.setSize(565, 850);
        lblJuego.setLocation(0, 0);
        lblJuego.setOpaque(true);
        this.add(lblJuego);
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
        this.requestFocusInWindow();

        int x = 50;
        int y = -100;
        int total = 0;
        for (int i = 0; i < 16; i++) {
            JLabel carta = new JLabel(new ImageIcon(g.otros[5]));
            carta.setSize(90, 120);
            carta.setHorizontalAlignment(JLabel.CENTER);
            carta.setForeground(Color.BLACK);
            carta.setOpaque(true);
            carta.setFocusable(false);

            boolean error;
            do {
                error = false;
                int imagen = (int) (Math.random() * 8 + 0);

                if (contAsignarImagenes[imagen] == 2) {
                    error = true;
                } else {
                    total++;
                    contAsignarImagenes[imagen]++;
                    carta.setText(Integer.toString(imagen));

                    boolean vez = false;
                    carta.putClientProperty("nombreImagen", imagen);
                    carta.putClientProperty("veces", vez);
                    imagenCartas[i] = (int) carta.getClientProperty("nombreImagen");
                    veces[i] = (boolean) carta.getClientProperty("veces");
                }

                if (total == 16) {
                    error = false;
                }

            } while (error);

            if (i % 4 == 0) {
                x = 50;
                y = y + 150;
            } else {
                x = x + 120;
            }
            carta.setLocation(x, y);
            cartas.add(carta);
            lblJuego.add(carta);
        }

        ImageIcon gato1 = new ImageIcon(g.gatos[g.inidiceJ1]);
        Image img1 = gato1.getImage().getScaledInstance(105, 105, 210);
        lblJ1 = new JLabel(new ImageIcon(img1));// hacer esto
        lblJ1.setSize(105, 105);
        lblJ1.setLocation(225, 675);
        lblJuego.add(lblJ1);

        ImageIcon gato2 = new ImageIcon(g.gatos[g.inidiceJ2]);
        Image img2 = gato2.getImage().getScaledInstance(105, 105, 210);
        lblJ2 = new JLabel(new ImageIcon(img2));
        lblJ2.setSize(105, 105);
        lblJ2.setLocation(330, 675);
        lblJuego.add(lblJ2);

        tmr = new Timer(200, this);
        tmr.start();

        lblTiempo = new JLabel("tiempo");
        lblTiempo.setSize(100, 30);
        lblTiempo.setLocation(425, 725);
        lblTiempo.setForeground(Color.RED);
        lblTiempo.setHorizontalAlignment(JTextField.CENTER);
        lblTiempo.setFont(new Font("Cambria Math", ABORT, 30));
        lblJuego.add(lblTiempo);

        txtPuntosJ1 = new JTextField(g.nombreGatos[g.inidiceJ1]);
        txtPuntosJ1.setSize(200, 40);
        txtPuntosJ1.setLocation(15, 640);
        txtPuntosJ1.setHorizontalAlignment(JTextField.CENTER);
        txtPuntosJ1.setForeground(Color.WHITE);
        txtPuntosJ1.setBackground(Color.BLACK);
        txtPuntosJ1.setFont(new Font("Cambria Math", ABORT, 30));
        txtPuntosJ1.setEditable(false);
        lblJuego.add(txtPuntosJ1);

        txtPuntosJ2 = new JTextField(g.nombreGatos[g.inidiceJ2]);
        txtPuntosJ2.setSize(200, 40);
        txtPuntosJ2.setLocation(15, 705);
        txtPuntosJ2.setHorizontalAlignment(JTextField.CENTER);
        txtPuntosJ2.setForeground(Color.WHITE);
        txtPuntosJ2.setBackground(Color.BLACK);
        txtPuntosJ2.setFont(new Font("Cambria Math", ABORT, 30));
        txtPuntosJ2.setEditable(false);
        lblJuego.add(txtPuntosJ2);

        

        for (Component d : getContentPane().getComponents()) {
            d.addKeyListener(new KeyHandler());
        }

        for (Component d : lblJuego.getComponents()) {
            d.addKeyListener(new KeyHandler());
        }

        for (int d = 0; d < g.cartasJuego.length; d++) {
            System.err.println(g.cartasJuego[d]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tmr) {

            contTmr++;
            if (contTmr == 5) {
                contTmr = 0;
                contSeg++;
            }

            if (contSeg == 60) {
                contSeg = 0;
                contMin++;
            }

            lblTiempo.setText(String.format("%02d:%02d", contMin, contSeg));

            boolean bandera = true;
            int acu = 0;
            for(int i = 0; i < veces.length; i++){
                if(veces[i]){
                    acu++;
                }
            }

            if(acu == 16){
                bandera = false;
            }

            if(!bandera){
                if(contPuntosJ1 > contPuntosJ2){
                    JOptionPane.showMessageDialog(null, String.format("%s ha ganado con %d puntos!",g.nombreGatos[g.inidiceJ1], contPuntosJ1), "Fin de la partida!!!", JOptionPane.INFORMATION_MESSAGE);

                }else if(contPuntosJ1 < contPuntosJ2){
                    JOptionPane.showMessageDialog(null, String.format("%s ha ganado con %d puntos!",g.nombreGatos[g.inidiceJ2], contPuntosJ2), "Fin de la partida!!!", JOptionPane.INFORMATION_MESSAGE);

                }else{
                    JOptionPane.showMessageDialog(null, String.format("Empate con %d puntos!",contPuntosJ1), "Fin de la partida!!!", JOptionPane.INFORMATION_MESSAGE);

                }

                System.exit(0);
            }
        }
    }

    private class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            // Movimiento jugador1
            if (e.getKeyCode() == KeyEvent.VK_D) {
                sumarX(lblJ1);
            }

            if (e.getKeyCode() == KeyEvent.VK_A) {
                restarX(lblJ1);
            }

            if (e.getKeyCode() == KeyEvent.VK_W) {
                restarY(lblJ1);
            }

            if (e.getKeyCode() == KeyEvent.VK_S) {
                sumarY(lblJ1);
            }

            // Movimiento jugador2
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                sumarX(lblJ2);
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                restarX(lblJ2);
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                restarY(lblJ2);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                sumarY(lblJ2);
            }

            // Elección de cartas
            if (!puedeElegir) return; // Evita seleccionar más de 2 cartas

            for (int i = 0; i < cartas.size(); i++) {
                if (turnoJ1 && e.getKeyCode() == KeyEvent.VK_SPACE &&
                        lblJ1.getBounds().intersects(cartas.get(i).getBounds())) {

                    elegirCarta(cartas.get(i), 1);
                    break;

                } else if (turnoJ2 && e.getKeyCode() == KeyEvent.VK_ENTER &&
                        lblJ2.getBounds().intersects(cartas.get(i).getBounds())) {

                    elegirCarta(cartas.get(i), 2);
                    break;
                }
            }
        }
    }

    public void restarX(JLabel lbl) {
        if (lbl.getX() <= 25) {
            lbl.setLocation(0, lbl.getY());
        } else {
            lbl.setLocation(lbl.getX() - 25, lbl.getY());
        }
    }

    public void sumarX(JLabel lbl) {
        if (lbl.getX() >= 435) {
            lbl.setLocation(460, lbl.getY());
        } else {
            lbl.setLocation(lbl.getX() + 25, lbl.getY());
        }
    }

    public void restarY(JLabel lbl) {
        if (lbl.getY() <= 25) {
            lbl.setLocation(lbl.getX(), 0);
        } else {
            lbl.setLocation(lbl.getX(), lbl.getY() - 25);
        }
    }

    public void sumarY(JLabel lbl) {
        if (lbl.getY() >= 675) {
            lbl.setLocation(lbl.getX(), 700);
        } else {
            lbl.setLocation(lbl.getX(), lbl.getY() + 25);
        }
    }

    public boolean elegirCarta(JLabel cartaSeleccionada, int jugador) {

        if (!puedeElegir || cartaSeleccionada == primeraCarta || veces[cartas.indexOf(cartaSeleccionada)]) {
            return true; // No hace nada si ya está descubierta o esperando
        }

        int indice = cartas.indexOf(cartaSeleccionada);
        int imagenID = imagenCartas[indice];

        g.reproducirAudio(g.audios[4]);
        ImageIcon icono = new ImageIcon(g.cartasJuego[imagenID]);
        Image imgEscalada = icono.getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH);
        cartaSeleccionada.setIcon(new ImageIcon(imgEscalada));
        cartaSeleccionada.setText(""); // Ocultar texto

        if (primeraCarta == null) {
            primeraCarta = cartaSeleccionada;
            return true; // Sigue el turno
        } else {
            segundaCarta = cartaSeleccionada;
            puedeElegir = false;

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int indice1 = cartas.indexOf(primeraCarta);
                    int indice2 = cartas.indexOf(segundaCarta);

                    if (imagenCartas[indice1] == imagenCartas[indice2]) {
                        // Acierto
                        g.reproducirAudio(g.audios[0]);
                        veces[indice1] = true;
                        veces[indice2] = true;

                        if(jugador == 1){
                            contPuntosJ1 = contPuntosJ1 + 2;
                            txtPuntosJ1.setText(String.format("%s: %d",g.nombreGatos[g.inidiceJ1], contPuntosJ1));
                        }else{
                            contPuntosJ2 = contPuntosJ2 + 2;
                            txtPuntosJ2.setText(String.format("%s: %d",g.nombreGatos[g.inidiceJ2], contPuntosJ2));
                        }
                        
                    } else {
                        // Fallo
                        g.reproducirAudio(g.audios[1]);
                        primeraCarta.setIcon(new ImageIcon(g.otros[5]));
                        segundaCarta.setIcon(new ImageIcon(g.otros[5]));

                        // Cambia de turno
                        if (jugador == 1) {
                            turnoJ1 = false;
                            turnoJ2 = true;
                        } else {
                            turnoJ2 = false;
                            turnoJ1 = true;
                        }
                    }

                    // Reset selección
                    primeraCarta = null;
                    segundaCarta = null;
                    puedeElegir = true;
                }
            });
            timer.setRepeats(false);
            timer.start();

            return false; // No continúa el turno hasta que compare 
        }
    }
}
