package ejercicio5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Loteria extends JFrame implements ActionListener, ItemListener {

    ArrayList<JCheckBox> cubos;
    int max;
    int total;

    JMenuBar mnuPrincipal;

    JMenu mnuDatos;

    JMenuItem mnuGuardar;
    JMenuItem mnuRecords;
    JMenuItem mnuCancelar;

    JLabel lblH1;

    JButton btnJugar;

    public Loteria() {

        super("Lotería primitiva");
        this.setLayout(null);

        lblH1 = new JLabel("Elige 6 números!");
        lblH1.setSize(200, 40);
        lblH1.setLocation(225, 25);
        lblH1.setHorizontalAlignment(JLabel.CENTER);
        lblH1.setFont(new Font("Arial", Font.BOLD, 25));
        this.add(lblH1);

        mnuGuardar = new JMenuItem("Guardar Partida");
        mnuGuardar.setMnemonic('g');
        mnuGuardar.addActionListener(this);

        mnuCancelar = new JMenuItem("Cancelar");
        mnuCancelar.setMnemonic('c');
        mnuCancelar.addActionListener(this);

        mnuRecords = new JMenuItem("Records");
        mnuRecords.setMnemonic('r');
        mnuRecords.addActionListener(this);

        mnuDatos = new JMenu("Datos");
        mnuDatos.setMnemonic('d');
        mnuDatos.add(mnuGuardar);
        mnuDatos.add(mnuRecords);
        mnuDatos.add(mnuCancelar);

        mnuPrincipal = new JMenuBar();
        mnuPrincipal.add(mnuDatos);

        this.setJMenuBar(mnuPrincipal);
        
        cubos = new ArrayList<>();
        max = 0;
        total = 0;

        int x = 40;
        int y = 60;
        for (int i = 1; i < 50; i++) {

            JCheckBox chk = new JCheckBox(Integer.toString(i));
            chk.setSize(50, 50);
            chk.setHorizontalAlignment(JCheckBox.CENTER);
            chk.setFont(new Font("Arial", Font.BOLD, 15));
            chk.addItemListener(this);

            if ((i - 1) % 10 == 0) {
                y = y + 30;
                x = 25;
            } else {
                x = x + 60;
            }
            chk.setLocation(x, y);

            cubos.add(chk);
            this.add(chk);
        }

        btnJugar = new JButton("Jugar!");
        btnJugar.setSize(100, 50);
        btnJugar.setLocation(100, 300);
        btnJugar.setVisible(false);
        btnJugar.addActionListener(this);
        this.add(btnJugar);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource().getClass() == JCheckBox.class) {
            max = 0;
            for (int i = 0; i < cubos.size(); i++) {
                JCheckBox chk = cubos.get(i);

                if (chk.isSelected()) {
                    max++;

                }

                if (max == 6) {
                    btnJugar.setVisible(true);
                } else {
                    btnJugar.setVisible(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJugar) {

            int[] result = new int[6];
            total = 0;
            
            for(int i = 0; i < cubos.size(); i++){
                cubos.get(i).setForeground(null);
            }

            for (int i = 0; i < result.length; i++) {
                int num = (int) (Math.random() * 49 + 0);
                result[i] = num;

                JCheckBox chk = cubos.get(num);
                if(chk.isSelected()){
                    chk.setForeground(Color.GREEN);
                    total++;
                }else{
                    chk.setForeground(Color.RED);
                }
            }
        }

        if(e.getSource() == mnuGuardar){

            Guardar secun = new Guardar(this);

            secun.setSize(500, 300);
            secun.setLocationRelativeTo(null);
            secun.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            secun.setVisible(true);
        }

        if(e.getSource() == mnuRecords){

            Record rec = new Record(this);
            rec.setVisible(true);
            rec.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            rec.pack();
        }
    }

}
