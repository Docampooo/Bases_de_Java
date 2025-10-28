package ejercicio4;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.print.attribute.IntegerSyntax;
import javax.swing.*;

public class Formulario extends JFrame implements ActionListener {

    public boolean comprobarCadena(String cadena) {

        if (cadena.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "El valor introducido no es válido { " + cadena + " }",
                    "Fallo en una cadena", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    public boolean comprobarEdad(String cadena) {

        int edad;

        try {
            edad = Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La edad introducida no es un parámetro entero { " + cadena + " }",
                    "Error con el parametro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (edad < 0) {
            JOptionPane.showMessageDialog(null, "La edad introducida no es coherente { " + edad + " }",
                    "Fallo numérico", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    JTextField txtNombre;
    JLabel lblNombre;

    JTextField txtEdad;
    JLabel lblEdad;

    JTextField txtDir;
    JLabel lblDir;

    JButton btnGuardar;
    JButton btnCargar;

    public Formulario() {

        super("Guardar info");
        this.setLayout(null);

        lblNombre = new JLabel("Introduce tu nombre");
        lblNombre.setSize(200, 30);
        lblNombre.setLocation(50, 50);
        this.add(lblNombre);

        txtNombre = new JTextField(10);
        txtNombre.setSize(200, 30);
        txtNombre.setLocation(50, 100);
        this.add(txtNombre);

        lblEdad = new JLabel("Introduce tu edad");
        lblEdad.setSize(200, 30);
        lblEdad.setLocation(50, 150);
        this.add(lblEdad);

        txtEdad = new JTextField(10);
        txtEdad.setSize(200, 30);
        txtEdad.setLocation(50, 200);
        this.add(txtEdad);

        lblDir = new JLabel("Introduce tu Direccion");
        lblDir.setSize(200, 30);
        lblDir.setLocation(50, 250);
        this.add(lblDir);

        txtDir = new JTextField(10);
        txtDir.setSize(200, 30);
        txtDir.setLocation(50, 300);
        this.add(txtDir);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setSize(125, 50);
        btnGuardar.setLocation(50, 350);
        btnGuardar.addActionListener(this);
        this.add(btnGuardar);

        btnCargar = new JButton("Cargar");
        btnCargar.setSize(125, 50);
        btnCargar.setLocation(200, 350);
        btnCargar.addActionListener(this);
        this.add(btnCargar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        File f = new File("datos.txt");

        if (e.getSource() == btnGuardar) {

            if (comprobarCadena(txtNombre.getText()) && comprobarEdad(txtEdad.getText())
                    && comprobarCadena(txtDir.getText())) {

                PrintWriter p;
                try {
                    p = new PrintWriter(f);

                    p.println(txtNombre.getText());
                    p.println(txtEdad.getText());
                    p.println(txtDir.getText());

                    p.close();

                    JOptionPane.showMessageDialog(null, "Se han guardado los datos", "Exito al guardar los datos",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, "El archivo no es valido", "Error con el archivo",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        if (e.getSource() == btnCargar) {

            if (f.exists()) { // seguir aqui

                if (txtNombre.getText().equals("") && txtEdad.getText().equals("") && txtDir.getText().equals("")) {

                    Scanner p;
                    try {
                        p = new Scanner(f);

                        txtNombre.setText(p.nextLine());

                        txtEdad.setText(p.nextLine());

                        txtDir.setText(p.nextLine());

                        p.close();

                    } catch (FileNotFoundException e1) {

                        JOptionPane.showMessageDialog(null, "El archivo no es valido", "Error con el archivo",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else {

                    int eleccion = JOptionPane.showConfirmDialog(null, "Quieres remplazar el contenido de los prompts?",
                            "Confirmar cargar archivo", JOptionPane.YES_NO_OPTION);

                    switch (eleccion) {
                        case JOptionPane.YES_OPTION://Mejor en funcion

                            Scanner p;
                            try {
                                p = new Scanner(f);

                                txtNombre.setText(p.nextLine());

                                txtEdad.setText(p.nextLine());

                                txtDir.setText(p.nextLine());

                                p.close();

                            } catch (FileNotFoundException e1) {

                                JOptionPane.showMessageDialog(null, "El archivo no es valido", "Error con el archivo",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            break;

                        case JOptionPane.NO_OPTION:

                            JOptionPane.showMessageDialog(null, "No se ha cargado el contenido del archivo",
                                    "Carga de archivo cancelada", JOptionPane.INFORMATION_MESSAGE);
                        default:
                            break;
                    }
                }
            }

        }
    }
}
