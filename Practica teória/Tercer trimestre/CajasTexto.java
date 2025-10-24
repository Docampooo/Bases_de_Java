import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CajasTexto extends JFrame implements ActionListener{
    
    JLabel lblDni;
    JLabel lblNombre;
    JTextField txtDni;
    JTextField txtNombre;
    JTextField txtInfo;

    public CajasTexto(){
        super("cajas de edicion de texto");
        this.setLayout(new FlowLayout());

        lblDni = new JLabel("Introduza su DNI");
        add(lblDni);

        txtDni = new JTextField(9);
        txtDni.addActionListener(this);
        this.add(txtDni);

        txtNombre = new JTextField("Escriba aqui su nombre");
        txtNombre.addActionListener(this);
        this.add(txtNombre);

        txtInfo = new JTextField("Informacion no modificable", 23);
        txtInfo.setEditable(false);
        txtInfo.addActionListener(this);
        this.add(txtInfo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == txtDni || e.getSource() == txtInfo){
            ((JTextField)e.getSource()).selectAll();
        }

        JOptionPane.showMessageDialog(null, ((JTextField)e.getSource()).getSelectedText() , "Cajas de texto", JOptionPane.INFORMATION_MESSAGE);
    }
}
