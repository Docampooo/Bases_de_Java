import java.io.File;
import java.util.Scanner;
public class lecturaArchivo {
    public static void main(String[] args) throws Exception{

        String linea;
        Scanner f = new Scanner(new File("prueba.txt"));

        linea = f.nextLine();//lee 3,14

        System.out.println(Double.parseDouble (linea) * 2); //saca por pantalla el doble de línea pasandolo a un double

        // double numero = f.nextDouble();
        // f.nextLine();
        // System.out.println(numero);

        f.close();
    }
}
