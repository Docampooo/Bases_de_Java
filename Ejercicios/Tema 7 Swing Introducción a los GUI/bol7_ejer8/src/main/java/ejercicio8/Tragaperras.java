package ejercicio8;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Tragaperras extends JFrame implements ActionListener {

    String ruta;
    String[] imagenes;

    JLabel lblIzquierda;
    JLabel lblCentro;
    JLabel lblDerecha;

    JButton btn;
    JLabel lblCredito;
    JLabel lblResult;
    JLabel lblTiempo;

    Timer temporizadorTotal;
    int contSeg = 0;
    int contMin = 0;

    Timer temporizador;
    int contTitulo = -1;
    int contBtn = 0;

    JLabel lblRacha;
    int racha = 0;

    double credito;

    public Tragaperras() {

        super("");
        this.setLayout(null);

        ruta = "C:\\Users\\Usuario\\Desktop\\programación\\Ejercicios\\Tercer trimestre\\Tema 7 Swing Introducción a los GUI\\bol7_ejer8\\imagenes\\";
        imagenes = new String[] {
            ruta + "deftones.jpg",
            ruta + "disguise.jpg",
            ruta + "hybridTheory.jpg",
            ruta + "slipknot.jpg",
            ruta + "theBrimstonSluggers.jpg",
            ruta + "thePoison.jpg",
            ruta + "one_X.jpg"
        };

        lblIzquierda = new JLabel(new ImageIcon(imagenes[6]));

        lblIzquierda.setSize(200, 200);
        lblIzquierda.setLocation(100, 50);
        this.add(lblIzquierda);

        lblCentro = new JLabel(new ImageIcon(imagenes[6]));
        lblCentro.setSize(200, 200);
        lblCentro.setLocation(375, 50);
        this.add(lblCentro);

        lblDerecha = new JLabel(new ImageIcon(imagenes[6]));
        lblDerecha.setSize(200, 200);
        lblDerecha.setLocation(650, 50);
        this.add(lblDerecha);

        btn = new JButton("1$");
        btn.setHorizontalAlignment(JButton.CENTER);
        btn.setFont(new Font("Arial", ABORT, 25));
        btn.setSize(125, 50);
        btn.setLocation(410, 300);
        btn.setToolTipText("El coste por tirada es 1$, hacer una pareja son 1.5$ y los tres 5$");
        btn.addActionListener(this);
        this.add(btn);

        lblCredito = new JLabel("10");
        lblCredito.setVerticalAlignment(JLabel.CENTER);
        lblCredito.setHorizontalTextPosition(JLabel.CENTER);
        lblCredito.setForeground(new Color(0, 200, 0));
        lblCredito.setFont(new Font("Arial", ABORT, 25));
        lblCredito.setSize(125, 20);
        lblCredito.setLocation(460, 375);
        this.add(lblCredito);

        lblResult = new JLabel();
        lblResult.setVerticalAlignment(JLabel.CENTER);
        lblResult.setHorizontalTextPosition(JLabel.CENTER);
        lblResult.setForeground(new Color(0, 0, 200));
        lblResult.setFont(new Font("Arial", ABORT, 25));
        lblResult.setSize(125, 20);
        lblResult.setLocation(460, 425);
        this.add(lblResult);

        lblTiempo = new JLabel();
        lblTiempo.setSize(125, 20);
        lblTiempo.setLocation(460, 475);
        lblTiempo.setForeground(new Color(0, 0, 200));
        lblTiempo.setFont(new Font("Arial", ABORT, 25));
        lblTiempo.setVerticalAlignment(JLabel.CENTER);
        lblTiempo.setHorizontalTextPosition(JLabel.CENTER);
        this.add(lblTiempo);

        lblRacha = new JLabel();
        lblRacha.setSize(250, 20);
        lblRacha.setLocation(425, 525);
        lblRacha.setForeground(new Color(0, 200, 0));
        lblRacha.setFont(new Font("Arial", ABORT, 25));
        lblRacha.setVerticalAlignment(JLabel.CENTER);
        lblRacha.setHorizontalTextPosition(JLabel.CENTER);
        this.add(lblRacha);

        temporizadorTotal = new Timer(1000, this);
        temporizadorTotal.start();

        temporizador = new Timer(200, this);
        temporizador.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == temporizadorTotal) {

            contSeg++;

            if (contSeg == 60) {
                contMin++;
                contSeg = 0;
            }

            lblTiempo.setText(String.format("%s:%s", Integer.toString(contMin), Integer.toString(contSeg)));
        }

        if (e.getSource() == temporizador) {

            contTitulo++;

            String titulo = "Superminitragaperras";
            if (contTitulo < titulo.length()) {

                this.setTitle(this.getTitle() + titulo.charAt(contTitulo));
            } else {

                contTitulo = -1;
                this.setTitle("");
            }

            if (contTitulo % 2 == 0) {

                contBtn++;
            }

            if (lblResult.getForeground().getRed() == 200) {

                if (credito < 4) {
                    if (contTitulo % 2 == 0) {
                        btn.setBackground(new Color(150, 100, 0));
                    } else {
                        btn.setBackground(new Color(200, 0, 0));
                    }
                } else {
                    if (contBtn % 2 == 0) {
                        btn.setBackground(new Color(150, 100, 0));
                    } else {
                        btn.setBackground(new Color(200, 0, 0));
                    }
                }

            } else if (lblResult.getForeground().getGreen() == 200) {

                if (racha >= 3) {

                    if (contTitulo % 2 == 0) {
                        btn.setBackground(new Color(0, 150, 50));
                    } else {
                        btn.setBackground(new Color(0, 200, 0));
                    }
                } else {

                    if (contBtn % 2 == 0) {
                        btn.setBackground(new Color(0, 150, 50));
                    } else {
                        btn.setBackground(new Color(0, 200, 0));
                    }
                }
            }
        }

        if (e.getSource() == btn) {

            credito = Double.parseDouble(lblCredito.getText());

            if (credito < 1) {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "falta de saldo", JOptionPane.ERROR_MESSAGE);
            } else {

                credito = credito - 1;
                int num1;
                num1 = (int) (Math.random() * 6);
                lblIzquierda.setIcon(new ImageIcon(imagenes[num1]));

                int num2;
                num2 = (int) (Math.random() * 6);
                lblCentro.setIcon(new ImageIcon(imagenes[num2]));

                int num3;
                num3 = (int) (Math.random() * 6);
                lblDerecha.setIcon(new ImageIcon(imagenes[num3]));

                if (num1 == num2 && num1 == num3) {

                    racha++;
                    credito = credito + 5;
                    lblResult.setText("+ 5");
                    lblResult.setForeground(new Color(0, 200, 0));

                } else if (num1 == num2 || num1 == num3 || num2 == num3) {

                    racha++;
                    credito = credito + 1.5;
                    lblResult.setText("+ 0.5");
                    lblResult.setForeground(new Color(0, 200, 0));
                } else {

                    racha = 0;
                    lblRacha.setText("");
                    lblResult.setText("-1");
                    lblResult.setForeground(new Color(200, 0, 0));
                }

                if (credito < 4) {

                    lblCredito.setForeground(new Color(200, 0, 0));
                } else {
                    lblCredito.setForeground(new Color(0, 200, 0));
                }

                if (racha >= 3) {

                    lblRacha.setText("Racha de " + racha + "!");
                }

                lblCredito.setText(Double.toString(credito));

            }

        }
    }

}
