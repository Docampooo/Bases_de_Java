package ejer2;

import java.awt.Color;
import java.awt.Font;
import java.awt.JobAttributes;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Movil extends JFrame implements ActionListener {

    File f = new File(System.getProperty("user.home") + "\\Numeros.txt");
    JTextField txtNumeros;

    JMenuBar mnuPrincipal;
    JMenu mnuArchivo, mnuMovil, mnuOtros;
    JMenuItem mnuGrabar, mnuLeer, mnuReset, mnuSalir, mnuInfo;

    ArrayList<String> numeros;
    JButton[] indiceBtn;
    String[] caracteres;

    JButton btnReset;


    public Movil() {

        super("Movil antiguo");
        setLayout(null);

        numeros = new ArrayList<>();
        caracteres = new String[]{"1","2","3","4","5","6","7","8","9","#","0","*"};

        try(Scanner p = new Scanner(f)){ //Comprobar

            while (p.hasNext()) {
                numeros.add(p.nextLine());
            }
        }catch(IOException o){
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo", "Error en el archivo",
                        JOptionPane.WARNING_MESSAGE);
        }

        // Menu Archivo
        mnuGrabar = new JMenuItem("Grabar Número");
        mnuGrabar.addActionListener(this);

        mnuLeer = new JMenuItem("Leer Número");
        mnuLeer.addActionListener(this);

        mnuArchivo = new JMenu("Archivo");
        mnuArchivo.setMnemonic(KeyEvent.VK_A);
        mnuArchivo.add(mnuGrabar);
        mnuArchivo.add(mnuLeer);

        // Menu Movil
        mnuReset = new JMenuItem("Resetear");
        mnuReset.addActionListener(this);

        mnuSalir = new JMenuItem("Salir");
        mnuSalir.addActionListener(this);

        mnuMovil = new JMenu("Movil");
        mnuMovil.setMnemonic(KeyEvent.VK_M);
        mnuMovil.add(mnuReset);
        mnuMovil.addSeparator();
        mnuMovil.add(mnuSalir);

        // Menu Otros
        mnuInfo = new JMenuItem("Acerca de...");
        mnuInfo.addActionListener(this);

        mnuOtros = new JMenu("Otros");
        mnuOtros.setMnemonic(KeyEvent.VK_O);
        mnuOtros.add(mnuInfo);

        // Menu Principal
        mnuPrincipal = new JMenuBar();
        mnuPrincipal.add(mnuArchivo);
        mnuPrincipal.add(mnuMovil);
        mnuPrincipal.add(mnuOtros);
        this.setJMenuBar(mnuPrincipal);

        int x = 25;
        int y = 25;
        int cont = -1;
        indiceBtn = new JButton[12];

        for (int i = 0; i < 12; i++) {
            JButton btn = new JButton();

            String[] caracteres = { "#", "0", "*" };

            btn.setLocation(x, y);
            btn.setSize(110, 110);
            btn.setFont(new Font("Arial", Font.BOLD, 30));
            btn.addKeyListener(new KeyHandler());
            btn.setBackground(Color.WHITE);

            if ((i + 1) % 3 == 0) {
                x = 25;
                y = y + 120;
            } else {
                x = (x + 120);
            }

            if (i < 9) {
                btn.setText(Integer.toString(i + 1));
            } else {
                cont++;
                btn.setText(caracteres[cont]);
            }

            indiceBtn[i] = btn;
            btn.addMouseListener(new MouseHandler());
            btn.addActionListener(this);
            this.add(btn);
        }

        txtNumeros = new JTextField();
        txtNumeros.setSize(350, 75);
        txtNumeros.setLocation(25, 510);
        txtNumeros.setHorizontalAlignment(JTextField.CENTER);
        txtNumeros.setEditable(false);
        this.add(txtNumeros);

        btnReset = new JButton("X");
        btnReset.setSize(75, 75);
        btnReset.setLocation(125, 600);
        btnReset.addActionListener(this);
        btnReset.setToolTipText("Boton reset");
        this.add(btnReset);

        this.setFocusable(true);
        addKeyListener(new KeyHandler());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().getClass() == JButton.class) {

            JButton btn = (JButton) e.getSource();

            txtNumeros.setText(txtNumeros.getText() + btn.getText());

            if (e.getSource() == btnReset) {

                txtNumeros.setText("");
                for (int i = 0; i < indiceBtn.length; i++) {
                    indiceBtn[i].setBackground(Color.WHITE);
                }
                this.setFocusable(true);
                this.requestFocusInWindow(true); // Esto está bien utilizado para devolver el focus al JFrame?
            }
        }

        if (e.getSource() == mnuGrabar) {

            numeros.add(txtNumeros.getText());

            try (PrintWriter p = new PrintWriter(new FileWriter(f))) {
                for (int i = 0; i < numeros.size(); i++) {
                    p.println(numeros.get(i));
                }
            } catch (IOException o) {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo", "Error en el archivo",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == mnuLeer) {

            String cadena = "";
            for (int i = 0; i < numeros.size(); i++) {
                cadena = cadena + "\n" + (i + 1) + ": " + numeros.get(i);
            }

            if (cadena.equals("")) {
                JOptionPane.showMessageDialog(null, "No hay números de teléfono guardados", "Falta de datos",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, cadena, "Numeros guardados", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == mnuReset) {

            int eleccion = JOptionPane.showConfirmDialog(null,
                    "Seguro que quieres eliminar el historial de números de teléfono?", "Confirmación de reset",
                    JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {

                try (PrintWriter q = new PrintWriter(new FileWriter(f))) {
                    q.print("");
                } catch (IOException o) {
                    System.err.println("Fallo en el archivo");
                }

                numeros.clear();
                JOptionPane.showMessageDialog(null, "Se ha reseteado el historial de números de teléfono",
                        "Archivo reseteado", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (e.getSource() == mnuSalir) {
            System.exit(0);
        }

        if (e.getSource() == mnuInfo) {
            JOptionPane.showMessageDialog(null,
                    "Este es un programa hecho para simular el funcionamiento de un móvil antiguo, donde se pueden guardar y mostrar teléfonos de un archivo"
                            + "\n" + "El autor del mini móvil es Nicolás Docampo, todo un novato de la programación",
                    "Autor & Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public class MouseHandler extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {

            JButton btn = (JButton) e.getSource();
            if (!btn.getBackground().equals(Color.GREEN)) {
                btn.setBackground(new Color(0, 100, 200));
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            JButton btn = (JButton) e.getSource();

            btn.setBackground(Color.GREEN);
        }

        @Override
        public void mouseExited(MouseEvent e) {

            JButton btn = (JButton) e.getSource();
            if (!btn.getBackground().equals(Color.GREEN)) {
                btn.setBackground(Color.WHITE);
            }
        }
    }

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            
            for(int i = 0; i < caracteres.length;i++){
                if(e.getKeyChar() == caracteres[i].charAt(0)){
                    txtNumeros.setText(txtNumeros.getText() + e.getKeyChar());

                    indiceBtn[i].setBackground(Color.GREEN);
                }
            }
        }
    }
}
