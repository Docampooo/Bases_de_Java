import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Eventos2 extends JFrame implements ActionListener {

    private JLabel etiqueta1;
    private JButton botonIncremento;
    private JButton botonDecremento;
    private JLabel lblPrueba;
    private JButton btnSalir;

    int contador;

    public Eventos2() {
        super("Controlador de eventos II");
        this.setLayout(new FlowLayout());

        contador = 0;

        lblPrueba = new JLabel("Prueba");
        lblPrueba.setForeground(new Color(10, 132, 245));
        lblPrueba.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
        this.add(lblPrueba);

        botonIncremento = new JButton("Incremento");
        botonIncremento.addActionListener(this);
        this.add(botonIncremento);

        botonDecremento = new JButton("Decremento");
        botonDecremento.addActionListener(this);
        this.add(botonDecremento);

        etiqueta1 = new JLabel(contador + "");
        this.add(etiqueta1);

        btnSalir = new JButton("Salir");
        btnSalir.setToolTipText("Sale de la aplicación");
        btnSalir.addActionListener(this);
        this.add(btnSalir);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        int salto = 1;

        this.setTitle(evento.getActionCommand()); // no entiendo muy bien que es esto

        if ((evento.getModifiers() & ActionEvent.SHIFT_MASK) == ActionEvent.SHIFT_MASK) {
            salto = 10;
        }

        if (evento.getSource() == botonIncremento) {
            contador += salto;
        }

        if (evento.getSource() == botonDecremento) {
            contador -= salto;
        }

        if(evento.getSource() == btnSalir){
            System.exit(0);
        }

        etiqueta1.setText(String.format("%10d", contador));
    }

}
