import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class BolRep_4 {
    
    public static void prints(int n1, double n2)throws Exception{
        PrintWriter f = new PrintWriter (new File("rep4.txt"));
        String cadena="";

        f.printf("numero entero: %2d  \t %05o \t %x \n", n1 , n1, n1); //los 0 al lado del 5 hacen que se rellenen los espacios con 0
        
        f.printf("numero real: %7.3f \n", n2); //el 7 son los espacios que ocupa el numero y tras el punto son los decimales del numero
        
        f.close();
        Scanner p = new Scanner (new File("rep4.txt"));

        while (p.hasNext()){
            cadena = cadena + p.nextLine();
            System.out.println(cadena);
        }
        p.close();
    }
   
    public static void main(String[] args)throws Exception {
        
        prints(5, 3);
    }
}
