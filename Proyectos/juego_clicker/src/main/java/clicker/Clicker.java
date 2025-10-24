package clicker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clicker extends JFrame implements ActionListener{
    
    JLabel lblFondo;

    JButton btnClick;

    JLabel lblClick;
    JLabel lblHola;
    JLabel lblFoto;

    int clicks;

    String ruta;
    String[] imagenes; 

    ImageIcon icono;
    Image imagenRedimensionada;

    ImageIcon icono2;
    Image imagenRedimensionada2;

    ImageIcon icono3;
    Image imagenRedimensionada3;

    ImageIcon icono4;
    Image imagenRedimensionada4;

    public Clicker(){
        
        super("Juego de Clicks!!!");
        this.setLayout(null);

        ruta = "C:\\Users\\Usuario\\Desktop\\programación\\casa\\juego_clicker\\imagenes\\";
        imagenes = new String[]{

            ruta + "zoom.png",
            ruta + "fondo.jpg",
            ruta + "mirada.jpg",
            ruta + "desculpa.jpg",
            ruta + "gatoFlores.jpg",
        };

        lblFondo = new JLabel(new ImageIcon(imagenes[1]));
        lblFondo.setLocation(0,0);
        lblFondo.setSize(500,550);
        lblFondo.setOpaque(true);
        this.add(lblFondo);

        clicks = 0;

        int width = 50;
        int height = 50;

        icono = new ImageIcon(imagenes[0]);
        imagenRedimensionada = icono.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);

        btnClick = new JButton(new ImageIcon(imagenRedimensionada));
        btnClick.setSize(width, height);
        btnClick.setLocation(225, 200);
        btnClick.addActionListener(this);
        lblFondo.add(btnClick);

        lblClick = new JLabel("Clicks: " + clicks + "!");
        lblClick.setSize(150, 30);
        lblClick.setLocation(215, 475);
        lblClick.setFont(new Font("Arial", ABORT, 20));
        lblClick.setForeground(Color.GRAY);
        lblFondo.add(lblClick);

        lblHola = new JLabel("Hola :3");
        lblHola.setSize(150, 30);
        lblHola.setLocation(218, 255);
        lblHola.setFont(new Font("Arial", ABORT, 20));
        lblHola.setForeground(Color.GRAY);
        lblFondo.add(lblHola);

        icono2 = new ImageIcon(imagenes[2]);
        imagenRedimensionada2 = icono2.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);

        lblFoto = new JLabel(new ImageIcon(imagenRedimensionada2));
        lblFoto.setSize(150, 150);
        lblFoto.setLocation(180, 325);
        lblFoto.setFont(new Font("Arial", ABORT, 20));
        lblFoto.setForeground(Color.GRAY);
        lblFoto.setVisible(false);
        lblFondo.add(lblFoto);

        icono3 = new ImageIcon(imagenes[3]);
        imagenRedimensionada3 = icono3.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);

        icono4 = new ImageIcon(imagenes[4]);
        imagenRedimensionada4 = icono4.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnClick){

            clicks++;

            if(clicks > 0){
                lblHola.setVisible(false);
            }

            if(clicks > 40 && clicks < 60){
                lblFoto.setVisible(true);
            }else{
                lblFoto.setVisible(false);
            }

            int newInt = btnClick.getWidth() + 2;
            int newHeight = btnClick.getHeight() + 2;

            btnClick.setSize(newInt, newHeight);

            if(clicks < 170){
                imagenRedimensionada = icono.getImage().getScaledInstance(newInt, newHeight,  java.awt.Image.SCALE_SMOOTH);
                btnClick.setIcon(new ImageIcon(imagenRedimensionada));
            } else if(clicks >= 170 && clicks < 175 ){
                imagenRedimensionada3 = icono3.getImage().getScaledInstance(newInt, newHeight,  java.awt.Image.SCALE_SMOOTH);
                btnClick.setIcon(new ImageIcon(imagenRedimensionada3));
            }else if(clicks >= 175 && clicks < 180){
                imagenRedimensionada4 = icono4.getImage().getScaledInstance(newInt, newHeight,  java.awt.Image.SCALE_SMOOTH);
                btnClick.setIcon(new ImageIcon(imagenRedimensionada4));
            }else if(clicks == 180){
                System.exit(0);
            }


            btnClick.setLocation(btnClick.getX() - 1, btnClick.getY() - 1);

            lblClick.setText("Clicks: " + clicks + "!");
        }
    }
}
