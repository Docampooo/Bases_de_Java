package repasoTema8;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Secundario extends JDialog implements ActionListener{

    JLabel lblPrueba;
    JLabel lblHerencia;

    JLabel lblInfo;
    JTextField txtMarca;
    JButton btnAñadir;

    JComboBox<String> cbxMarcas; 

    File f = new File(System.getProperty("user.home") + "\\marquitas");

    JButton btnHerencia;

    Pruebas prueba;
    
    public Secundario(Pruebas p){

        super(p, true);
        this.setLayout(new FlowLayout());
        JOptionPane.showMessageDialog(null, "Vivan los formularios secundario");

        lblPrueba = new JLabel("Esto es una pruebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        this.add(lblPrueba);

        lblHerencia = new JLabel();
        this.add(lblHerencia);

        btnHerencia = new JButton("Pulsame");
        btnHerencia.addActionListener(this);
        this.add(btnHerencia);

        lblInfo = new JLabel();
        lblInfo.setPreferredSize(lblInfo.getPreferredSize());
        this.add(lblInfo);

        cbxMarcas = new JComboBox<String>();
        cbxMarcas.setMaximumRowCount(10);
        this.add(cbxMarcas);
        if(f.exists()){
            try(Scanner q = new Scanner(f)){
                
                while (q.hasNext()) {
                    String cad = q.nextLine();
                    cbxMarcas.addItem(cad);
                    lblInfo.setText(String.format("%s \n",lblInfo.getText(), cad));
                }
                
            }catch(IOException o){
                System.err.println("Error en el archivo");
            }
        }

        btnAñadir = new JButton("Añadir");
        btnAñadir.setPreferredSize(btnAñadir.getPreferredSize());
        btnAñadir.addActionListener(this);
        this.add(btnAñadir);

        txtMarca = new JTextField(15);
        txtMarca.setPreferredSize(txtMarca.getPreferredSize());
        this.add(txtMarca);

        prueba = (Pruebas)this.getOwner();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnHerencia){

            lblHerencia.setText(prueba.lblInfo.getText());
        }

        if(e.getSource() == btnAñadir){
            
            if(txtMarca.getText().equals("")){
                JOptionPane.showMessageDialog(null, "No hay nada que añadir", "error", JOptionPane.INFORMATION_MESSAGE);
            }else{

                try(PrintWriter t = new PrintWriter(new FileWriter(f, true))){

                    cbxMarcas.addItem(txtMarca.getText());
                    t.println(txtMarca.getText());
                    prueba.lblTeclas.setText(txtMarca.getText());
                
                }catch(IOException o){
                    System.err.println("Error en el archivo");
                }
            }
        }
    }
}
