package examen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener{
    
    File f = new File(System.getProperty("user.home") + "\\palabra.txt");

    ButtonGroup grupoDificultad;
    JRadioButton rbEstandar;
    JRadioButton rbFacil;

    JButton btnInicio;

    JTextField txfPalabra;

    private boolean dificultad;
    private String pal;

    JLabel[][] letras;

    public Principal(){

        super("Wordle");
        this.setLayout(null);

        try(PrintWriter p = new PrintWriter(new FileWriter(f))){
            p.println("raton;oveja;denis;pablo;lucas;error;facil;exame;ratas");
    
        }catch(IOException o){
            System.err.println("Error en el archivo");
        }

        String[] palabras = null;
        try(Scanner p = new Scanner(f)){
            palabras = p.nextLine().split("[;]");

        }catch(IOException o){
            System.err.println("Error en el archivo");
        }

        int num = (int)(Math.random()*palabras.length);
        pal = palabras[num];

        int x = 120;
        int y = 10;
        letras = new JLabel[10][5];
        for(int i = 0; i < 10; i++){

            for(int p = 0; p < 5; p++){

                JLabel lbl = new JLabel("PRB");
                lbl.setOpaque(true);
                lbl.setSize(40, 40);
                lbl.setHorizontalAlignment(JLabel.CENTER);
                lbl.setVerticalAlignment(JLabel.CENTER);
                lbl.setVisible(false);
                x = x + 50;
                lbl.setLocation(x, y);

                letras[i][p] = lbl;
                this.add(lbl);
            }
            y = y + 50;
            x = 120;
        }
        
        dificultad = true;

        rbEstandar = new JRadioButton("Estandar");
        rbEstandar.setSize(100, 30);
        rbEstandar.setLocation(40, 60);
        rbEstandar.addMouseListener(new MouseHandler());
        this.add(rbEstandar);

        rbFacil = new JRadioButton("Facil");
        rbFacil.setSize(100, 30);
        rbFacil.setLocation(40, 90);
        rbFacil.addMouseListener(new MouseHandler());
        this.add(rbFacil);

        if(rbEstandar.isSelected()){ //probar
            dificultad = true;
        }else if(rbFacil.isSelected()){
            dificultad = false;
        }

        grupoDificultad = new ButtonGroup();
        grupoDificultad.add(rbEstandar);
        grupoDificultad.add(rbFacil);
        
        btnInicio = new JButton("Inicio");
        btnInicio.setSize(100, 30);
        btnInicio.setLocation(40, 120);
        btnInicio.addActionListener(this);
        this.add(btnInicio);

        txfPalabra = new JTextField("");
        txfPalabra.setSize(100, 30);
        txfPalabra.setLocation(40, 160);
        txfPalabra.addActionListener(this);
        txfPalabra.setEditable(false);
        this.add(txfPalabra);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnInicio){
            txfPalabra.setEditable(true);

            int num = dificultad?6:10;
            for(int i = 0; i < num; i++){
                for(int p = 0; p < letras[i].length; p++){
                    letras[i][p].setVisible(true);
                    letras[i][p].setBackground(Color.WHITE);
                }
            }
        }
    }

    private class MouseHandler extends MouseAdapter{

        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource().getClass() == JRadioButton.class){
                JRadioButton rb = (JRadioButton)e.getSource();

                rb.setForeground(Color.YELLOW);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource().getClass() == JRadioButton.class){
                JRadioButton rb = (JRadioButton)e.getSource();

                rb.setForeground(Color.BLACK);
            }
        }
    }

    public Color comprueba(char carac, int pos){//REVISAR

        Color color = null;

        for(int i = 0; i < letras.length;i++){
            for(int p = 0; p < letras[i].length; p++){
                
                for(int u = 0; u < letras[i][p].getText().length(); u++){
                    if(carac == letras[i][p].getText().charAt(pos)){
                        return color = Color.decode("#126a06");
                    }else{
                        if(carac == letras[i][p].getText().charAt(u) && carac != letras[i][p].getText().charAt(pos)){
                            return Color.ORANGE;
                        }else{
                            color = Color.GRAY;
                        }
                    }
                }
            }
        }
    return color;
    }
}
