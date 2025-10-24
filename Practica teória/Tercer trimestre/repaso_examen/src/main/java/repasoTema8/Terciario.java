package repasoTema8;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Terciario extends JDialog implements ItemListener{
    
    File f = new File(System.getProperty("user.home"));
    JComboBox<String> cbxArchivos; 

    JTextArea txtInfo;
    JScrollPane scroll;

    Pruebas prueba;

    public Terciario(Pruebas p){

        super(p, true);
        this.setLayout(new FlowLayout());

        cbxArchivos = new JComboBox<>(f.list());
        cbxArchivos.setMaximumRowCount(10);
        cbxArchivos.addItemListener(this);
        this.add(cbxArchivos);

        txtInfo = new JTextArea(15, 15);
        this.add(txtInfo);

        scroll = new JScrollPane(txtInfo);
        this.add(scroll);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        if(e.getSource() == cbxArchivos){

            File p = new File(f.getPath() + "\\" + cbxArchivos.getSelectedItem());

            if(p.isFile()){
                txtInfo.setText(String.format("[FILE] su tamaño en bytes es: %l",cbxArchivos.getSelectedItem(), p.length()));
            }else{
                if(p.isDirectory()){
                    for(int i = 0; i < p.list().length; i++){
                        File o = new File(p.getPath(), p.list()[i]);

                        if(o.isFile()){
                            txtInfo.append(String.format("<html>[FILE] %s ocupa: %l<br></html>", o.getName()));
                        }else{
                            txtInfo.append(String.format("<html>[DIR] %s<br></html>",o.getName()));
                        }
                    }
                }
            }
        }
    }
}
