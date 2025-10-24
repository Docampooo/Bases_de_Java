import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
    JMenuBar mnuPrincipal;
    JMenu mnuArchivo, mnuEdicion, mnuEstilo;
    JMenuItem mnuAbrir, mnuGuardar, mnuSalir, mnuCopiar, mnuNegrita;
    JLabel lbl;

    public Menu() {
        super("Menú simple");
        setLayout(new FlowLayout());
        // Menú Archivo
        mnuAbrir = new JMenuItem("Abrir");
        mnuAbrir.setMnemonic('A');
        mnuAbrir.addActionListener(this);
        mnuGuardar = new JMenuItem("Guardar");
        mnuGuardar.setMnemonic('G');
        mnuGuardar.addActionListener(this);
        mnuSalir = new JMenuItem("Salir");
        mnuSalir.setMnemonic('S');
        mnuSalir.addActionListener(this);
        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setMnemonic('A');
        mnuArchivo.add(mnuAbrir);
        mnuArchivo.add(mnuGuardar);

        // Menú Edición
        mnuNegrita = new JMenuItem("<html><b>Negrita</b></html>");
        mnuNegrita.addActionListener(this);
        mnuNegrita.addActionListener(this);
        mnuEstilo = new JMenu("Estilo");
        mnuEstilo.setMnemonic('E');
        mnuEstilo.add(mnuNegrita);
        mnuEstilo.addActionListener(this);
        mnuCopiar = new JMenuItem("Copiar");
        mnuCopiar.setMnemonic('C');
        mnuCopiar.addActionListener(this);
        mnuEdicion = new JMenu("Edicion");
        mnuEdicion.setMnemonic('E');
        mnuEdicion.add(mnuEstilo);
        mnuEdicion.addSeparator();
        mnuEdicion.add(mnuCopiar);
        // Menú Principal
        mnuPrincipal = new JMenuBar();
        mnuPrincipal.add(mnuArchivo);
        mnuPrincipal.add(mnuEdicion);
        this.setJMenuBar(mnuPrincipal);
        lbl = new JLabel();
        add(lbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lbl.setText(e.getActionCommand());
    }
}
