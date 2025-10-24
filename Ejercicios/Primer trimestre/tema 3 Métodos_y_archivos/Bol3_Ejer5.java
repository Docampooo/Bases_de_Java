import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
public class Bol3_Ejer5 {
    public static void main(String[] args)throws Exception {  //TODO mostrar en pantalla la parte del archvio pedida
    Scanner sc = new Scanner(System.in);
    PrintWriter f = new PrintWriter("Bol3_Ejer5.txt");
    
    int año;
    String cadena;
    
        System.out.println("introduce un año anterior al actual");
        f.println(año = sc.nextInt());
        f.println(Bol3_Ejer4.bisiesto(año)?"el año es bisiesto" : "el año no es bisiesto");
        if(año > 2024){
            f.println("ese año es posterior a la actualidad");
        }
         f.println("los numeros bisiestos desde ese año hasta el actual son:  ");
         for(int cont = año+1; cont < 2024; cont++){
             if(Bol3_Ejer4.bisiesto(cont) == true){
                 f.println(cont);
             }
        }

        f.close();
        Scanner P = new Scanner(new File("Bol3_Ejer5.txt"));

        P.nextLine();
        while(P.hasNext()){
            cadena = P.nextLine();
            System.out.printf("%S , ", cadena);
        }
        P.close();
    }
}
