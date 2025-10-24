package ejercicio10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

public class Lista extends JFrame implements ActionListener{
        
    JList lista;

    JLabel lblInfo;

    JButton btnAñadir;
    JButton btnEliminar;

    public Lista(){
        super("Lista de personas");
        setLayout(null);

        lista = new JList<>();
        lista.setSize(200, 200);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
