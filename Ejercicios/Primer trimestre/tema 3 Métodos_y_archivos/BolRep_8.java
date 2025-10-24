import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class BolRep_8 {

    public static void desc() throws Exception {
        PrintWriter f = new PrintWriter(new File("Rep8.txt"));
        f.printf("los numeros del 50 al 0 de forma decreciente son: \n");
        for (int cont = 50; cont > 0; cont--) {
            f.printf("%3d \t", cont);

        }
        f.close();
    }

    public static void multiplos() throws Exception {
        Scanner g = new Scanner(new File("Rep8.txt"));
        String cadena = "";
        while (g.hasNext()) {
            cadena = cadena + g.nextLine();
        }
        g.close();

        PrintWriter f = new PrintWriter(new File("Rep8.txt"));
        f.println(cadena);
        for (int cont = 70; cont >= 25; cont--) {
            if (cont % 5 == 0) {
                f.println(cont);
            }
        }
        f.close();
    }

    public static void menores() throws Exception {
        Scanner g = new Scanner(new File("Rep8.txt"));
        String cadena = "";
        while (g.hasNext()) {
            cadena = cadena + g.nextLine();
        }
        g.close();

        PrintWriter f = new PrintWriter("Rep8.txt");
        f.println(cadena);
        for(int cont=0;cont<20;cont++){
            if(cont%2==0){
                System.out.println(cont);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        desc();

        multiplos();
    }
}
