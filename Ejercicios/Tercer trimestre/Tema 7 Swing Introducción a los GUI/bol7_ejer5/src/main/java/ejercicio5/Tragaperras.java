package ejercicio5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tragaperras extends JFrame implements ActionListener{

    private JLabel lbl;
    private JLabel lblTiempo;
    
    private JTextField txtIzquierda;
    private JTextField txtCentro;
    private JTextField txtDerecha;

    private JButton btn;

    private Timer temporizador;
    private int contSeg = 55;
    private int contMIn = 0;

    public Tragaperras(){
        super("Tragaperras");
        this.setLayout(null);
        
        lbl = new JLabel("Pulsa el botón para probar suerte!");
        lbl.setSize(200, 30);
        lbl.setLocation(155, 50);
        this.add(lbl);

        txtIzquierda = new JTextField();
        txtIzquierda.setSize(100, 100);
        txtIzquierda.setLocation(50, 100);
        txtIzquierda.setEditable(false);
        txtIzquierda.setBackground(new Color(0, 0, 255));
        txtIzquierda.setHorizontalAlignment(JTextField.CENTER);
        txtIzquierda.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(txtIzquierda);

        txtCentro = new JTextField();
        txtCentro.setSize(100, 100);
        txtCentro.setLocation(200, 100);
        txtCentro.setEditable(false);
        txtCentro.setBackground(new Color(0, 0, 255));
        txtCentro.setHorizontalAlignment(JTextField.CENTER);
        txtCentro.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(txtCentro);

        txtDerecha = new JTextField();
        txtDerecha.setSize(100, 100);
        txtDerecha.setLocation(350, 100);
        txtDerecha.setEditable(false);
        txtDerecha.setBackground(new Color(0, 0, 255));
        txtDerecha.setHorizontalAlignment(JTextField.CENTER);
        txtDerecha.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(txtDerecha);

        btn = new JButton();
        btn.setSize(75, 75);
        btn.setLocation(212, 250);
        btn.addActionListener(this);
        this.add(btn);

        lblTiempo = new JLabel();
        lblTiempo.setSize(200, 30);
        lblTiempo.setLocation(240, 350);
        this.add(lblTiempo);

        temporizador = new Timer(1000, this);
        temporizador.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == temporizador){

            contSeg++;

            if(contSeg == 60){
                contMIn++;
                contSeg = 0;
            }

            lblTiempo.setText(String.format("%02d:%02d",contMIn, contSeg));
        }
        
        if(e.getSource()==btn){

            int num1;
            num1 = (int) (Math.random()*6+1);
            txtIzquierda.setText(Integer.toString(num1));

            int num2;
            num2 = (int) (Math.random()*6+1);
            txtCentro.setText(Integer.toString(num2));

            int num3;
            num3 = (int) (Math.random()*6+1);
            txtDerecha.setText(Integer.toString(num3));

            if(txtIzquierda.getText().equals(txtCentro.getText()) && txtIzquierda.getText().equals(txtDerecha.getText())){

                txtIzquierda.setBackground(new Color(0, 255, 0));
                txtCentro.setBackground(new Color(0, 255, 0));
                txtDerecha.setBackground(new Color(0, 255, 0));

                JOptionPane.showMessageDialog(null, "Has Ganado!!", "victoria", JOptionPane.INFORMATION_MESSAGE);
            }else{
    
                txtIzquierda.setBackground(new Color(255, 0, 0));
                txtCentro.setBackground(new Color(255, 0, 0));
                txtDerecha.setBackground(new Color(255, 0, 0));

                JOptionPane.showMessageDialog(null, "Has Perdido!", "Fallo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
