package ejercicio6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mates extends JFrame implements ActionListener {

    public boolean comprobarNumero(String cadena) {

        if (cadena.trim().equals("")) {
            lblResult.setForeground(new Color(255, 0, 0));
            lblResult.setText("Se necesitan valores numéricos en ambos prompts");
            return false;
        }

        try {
            Double.parseDouble(cadena);

        } catch (NumberFormatException e) {

            lblResult.setForeground(new Color(255, 0, 0));
            lblResult.setText(("Parámetro no numérico entero en el prompt"));
            return false;
        }

        return true;
    }

    JTextField txt1;
    JTextField txt2;

    JLabel lblResult;

    JButton btnSuma;
    JButton btnDivision;
    JButton btnRaiz;

    public Mates() {

        super("Funciones matemáticas");
        this.setLayout(new FlowLayout());

        txt1 = new JTextField();
        txt1.setPreferredSize(new Dimension(120, 30));
        txt1.setHorizontalAlignment(JTextField.CENTER);
        txt1.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(txt1);

        txt2 = new JTextField();
        txt2.setPreferredSize(new Dimension(120, 30));
        txt2.setHorizontalAlignment(JTextField.CENTER);
        txt2.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(txt2);

        btnSuma = new JButton("Suma");
        btnSuma.setSize(getPreferredSize());
        btnSuma.addActionListener(this);
        this.add(btnSuma);

        btnDivision = new JButton("Division");
        btnDivision.setSize(getPreferredSize());
        btnDivision.addActionListener(this);
        this.add(btnDivision);

        btnRaiz = new JButton("Raiz Cuadrada");
        btnRaiz.setSize(getPreferredSize());
        btnRaiz.addActionListener(this);
        this.add(btnRaiz);

        lblResult = new JLabel("Resultados");
        lblResult.setSize(getPreferredSize());
        lblResult.setHorizontalAlignment(JLabel.CENTER);
        lblResult.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(lblResult);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (comprobarNumero(txt1.getText()) && comprobarNumero(txt2.getText())) {

            if (e.getSource() == btnSuma) {

                double result = Double.parseDouble(txt1.getText().trim()) + Double.parseDouble(txt2.getText().trim());

                lblResult.setForeground(new Color(0 ,0 ,0));
                lblResult.setText(String.format("%.4s", Double.toString(result)));
            }

            if (e.getSource() == btnDivision) {

                if (txt2.getText().trim().equals("0")) {
                    lblResult.setForeground(new Color(255, 0, 0));
                    lblResult.setText("No se puede dividir por 0, el número es infinito");
                } else {
                    double result = Double.parseDouble(txt1.getText().trim()) / Double.parseDouble(txt2.getText().trim());

                    lblResult.setForeground(new Color(0, 0, 0));
                    lblResult.setText(String.format("%.4s", Double.toString(result)));
                }

            }

        }

        if(comprobarNumero(txt1.getText())){
            
            if (e.getSource() == btnRaiz) {
    
                double num = Double.parseDouble(txt1.getText().trim());
    
                if(num < 0){
    
                    lblResult.setForeground(new Color(255 ,0 ,0));
                    lblResult.setText("No se puede hacer una raíz cuadrada de un número negativo");
                }else{
                    lblResult.setForeground(new Color(0 ,0 ,0));
                    lblResult.setText(String.format(" √%.2f = %.4s",num ,Math.sqrt(num)));
                }
            }
        }
    }
}
