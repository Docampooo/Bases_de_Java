package repasoTema8;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Pruebas extends JFrame implements ItemListener{

    String ruta = "C:\\Users\\Usuario\\Desktop\\programación\\practica teoria\\Tercer trimestre\\repaso_examen\\imagenes\\";

    String[] nombreImagenes = new String[]{"deftones","disguise","hybridTheory","one_X","slipknot","thePoison","theBrimstonSluggers"};
    String[] imagenes = new String[] {
            ruta + "deftones.jpg",
            ruta + "disguise.jpg",
            ruta + "hybridTheory.jpg",
            ruta + "one_X.jpg",
            ruta + "slipknot.jpg",
            ruta + "thePoison.jpg",
            ruta + "theBrimstonSluggers.jpg"
    };

    JLabel lblInfo;
    JLabel lblCords;
    JLabel lblTeclas;

    ArrayList<JLabel> img;

    ButtonGroup grupoColor;
    ButtonGroup grupoFuente;

    JRadioButton rbRojo;
    JRadioButton rbAzul;

    JRadioButton rbSherif;
    JRadioButton rbArial;

    public Pruebas(){

        super("Pruebas con la teoría del tema 8");
        this.setLayout(null);

        int x = 10;
        int y = 10;
        img = new ArrayList<>();

        for(int i = 0; i < imagenes.length; i++){
            JLabel lblImagen = new JLabel(new ImageIcon(imagenes[i]));
            lblImagen.setToolTipText(nombreImagenes[i]);
            lblImagen.setSize(150, 150);
            lblImagen.addMouseListener(new MouseHandler());
            lblImagen.addMouseMotionListener(new MouseHandler());
            lblImagen.addKeyListener(new KeyHandler());

            if((i+1) % 4 == 0){
                x = 10;
                y = y + 175;
            }else{
                x = x + 175;
            }

            lblImagen.setLocation(x, y);
            img.add(lblImagen);
            this.add(lblImagen);
        }

        lblInfo = new JLabel();
        lblInfo.setSize(300, 50);
        lblInfo.setLocation(300, 350);
        lblInfo.setHorizontalAlignment(JLabel.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(lblInfo);

        lblCords = new JLabel();
        lblCords.setSize(100, 50);
        lblCords.setLocation(400, 400);
        lblCords.setHorizontalAlignment(JLabel.CENTER);
        lblCords.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(lblCords);

        lblTeclas = new JLabel();
        lblTeclas.setSize(200, 50);
        lblTeclas.setLocation(350, 450);
        lblTeclas.setHorizontalAlignment(JLabel.CENTER);
        lblTeclas.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(lblTeclas);

        rbAzul = new JRadioButton("Azul");
        rbAzul.addItemListener(this);
        rbAzul.setForeground(Color.BLUE);
        rbAzul.setLocation(200, 500);
        rbAzul.setSize(50, 25);
        rbAzul.addKeyListener(new KeyHandler());
        this.add(rbAzul);

        rbRojo = new JRadioButton("Rojo");
        rbRojo.addItemListener(this);
        rbRojo.setForeground(Color.RED);
        rbRojo.setLocation(275, 500);
        rbRojo.setSize(75, 25);
        rbRojo.setSelected(true);
        rbRojo.addKeyListener(new KeyHandler());
        this.add(rbRojo);

        rbSherif = new JRadioButton("Sherif");
        rbSherif.addItemListener(this);
        rbSherif.setFont(new Font("Serif", Font.PLAIN, 10));
        rbSherif.setLocation(350, 500);
        rbSherif.setSize(50, 25);
        rbSherif.addKeyListener(new KeyHandler());
        this.add(rbSherif);

        rbArial = new JRadioButton("Arial");
        rbArial.addItemListener(this);
        rbArial.setFont(new Font("Arial", Font.PLAIN, 10));
        rbArial.setLocation(425, 500);
        rbArial.setSize(50, 25);
        rbArial.setSelected(true);
        rbArial.addKeyListener(new KeyHandler());
        this.add(rbArial);

        grupoColor = new ButtonGroup();
        grupoColor.add(rbRojo);
        grupoColor.add(rbAzul);

        grupoFuente = new ButtonGroup();
        grupoFuente.add(rbArial);
        grupoFuente.add(rbSherif);

        this.getContentPane().addMouseListener(new MouseHandler());
        this.getContentPane().addMouseMotionListener(new MouseHandler());
        this.addKeyListener(new KeyHandler());
    }

    private class MouseHandler extends MouseAdapter{

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource().getClass() == JLabel.class){
                JLabel lbl = (JLabel) e.getSource();
                lblInfo.setText(lbl.getToolTipText());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource().getClass() == JLabel.class){
                JLabel lbl = (JLabel) e.getSource();
                lblInfo.setText("");
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource().getClass() == JLabel.class){
                JLabel lbl = (JLabel) e.getSource();
                
                int eleccion = img.indexOf(lbl);

                switch (eleccion) {
                    case 0:
                        lblInfo.setForeground(Color.GREEN);
                        break;
                    case 1:
                    lblInfo.setForeground(Color.BLUE);
                        break;
                    case 2:
                    lblInfo.setForeground(Color.GRAY);
                        break;
                    case 3:
                    lblInfo.setForeground(Color.GRAY);
                        break;
                    case 4:
                    lblInfo.setForeground(Color.magenta);
                        break;
                    case 5:
                    lblInfo.setForeground(Color.RED);
                        break;
                    case 6:
                    lblInfo.setForeground(Color.pink);
                        break;
                    case 7:
                    lblInfo.setForeground(Color.lightGray);
                        break;
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            
            if(e.getSource().getClass() == JLabel.class){
                JLabel lbl = (JLabel)e.getSource();
                lblCords.setText(String.format("X:%d; Y:%d", e.getX() + lbl.getX(), e.getY() + lbl.getY()));
            }else{
                lblCords.setText(String.format("X:%d; Y:%d", e.getX(), e.getY()));
            }
        }
    }

    private class KeyHandler extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {

            lblTeclas.setText(String.format("Tecla: %d Code: %c", e.getKeyCode(), e.getKeyChar()));

           if(e.getKeyCode() == KeyEvent.VK_C && e.isControlDown()){

                Secundario secun = new Secundario(Pruebas.this);

                secun.pack();
                secun.setVisible(true);
                secun.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                secun.setLocationRelativeTo(null);
           }

           if((e.getKeyCode() == KeyEvent.VK_C) && e.isShiftDown()){
                lblTeclas.setForeground(lblInfo.getForeground());
           }

           if(e.getKeyCode() == KeyEvent.VK_LEFT && e.isAltDown()){
                lblInfo.setLocation(lblInfo.getX() - 15, lblInfo.getY());
           }

           if(e.getKeyCode() == KeyEvent.VK_RIGHT && e.isAltDown()){
                lblInfo.setLocation(lblInfo.getX() + 15, lblInfo.getY());
           }

           if(e.getKeyCode() == KeyEvent.VK_C && e.isAltDown()){
                Terciario terci = new Terciario(Pruebas.this);
                terci.pack();
                terci.setVisible(true);
                terci.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                terci.setLocationRelativeTo(null);
           }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().getClass() == JRadioButton.class){

            JRadioButton rb = (JRadioButton)e.getSource();
            if(rb == rbAzul){
                lblCords.setForeground(rb.getForeground());
            }

            if(rb == rbRojo){
                lblCords.setForeground(rb.getForeground());
            }

            if(rb == rbSherif){
                lblCords.setFont(rb.getFont());
            }

            if(rb == rbArial){
                lblCords.setFont(rb.getFont());
            }
        }
    }
}
