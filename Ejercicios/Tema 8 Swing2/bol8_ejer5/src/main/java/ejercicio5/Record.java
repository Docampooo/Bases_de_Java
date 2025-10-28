package ejercicio5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Record extends JDialog {
    
    JTextArea txt;
    File f = new File(System.getProperty("user.home") + "\\DatosLotería.txt");
    String cad;

    public Record(Loteria l){

        super(l, true);

        txt = new JTextArea();
        this.add(txt);
        cad = "";

        if(f.exists()){

            try(Scanner p = new Scanner(f)){
                while (p.hasNext()) {
                    cad = cad + "\n" + p.nextLine();
                }

            }catch(IOException o){
                System.err.println("Error en el archivo");
            }
        }else{
            System.err.println("el archivo no tiene contenido");
        }
        txt.setText(cad);
    }
}
