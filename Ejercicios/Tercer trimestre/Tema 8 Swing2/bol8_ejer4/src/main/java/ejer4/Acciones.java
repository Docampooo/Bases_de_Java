package ejer4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Acciones extends JFrame implements ActionListener, ItemListener {

    JComboBox cbA;
    String[] elementos;
    ArrayList<String> elem1;
    ArrayList<String> elem2;

    JComboBox cbB;

    JButton btnAñadir;
    JButton btnQuitar;
    JButton btnTraspasar1;
    JButton btnTraspasar2;

    JTextField txt1;
    JTextField txt2;

    JLabel lblElementos;
    JLabel lblIndice;
    JLabel lbl3;

    Timer tmr;
    int contSeg;

    String cad;

    public Acciones() {

        super("Funciones con texto");
        this.setLayout(null);

        txt1 = new JTextField();
        txt1.setFont(new Font("Arial", ABORT, 15));
        txt1.setHorizontalAlignment(JTextField.CENTER);
        txt1.setSize(200, 50);
        txt1.setLocation(25, 25);
        txt1.addActionListener(this);
        this.add(txt1);

        txt2 = new JTextField();
        txt2.setFont(new Font("Arial", ABORT, 15));
        txt2.setHorizontalAlignment(JTextField.CENTER);
        txt2.setSize(200, 50);
        txt2.setLocation(250, 25);
        this.add(txt2);

        btnAñadir = new JButton("Añadir");
        btnAñadir.setSize(75, 75);
        btnAñadir.setLocation(25, 125);
        btnAñadir.setHorizontalAlignment(JButton.CENTER);
        btnAñadir.addActionListener(this);
        btnAñadir.setBackground(Color.WHITE);
        btnAñadir.addMouseListener(new MouseHandler());
        btnAñadir.setToolTipText("Se añade el texto del textField de la izquierda al combobox de la izquierda");
        this.add(btnAñadir);

        btnQuitar = new JButton("Quitar");
        btnQuitar.setSize(75, 75);
        btnQuitar.setLocation(125, 125);
        btnQuitar.setHorizontalAlignment(JButton.CENTER);
        btnQuitar.addActionListener(this);
        btnQuitar.setBackground(Color.WHITE);
        btnQuitar.addMouseListener(new MouseHandler());
        btnQuitar.setToolTipText(
                "elimina la cadena que contenga del combobox izquiedo, si no tiene nada elimina el contenido del textField de la izquierda");
        this.add(btnQuitar);

        btnTraspasar1 = new JButton("cbA --> cbB");
        btnTraspasar1.setSize(100, 75);
        btnTraspasar1.setLocation(225, 125);
        btnTraspasar1.setHorizontalAlignment(JButton.CENTER);
        btnTraspasar1.setFont(new Font("Arial", ABORT, 12));
        btnTraspasar1.addActionListener(this);
        btnTraspasar1.setBackground(Color.WHITE);
        btnTraspasar1.addMouseListener(new MouseHandler());
        btnTraspasar1.setToolTipText("traspasa al combobox de la derecha el elemento seleccionado");
        this.add(btnTraspasar1);

        btnTraspasar2 = new JButton("cbA <-- cbB");
        btnTraspasar2.setSize(100, 75);
        btnTraspasar2.setLocation(350, 125);
        btnTraspasar2.setHorizontalAlignment(JButton.CENTER);
        btnTraspasar2.setFont(new Font("Arial", ABORT, 12));
        btnTraspasar2.addActionListener(this);
        btnTraspasar2.setBackground(Color.WHITE);
        btnTraspasar2.addMouseListener(new MouseHandler());
        btnTraspasar2.addMouseMotionListener(new MouseHandler());
        btnTraspasar2.setToolTipText("traspasa al combobox de la izquierda el elemento seleccionado");

        this.add(btnTraspasar2);

        elementos = new String[] {};
        elem1 = new ArrayList<>();
        elem2 = new ArrayList<>();

        cbA = new JComboBox<>(elementos);
        cbA.setMaximumRowCount(8);
        cbA.setLocation(25, 225);
        cbA.setSize(100, 30);
        cbA.addItemListener(this);
        cbA.setToolTipText("combobox con los elementos añadidos por el usuario en el textfield de la izquierda");
        this.add(cbA);

        cbB = new JComboBox<>();
        cbB.setMaximumRowCount(8);
        cbB.setLocation(150, 225);
        cbB.setSize(100, 30);
        cbB.addItemListener(this);
        cbB.setToolTipText("No hay elementos en el combobox");
        this.add(cbB);

        lblElementos = new JLabel();
        lblElementos.setSize(200, 30);
        lblElementos.setLocation(25, 275);
        lblElementos.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblElementos);

        lblIndice = new JLabel();
        lblIndice.setSize(200, 30);
        lblIndice.setLocation(25, 300);
        lblIndice.setHorizontalAlignment(JLabel.CENTER);
        this.add(lblIndice);

        tmr = new Timer(1000, this);
        tmr.start();

        contSeg = 0;

        lbl3 = new JLabel();
        lbl3.setSize(100, 30);
        lbl3.setLocation(25, 360);
        lbl3.setHorizontalAlignment(JLabel.CENTER);
        this.add(lbl3);

        this.addWindowListener(new WindowHandler());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tmr) {

            contSeg++;

            if (contSeg % 60 == 0) {
                contSeg = 0;

                cbA.removeAllItems();
                cbB.removeAllItems();

                txt1.setText("");
                txt2.setText("");
            }

            if (contSeg >= 50) {
                lbl3.setForeground(Color.RED);
            } else {
                lbl3.setForeground(null);
            }

            lbl3.setText(contSeg + "");
        }

        if (e.getSource() == btnAñadir || e.getSource() == txt1) {
            añadirTexto();
        }

        if (e.getSource() == btnQuitar) {
            contSeg = 0;
            cad = txt2.getText();

            if (cad.trim().equals("")) {
                txt1.setText("");
            } else {
                if (elem1.size() > 0) {
                    String infoBorrado = "";
                    for (int i = elem1.size() - 1; i >= 0; i--) {
                        if (elem1.get(i).startsWith(cad)) {
                            infoBorrado = infoBorrado + " " + elem1.get(i);

                            elem1.remove(i);
                            cbA.removeItemAt(i);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se han elimindo las cadenas: " + infoBorrado,
                            "Borrado exitoso", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "La librería está vacía, no se puede eliminar ningún elemento",
                            "Error de parámetro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            actualizarEtiquetas();
        }

        if (e.getSource() == btnTraspasar1) {

            contSeg = 0;
            if (cbA.getItemCount() != 0) {

                String cambio = cbA.getSelectedItem().toString();
                cbB.addItem(cambio);

                for (int i = elem1.size() - 1; i >= 0; i--) {

                    if (elem1.get(i).equals(cambio)) {
                        elem2.add(elem1.get(i));

                        elem1.remove(i);
                        cbA.removeItemAt(i);
                    }

                    actualizarEtiquetas();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede traspasar el valor porque el combo está vacío",
                        "Contenedor vacío", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == btnTraspasar2) {

            contSeg = 0;
            if (cbB.getItemCount() != 0) {
                String cambio = cbB.getSelectedItem().toString();
                cbA.addItem(cambio);

                for (int i = elem2.size() - 1; i >= 0; i--) {

                    if (elem2.get(i).equals(cambio)) {

                        elem1.add(elem2.get(i));

                        elem2.remove(i);
                        cbB.removeItemAt(i);
                    }

                    actualizarEtiquetas();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede traspasar el valor porque el combo está vacío",
                        "Contenedor vacío", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                JButton btn = (JButton) e.getSource();

                btn.setBackground(Color.BLUE);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource().getClass() == JButton.class) {
                JButton btn = (JButton) e.getSource();

                btn.setBackground(Color.WHITE);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cbA || e.getSource() == cbB) {

            int indice = cbA.getSelectedIndex() + 1;
            lblIndice.setText(String.format("Indice del elemento de cbA: %s", Integer.toString(indice)));

            if (indice == -1) {
                lblIndice.setText(String.format("Indice del elemento de cbA: %s", 0));
            }

            if (cbB.getItemCount() != 0) {
                cbB.setToolTipText(String.format("Indice del elemento: %s", Integer.toString(cbB.getItemCount())));
            }
        }
    }

    public class WindowHandler extends WindowAdapter{
        
        @Override
        public void windowClosing(WindowEvent e) {
            int opcion = JOptionPane.showConfirmDialog(null, "Quieres cerrar el programa?", "Cerrar el programa", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if(opcion == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
    }

    public void añadirTexto() {
        cad = txt1.getText().trim();

        for (String c : cad.split("[;]")) {

            if (!c.trim().equals("")) {
                cbA.addItem(c);
                elem1.add(c);

            }
        }
    }

    public void actualizarEtiquetas() {
        int numElementos = cbA.getItemCount();
        lblElementos.setText(String.format("Num elementos de cbA: %s", Integer.toString(numElementos)));
    }

}
