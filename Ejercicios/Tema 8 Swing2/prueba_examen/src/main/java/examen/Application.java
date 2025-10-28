
package examen;

import javax.swing.JFrame;

public class Application {
  public static void main(String[] args) {
    
    Principal prin = new Principal();

    prin.setVisible(true);
    prin.setSize(700, 700);
    prin.setLocationRelativeTo(null);
    prin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
