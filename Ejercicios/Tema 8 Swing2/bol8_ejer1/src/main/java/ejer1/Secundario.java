package ejer1;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Secundario extends JDialog implements ItemListener{

    JComboBox<String> cbx;
    JTextArea txa;
    JScrollPane scroll;
    String ruta = System.getProperty("user.home");
    String[] texto;
    String[] total;
    
    File f = new File(ruta);

    public Secundario(Raton t){

        super(t, true);
        setLayout(new FlowLayout());
        setTitle("Ejercicio1.0");

        cbx = new JComboBox<String>(f.list());
        cbx.setMaximumRowCount(8);
        cbx.addItemListener(this);
        add(cbx);
 
        txa = new JTextArea(10,10);
        add(txa);

        scroll = new JScrollPane(txa);
        add(scroll);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String cadena = (String)(cbx.getSelectedItem());

        File i = new File(ruta, cadena);

        if(i.isFile()){
            
            txa.setText(String.format("El tamaño del archivo es:%d bytes", i.length()));

        }else if(i.isDirectory()){
            String[] lista = i.list();

            if(lista.length == 0){
                txa.setText("[DIR] El directorio está vacío: \n");

            }else{
                txa.setText("[DIR] El directorio contiene: \n");

                for(int q = 0; q<lista.length; q++){

                    String ruta2 = i.getPath();
                    File elemento = new File(ruta2, lista[q]);

                    if(elemento.isFile()){
                        txa.append("\t" + "[FILE] " + lista[q] + "\n");
                    }else{
                        txa.append("\t" + "[DIR] " + lista[q] + "\n");
                    }
                }
            }
        }
    }
}