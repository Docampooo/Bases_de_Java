package ejer3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Operaciones extends JFrame implements ItemListener, ActionListener {

    File f = new File(System.getProperty("user.home") + "\\Operaciones.txt");

    JTextField txt1;
    JTextField txt2;
    JTextField txtResult;

    JLabel lblSigno;
    JLabel lblResult;
    JLabel lblError;

    ButtonGroup grupoSignos;

    JRadioButton rbSuma;
    JRadioButton rbResta;
    JRadioButton rbMultiplicacion;
    JRadioButton rbDivision;

    JRadioButton[] listaSignos;

    JButton btnOperacion;

    JLabel lblDecimales;
    JComboBox cbDecimales;
    String[] decimales;

    double num1;
    double num2;
    double result;
    boolean error;
    int seleccionRd;

    public Operaciones() {

        super("Mini calculadora");
        this.setLayout(null);

        txt1 = new JTextField();
        txt1.setSize(100, 100);
        txt1.setLocation(25, 25);
        txt1.setFont(new Font("Arial", Font.BOLD, 25));
        txt1.setHorizontalAlignment(JTextField.CENTER);
        this.add(txt1);

        txt2 = new JTextField();
        txt2.setSize(100, 100);
        txt2.setLocation(200, 25);
        txt2.setFont(new Font("Arial", Font.BOLD, 25));
        txt2.setHorizontalAlignment(JTextField.CENTER);
        this.add(txt2);

        lblSigno = new JLabel();
        lblSigno.setHorizontalAlignment(JLabel.CENTER);
        lblSigno.setFont(new Font("Arial", Font.BOLD, 25));
        lblSigno.setLocation(150, 62);
        lblSigno.setSize(25, 25);
        this.add(lblSigno);

        lblResult = new JLabel("=");
        lblResult.setHorizontalAlignment(JLabel.CENTER);
        lblResult.setFont(new Font("Arial", Font.BOLD, 25));
        lblResult.setLocation(325, 62);
        lblResult.setSize(25, 25);
        lblResult.setVisible(false);
        this.add(lblResult);

        txtResult = new JTextField();
        txtResult = new JTextField();
        txtResult.setSize(100, 100);
        txtResult.setLocation(375, 25);
        txtResult.setFont(new Font("Arial", Font.BOLD, 25));
        txtResult.setHorizontalAlignment(JTextField.CENTER);
        txtResult.setVisible(false);
        this.add(txtResult);

        grupoSignos = new ButtonGroup();

        rbSuma = new JRadioButton("Suma");
        rbSuma.setSize(125, 25);
        rbSuma.setLocation(25, 150);
        rbSuma.addItemListener(this);
        rbSuma.setSelected(true);
        this.add(rbSuma);
        grupoSignos.add(rbSuma);

        rbResta = new JRadioButton("Resta");
        rbResta.setSize(125, 25);
        rbResta.setLocation(25, 175);
        rbResta.addItemListener(this);
        this.add(rbResta);
        grupoSignos.add(rbResta);

        rbMultiplicacion = new JRadioButton("Multiplicacion");
        rbMultiplicacion.setSize(125, 25);
        rbMultiplicacion.setLocation(25, 200);
        rbMultiplicacion.addItemListener(this);
        this.add(rbMultiplicacion);
        grupoSignos.add(rbMultiplicacion);

        rbDivision = new JRadioButton("Division");
        rbDivision.setSize(125, 25);
        rbDivision.setLocation(25, 225);
        rbDivision.addItemListener(this);
        this.add(rbDivision);
        grupoSignos.add(rbDivision);

        listaSignos = new JRadioButton[] { rbSuma, rbResta, rbMultiplicacion, rbDivision };

        btnOperacion = new JButton("Operacion");
        btnOperacion.setHorizontalAlignment(JLabel.CENTER);
        btnOperacion.setLocation(200, 150);
        btnOperacion.setSize(100, 100);
        btnOperacion.addActionListener(this);
        this.add(btnOperacion);

        lblError = new JLabel();
        lblError.setHorizontalAlignment(JLabel.CENTER);
        lblError.setForeground(Color.RED);
        lblError.setFont(new Font("Arial", Font.BOLD, 10));
        lblError.setLocation(235, 150);
        lblError.setSize(500, 100);
        this.add(lblError);

        decimales = new String[] { "0", "1", "2", "3", "4", "5" };
        cbDecimales = new JComboBox<>(decimales);
        cbDecimales.setMaximumRowCount(8);
        cbDecimales.setSelectedIndex(2);
        cbDecimales.setLocation(200, 325);
        cbDecimales.setSize(100, 30);
        cbDecimales.addItemListener(this);
        this.add(cbDecimales);

        lblDecimales = new JLabel("Cuantos decimales quieres?");
        lblDecimales.setSize(300, 30);
        lblDecimales.setHorizontalAlignment(JLabel.CENTER);
        lblDecimales.setLocation(100, 275);
        this.add(lblDecimales);

        try (Scanner q = new Scanner(f)) { //Try with resources hecho
            txt1.setText(q.nextLine());
            txt2.setText(q.nextLine());
            seleccionRd = Integer.parseInt(q.nextLine());

            listaSignos[seleccionRd - 1].setSelected(true);
        }catch(IOException o){
            System.err.println("No se encuentra el archivo");

        }

        this.addWindowListener(new WindowHandler());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource().getClass() == JRadioButton.class) {

            JRadioButton rb = (JRadioButton) e.getSource();

            if (rb == rbSuma) {
                lblSigno.setText("+");
                seleccionRd = 1;
            }

            if (rb == rbResta) {
                lblSigno.setText("-");
                seleccionRd = 2;
            }

            if (rb == rbMultiplicacion) {
                lblSigno.setText("*");
                seleccionRd = 3;
            }

            if (rb == rbDivision) {
                lblSigno.setText("/");
                seleccionRd = 4;
            }
        }

        if (e.getSource() == cbDecimales) {
            decimales();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnOperacion) {
            txtResult.setVisible(false);
            lblResult.setVisible(false);
            lblError.setText("");

            try {
                error = false;
                num1 = Double.parseDouble(txt1.getText().trim());
                num2 = Double.parseDouble(txt2.getText().trim());

            } catch (NumberFormatException | NullPointerException o) {
                error = true;
                lblError.setText("Los parámetros han de ser números reales para poder realizar las operaciones");
            }

            if (!error) {
                lblResult.setVisible(true);
                txtResult.setVisible(true);
                txtResult.setBackground(Color.GREEN);

                if (rbSuma.isSelected()) {
                    result = num1 + num2;
                }

                if (rbResta.isSelected()) {
                    result = num1 - num2;
                }

                if (rbMultiplicacion.isSelected()) {
                    result = num1 * num2;
                }

                if (rbDivision.isSelected()) {
                    result = num1 / num2;
                }
                txtResult.setText(Double.toString(result));
                decimales();
            }
        }
    }

    public void decimales() {
        int pos = cbDecimales.getSelectedIndex();
        String[] decimales = { "%.0f", "%.1f", "%.2f", "%.3f", "%.4f", "%.5f" };

        String punto = Double.toString(result);
        punto = punto.replace(',', '.');
        try {
            txtResult.setText(String.format(decimales[pos], Double.parseDouble(punto)));

        } catch (NumberFormatException o) {
            System.err.println("fallo");
        }
    }

    private class WindowHandler extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {

            try (PrintWriter q = new PrintWriter(new FileWriter(f))) {
                q.println(txt1.getText());
                q.println(txt2.getText());
                q.println(seleccionRd);

            } catch (IOException o) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo", "Error en el archivo",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}