import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmPrincipal extends JFrame {

    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JButton boton1;
    private JButton boton2;

    // Constructor
    public FrmPrincipal() {
        super("Mi aplicación");
        this.setLayout(null);

        // Etiqueta 1
        etiqueta1 = new JLabel("Etiqueta Uno");
        etiqueta1.setSize(etiqueta1.getPreferredSize());
        etiqueta1.setLocation(0, 0);
        this.add(etiqueta1);

        // Etiqueta 2
        etiqueta2 = new JLabel("Etiqueta Dos");
        etiqueta2.setSize(etiqueta2.getPreferredSize());
        etiqueta2.setLocation(100, 0);
        this.add(etiqueta2);

        // Botón 1
        boton1 = new JButton("Aceptar");
        boton1.setLocation(0, 100);
        boton1.setSize(boton1.getPreferredSize());
        this.add(boton1);

        // Botón 2
        boton2 = new JButton("Cancelar");
        boton2.setSize(boton2.getPreferredSize());
        boton2.setLocation(100, 100);
        this.add(boton2);
    }
}
