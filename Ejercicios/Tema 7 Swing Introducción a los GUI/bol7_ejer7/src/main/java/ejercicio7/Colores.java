package ejercicio7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.IntegerSyntax;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Colores extends JFrame implements ActionListener{

    public boolean comprobarNumero(String cadena){

        int num;

        if(cadena.trim().equals("")){
            return true;
        }

        try {
           num = Integer.parseInt(cadena.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Parámetro erróneo, solo se admiden numeros enteros entre el 0 y el 255", "Parámetro erróneo", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if(num < 0 || num > 255){
            JOptionPane.showMessageDialog(null, "Las propiedades RGB están en un rango de 0 a 255", "Parámetro fuera de rango", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public int conversorTexto(String cadena){

        int num;
        if(cadena.trim().equals("")){
            num = 0;
        }else{
            num = Integer.parseInt(cadena);
        }

        return num;
    }
    
    
    JTextField txtR;
    JTextField txtG;
    JTextField txtB;

    JButton btn;

    JTextField txtImagen;
    JLabel lblImagen;

    public Colores(){

        super("Jugar con colores, imagenes y teclas");
        this.setLayout(new FlowLayout());

        txtR = new JTextField();
        txtR.setPreferredSize(new Dimension(125, 30));
        txtR.setToolTipText("Int de la propiedad roja del color, de 0 a 255");
        this.add(txtR);

        txtG = new JTextField();
        txtG.setPreferredSize(new Dimension(125, 30));
        txtG.setToolTipText("Int de la propiedad verde del color, de 0 a 255");
        this.add(txtG);

        txtB = new JTextField();
        txtB.setPreferredSize(new Dimension(125, 30));
        txtB.setToolTipText("Int de la propiedad azul del color, de 0 a 255");
        txtB.addActionListener(this);
        this.add(txtB);

        btn = new JButton("Crear Color");
        btn.setPreferredSize(new Dimension(150, 50));
        btn.setToolTipText("Al pulsar el botón crea el color usando las propiedades RGB proporcionadas en los prompts y lo establece de fondo, si se está pulsado la tecla SHIFT simultaneamente, cambiará el color del texto del botón");
        btn.addActionListener(this);
        this.add(btn);

        txtImagen = new JTextField();
        txtImagen.setPreferredSize(new Dimension(125, 30));
        txtImagen.setToolTipText("Introduce la ruta completa de una imagen y se cargará en una etiqueta");
        txtImagen.addActionListener(this);
        this.add(txtImagen);

        lblImagen = new JLabel();
        lblImagen.setSize(new Dimension(200, 200));
        this.add(lblImagen);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btn || e.getSource() == txtB){

            if(comprobarNumero(txtR.getText()) && comprobarNumero(txtG.getText()) && comprobarNumero(txtB.getText())){
                
                int R = conversorTexto(txtR.getText());
                int G = conversorTexto(txtG.getText());
                int B = conversorTexto(txtB.getText());
                
                if((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK){

                    btn.setForeground(new Color(R, G, B));
                }else{
                    btn.setBackground(new Color(R, G, B));
                }

            }
        }

        if(e.getSource() == txtImagen){

            lblImagen.setIcon(new ImageIcon(txtImagen.getText()));
        }
    }
    
}
