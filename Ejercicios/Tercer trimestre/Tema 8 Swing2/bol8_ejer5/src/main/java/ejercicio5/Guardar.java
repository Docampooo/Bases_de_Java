package ejercicio5;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Guardar extends JDialog implements ActionListener{
    
    File f = new File(System.getProperty("user.home") + "\\DatosLotería.txt");

    JTextField txtNombre;

    ArrayList<String> elementos;
    String[] datos;
    JComboBox<String> cbxDatos;
    int cont;

    public Guardar(Loteria l){
        
        super(l, true);
        this.setLayout(null);

        cont = 0;

        txtNombre = new JTextField("Inserta el Nombre");
        txtNombre.setSize(250, 50);
        txtNombre.setLocation(100, 25);
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setFont(new Font("Arial", Font.BOLD, 20));
        txtNombre.addActionListener(this);
        this.add(txtNombre);

        cbxDatos = new JComboBox<String>();
        if(f.exists()){
            try(Scanner q = new Scanner(f)){
    
                while (q.hasNext()) {
                    cbxDatos.addItem(q.nextLine());
                }

            }catch(IOException e){
                System.err.println("Error en el archivo");
            }
        }
        cbxDatos.setMaximumRowCount(10);
        cbxDatos.setLocation(100, 100);
        cbxDatos.setSize(250, 50);
        this.add(cbxDatos);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        Loteria l = (Loteria)this.getOwner();

        if(e.getSource() == txtNombre){
            if(txtNombre.getText().trim().equals("") || txtNombre.getText().trim().equals("Inserta el Nombre")){
                JOptionPane.showMessageDialog(null, "Inserta un nombre", "error en el nombre", JOptionPane.INFORMATION_MESSAGE);
            }else{
                cont++;
                if(cont > 1){
                    JOptionPane.showMessageDialog(null, "Ya se han guardado los datos de esta partida", "Datos ya guardados", JOptionPane.INFORMATION_MESSAGE);
                }else{

                    String pos = txtNombre.getText() + ";" + l.total;
                    cbxDatos.addItem(pos);
                    
                    try(PrintWriter p = new PrintWriter(new FileWriter(f, true))){
                       p.println(pos);

                    }catch(IOException o){
                        System.out.println("Error en el archivo");
                    }
                }
            }
        }
    }
}
