package basicos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Etiquetas extends JFrame{

    
    public Etiquetas(){

        super("muchas etiquetas");
        setLayout(null);

        int x = 10, y = 10;

        for(int i = 0; i < 100; i++){
            JLabel lbl = new JLabel(Integer.toString(i+1));
            lbl.setFont(new Font("Arial", Font.BOLD, 12));
            lbl.setForeground(Color.BLUE);
            lbl.setHorizontalAlignment(JLabel.CENTER);

            lbl.setSize(35, 20);
            if(i % 20 == 0){
                x = 10;
                y = y + 30;
            }else{
                x = x + 20;
            }
            lbl.setLocation(x, y);
            lbl.addMouseListener(new MouseHandler());
            this.add(lbl);
        }
    }

    public class MouseHandler extends MouseAdapter{

        @Override
        public void mouseEntered(MouseEvent e) {
            JLabel lbl = (JLabel)(e.getSource());
            lbl.setForeground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JLabel lbl = (JLabel)(e.getSource());
            lbl.setForeground(Color.BLUE);
        }
    }
}
