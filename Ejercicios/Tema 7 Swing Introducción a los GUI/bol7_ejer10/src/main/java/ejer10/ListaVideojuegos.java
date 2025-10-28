package ejer10;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ListaVideojuegos extends JFrame implements ActionListener {

    ArrayList<Videojuego> videojuegos;

    File f = new File("Videojuegos.txt");

    JTextField txtTitulo;
    JTextField txtAño;

    JButton btnAdd;
    JButton btnShow;
    JButton btnSearch;
    JButton btnSave;

    JLabel lblInfo;

    public ListaVideojuegos() {

        super("Lista de videojuegos");
        this.setLayout(null);

        videojuegos = new ArrayList<>();

        txtTitulo = new JTextField("Titulo");
        txtTitulo.setLocation(175, 50);
        txtTitulo.setSize(100, 30);
        this.add(txtTitulo);

        txtAño = new JTextField("Año");
        txtAño.setLocation(300, 50);
        txtAño.setSize(100, 30);
        this.add(txtAño);

        btnAdd = new JButton("Añadir");
        btnAdd.setLocation(50, 100);
        btnAdd.setSize(100, 50);
        btnAdd.addActionListener(this);
        this.add(btnAdd);

        btnShow = new JButton("Mostrar");
        btnShow.setLocation(175, 100);
        btnShow.setSize(100, 50);
        btnShow.addActionListener(this);
        this.add(btnShow);

        btnSearch = new JButton("Buscar");
        btnSearch.setLocation(300, 100);
        btnSearch.setSize(100, 50);
        btnSearch.addActionListener(this);
        this.add(btnSearch);

        btnSave = new JButton("Guardar");
        btnSave.setLocation(425, 100);
        btnSave.setSize(100, 50);
        btnSave.addActionListener(this);
        this.add(btnSave);

        lblInfo = new JLabel();
        lblInfo.setLocation(50, 175);
        lblInfo.setSize(500, 300);
        lblInfo.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblInfo);

        if (f.exists()) {

            try {
                Scanner p = new Scanner(f);

                while (p.hasNext()) {

                    String cadena = p.nextLine();
                    Videojuego juego = new Videojuego();

                    int cont = 0;
                    for (String c : cadena.split("[;]")) {
                        cont++;
                        if (cont == 1) {
                            juego.setTitulo(c);
                        } else {
                            juego.setAño(Integer.parseInt(c.trim()));
                        }
                    }
                    videojuegos.add(juego);

                }

            } catch (FileNotFoundException o) {
                System.out.println("No se encuentra el archivo");

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {

            Videojuego juego;

            if (comprobarAño(txtAño.getText()) && comprobarTitulo(txtTitulo.getText())) {

                juego = new Videojuego(txtTitulo.getText(), Integer.parseInt(txtAño.getText()));

                if (comprobarlista(juego)) {

                    videojuegos.add(juego);
                    JOptionPane.showMessageDialog(null, "Se ha añadido el videojuego", "Juego añdido con éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se ha añadido el videojuego", "Error al añadir el juego",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnShow) {

            lblInfo.setText("");
            for (int i = 0; i < videojuegos.size(); i++) {
                lblInfo.setText(lblInfo.getText() + "\n" + videojuegos.get(i).toString()); // añadir estilos
            }
        }

        if (e.getSource() == btnSearch) {

            lblInfo.setText("");

            try {
                for (int i = 0; i < videojuegos.size(); i++) {
                    if (videojuegos.get(i).getTitulo().contains(txtTitulo.getSelectedText().toUpperCase().trim())) {
                        lblInfo.setText(videojuegos.get(i).toString());
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha encontrado ningun videojuego que contenga: " + txtTitulo.getSelectedText(), "Error en la busqueda", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            } catch (IllegalArgumentException | NullPointerException o) {
                JOptionPane.showMessageDialog(null, "No hay ningún texto seleccionado en el titulo",
                        "Error en la seleccion del texto", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == btnSave) {

            try {
                PrintWriter p = new PrintWriter(f);
                for (int i = 0; i < videojuegos.size(); i++) {
                    p.print(videojuegos.get(i).toString());

                }
                p.close();
                JOptionPane.showMessageDialog(null, "Se han guardado los datos", "Exito en el guardado",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException o) {

                System.out.println("No se encuentra el archivo");
            }
        }
    }

    public boolean comprobarTitulo(String titulo) {

        if (titulo.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "El campo de titulo no puede estar vacío", "Error en el titulo",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public boolean comprobarAño(String año) {

        try {
            Integer.parseInt(año);

        } catch (NumberFormatException o) {
            JOptionPane.showMessageDialog(null, "En el campo de años solo se admiten numeros entre 1950 y 2025",
                    "Error en el año", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public boolean comprobarlista(Videojuego juego) {

        if (videojuegos.size() != 0) {

            for (int i = 0; i < videojuegos.size(); i++) {
                if (juego.equals(videojuegos.get(i))) {
                    JOptionPane.showMessageDialog(null, "El juego ya forma parte de tu lista de juegos",
                            "Juego ya existente", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
        return true;
    }
}
