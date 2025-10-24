import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Eventos1 extends JFrame implements ActionListener{
    
    private JLabel etiqueta1;
    private JButton boton1;

    public Eventos1(){

        super("Controlador de eventos I");
        this.setLayout(new FlowLayout());

        boton1 = new JButton("Pulsame!");
        boton1.addActionListener(this); //esto indica qué activa el boton
        this.add(boton1);

        etiqueta1 = new JLabel("Aun no has pulsado el boton!");
        this.add(etiqueta1);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        this.etiqueta1.setText("Boton pulsado!");
        
        System.err.println("El boton se ha pulsado");
    }

    
}
