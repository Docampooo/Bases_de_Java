import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class BolRep6 {

    public static void mayor(double n1, double n2, double n3)throws Exception{
        double result=0;
        PrintWriter f = new PrintWriter(new File("rep6.txt"));
        f.println("el numero más grande es: ");
        if((n1 >= n2)&&(n1 >= n3)){
            result = n1;
            f.println(result);
        } else if((n2 > n1) && (n2 >= n3)){
            result = n2;
            f.println(result);
            } else{
                result = n3;
                f.println(result);
            }
        f.close();
    }

    public static void main(String[] args) throws Exception {
        
        mayor(5, 6, 7);

        String cadena;

        Scanner p = new Scanner (new File("rep6.txt"));
        while(p.hasNext()){
            cadena = p.nextLine();
            System.out.println(cadena);
        }
    }
}
