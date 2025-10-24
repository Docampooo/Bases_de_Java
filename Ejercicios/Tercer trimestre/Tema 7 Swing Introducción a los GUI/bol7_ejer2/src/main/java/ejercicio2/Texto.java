package ejercicio2;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Texto extends JFrame implements ActionListener, ItemListener {// TODO gestionar bien el check y el titulo
                                                                           // en eljoptionpane

    private JLabel lblTexto;
    private JButton btn;
    private JTextField txt;

    private JCheckBox chk;
    private JCheckBox chkQuitar;

    public Texto() {

        super("Prueba TextField");
        this.setLayout(new FlowLayout());

        lblTexto = new JLabel(
                "Para cambiar el titulo del programa introduce un texto en el prompt y pulsa enter o dale al boton");
        this.add(lblTexto);

        txt = new JTextField(10);
        txt.addActionListener(this);
        this.add(txt);

        btn = new JButton();
        btn.addActionListener(this);
        this.add(btn);

        chk = new JCheckBox("Del revés");
        this.add(chk);

        chkQuitar = new JCheckBox("Habilitar/deshabilitar prompt");
        chkQuitar.addItemListener(this);
        this.add(chkQuitar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn || e.getSource() == txt) {
            int eleccion = JOptionPane.showConfirmDialog(null, "cambiar titulo",
                    "cambiar el titulo del programa a " + txt.getText() + "?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            switch (eleccion) {
                case JOptionPane.YES_OPTION:

                    String titulo;
                    if (chk.isSelected()) {
                        titulo = "";

                        for (int i = txt.getText().length() - 1; i >= 0; i--) {
                            titulo = titulo + this.getTitle().charAt(i);
                        }
                        this.setTitle(titulo);
                    }else{
                        this.setTitle(txt.getText());
                    }
                    JOptionPane.showMessageDialog(null, "Se ha cambiado el titulo a " + this.getTitle());

                    break;

                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(null, "No has cambiado nada");

                    break;
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        // if (chkQuitar.isSelected()) {
        //     txt.setEditable(false);
        // } else {
        //     txt.setEditable(true);
        // }
        txt.setEditable(!chkQuitar.isSelected()); //lo hizo pablo 
    }

}
