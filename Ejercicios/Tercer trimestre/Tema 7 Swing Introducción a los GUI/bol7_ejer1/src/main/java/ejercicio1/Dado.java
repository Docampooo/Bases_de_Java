package ejercicio1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.*;

public class Dado extends JFrame implements ActionListener {

    private JLabel lbl;
    private JButton btn;

    private JLabel lblInfo;
    private JTextField txt;
    
    private JLabel lblAviso;

    public Dado() {
        super("Dado de seis caras");
        this.setLayout(new FlowLayout());

        lbl = new JLabel("");
      //  lbl.setSize(getPreferredSize());
        this.add(lbl);

        btn = new JButton("Dado");
        btn.setSize(getPreferredSize());
        btn.addActionListener(this);
        this.add(btn);

        lblInfo = new JLabel("Introduce un número real");
        lblInfo.setSize(getPreferredSize());
        this.add(lblInfo);

        txt = new JTextField(9);
        txt.setSize(getPreferredSize());
        txt.setEditable(true);
        this.add(txt);

        lblAviso = new JLabel("");
        lblAviso.setSize(getPreferredSize());
        this.add(lblAviso);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // cont = 0;
        // if(e.getSource() == btn){
        // cont = (int) (Math.random()*6+1);

        // lbl.setText(Integer.toString(cont));
        // }
        lblAviso.setText("");
        int num = 0;
        int result = 0;
        if (e.getSource() == btn) {
            try {
                num = Integer.parseInt(txt.getText());
            } catch (NumberFormatException e1) {
                System.err.println("El parámetro de la caja de texto no es un número real");
                lblAviso.setText("El parámetro de la caja de texto no es un número real");
            }

            if (num > 1) {
                result = (int) (Math.random() * num + 1);
            } else {
                result = (int) (Math.random() * 6 + 1);
            }
            lbl.setText(Integer.toString(result));
        }
    }
}
