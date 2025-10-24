import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {

        String archivo = "Ventas.txt";
        if (args.length > 0) {
            archivo = args[0];
        }
        File f = new File(archivo);
        Scanner p = new Scanner(new File(archivo));

        Ventas ventas;

        if (f.exists()) {
            int ano = p.nextInt();
            int[] valores = new int[12];

            p.nextLine();
            String cadena = p.nextLine();
            String linea[] = cadena.split(";");
            
            for (int i = 0; i < valores.length; i++) {
                valores[i] = Integer.parseInt(linea[i].trim());
            }

            p.close();
            ventas = new Ventas(ano, valores);
        } else {

            Calendar cal = Calendar.getInstance();
            int anoActual = cal.get(Calendar.YEAR);

            ventas = new Ventas(anoActual - 1);
        }

        System.out.println("La media es: " + ventas.medias());

        ventas.grafica();

        PrintWriter q = new PrintWriter(archivo);

        q.println(ventas.getAno());
        for (int i = 0; i < 12; i++) {
            q.printf("%4d;", ventas.ventas[i]);
        }
        q.close();
    }
}
