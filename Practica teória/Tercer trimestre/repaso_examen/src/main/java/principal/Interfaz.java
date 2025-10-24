package principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import prueba.Astro;
import prueba.Planeta;

public class Interfaz extends JFrame implements ActionListener{

    File f = new File(System.getProperty("user.home")+ "\\planetitas");
    
    JButton btnPlaneta;
    JButton btnSalir;

    JTextField txtDatos;
    JTextField txtLunas;

    JLabel lblInfo;

    JComboBox cbx = new JComboBox<String>();

    public Interfaz(){

        super("Planetas visuales");
        this.setLayout(new FlowLayout());

        cbx = new JComboBox<String>();
        if(f.exists()){
            try(Scanner p = new Scanner(f)){

                while (p.hasNext()) {
                    cbx.addItem(p.nextLine());
                }
            }catch(IOException o){
                System.err.println("No se encuentra el archivo");
            }
        }

        btnPlaneta = new JButton("Añadir Planeta");
        btnPlaneta.setSize(btnPlaneta.getPreferredSize());
        btnPlaneta.addActionListener(this);
        this.add(btnPlaneta);

        btnSalir = new JButton("Salir");
        btnSalir.setSize(btnSalir.getPreferredSize());
        btnSalir.addActionListener(this);
        this.add(btnSalir);

        txtDatos = new JTextField(15);
        txtDatos.setSize(txtDatos.getPreferredSize());
        txtDatos.addActionListener(this);
        this.add(txtDatos);

        lblInfo = new JLabel();
        lblInfo.setSize(lblInfo.getPreferredSize());
        this.add(lblInfo);

        txtLunas = new JTextField(15);
        txtLunas.setSize(txtLunas.getPreferredSize());
        txtLunas.addActionListener(this);
        txtLunas.setVisible(true);
        this.add(txtLunas);

        cbx.setMaximumRowCount(10);
        this.add(cbx);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnPlaneta){

            if(txtDatos.getText().trim().equals("") || txtLunas.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null, "Inserta valores", "Parametros erroneos", JOptionPane.WARNING_MESSAGE);
            }else{

                boolean gaseoso = false;
                
                int eleccion = JOptionPane.showConfirmDialog(null, "Es un planeta gaseosos?", "Tipo de planeta", JOptionPane.YES_NO_OPTION);
                if(eleccion == JOptionPane.YES_NO_OPTION){
                    gaseoso = true;
                }
                
                String[] datos = txtDatos.getText().trim().split("[;]");
                
                String  nombre = datos[0];
                
                double radio = 0;
                try{
                    radio = Double.parseDouble(datos[1]);
                    
                }catch(NumberFormatException | NullPointerException o){
                    JOptionPane.showMessageDialog(null, "Error en los parámetros", "Parametros erroneos", JOptionPane.WARNING_MESSAGE);
                }
                
                Planeta p = new Planeta(nombre, radio, gaseoso);
                cbx.addItem(String.format("%s;%s", txtDatos.getText().trim(), gaseoso?"gaseoso":"No gaseoso"));

                try(PrintWriter q = new PrintWriter(new FileWriter(f, true))){
                    q.println(String.format("%s;%s", txtDatos.getText().trim(), gaseoso?"gaseoso":"No gaseoso"));

                }catch(IOException o){
                    System.err.println("No se encuentra el archivo");
                }
                
                String[] datos2 = txtLunas.getText().trim().split("[;]");
                
                String  nombreSat = datos2[0];
                
                double radioSat = 0;
                try{
                    radioSat = Double.parseDouble(datos2[1]);
                    
                }catch(NumberFormatException | NullPointerException o){
                    JOptionPane.showMessageDialog(null, "Error en los parámetros", "Parametros erroneos", JOptionPane.WARNING_MESSAGE);
                }
                Astro astro = new Astro(nombreSat, radioSat);
                p.satelites.add(astro);
                
            }
        }

        if(e.getSource() == btnSalir){
            System.exit(0);
        }
    }
}
