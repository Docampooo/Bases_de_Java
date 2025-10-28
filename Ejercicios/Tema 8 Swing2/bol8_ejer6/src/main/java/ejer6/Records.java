package ejer6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Records extends JDialog implements ActionListener{
    
    File f;
    JComboBox cmbRec;

    JTextField txtNombre;

    public Records(Bombas b){

        super(b, true);
        this.setLayout(null);

        f = new File("puntuacion.txt");

        cmbRec = new JComboBox<String>();
        cmbRec.setMaximumRowCount(10);
        this.add(cmbRec);

        if (f.exists()) {
            try (Scanner p = new Scanner(f)) {

                while (p.hasNext()) {
                    cmbRec.addItem((String)p.nextLine());

                }
            } catch (IOException o) {
                System.err.println("Error en el archivo");
            }
        }

        txtNombre = new JTextField("Inserta tu nombre");
        txtNombre.addActionListener(this);
        this.add(txtNombre);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == txtNombre){

            if(txtNombre.getText().trim().equals("") || txtNombre.getText().trim().equals("Inserta tu nombre")){
                JOptionPane.showMessageDialog(null, "Inserta un nombre", "Nombre no válido", JOptionPane.INFORMATION_MESSAGE);

            }else{
                try(PrintWriter q = new PrintWriter(f)){
                    Bombas b = (Bombas)this.getOwner();
                    LocalDate fecha = LocalDate.now();

                    q.println(String.format("%s;%d;%s", txtNombre.getText(), fecha)); //TODO me quede aqui

                }catch(IOException o){
                    System.err.println("Error en el archivo");
                }
            }
        }    
    }
}
